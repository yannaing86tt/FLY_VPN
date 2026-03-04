package com.flyvpnpro.second.tunnel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.PreferenceManager;
import com.flyvpnpro.official.R;
import com.flyvpnpro.second.config.PasswordCache;
import com.flyvpnpro.second.config.Settings;
import com.flyvpnpro.second.logger.SkStatus;
import com.flyvpnpro.second.tunnel.SSLRemoteProxy;
import com.flyvpnpro.second.tunnel.Pinger;
import com.flyvpnpro.second.tunnel.vpn.TunnelState;
import com.flyvpnpro.second.tunnel.vpn.TunnelVpnManager;
import com.flyvpnpro.second.tunnel.vpn.TunnelVpnService;
import com.flyvpnpro.second.tunnel.vpn.TunnelVpnSettings;
import com.flyvpnpro.second.tunnel.vpn.VpnUtils;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.ConnectionMonitor;
import com.trilead.ssh2.DebugLogger;
import com.trilead.ssh2.DynamicPortForwarder;
import com.trilead.ssh2.InteractiveCallback;
import com.trilead.ssh2.KnownHosts;
import com.trilead.ssh2.ProxyData;
import com.trilead.ssh2.ServerHostKeyVerifier;
import com.trilead.ssh2.transport.TransportManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class TunnelManagerThread
implements Runnable, ConnectionMonitor, InteractiveCallback,
ServerHostKeyVerifier, DebugLogger
{
    private static final String TAG = TunnelManagerThread.class.getSimpleName();

    private OnStopCliente mListener;
    private Context mContext;
    private Handler mHandler;
    private Settings mConfig;
    private boolean mRunning = false, mStopping = false, mStarting = false;
    private Pinger pinger;
    private CountDownLatch mTunnelThreadStopSignal;
    //private ConnectivityManager mCmgr;

    public interface OnStopCliente {
        void onStop();
    }

    public TunnelManagerThread(Handler handler, Context context) {
        mContext = context;
        mHandler = handler;

        mConfig = new Settings(context);
    }

    public void setOnStopClienteListener(OnStopCliente listener) {
        mListener = listener;
    }

    @Override
    public void run()
    {
        mStarting = true;
        mTunnelThreadStopSignal = new CountDownLatch(1);
        SharedPreferences prefs = mConfig.getPrefsPrivate();
        int tunnelType = prefs.getInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT);
        if(tunnelType==Settings.bTUNNEL_TYPE_SSH_PROXY){
            SkStatus.logInfo("<strong>"+"Secure Shell (SSH PROXY) | FLY VPN PRO"+"</strong>");
        }else if(tunnelType==Settings.bTUNNEL_TYPE_SSH_SSL){
            SkStatus.logInfo("<strong>"+"Secure Shell (SSL) | FLY VPN PRO"+"</strong>");
		}else if(tunnelType==Settings.bTUNNEL_TYPE_PAY_SSL){
            SkStatus.logInfo("<strong>"+"Secure Shell (SSL + PAY) | FLY VPN PRO"+"</strong>");
		}else if(tunnelType==Settings.bTUNNEL_TYPE_SSL_RP){
            SkStatus.logInfo("<strong>"+"Secure Shell (SSL + RP) | FLY VPN PRO"+"</strong>");
		}else if(tunnelType==Settings.bTUNNEL_TYPE_SLOWDNS){
            SkStatus.logInfo("<strong>"+"Secure Shell (SlowDNS) | FLY VPN PRO"+"</strong>");
        }else{
            SkStatus.logInfo("<strong>"+"Direct Connection"+"</strong>");
        }
        if(prefs.getInt(Settings.TUNNELTYPE_KEY,Settings.bTUNNEL_TYPE_SSH_DIRECT)==Settings.bTUNNEL_TYPE_SSH_SSL){
            //SkStatus.logInfo("<strong>" + mContext.getString(R.string.starting_service_ssl) + "</strong>");
        }else{
            //SkStatus.logInfo("<strong>" + mContext.getString(R.string.starting_service_ssh) + "</strong>");

		}
        int tries = 0;
        while (!mStopping) {
            try {
                if (!TunnelUtils.isNetworkOnline(mContext)) {
                    SkStatus.updateStateString(SkStatus.SSH_WAITING, mContext.getString(R.string.state_nonetwork));
                    mContext.getString(R.string.state_nonetwork);
                    SkStatus.logInfo(R.string.state_nonetwork);

                    try {
                        Thread.sleep(5000);
                    } catch(InterruptedException e2) {
                        stopAll();
                        break;
                    }
                }
                else {
                    if (tries > 0)
                        SkStatus.logInfo("<strong>" + mContext.getString(R.string.state_reconnecting) + "</strong>");

                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException e2) {
                        stopAll();
                        break;
                    }
                     
                    startClienteSSH();
					break;
                }
            } catch(Exception e) {

                SkStatus.logError("<strong><html><font color='#FD1C0D'>" + mContext.getString(R.string.state_disconnected) + "</font></html></strong>");
                closeSSH();

                try {
                    Thread.sleep(500);
                } catch(InterruptedException e2) {
                    stopAll();
                    break;
                }
            }

            tries++;
        }

        mStarting = false;

        if (!mStopping) {
            try {
                mTunnelThreadStopSignal.await();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (mListener != null) {
            mListener.onStop();
        }
    }

    public void stopAll() {
        if (mStopping) return;

        SkStatus.updateStateString(SkStatus.SSH_STOPPING, mContext.getString(R.string.stopping_service_ssh));
//        SkStatus.logInfo("<strong>" + mContext.getString(R.string.stopping_service_ssh) + "</strong>");
        SkStatus.logInfo("<strong><html><font color=\"#FF0000\">" + "Disconnected" + "</font></html></strong>");
        new Thread(new Runnable() {
                @Override
                public void run() {
                    mStopping = true;

                    if (mTunnelThreadStopSignal != null)
                        mTunnelThreadStopSignal.countDown();

                    closeSSH();

                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e){}

                    SkStatus.updateStateString(SkStatus.SSH_DISCONNECTED, mContext.getString(R.string.state_disconnected));
                    
                    mRunning = false;
                    mStarting = false;
                    mReconnecting = false;
                }
           }).start();
    }

    /**
     * Forwarder
     */

    /** Forwarder */
    protected void startForwarder(int portaLocal) throws Exception {
        if (!mConnected) {
            throw new Exception();
        }
        if (PreferenceManager.getDefaultSharedPreferences(mContext).getBoolean(Settings.VIBRATE, true)) {
            Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                v.vibrate(200);
            }
        }

        String PING = mConfig.setPinger();  

        if (mConfig.setAutoPing()){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            if (!PING.equals(""))
            {
                pinger = new Pinger(mConnection, PING);
                pinger.start();
            }

        }



        startForwarderSocks(portaLocal);

        startTunnelVpnService();

        new Thread(new Runnable() {

                private Pinger pinger;
                @Override
                public void run() {
                    while (true) {
                        if (!mConnected) break;
//                  if (mConfig.speedmeter()){   
//                        mContext.startService(new Intent(mContext, NetSpeedNotification.class));
//                    }
                        try {
                            Thread.sleep(2000);
                        } catch(InterruptedException e) {
                            break;
                        }
                        //    If connected, 1s delay before pinger started 

                        if (lastPingLatency < 100) {
                            SkStatus.logInfo(String.format("time it take <font color=\"green\">%dms</font>", lastPingLatency));
                            break;
                        }else if (lastPingLatency > 100 ) {
                            SkStatus.logInfo(String.format("time it take <font color=\"red\">%dms</font>", lastPingLatency));
                            break;
                        }
                    }
                }
            }).start();
    }

    protected void stopForwarder() {
        stopTunnelVpnService();

        stopForwarderSocks();

    }

    /**
     * Cliente SSH
     */

    private final static int AUTH_TRIES = 1;
    private final static int RECONNECT_TRIES = 5;

    private Connection mConnection;

    private boolean mConnected = false;

    protected void startClienteSSH() throws Exception {
        mStopping = false;
        mRunning = true;

        String servidor = mConfig.getPrivString(Settings.SERVIDOR_KEY);
        int porta = Integer.parseInt(mConfig.getPrivString(Settings.SERVIDOR_PORTA_KEY));
        String usuario = mConfig.getPrivString(Settings.USUARIO_KEY);

        String _senha = mConfig.getPrivString(Settings.SENHA_KEY);
        String senha = _senha.isEmpty() ? PasswordCache.getAuthPassword(null, false) : _senha;

        String keyPath = mConfig.getSSHKeypath();
        int portaLocal = Integer.parseInt(mConfig.getPrivString(Settings.PORTA_LOCAL_KEY));

        try {

            conectar(servidor, porta);

            for (int i = 0; i < AUTH_TRIES; i++) {
                if (mStopping) {
                    return;
                }

                try {
                    autenticar(usuario, senha, keyPath);

                    break;
                } catch (IOException e) {
                    if (i + 1 >= AUTH_TRIES) {
                        throw new IOException("Authentication failed");
                    } else {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e2) {
                            return;
                        }
                    }
                }
            }

            SkStatus.updateStateString(SkStatus.SSH_CONNECTED, "SSH Connection Established");
            SkStatus.logInfo("<strong><html><font color='#FFDA0A'>" + "Connected" + "</font></html></strong>");
        //    SkStatus.logInfo( "Tunnelling started");
            if (mConfig.getSSHPinger() > 0) {
                startPinger(mConfig.getSSHPinger());
            }

            startForwarder(portaLocal);

        } catch (Exception e) {
            mConnected = false;

            throw e;
        }
    }

    public synchronized void closeSSH() {
        stopForwarder();
        stopPinger();

        if (mConnection != null) {
            SkStatus.logDebug("Stopping SSH");
            mConnection.close();
        }
    }

    protected void conectar(String servidor, int porta) throws Exception {
        if (!mStarting) {
            throw new Exception();
        }

        SharedPreferences prefs = mConfig.getPrefsPrivate();
        
        try {

            mConnection = new Connection(servidor, porta);

            if (mConfig.getModoDebug() && !prefs.getBoolean(Settings.CONFIG_PROTEGER_KEY, false)) {
                // Desativado, pois estava enchendo o Logger
                // mConnection.enableDebugging(true, this);
                mHandler.post(
                        new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mContext, "Debug mode enabled", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
            }

            // delay sleep
            if (mConfig.getIsDisabledDelaySSH()) {
                mConnection.setTCPNoDelay(true);
            }
            // Data Compression
            if (mConfig.sshCompression()){
				mConnection.setCompression(true);
				SkStatus.logInfo("<strong><font color='#ff9100'>SSH Compression Enabled</font><strong>");
			} else {
				mConnection.setCompression(false);
				SkStatus.logInfo("<strong><font color='#f44235'>SSH Compression Disabled</font><strong>");
			}
            // proxy
            addProxy(
                    prefs.getBoolean(Settings.CONFIG_PROTEGER_KEY, false),
                    prefs.getInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT),
                    (!prefs.getBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, true)
                            ? mConfig.getPrivString(Settings.CUSTOM_PAYLOAD_KEY)
                            : null),
                    mConfig.getPrivString(Settings.CUSTOM_SNI),
                    mConnection);

            // monitora a conexão
            mConnection.addConnectionMonitor(this);

            if (Build.VERSION.SDK_INT >= 23) {
                ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                ProxyInfo proxy = cm.getDefaultProxy();
                if (proxy != null) {
                    SkStatus.logInfo("<strong>Network Proxy:</strong> " + String.format("%s:%d", proxy.getHost(), proxy.getPort()));
                }
            }

            SkStatus.updateStateString(SkStatus.SSH_CONNECTING, mContext.getString(R.string.state_connecting));
            SkStatus.logInfo(R.string.state_connecting);

            mConnection.connect(this, 10*1000, 20*1000);

            mConnected = true;

        } catch(Exception e) {

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));

            String cause = e.getCause().toString();
            if (useProxy && cause.contains("Key exchange was not finished")) {
                SkStatus.logError("Proxy: Connection Lost");
            }
            else {
                SkStatus.logError("SSH: " + cause);
            }

            throw new Exception(e);
        }
    }


    /**
     * Autentica莽茫o
     */

    private static final String AUTH_PUBLICKEY = "publickey",
            AUTH_PASSWORD = "password",
            AUTH_KEYBOARDINTERACTIVE = "keyboard-interactive";

    protected void autenticar(String usuario, String senha, String keyPath) throws IOException {
        if (!mConnected) {
            throw new IOException();
        }

        SkStatus.updateStateString(
                SkStatus.SSH_AUTHENTICATING, mContext.getString(R.string.state_auth));

        try {
            if (mConnection.isAuthMethodAvailable(usuario, AUTH_PASSWORD)) {

                SkStatus.logInfo("Password auth available");

                if (mConnection.authenticateWithPassword(usuario, senha)) {
                    SkStatus.logInfo(mContext.getString(R.string.state_auth_success));
                }
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "Connection went away while we were trying to authenticate", e);
        } catch (Exception e) {
            Log.e(TAG, "Problem during handleAuthentication()", e);
        }

        try {
            if (mConnection.isAuthMethodAvailable(usuario, AUTH_PUBLICKEY)
                    && keyPath != null
                    && !keyPath.isEmpty()) {
                File f = new File(keyPath);
                if (f.exists()) {
                    if (senha.equals("")) senha = null;

                    SkStatus.logInfo("Authenticating com public key");

                    if (mConnection.authenticateWithPublicKey(usuario, f, senha)) {
                        SkStatus.logInfo(
                                "<strong>"
                                        + mContext.getString(R.string.state_auth_success)
                                        + "</strong>");
                    }
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "Host does not support 'Public key' authentication.");
        }

        if (!mConnection.isAuthenticationComplete()) {
            SkStatus.logInfo("Failed to authenticate, User or Password Expired");

            throw new IOException("It was not possible to authenticate with the data provided");
        }
    }

    // XXX: Is it right?
    @Override
    public String[] replyToChallenge(
            String name, String instruction, int numPrompts, String[] prompt, boolean[] echo)
            throws Exception {
        String[] responses = new String[numPrompts];
        for (int i = 0; i < numPrompts; i++) {
            // request response from user for each prompt
            if (prompt[i].toLowerCase().contains("password"))
                responses[i] = mConfig.getPrivString(Settings.SENHA_KEY);
        }
        return responses;
    }


    /**
     * ServerHostKeyVerifier
     * Fingerprint
     */

    @Override
    public boolean verifyServerHostKey(
            String hostname, int port, String keyAlgorithm, byte[] hostKey) throws Exception {
        String createHexFingerprint = KnownHosts.createHexFingerprint(keyAlgorithm, hostKey);
        String createHashedHostname = KnownHosts.createHashedHostname(hostname);
        String createBubblebabbleFingerprint = KnownHosts.createBubblebabbleFingerprint(keyAlgorithm, hostKey);
        
        SkStatus.logInfo( new StringBuffer().append("Hostkey fingerprint: ").append(createHexFingerprint).toString());
        SkStatus.logInfo( new StringBuffer().append("Key exchange algorithm: ").append(hostKey).toString());
        SkStatus.logInfo( new StringBuffer().append("Using algorithm: ").append(keyAlgorithm).toString());
        
        return true;
    }

    /**
     * Proxy
     */

    private boolean useProxy = false;

    protected void addProxy(boolean isProteger, int mTunnelType, String mCustomPayload,String mCustomSNI, Connection conn) throws Exception {

        if (mTunnelType != 0) {
            useProxy = true;

            switch (mTunnelType) {
                case Settings.bTUNNEL_TYPE_SSH_DIRECT:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SSH Direct Method</font></strong>");
                    if (mCustomPayload != null) {
						try {
							ProxyData proxyData = new HttpProxyCustom(mConfig.getPrivString(Settings.SERVIDOR_KEY), Integer.parseInt(mConfig.getPrivString(Settings.SERVIDOR_PORTA_KEY)),
								null, null, mCustomPayload, true, mContext);

							conn.setProxyData(proxyData);

							if (!mCustomPayload.isEmpty() && !isProteger);
							//	SkStatus.logInfo("Payload: " + "locked");

						} catch(Exception e) {
							throw new Exception(mContext.getString(R.string.error_proxy_invalid));
						}
					}
					else {
						useProxy = false;
					}
				break;

                case Settings.bTUNNEL_TYPE_SSH_PROXY:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SSH Proxy Method</font></strong>");
                    String customPayload = mCustomPayload;

                    if (customPayload != null && customPayload.isEmpty()) {
						customPayload = null;
					}

					String servidor = mConfig.getPrivString(Settings.PROXY_IP_KEY);
					int porta = Integer.parseInt(mConfig.getPrivString(Settings.PROXY_PORTA_KEY));

					try {
						ProxyData proxyData = new HttpProxyCustom(servidor, porta,
							null, null, customPayload, false, mContext);

						if (!isProteger)
							//SkStatus.logInfo(String.format("Remote Proxy: %s:%d", servidor, porta));
						conn.setProxyData(proxyData);

						if (customPayload != null && !customPayload.isEmpty() && !isProteger){}
							

					} catch(Exception e) {
						SkStatus.logError(R.string.error_proxy_invalid);

						throw new Exception(mContext.getString(R.string.error_proxy_invalid));
					}
				break;

                case Settings.bTUNNEL_TYPE_SSH_SSL:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SSL/Stunnel Method</font></strong>");
                    String customsni = mCustomPayload;

                    if (customsni != null && customsni.isEmpty()) {
                        customPayload = null;
                    }
                    
                    String sshServer = mConfig.getPrivString(Settings.PROXY_IP_KEY);
                    int sshPort = Integer.parseInt(mConfig.getPrivString(Settings.PROXY_PORTA_KEY));
                    
                    try{
                        
                        SSLTunnelProxy sslTun = new SSLTunnelProxy(sshServer, sshPort, customsni);
                        conn.setProxyData(sslTun);
                        
                    } catch(Exception e) {
                        SkStatus.logInfo(e.getMessage());
                    }
                    
                    break;
                    
                case Settings.bTUNNEL_TYPE_PAY_SSL:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SSL PAY Method</font></strong>");
                    String customSNI2 = mCustomSNI;
                    if (customSNI2 != null && customSNI2.isEmpty()) {
                        customSNI2 = null;
                    }
                    String customPayload2 = mCustomPayload;

                    if (customPayload2 != null && customPayload2.isEmpty()) {
                        customPayload2= null;
                    }

                    String sshServer2 = mConfig.getPrivString(Settings.SERVIDOR_KEY);
                    int sshPort2 = Integer.parseInt(mConfig.getPrivString(Settings.SERVIDOR_PORTA_KEY));

                    try{

                        SSLProxy sslTun = new SSLProxy(sshServer2, sshPort2, customSNI2,customPayload2);
                        conn.setProxyData(sslTun);

                    } catch(Exception e) {
                        SkStatus.logInfo(e.getMessage());
                    }

                    break;
                case Settings.bTUNNEL_TYPE_SSL_RP:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SSL RP Method</font></strong>");
                    String customSNI3 = mCustomSNI;
                    if (customSNI3 != null && customSNI3.isEmpty()) {
						customSNI3 = null;
					}
					String customPayload3 = mCustomPayload;

					if (customPayload3 != null && customPayload3.isEmpty()) {
						customPayload3= null;
					}

					String sshServer3 = mConfig.getPrivString(Settings.SERVIDOR_KEY);
					int sshPort3 = Integer.parseInt(mConfig.getPrivString(Settings.SERVIDOR_PORTA_KEY));
					try{
						SSLRemoteProxy sslTun = new SSLRemoteProxy(sshServer3, sshPort3, customSNI3,customPayload3);
						conn.setProxyData(sslTun);


					} catch(Exception e) {
						SkStatus.logInfo(e.getMessage());
					}
					break;
                
               case Settings.bTUNNEL_TYPE_SLOWDNS:
                    SkStatus.logWarning(
                            "<strong><font color='#00e676'>SlowDNS Method</font></strong>");
                    
                    if (mCustomPayload != null) {
                        try {
                            ProxyData proxyData = new HttpProxyCustom("127.0.0.1", Integer.parseInt("2222"),
                                                                      null, null, mCustomPayload, true, mContext);

                            conn.setProxyData(proxyData);

							  /*      if (!mCustomPayload.isEmpty() && !isProteger)
							SkStatus.logInfo("Payload" + mCustomPayload);**/

                        } catch(Exception e) {
                            throw new Exception(mContext.getString(R.string.error_proxy_invalid));
                        }
                    }
                    else {
                        useProxy = false;
                    }
					break;
                
                    default: useProxy = false;
					break;
            }
        }
    }


    /**
     * Socks5 Forwarder
     */

    private DynamicPortForwarder dpf;

    private synchronized void startForwarderSocks(int portaLocal) throws Exception {
        if (!mConnected) {
            throw new Exception();
        }
        SkStatus.logInfo("starting socks local");
        SkStatus.logInfo(String.format("socks local listen: %d", portaLocal));

        try {

            int nThreads = mConfig.getMaximoThreadsSocks();

            if (nThreads > 0) {
                dpf = mConnection.createDynamicPortForwarder(portaLocal, nThreads);

                SkStatus.logDebug("socks local number threads: " + Integer.toString(nThreads));
            } else {
                dpf = mConnection.createDynamicPortForwarder(portaLocal);
            }

        } catch (Exception e) {
            SkStatus.logError("Socks Local: " + e.getCause().toString());

            throw new Exception();
        }
    }

    private synchronized void stopForwarderSocks() {
        if (dpf != null) {
            try {
                dpf.close();
            } catch (IOException e) {
            }
            dpf = null;
        }
    }


    /**
     * Pinger
     */

      /** Pinger */
    private Thread thPing;
	private long lastPingLatency = -1;
	
	private void startPinger(final int timePing) throws Exception {
		if (!mConnected) {
			throw new Exception();
		}

		//SkStatus.logInfo("starting pinger");

		thPing = new Thread() {
			@Override
			public void run() {
				while (mConnected) {
					try {
						makePinger();
					} catch(InterruptedException e) {
						break;
					}
				}
				SkStatus.logDebug("pinger stopped");
			}
			
			private synchronized void makePinger() throws InterruptedException {
				try {
					if (mConnection != null) {
						long ping = mConnection.ping();
						if (lastPingLatency < 0) {
							lastPingLatency = ping;
						}
					}
					else throw new InterruptedException();
				} catch(Exception e) {
					Log.e(TAG, "ping error", e);
				}
				
				if (timePing == 0)
					return;

				if (timePing > 0)
					sleep(timePing*1000);
				else {
					SkStatus.logError("ping invalid");
					throw new InterruptedException();
				}
			}
		};

		// inicia
		thPing.start();
	}

	private synchronized void stopPinger() {
		if (thPing != null && thPing.isAlive()) {
			SkStatus.logInfo("stopping pinger");
			
			thPing.interrupt();
			thPing = null;
		}
	}

     /** Connection Monitor */
    @Override
    public void connectionLost(Throwable reason) {
        if (mStarting || mStopping || mReconnecting) {
            return;
        }

        SkStatus.logError(
                "<strong>" + mContext.getString(R.string.log_conection_lost) + "</strong>");

        if (reason != null) {
            if (reason.getMessage().contains("There was a problem during connect")) {
                return;
            } else if (reason.getMessage().contains("Closed due to user request")) {
                return;
            } else if (reason.getMessage().contains("The connect timeout expired")) {
                stopAll();
                return;
            }
        } else {
            stopAll();
            return;
        }

        reconnectSSH();
    }

    public boolean mReconnecting = false;

    public void reconnectSSH() {
        if (mStarting || mStopping || mReconnecting) {
            return;
        }

        mReconnecting = true;

        closeSSH();

        SkStatus.updateStateString(SkStatus.SSH_RECONNECTING, "Reconnecting..");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            mReconnecting = false;
            return;
        }

        for (int i = 0; i < RECONNECT_TRIES; i++) {
            if (mStopping) {
                mReconnecting = false;
                return;
            }

            int sleepTime = 5;
            if (!TunnelUtils.isNetworkOnline(mContext)) {
                SkStatus.updateStateString(SkStatus.SSH_WAITING, "Waiting for network ..");

                SkStatus.logInfo(R.string.state_nonetwork);
            } else {
                sleepTime = 3;
                mStarting = true;
                SkStatus.updateStateString(SkStatus.SSH_RECONNECTING, "Reconnecting..");

                SkStatus.logInfo(
                        "<strong>" + mContext.getString(R.string.state_reconnecting) + "</strong>");

                try {
                    startClienteSSH();

                    mStarting = false;
                    mReconnecting = false;
                    // mConnected = true;

                    return;
                } catch (Exception e) {
                    SkStatus.logInfo(
                            "<strong>"
                                    + mContext.getString(R.string.state_disconnected)
                                    + "</strong>");
                }

                mStarting = false;
            }

            try {
                Thread.sleep(sleepTime * 1000);
                i--;
            } catch (InterruptedException e2) {
                mReconnecting = false;
                return;
            }
        }

        mReconnecting = false;
        stopAll();
    }

    @Override
    public void onReceiveInfo(int id, String msg) {
        if (id == SERVER_BANNER) {
            // SkStatus.logInfo("<strong>" + mContext.getString(R.string.log_server_banner)
            // + "</strong> "
            // + msg);
        }
    }

    /**
     * Debug Logger
     */

    @Override
    public void log(int level, String className, String message)
    {
        SkStatus.logDebug(String.format("%s: %s", className, message));
    }


    /**
     * Vpn Tunnel
     */

    String serverAddr;

    protected void startTunnelVpnService() throws IOException {
        if (!mConnected) {
            throw new IOException();
        }
        SkStatus.logInfo("starting tunnel service");
        SharedPreferences prefs = mConfig.getPrefsPrivate();
        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        
		// Broadcast
        IntentFilter broadcastFilter =
            new IntentFilter(TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST);
        broadcastFilter.addAction(TunnelVpnService.TUNNEL_VPN_START_BROADCAST);
        // Inicia Broadcast
        LocalBroadcastManager.getInstance(mContext)
            .registerReceiver(m_vpnTunnelBroadcastReceiver, broadcastFilter);

        String m_socksServerAddress = String.format("127.0.0.1:%s", mConfig.getPrivString(Settings.PORTA_LOCAL_KEY));
		boolean m_dnsForward = mConfig.getVpnDnsForward();
		String m_udpResolver = mConfig.getVpnUdpForward() ? mConfig.getVpnUdpResolver() : null;
		String servidorIP = mConfig.getPrivString(Settings.SERVIDOR_KEY);
        
        if (prefs.getInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT)
                == Settings.bTUNNEL_TYPE_SSH_PROXY) {
            try {
                servidorIP = mConfig.getPrivString(Settings.PROXY_IP_KEY);
            } catch (Exception e) {
                SkStatus.logError(R.string.error_proxy_invalid);

                throw new IOException(mContext.getString(R.string.error_proxy_invalid));
            }
        }

		try {
			InetAddress servidorAddr = TransportManager.createInetAddress(servidorIP);
			serverAddr = servidorIP = servidorAddr.getHostAddress();
		} catch(UnknownHostException e) {
			throw new IOException(mContext.getString(R.string.error_server_ip_invalid));
		}
		
		String[] m_excludeIps = {servidorIP};

		String[] m_dnsResolvers = null;
        if (m_dnsForward) {
            if(mConfig.getVpnDnsResolver2().isEmpty()){
                m_dnsResolvers = new String[]{mConfig.getVpnDnsResolver1()};
            }else{
                m_dnsResolvers = new String[]{mConfig.getVpnDnsResolver1(),mConfig.getVpnDnsResolver2()};
            }
        }
        else {
            List<String> lista = VpnUtils.getNetworkDnsServer(mContext);
            m_dnsResolvers = new String[]{lista.get(0)};
        }

		if(m_dnsForward){
            if(mPref.getString(Settings.DNSTYPE_KEY, Settings.DNS_GOOGLE_KEY).equals(Settings.DNS_GOOGLE_KEY)){
                SkStatus.logInfo("<strong><font color='#00e676'>Google DNS enabled</font><strong>");
                SkStatus.logInfo("DNS Forwarding: Google DNS");
            }else if(mPref.getString(Settings.DNSTYPE_KEY, Settings.DNS_GOOGLE_KEY).equals(Settings.DNS_CUSTOM_KEY)){
                SkStatus.logInfo("<strong><font color='#00e676'>Custom DNS enabled</font><strong>");
                SkStatus.logInfo("DNS Forwarding: Custom DNS");
            }	else{
                SkStatus.logInfo("<strong><font color='#00e676'>Default DNS enabled</font><strong>");
                SkStatus.logInfo("DNS Forwarding: Default DNS");
            }
            
        }else{
            SkStatus.logInfo("<strong><font color='#ff1745'>DNS disabled</font><strong>");
        }

        if (isServiceVpnRunning()) {
            Log.d(TAG, "already running service");

            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();

            if (tunnelManager != null) {
                tunnelManager.restartTunnel(m_socksServerAddress);
            }

            return;
        }

        Intent startTunnelVpn = new Intent(mContext, TunnelVpnService.class);
        startTunnelVpn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        TunnelVpnSettings settings =
                new TunnelVpnSettings(
                        m_socksServerAddress,
                        m_dnsForward,
                        m_dnsResolvers,
                        (m_dnsForward && m_udpResolver == null
                                || !m_dnsForward && m_udpResolver != null),
                        m_udpResolver,
                        m_excludeIps,
                        mConfig.getIsFilterApps(),
                        mConfig.getIsFilterBypassMode(),
                        mConfig.getFilterApps(),
                        mConfig.getIsTetheringSubnet(),
                        mConfig.getBypass());
        startTunnelVpn.putExtra(TunnelVpnManager.VPN_SETTINGS, settings);

        if (mContext.startService(startTunnelVpn) == null) {
            SkStatus.logInfo("failed to start tunnel vpn service");

            throw new IOException("Vpn Service failed to start");
        }

        TunnelState.getTunnelState().setStartingTunnelManager();
    }

    public static boolean isServiceVpnRunning() {
        TunnelState tunnelState = TunnelState.getTunnelState();
        return tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null;
    }

    protected synchronized void stopTunnelVpnService() {
        if (!isServiceVpnRunning()) {
            return;
        }

        SkStatus.logInfo(R.string.service_tunnel_stopping);

        TunnelVpnManager currentTunnelManager = TunnelState.getTunnelState().getTunnelManager();

        if (currentTunnelManager != null) {
            currentTunnelManager.signalStopService();
        }

        // Parando Broadcast
        LocalBroadcastManager.getInstance(mContext)
                .unregisterReceiver(m_vpnTunnelBroadcastReceiver);
    }

    // Local BroadcastReceiver
    private final BroadcastReceiver m_vpnTunnelBroadcastReceiver =
            new BroadcastReceiver() {
                @Override
                public synchronized void onReceive(Context context, Intent intent) {
                    final String action = intent.getAction();

                    if (TunnelVpnService.TUNNEL_VPN_START_BROADCAST.equals(action)) {
                        boolean startSuccess =
                                intent.getBooleanExtra(
                                        TunnelVpnService.TUNNEL_VPN_START_SUCCESS_EXTRA, true);

                        if (!startSuccess) {
                            stopAll();
                        }

                    } else if (TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST.equals(action)) {
                        stopAll();
                    }
                }
            };
}

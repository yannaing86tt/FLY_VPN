package com.flyvpnpro.main;

import android.annotation.SuppressLint;
import android.app.*;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.*;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.*;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.flyvpnpro.main.activities.CheckVIP;
import com.flyvpnpro.main.util.DeviceUtils;
import com.flyvpnpro.second.util.securepreferences.crypto.SecureDevice;
import com.flyvpnpro.second.util.securepreferences.model.CheckRoot;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import android.content.IntentSender;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.model.InstallStatus;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import com.flyvpnpro.official.R;
import com.flyvpnpro.main.MainApp;
import com.flyvpnpro.main.SpeedTest;
import com.flyvpnpro.main.CrashWindow;
import com.flyvpnpro.main.Errors;
import com.flyvpnpro.main.DrawerLog;
import com.flyvpnpro.main.activities.VIPActivity;
import com.flyvpnpro.main.activities.AboutActivity;
import com.flyvpnpro.main.activities.BaseActivity;
import com.flyvpnpro.main.activities.ConfigGeralActivity;
import com.flyvpnpro.main.activities.GetPackageClass;
import com.flyvpnpro.main.activities.Premium;
import com.flyvpnpro.main.activities.SMSuPdater;
import com.flyvpnpro.main.adapter.LogsAdapter;
import com.flyvpnpro.main.adapter.PrefManager;
import com.flyvpnpro.main.adapter.SpinnerAdapter;
import com.flyvpnpro.main.util.AESCrypt;
import com.flyvpnpro.main.util.ConfigUpdate;
import com.flyvpnpro.main.util.ConfigUtil;
import com.flyvpnpro.main.util.Utils;
import com.flyvpnpro.main.view.Ripple;
import com.flyvpnpro.main.util.FileRename;
import com.flyvpnpro.main.util.Base64Util;
import com.flyvpnpro.main.util.ContextUtils;
import com.flyvpnpro.main.util.MD5Utils;
import com.flyvpnpro.main.view.RecyclerItemTouch;
import com.flyvpnpro.main.view.ServerAdapter;
import com.flyvpnpro.main.custom.ServerDialog;
import com.flyvpnpro.main.custom.SpinnerListener;
import com.flyvpnpro.main.util.ToastUtil;
import com.flyvpnpro.main.fragments.ProxyRemoteDialogFragment;

import com.flyvpnpro.second.tunnel.vpn.*;
import com.flyvpnpro.second.config.PasswordCache;
import com.flyvpnpro.second.MainService;
import com.flyvpnpro.second.StatisticGraphData;
import com.flyvpnpro.second.util.securepreferences.*;
import com.flyvpnpro.second.StatisticGraphData.DataTransferStats;
import com.flyvpnpro.second.config.ConfigParser;
import com.flyvpnpro.second.config.Settings;
import com.flyvpnpro.second.logger.ConnectionStatus;
import com.flyvpnpro.second.logger.SkStatus;
import com.flyvpnpro.second.tunnel.TunnelManagerHelper;
import com.flyvpnpro.second.tunnel.TunnelUtils;
import com.flyvpnpro.second.util.ProtectedHS;
import com.flyvpnpro.second.util.securepreferences.model.*;
import com.flyvpnpro.second.util.securepreferences.crypto.*;
import com.flyvpnpro.second.config.*;
import com.flyvpnpro.second.tunnel.*;
import com.flyvpnpro.second.logger.*;
import com.flyvpnpro.second.util.securepreferences.SecurePreferences;
import com.flyvpnpro.second.LaunchVpn;

import com.sdsmdg.tastytoast.TastyToast;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.*;
import java.lang.Process;
import java.text.DateFormat;
import android.net.VpnService;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.CheckBox;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.security.GeneralSecurityException;
import cn.pedant.SweetAlert.widget.SweetAlertDialog;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.HSGravity;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;

public class MainActivity extends BaseActivity 
implements View.OnClickListener,RadioGroup.OnCheckedChangeListener, 
CompoundButton.OnCheckedChangeListener, SkStatus.StateListener, View.OnLongClickListener
{
    private AlertDialog.Builder builer;
    private AlertDialog alert;
	private TextView ok;
	private TextView cancel;
    private ToastUtil toastutil;
    private boolean mShown, mShown2;
    private final boolean isConnected = true;
    private boolean isExiting = false;
    private Timer _timer = new Timer();
    private TimerTask timeExit;
    private String mTransientAuthPW;
    private boolean isDelete;
    private TextInputEditText payloadEdit;
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView ja123;
    private ImageView hs123;
    private ImageView btnMenu;
    
    private TextView bytesIn;
	private TextView bytesOut;
    private CoordinatorLayout coordinatorLayout;;
    private TextView connectionStatus;
    
    private FloatingActionButton deleteLogs; 
    public static LogsAdapter mAdapter;
    private RecyclerView logList;
    private View bshl;
    private TimerTask timer;
    private DrawerLog mDrawer;
	private VIPActivity modoc;
	private static final int START_VPN_PROFILE = 2002;
    private View view5;
    private View view4;
    private View view3;
    private View view2;
    private View view1;
    
    private Ripple ripple;
//    private Context c;
    public static Context c;
    
    @SuppressLint("StaticFieldLeak")
	private static final String TAG = MainActivity.class.getSimpleName();
	private static final String UPDATE_VIEWS = "MainUpdate";
    public static final String OPEN_LOGS = "com.flyvpnpro.main:openLogs";
    private Settings mConfig;
	private Toolbar toolbar_main;
	private Handler mHandler;
	private LinearLayout mainLayout;
	private LinearLayout loginLayout;
	private LinearLayout proxyInputLayout;
	private TextView proxyText;
	private RadioGroup metodoConexaoRadio;
	private LinearLayout payloadLayout;
	private SwitchCompat customPayloadSwitch;
	private ImageView starterButton;
	private ImageView ping;
	private LinearLayout configMsgLayout;
	private TextView configMsgText;
    private SweetAlertDialog sweetDialog;
    private FileUtil configs;
    private ImageView server_edit;
    private ImageView servIcon;
    private TextView servName;
    private LinearLayout servLay;
    private ArrayList<HashMap<String, String>> serversList;
    private JSONObject jSONObject;
    private TextView serverInfo;
    private ImageView free;
    private ImageView vipp;
    
    private ConfigUtil config;
    private Spinner serverSpinner;
	
    private InterstitialAd interstitialAd;
    private AdView adsBannerView;
	private RewardedAd rewardedAd;
    public Chronometer chronometer;
    private Chronometer cmTimer;
	private TextInputEditText inputPwUser;
	private TextInputEditText inputPwPass;
	private ImageButton inputPwShowPass;
    public TextView vencimentoDate;
	public TextView diasRestantes;
	private TextView username;
	private TextView textstatus;
    private ImageView statusVip1;
	private ImageView statusVip2;
	private TextView statusVip2text;
	private TextView statusVip1text;
    private View sheetvipOpen;
    private ImageView accountClosesheet;
	private TextView saludoDia;
	private ImageView saludoPng;
    
    private static final String DNS_BIN = "libdns";
    private Process dnsProcess;
    private File filedns;
    
    private AppUpdateManager mAppUpdateManager;
    private static final int RC_APP_UPDATE = 100;
//    private SharedPreferences prefs;
    private SharedPreferences sp;
    private SharedPreferences sharedPreferences;
    private SecurePreferences prefs;
    private SecurePreferences.Editor edit;
    private SecurePreferences.Editor putInt;
    
    private TextView txt1;
    private TextView txt2;
	private boolean edit_state_pressed = false;
    private ProgressDialog ppd;
    private boolean cancelProgressBar;
    public static int PICK_FILE = 1;
    public static final boolean isRunning = false;
    
    @Override
    public void onCheckedChanged(CompoundButton p1, boolean p2) {
    }
    
    public void offlinez(View v)
    {
        drawerLayout.openDrawer(GravityCompat.START);
	}
    
    private void uninstall() {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
    
    @SuppressLint("InflateParams")
	private void antiRemod1() {

		// Keep package validation only, allow app-name rebranding (PLUS VPN PRO)
		if (!(getPackageName().equals(FLYProtect.pkgname))) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setView(getLayoutInflater().inflate(R.layout.flyprotect, null));
			builder.setCancelable(false);
            builder.setNegativeButton("Uninstall", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface p1, int p2) {
                        uninstall();
                    }                      
                });
			builder.setPositiveButton("Exit", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface p1, int p2) {
						// TODO: Implement this method
						if (android.os.Build.VERSION.SDK_INT >= 21) {
							finishAndRemoveTask();
						} else {
							android.os.Process.killProcess(android.os.Process.myPid());
						}
						System.exit(0);

					}
				});
			builder.show();

		}
	}
    
    public void notif1() {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.icons)
            .setTicker("{your tiny message}")
            .setContentTitle("App Update Available")
            .setContentText("Update Your App Now")
            .setContentInfo("PLUS VPN PRO");

        NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, b.build());
    }

    private void notif2(){
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
    }
	    
    private void setSpinner() {
        SecurePreferences prefsPrivate = mConfig.getPrefsPrivate();
        serverSpinner.setSelection(prefsPrivate.getInt("LastSelectedServer", 0));
        }

    private void saveSpinner() {
        edit = mConfig.getPrefsPrivate().edit();
        int selectedItemPosition = serverSpinner.getSelectedItemPosition();
        putInt = edit.putInt("LastSelectedServer", selectedItemPosition);
        edit.apply();
    }
     
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sp = getSharedPreferences("JA", 0);
        new SMSuPdater(this);
        antiRemod1();
        toastutil = new ToastUtil(this);
        mHandler = new Handler();
		mConfig = new Settings(this);
        mDrawer = new DrawerLog(this);
        modoc = new VIPActivity();
        Thread.setDefaultUncaughtExceptionHandler(new CrashWindow(this));  
        final SharedPreferences prefs2= mConfig.getPrefsPrivate();
		SharedPreferences prefs = getSharedPreferences(MainApp.PREFS_GERAL, Context.MODE_PRIVATE);

        if (CheckRoot.isDeviceRooted()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Rooted Device!!")
                    .setCancelable(false)
                    .setMessage("Your device is rooted. You cannot use this app?")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }
        
        mAppUpdateManager = AppUpdateManagerFactory.create(this);	mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>()
			{
				@Override
				public void onSuccess(AppUpdateInfo result) {
					if(result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && result.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE))
					{
						try {
							mAppUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, MainActivity.this,
																	   RC_APP_UPDATE);

						} catch (IntentSender.SendIntentException e) {}}
				}
			});
		mAppUpdateManager.registerListener(installUpdatelistener);
        
    	boolean showFirstTime = prefs.getBoolean("connect_first_time", true);
		int lastVersion = prefs.getInt("last_version", 0);
            
		if (showFirstTime)
        {
            SharedPreferences.Editor pEdit = prefs.edit();
            pEdit.putBoolean("connect_first_time", false);
            pEdit.apply();
			
			Settings.setDefaultConfig(this);
		}
		try {
			int idAtual = ConfigParser.getBuildId(this);

			if (lastVersion < idAtual) {
				SharedPreferences.Editor pEdit = prefs.edit();
				pEdit.putInt("last_version", idAtual);
				pEdit.apply();

				if (!showFirstTime) {
					if (lastVersion <= 12) {
						Settings.setDefaultConfig(this);
						Settings.clearSettings(this);

						Toast.makeText(this, "Settings have been cleaned up to avoid bugs",
							Toast.LENGTH_LONG).show();
					}
				}
			}
		} catch(IOException e) {}
		
		// set layout
		doLayout();
        initBytesInAndOut();
        ProtectedHS.CharlieProtect();
        setServerFlag();
		// recebe local dados
        
		IntentFilter filter = new IntentFilter();
		filter.addAction(UPDATE_VIEWS);
		filter.addAction(OPEN_LOGS);
		LocalBroadcastManager.getInstance(this)
			.registerReceiver(mActivityReceiver, filter);
			
		doUpdateLayout();
        
        ripple.setRippleColor(Color.parseColor(getString(R.color.color_disconnected)));
        ripple.startRippleAnimation();
        
    }
    
    @Override
	protected void onStop() {
		if(mAppUpdateManager != null) mAppUpdateManager.unregisterListener(installUpdatelistener);
		super.onStop();
	}
    
    @Override
    public boolean onLongClick(View p1) {
        switch (p1.getId()) {
            case R.id.serverListLayout:
                editServer(p1, sp.getInt("SelectedServer", 0));
                break;
        }
        return false;
    }
    
    //customServer
    public void getData() {
        String jSONArray = configs.getServersArray().toString();
        String version = configs.getVersion();
        String notes = configs.geNote();
        sp.edit().putString("FLYVersion", version).apply();
        sp.edit().putString("FLYReleaseNotes", notes).apply();
        sp.edit().putString("FLYServers", jSONArray).apply();
    } 
    
    private JSONObject custom() {
        String ja=sp.getString("Configuration", "{}");
        try {
            JSONArray a=new JSONArray(sp.getString("FLYServers", "[]"));
            return new JSONObject(ja).put("FLYVersion",sp.getString("FLYVersion", "")).put("FLYReleaseNotes",sp.getString("FLYReleaseNotes", "")).put("FLYServers", a);
        } catch (JSONException e) {
            return null;
        }
    } 
    
    public void addserver() {
        ServerDialog.Server a=new ServerDialog.Server(this);
        a.add();
        a.onServerAdd(new SpinnerListener()
            {
                @Override
                public void onAdd(JSONObject json) {
                    try {
                        getData();
                        JSONArray ja = new JSONArray(sp.getString("FLYServers", "[]"));
                        ja.put(json);
                        sp.edit().putString("FLYServers", ja.toString()).apply();
                        isDelete = false;
                        saveServerData();
                    } catch (JSONException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        a.init();
    }
    
    public String getJson() {
        String str = "";
        try {
            str = AESCrypt.encrypt(configs.PASSWORD, custom().toString());
        } catch (GeneralSecurityException e) {
            //  GeneralSecurityException generalSecurityException = e;
        }
        return str;
    }

    private void saveServerData() {
        try {
            File file = new File(getFilesDir(), "flyvpnpro.json");
            OutputStream out = new FileOutputStream(file);
            out.write(getJson().getBytes());
            out.flush();
            out.close();
            loadServer();
            if (isDelete) {
                parseSelectedServer(sp.getInt("SelectedServer", 0));
                 } else {
                parseSelectedServer(sp.getInt("ServerPos", 0));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void editServer(View p1,final int selectedItemPosition) {
        PopupMenu pupup =new PopupMenu(this, p1);
        pupup.getMenu().add(0, 0, 0, "Edit");
        pupup.getMenu().add(1, 1, 1, "Delete");
        pupup.getMenu().add(2, 2, 2, "Cancel");
        pupup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem p1) {
            switch (p1.getItemId()) {
              case 0:
                ServerDialog.Server a = new ServerDialog.Server(MainActivity.this);
                try {
                  final JSONArray ja = new JSONArray(sp.getString("FLYServers", "[]"));
                  a.edit(ja.getJSONObject(selectedItemPosition));
                  a.onServerAdd(
                      new SpinnerListener() {
                        @Override
                        public void onAdd(JSONObject json) {
                          try {
                            String[] ob = {
                              "FLY=Name",
                              "FLYFLAG",
                              "FLYsHost",
                              "FLYsPort",
                              "FLYsslPort",
                              "FLYreHost",
                              "FLYrePort",
                              "FLYUser",
                              "FLYPass",
                              "FLYInfo",
                              "FLYBugPayload",
                              "FLYBugSNI",
                              "FLYchavKey",
                              "FLYnvKey",
                              "FLYdnsKey",
                              "SSLMethod",
                              "SSLPayMethod",
                              "SSLRpMethod",
                              "SlowDNSMethod",
                              "DirectMethod",
                              "ProxyMethod"
                            };
                            for (int i = 0; i < ob.length; i++) {
                              ja.getJSONObject(selectedItemPosition).remove(ob[i]);
                            }
                            for (int i = 0; i < json.length(); i++) {
                              ja.getJSONObject(selectedItemPosition)
                                  .put(ob[i], json.getString(ob[i]));
                            }
                            sp.edit().putString("FLYServers", ja.toString()).apply();
                            isDelete = false;
                            saveServerData();
                          } catch (JSONException e) {
                            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                          }
                        }
                      });
                  a.init();
                } catch (JSONException e) {
                  Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
              case 1:
                deleteServer(sp.getInt("SelectedServer", 0));
                break;
            }
            return false;
          }
        });
    String str="";
    try {
            str = configs.getServersArray().getJSONObject(sp.getInt("SelectedServer", 0)).getString("FLYInfo");
        } catch (JSONException e) {
        }
        if (str.contains("Custom Server")) {
            pupup.show();
        }
    }
    
    public void deleteServer(final int position) {

        try {
            JSONArray ja=new JSONArray(sp.getString("FLYServers", "[]"));
            ja.remove(position);
            sp.edit().putString("FLYServers", ja.toString()).apply();
            isDelete = true;
            saveServerData();
        } catch (JSONException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    //end
    private InstallStateUpdatedListener installUpdatelistener = new InstallStateUpdatedListener()
	{
		@Override
		public void onStateUpdate(InstallState state) {
			if(state.installStatus() == InstallStatus.DOWNLOADED)
			{
				showCompleterUpdate();
			}
		}
	};

	private void showCompleterUpdate()
	{
		Snackbar snacks = Snackbar.make(findViewById(android.R.id.content), "New app is ready!",
										Snackbar.LENGTH_INDEFINITE);
		snacks.setAction("Install", new View.OnClickListener()
			{
				@Override
				public void onClick(View view) {
					mAppUpdateManager.completeUpdate();
				}
			});
		snacks.setActionTextColor(Color.parseColor("#ffffff"));
		snacks.show();
	}
    
     
    /**
     * Drawer Main
     */

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    public void doDrawerMain(Toolbar toolbar) {
        NavigationView drawerNavigationView = (NavigationView) findViewById(R.id.drawerNavigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.cancel);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        
        // set app info
        PackageInfo pinfo = Utils.getAppInfo(this);
        if (pinfo != null) {
            String version_nome = pinfo.versionName;
            int version_code = pinfo.versionCode;
            String header_text = String.format("v. %s (%d)", version_nome, version_code);
            View view = drawerNavigationView.getHeaderView(0);
//            TextView app_info_text = view.findViewById(R.id.nav_headerAppVersion);
//            app_info_text.setText(header_text);
        }
        // set navigation view
      //  drawerNavigationView.setNavigationItemSelectedListener(this);
    }
     

	private void parseSelectedServer(int i) {
        if (i == 0) {
            
        try {
            JSONObject jSONObject = configs.getServersArray().getJSONObject(Utils.nextIntInRange(i, configs.getServersArray().length(), new Random()));
            sp.edit().putString("SSHName", "Best Server").commit();
            sp.edit().putString("ServerFLAG", "random").commit();
            sp.edit().putString("FLYInfo", "Auto Select").commit();
            sp.edit().putString("FLYsHost", HSCryptA.decrypt(HSDevTeam, jSONObject.getString("FLYsHost"))).commit();
            sp.edit().putString("FLYsPort", HSCryptC.decrypt(HSDevTeam, jSONObject.getString("FLYsPort"))).commit();
            sp.edit().putString("FLYsslPort", HSCryptC.decrypt(HSDevTeam, jSONObject.getString("FLYsslPort"))).commit();
            sp.edit().putString("FLYreHost", HSCryptB.decrypt(HSDevTeam, jSONObject.getString("FLYreHost"))).commit();
            sp.edit().putString("FLYrePort", HSCryptD.decrypt(HSDevTeam, jSONObject.getString("FLYrePort"))).commit();
            sp.edit().putString("FLYUser", HSCryptE.decrypt(HSDevTeam, jSONObject.getString("FLYUser"))).commit();
            sp.edit().putString("FLYPass", HSCryptE.decrypt(HSDevTeam, jSONObject.getString("FLYPass"))).commit();
            sp.edit().putString("FLYBugPayload", HSCryptD.decrypt(HSDevTeam, jSONObject.getString("FLYBugPayload"))).commit();
            sp.edit().putString("FLYBugSNI", HSCryptA.decrypt(HSDevTeam, jSONObject.getString("FLYBugSNI"))).commit();
            sp.edit().putString("FLYchavKey", HSCryptD.decrypt(HSDevTeam, jSONObject.getString("FLYchavKey"))).commit();
            sp.edit().putString("FLYnvKey", HSCryptD.decrypt(HSDevTeam, jSONObject.getString("FLYnvKey"))).commit();
            sp.edit().putString("FLYdnsKey", HSCryptB.decrypt(HSDevTeam, jSONObject.getString("FLYdnsKey"))).commit();
            sp.edit().putBoolean("SSLMethod", jSONObject.getBoolean("SSLMethod")).commit();
            sp.edit().putBoolean("SSLRpMethod", jSONObject.getBoolean("SSLRpMethod")).commit();
            sp.edit().putBoolean("SlowDNSMethod", jSONObject.getBoolean("SlowDNSMethod")).commit();
            sp.edit().putBoolean("DirectMethod", jSONObject.getBoolean("DirectMethod")).commit();
            sp.edit().putBoolean("ProxyMethod", jSONObject.getBoolean("ProxyMethod")).commit();  
            sp.edit().putBoolean("SSLPayMethod", jSONObject.getBoolean("SSLPayMethod")).commit(); 
            server_edit.setVisibility(View.GONE);
                } catch (Exception e) {
                return;
            }
        }else if(i ==1){
            sp.edit().putString("SSHName", "Custom Setup").commit();
            sp.edit().putString("ServerFLAG", "random").commit();
            sp.edit().putString("FLYInfo", "Custom").commit();
            server_edit.setVisibility(View.VISIBLE);
            servIcon.setImageResource(R.drawable.icons);
        }
       try {
            jSONObject = configs.getServersArray().getJSONObject(i - 2);
            sp.edit().putString("SSHName", jSONObject.getString("FLYName")).commit();
            sp.edit().putString("ServerFLAG", jSONObject.getString("FLYFLAG")).commit();
            sp.edit().putString("FLYInfo", jSONObject.getString("FLYInfo")).commit();
            sp.edit().putString("FLYsHost", jSONObject.getString("FLYsHost")).commit();
            sp.edit().putString("FLYsPort", jSONObject.getString("FLYsPort")).commit();
            sp.edit().putString("FLYsslPort", jSONObject.getString("FLYsslPort")).commit();
            sp.edit().putString("FLYreHost", jSONObject.getString("FLYreHost")).commit();
            sp.edit().putString("FLYrePort", jSONObject.getString("FLYrePort")).commit();
            sp.edit().putString("FLYUser", jSONObject.getString("FLYUser")).commit();
            sp.edit().putString("FLYPass", jSONObject.getString("FLYPass")).commit();
            sp.edit().putString("FLYBugPayload", jSONObject.getString("FLYBugPayload")).commit();
            sp.edit().putString("FLYBugSNI", jSONObject.getString("FLYBugSNI")).commit();
            sp.edit().putString("FLYchavKey", jSONObject.getString("FLYchavKey")).commit();
            sp.edit().putString("FLYnvKey", jSONObject.getString("FLYnvKey")).commit();
            sp.edit().putString("FLYdnsKey", jSONObject.getString("FLYdnsKey")).commit();
            sp.edit().putBoolean("SSLMethod", jSONObject.getBoolean("SSLMethod")).commit();
            sp.edit().putBoolean("SSLRpMethod", jSONObject.getBoolean("SSLRpMethod")).commit();
            sp.edit().putBoolean("SlowDNSMethod", jSONObject.getBoolean("SlowDNSMethod")).commit();
            sp.edit().putBoolean("DirectMethod", jSONObject.getBoolean("DirectMethod")).commit();
            sp.edit().putBoolean("ProxyMethod", jSONObject.getBoolean("ProxyMethod")).commit();  
            sp.edit().putBoolean("SSLPayMethod", jSONObject.getBoolean("SSLPayMethod")).commit(); 
            server_edit.setVisibility(View.GONE);
            } catch (Exception e) {
//            return;
           }
            sp.edit().putInt("SelectedServer", i - 2).apply();
            setServerFlag();
            servName.setText(sp.getString("SSHName", "Best Server"));
            serverInfo.setText(sp.getString("FLYInfo", "Auto Select"));
    }
    
    public void setServerFlag() {
        String lowerCase = sp.getString("ServerFLAG", "").toLowerCase();
        String name = sp.getString("FLYInfo","").toLowerCase();
        if (lowerCase.contains("sg")) {
            servIcon.setImageResource(R.drawable.sg);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("us")) {
            servIcon.setImageResource(R.drawable.us);
             if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("uk")) {
            servIcon.setImageResource(R.drawable.uk);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("jp")) {
            servIcon.setImageResource(R.drawable.jp);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("tl")) {
            servIcon.setImageResource(R.drawable.tl);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("th")) {
            servIcon.setImageResource(R.drawable.th);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("ph")) {
            servIcon.setImageResource(R.drawable.ph);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("kr")) {
            servIcon.setImageResource(R.drawable.kr);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("ca")) {
            servIcon.setImageResource(R.drawable.ca);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else if (lowerCase.contains("ie")) {
            servIcon.setImageResource(R.drawable.ie);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("ch")) {
            servIcon.setImageResource(R.drawable.ch);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("de")) {
            servIcon.setImageResource(R.drawable.de);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("fr")) {
            servIcon.setImageResource(R.drawable.fr);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("hk")) {
            servIcon.setImageResource(R.drawable.hk);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("id")) {
            servIcon.setImageResource(R.drawable.id);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("in")) {
            servIcon.setImageResource(R.drawable.in);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("lb")) {
            servIcon.setImageResource(R.drawable.lb);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("mm")) {
            servIcon.setImageResource(R.drawable.mm);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("pt")) {
            servIcon.setImageResource(R.drawable.pt);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("tk")) {
            servIcon.setImageResource(R.drawable.tk);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("tw")) {
            servIcon.setImageResource(R.drawable.tw);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("uo")) {
            servIcon.setImageResource(R.drawable.uo);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("vt")) {
            servIcon.setImageResource(R.drawable.vt);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("at")) {
            servIcon.setImageResource(R.drawable.at);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("br")) {
            servIcon.setImageResource(R.drawable.br);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("kh")) {
            servIcon.setImageResource(R.drawable.kh);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("pl")) {
            servIcon.setImageResource(R.drawable.pl);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
		}else if (lowerCase.contains("nl")) {
            servIcon.setImageResource(R.drawable.nl);
            if (name.contains("vip")) {
                vipp.setVisibility(View.VISIBLE);
                free.setVisibility(View.GONE);
                } else {
                vipp.setVisibility(View.GONE);
                free.setVisibility(View.VISIBLE);
            }
        }else {
            servIcon.setImageResource(R.drawable.icons);
            vipp.setVisibility(View.GONE);
            free.setVisibility(View.GONE);
        }
	}
    
    void loadServer() {
        try {
            if (serversList.size() > 0) {
                serversList.clear();
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("COUNTRY", "Best Server");
            map.put("FLAG", "auto");
            map.put("INFO", "Auto Select");
            serversList.add(map);
            HashMap<String, String> map1 = new HashMap<String, String>();
            map1.put("COUNTRY", "Custom Setup");
            map1.put("FLAG", "auto");
            map1.put("INFO", "Custom");
            serversList.add(map1);
            JSONArray arr = configs.getServersArray();
            for (int i = 0; i < arr.length(); i++) {
            JSONObject jSONObject = arr.getJSONObject(i);
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            hashMap2.put("COUNTRY", jSONObject.optString("FLYName", jSONObject.optString("Name", "Server")));
            hashMap2.put("FLAG", jSONObject.optString("FLYFLAG", jSONObject.optString("Flag", "auto")));
            hashMap2.put("INFO", jSONObject.optString("FLYInfo", jSONObject.optString("ServerInfo", "")));
            serversList.add(hashMap2);
            }
        } catch (JSONException e) {
        }
    }

    public void onStatusChanged(int status) {
        switch (status)
        {
            case 0:
                // snack("Conectando...");
                break;
            case 1:
                //snack("Falha na autenticação!");
                break;
            case 2:
                ripple.stopRippleAnimation();
                ripple.setRippleColor(Color.parseColor(getString(R.color.color_disconnected)));
                ripple.startRippleAnimation();
                //snack("Desconectado");
                break;
            case 3:
                ripple.stopRippleAnimation();
                ripple.setRippleColor(Color.parseColor(getString(R.color.color_connected)));
                ripple.startRippleAnimation();
                break;
        }
    }
    
	/**
	 * Layout
	 */
    void initBytesInAndOut() {
        bytesIn = (TextView) findViewById(R.id.bytes_In);
        bytesOut = (TextView) findViewById(R.id.bytes_Out);
        StatisticGraphData.getStatisticData().setDisplayDataTransferStats(true);
    }

    private void updateHeaderCallback() {
        DataTransferStats dataTransferStats = StatisticGraphData.getStatisticData().getDataTransferStats();
        bytesIn.setText(dataTransferStats.byteCountToDisplaySize(dataTransferStats.getTotalBytesReceived(), false));
        bytesOut.setText(dataTransferStats.byteCountToDisplaySize(dataTransferStats.getTotalBytesSent(), false));
    }
	
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
	private void doLayout() {
    	setContentView(R.layout.activity_main_drawer);
        toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar_main);
        
        PackageInfo pinfo = Utils.getAppInfo(this);
        if (pinfo != null) {
        String version_nome = pinfo.versionName;
        int version_code = pinfo.versionCode;
            
        if (CheckVIP.isVIPBoolean()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Your Not VIP")
                    .setCancelable(false)
                    .setMessage("You Go to click Buy VIP")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }     
      
        prefs = mConfig.getPrefsPrivate();
        SharedPreferences.Editor edit = prefs.edit();
        final SharedPreferences sPrefs = mConfig.getPrefsPrivate();  
            
        @SuppressLint("DefaultLocale")
        String header_text = String.format("%s (%d)", version_nome, version_code);

        }
		
        cmTimer = (Chronometer) findViewById(R.id.cmTimer);
        cmTimer.setOnChronometerTickListener(new OnChronometerTickListener(){
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                    int h   = (int)(time /3600000);
                    int m = (int)(time - h*3600000)/60000;
                    int s= (int)(time - h*3600000- m*60000)/1000 ;
                    String t = (h < 10 ? "0"+h: h)+"h:"+(m < 10 ? "0"+m: m)+"m:"+ (s < 10 ? "0"+s: s)+"s";
                    chronometer.setText(t);
                }
            });
        cmTimer.setBase(SystemClock.elapsedRealtime());
        cmTimer.setText("00h:00m:00s");
             
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);       
        NavigationView navigationView = (NavigationView) findViewById(R.id.drawerNavigationView);

        navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
         
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                        
              case R.id.configUpdate:
                drawerLayout.closeDrawer(Gravity.START);
                updateConfig(false);
                return true;

              case R.id.buy_premium:
                drawerLayout.closeDrawers();
                Intent Premium = new Intent(MainActivity.this, Premium.class);
                startActivity(Premium);
                overridePendingTransition(R.anim.up_enter,R.anim.up_exit);      
                return true;
               
              case R.id.vip_login:
                Intent VIP = new Intent(MainActivity.this, VIPActivity.class);
                startActivity(VIP);
                overridePendingTransition(R.anim.up_enter,R.anim.up_exit);
                return true;  

              case R.id.geolocation:
                drawerLayout.closeDrawers();
                new UpdateCore(
                        MainActivity.this,
                        "http://ip-api.com/json",
                        new UpdateCore.Listener() {
                          @Override
                          public void onLoading() {
                            showSnackBar("Searching...");
                          }

                          @Override
                          public void onCompleted(String configs) throws Exception {
                            JSONObject geo = new JSONObject(configs);
                            StringBuffer sb = new StringBuffer();
                            sb.append("\n").append("ISP: ").append(geo.getString("isp"));
                            sb.append("\n").append("Time Zone: ").append(geo.getString("timezone"));
                            sb.append("\n")
                              .append("Country Code: ")
                              .append(geo.getString("countryCode"));
                            sb.append("\n").append("Country: ").append(geo.getString("country"));
                            sb.append("\n").append("Region: ").append(geo.getString("regionName"));
                            sb.append("\n").append("City: ").append(geo.getString("city"));

                            LayoutInflater inflater =
                            (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
                            AlertDialog.Builder builer = new AlertDialog.Builder(MainActivity.this);
                            builer.setView(inflate);
                            ImageView iv = inflate.findViewById(R.id.icon);
                            TextView title = inflate.findViewById(R.id.title);
                            TextView ms = inflate.findViewById(R.id.message);
                            TextView ok = inflate.findViewById(R.id.confirm);
                            iv.setImageResource(R.drawable.maps);
                            title.setText("Geo Location");
                            ms.setText(sb.toString());
                            ok.setText("Ok,Close");
                            final AlertDialog alert = builer.create();
                            alert.setCancelable(false);
                            alert
                                .getWindow()
                                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            //  alert.getWindow().setGravity();
                            alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
                            alert.show();
                            ok.setOnClickListener(
                                new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                    try {
                                      alert.dismiss();

                                    } catch (Exception e) {
                                      e.printStackTrace();
                                    }
                                  }
                                });

                            alert.show();
                          }

                          @Override
                          public void onCancelled() {}

                          @Override
                          public void onException(String ex) {
                            Toast.makeText(MainActivity.this, ex, Toast.LENGTH_SHORT).show();
                          }
                        })
                    .execute();
                return true;

              case R.id.telegram_ch:
                String url2 = "https://t.me/tazeteam9";
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(Intent.createChooser(intent2, getText(R.string.open_with)));
                break;

              case R.id.telegram_gp:
                String url3 = "https://t.me/tazechat9";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                startActivity(Intent.createChooser(intent3, getText(R.string.open_with)));
                break;
                        
              case R.id.facebook_page:
                String url5 = "https://facebook.com/TazeTeam";
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                startActivity(Intent.createChooser(intent5, getText(R.string.open_with)));
                break;                 

              case R.id.speedtest:
                Intent hstest = new Intent(MainActivity.this, SpeedTest.class);
                startActivity(hstest);
                overridePendingTransition(R.anim.up_enter,R.anim.up_exit);      
                return true;

              case R.id.changelogs:
                Changelogs();
                break;

              case R.id.miSettings:
                Intent intentSettings = new Intent(MainActivity.this, ConfigGeralActivity.class);
                //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentSettings);
                overridePendingTransition(R.anim.up_enter,R.anim.up_exit);      
                return true;

              case R.id.miAbout:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                overridePendingTransition(R.anim.up_enter,R.anim.up_exit);       
                break;
                        
              default:
                //    snack("Coming Soon!");
                return true;
            }
            return false;
          }
        });

        view1 = findViewById(R.id.relConnect);
        view2 = findViewById(R.id.bytes_In);
        view3 = findViewById(R.id.bytes_Out);
        view4 = findViewById(R.id.serverListLayout);
        view5 = findViewById(R.id.connection_status);

        btnMenu = (ImageView) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(this);  
        
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
        
        prefs = mConfig.getPrefsPrivate();
        SharedPreferences.Editor edit = prefs.edit();
        final SharedPreferences sPrefs = mConfig.getPrefsPrivate();
            
	    toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
	    setSupportActionBar(toolbar_main);
        
        cmTimer = (Chronometer) findViewById(R.id.cmTimer);
        free = (ImageView) findViewById(R.id.free);
        vipp = (ImageView) findViewById(R.id.vip);
        servIcon = (ImageView) findViewById(R.id.imageIconSpinner);
        servName = (TextView) findViewById(R.id.imageNameSpinner);
        servIcon.setImageResource(getResources().getIdentifier(sp.getString("ServerFLAG", "auto").toLowerCase().toString(), "drawable", getPackageName()));
        servName.setText(sp.getString("SSHName", "Best Server"));
        server_edit = (ImageView) findViewById(R.id.server_edit);
        if (sp.getInt("ServerPos", 0) == 1) {
            server_edit.setVisibility(View.VISIBLE);
        }
        server_edit.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View p1) {
                    addserver();
                }
        });
        servLay = (LinearLayout) findViewById(R.id.serverListLayout);
        servLay.setOnLongClickListener(this);
        serverInfo = (TextView) findViewById(R.id.infoServer);
        serverInfo.setText(sp.getString("FLYInfo", "Auto Select"));
        
        servLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View p1) {
                    final BottomSheetDialog dialog;
                    LinearLayout ll = new LinearLayout(MainActivity.this);
                    ll.setOrientation(1);
                    TextView tv = new TextView(MainActivity.this);
                    tv.setPadding(20, 20, 20, 20);

                    tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
                    //  tv.setTypeface(tv.getTypeface(), Typeface.ITALIC);
                    ll.addView(tv);
                    RecyclerView rv = new RecyclerView(MainActivity.this);
                    rv.setHasFixedSize(true);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    //rv.setNestedScrollingEnabled(false);
                    rv.setItemAnimator(new DefaultItemAnimator());
                    rv.setAdapter(new ServerAdapter(MainActivity.this, true, sp.getInt("ServerPos", 0), serversList));
                    rv.scrollToPosition(sp.getInt("ServerPos", 0));
                     ll.addView(rv);
                 if (mConfig.getModoNoturno().equals("off")) {
                  dialog = new BottomSheetDialog(MainActivity.this,R.style.AppBottomSheetDialogTheme_Light);
                             
                } else {
                    dialog=new BottomSheetDialog(MainActivity.this, R.style.AppBottomSheetDialogTheme);
                }
                   // final BottomSheetDialog dialog = new BottomSheetDialog(SocksHttpMainActivity.this);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setContentView(ll);
					dialog.show();
                                   rv.addOnItemTouchListener(new RecyclerItemTouch(MainActivity.this, rv, 
                                                  new RecyclerItemTouch.ClickListener() {
                                                      @Override
                                                      public void onClick(View view, int i) {
                                                          sp.edit().putInt("ServerPos", i).commit();
                                                          parseSelectedServer(i);
                                                          dialog.dismiss();
                                                      }

                                                      @Override
                                                      public void onLongClick(View view, int i) {

                                                      }
                                                  }));
            }
            
			});
        
        cmTimer.setOnChronometerTickListener(new OnChronometerTickListener(){
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                    int h   = (int)(time /3600000);
                    int m = (int)(time - h*3600000)/60000;
                    int s= (int)(time - h*3600000- m*60000)/1000 ;
                    String t = (h < 10 ? "0"+h: h)+"h:"+(m < 10 ? "0"+m: m)+"m:"+ (s < 10 ? "0"+s: s)+"s";
                    chronometer.setText(t);
                }
            });
        cmTimer.setBase(SystemClock.elapsedRealtime());
        cmTimer.setText("00h:00m:00s");
                                     
        View bottomSheet = findViewById(R.id.bottom_sheet);
        this.bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        this.bshl = findViewById(R.id.bshl);
        iv1 = (ImageView) findViewById(R.id.ivLogsDown);
    
        View persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);

        final BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);
        behavior.setBottomSheetCallback(
        new BottomSheetBehavior.BottomSheetCallback() {
        @Override
          public void onStateChanged(@NonNull View view, int i) {
            switch (i) {
              case BottomSheetBehavior.STATE_COLLAPSED:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                iv1.animate().setDuration(500).rotation(0);
                break;
              case BottomSheetBehavior.STATE_EXPANDED:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                iv1.animate().setDuration(300).rotation(180);
                break;
              case BottomSheetBehavior.STATE_HIDDEN:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                if (iv1.getRotation() == 0) {
                  iv1.animate().setDuration(500).rotation(180);
                } else {
                  iv1.animate().setDuration(500).rotation(0);
                }
                break;
            }
        }

        @Override
          public void onSlide(@NonNull View view, float slideOffset) {}
         });

        bshl.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
              bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
              iv1.animate().setDuration(500).rotation(180);
            }
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
              bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
              iv1.animate().setDuration(500).rotation(0);
            }
          }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new LogsAdapter(layoutManager, this);
        deleteLogs = (FloatingActionButton) findViewById(R.id.clearLog);
        logList = (RecyclerView) findViewById(R.id.recyclerLog);
        logList.setAdapter(mAdapter);
        logList.setLayoutManager(layoutManager);
        mAdapter.scrollToLastPosition();
        deleteLogs.setOnClickListener(
        new OnClickListener() {

          @Override
          public void onClick(View p1) {
            mAdapter.clearLog();
            SkStatus.logInfo("<font color='green'>Log Cleared!</font>");
            // TODO: Implement this method
          }
        });
        
        ripple = (Ripple) findViewById(R.id.content);
        connectionStatus = (TextView) findViewById(R.id.connection_status);
        configs = new FileUtil(this);
        sheetvipOpen = (View) findViewById(R.id.sheetvipopen);
        sheetvipOpen.setOnClickListener(this);
        statusVip1 = (ImageView) findViewById(R.id.statusvip1);
		statusVip2 = (ImageView) findViewById(R.id.statusvip2);
        statusVip2text = (TextView) findViewById(R.id.statusvip2text);
		statusVip1text = (TextView) findViewById(R.id.statusvip1text);
        premium();
        mainLayout = (LinearLayout) findViewById(R.id.activity_mainLinearLayout);
		loginLayout = (LinearLayout) findViewById(R.id.activity_mainInputPasswordLayout);
		
        starterButton = (ImageView) findViewById(R.id.activity_starterButtonMain);
        starterButton.setOnClickListener(this);
		
        inputPwUser = (TextInputEditText) findViewById(R.id.activity_mainInputPasswordUserEdit);
		inputPwPass = (TextInputEditText) findViewById(R.id.activity_mainInputPasswordPassEdit);
		inputPwShowPass = (ImageButton) findViewById(R.id.activity_mainInputShowPassImageButton);
		inputPwShowPass.setOnClickListener(this);
        
		((TextView) findViewById(R.id.activity_mainAutorText))
	    .setOnClickListener(this);
        proxyInputLayout = (LinearLayout) findViewById(R.id.activity_mainInputProxyLayout);
		proxyText = (TextView) findViewById(R.id.activity_mainProxyText);
        
        final SharedPreferences prefs = mConfig.getPrefsPrivate();
        sPrefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, false).apply();
		sPrefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_PROXY).apply();
     
        config = new ConfigUtil(this);
		serverSpinner = (Spinner) findViewById(R.id.serverSpinner);
        serversList = new ArrayList<HashMap<String, String>>();
        serverSpinner.setOnLongClickListener(this);  
		loadServer();
        updateConfig(true);
        
		metodoConexaoRadio = (RadioGroup) findViewById(R.id.activity_mainMetodoConexaoRadio);
		customPayloadSwitch = (SwitchCompat) findViewById(R.id.activity_mainCustomPayloadSwitch);
		proxyInputLayout.setOnClickListener(this);
		payloadLayout = (LinearLayout) findViewById(R.id.activity_mainInputPayloadLinearLayout);
		payloadEdit = (TextInputEditText) findViewById(R.id.activity_mainInputPayloadEditText);
	    configMsgLayout = (LinearLayout) findViewById(R.id.activity_mainMensagemConfigLinearLayout);
		configMsgText = (TextView) findViewById(R.id.activity_mainMensagemConfigTextView);
        setSpinner();
        payloadLayout = (LinearLayout) findViewById(R.id.activity_mainInputPayloadLinearLayout);
        payloadEdit = (TextInputEditText) findViewById(R.id.activity_mainInputPayloadEditText);

        // fix bugs
		if (mConfig.getPrefsPrivate().getBoolean(Settings.CONFIG_PROTEGER_KEY, false)) {
			if (mConfig.getPrefsPrivate().getBoolean(Settings.CONFIG_INPUT_PASSWORD_KEY, false)) {
				inputPwUser.setText(mConfig.getPrivString(Settings.USUARIO_KEY));
				inputPwPass.setText(mConfig.getPrivString(Settings.SENHA_KEY));
			}
		}
        customPayloadSwitch.setChecked(true);
        edit.putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, !true);
        metodoConexaoRadio.setOnCheckedChangeListener(this);
       }
    
    public void premium(){
		final SharedPreferences myPrefo = getSharedPreferences("MY_PREFSONNE",MODE_PRIVATE);
        boolean vip_switchone = myPrefo.getBoolean("VIP_SWITCHONE", false);
        final SharedPreferences myPrefet = getSharedPreferences("MY_PREFSTWO",MODE_PRIVATE);
        boolean vip_switchtwo = myPrefet.getBoolean("VIP_SWITCHTWO", false);

		if (vip_switchone == true) {
			statusVip1.setBackgroundResource(R.drawable.vip);
			statusVip2.setBackgroundResource(R.drawable.vip2);
			statusVip2text.setText("VIP");
            statusVip1text.setText("You Are VIP");
			sheetvipOpen.setBackgroundResource(R.drawable.bg_roundtwovip);
		
		} else if (vip_switchtwo == true) {
				statusVip1.setBackgroundResource(R.drawable.vip);
				statusVip2.setBackgroundResource(R.drawable.vip2);
				statusVip2text.setText("VIP");
                statusVip1text.setText("You Are VIP");
				sheetvipOpen.setBackgroundResource(R.drawable.bg_roundtwovip);
		
        	} else {
				statusVip1.setBackgroundResource(R.drawable.govip);
				statusVip2.setBackgroundResource(R.drawable.free);
				statusVip2text.setText("Free");
				statusVip1text.setText("Go VIP");
				sheetvipOpen.setBackgroundResource(R.drawable.bg_roundvip);
	    }
	}
    
	private void doUpdateLayout() {
   	setStarterButton(starterButton, this);
	}
	
	private synchronized void doSaveData() {
        try {
            SharedPreferences prefsPrivate = mConfig.getPrefsPrivate();
            SharedPreferences.Editor edit = prefsPrivate.edit();
            
            edit.apply();
            if (mainLayout != null && !isFinishing())
                mainLayout.requestFocus();

            if(!prefs.getBoolean(Settings.CONFIG_PROTEGER_KEY, false)) {
                if (payloadEdit != null && !prefs.getBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, true)) {
                    parseSelectedServer(sp.getInt("ServerPos", 0));
                    
                    boolean ssltype = sp.getBoolean("SSLMethod", false);
                    boolean sslpaytype = sp.getBoolean("SSLPayMethod", false);
                    boolean sslrptype = sp.getBoolean("SSLRpMethod", false);
                    boolean slowdnstype = sp.getBoolean("SlowDNSMethod", false);
                    boolean directtype = sp.getBoolean("DirectMethod", false);
                    boolean proxytype = sp.getBoolean("ProxyMethod", false);
                    
                    if (ssltype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_SSL).apply();
                        String sni = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYBugSNI",""));
                        edit.putString(Settings.CUSTOM_SNI, sni);
                        edit.apply();
                        
                    } else if (directtype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT).apply();
                        if (HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload", "")) == Settings.PAYLOAD_DEFAULT) {
                        edit.putString("FLYBugPayload" , Settings.PAYLOAD_DEFAULT);
                        edit.apply();
                        } else {
                        String payload = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload", ""));
                        edit.putString(Settings.CUSTOM_PAYLOAD_KEY, payload);
                        edit.apply();
                        }
                        
                    } else if (proxytype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_PROXY).apply();
                        String payload = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload", ""));
                        edit.putString(Settings.CUSTOM_PAYLOAD_KEY, payload);   
                        edit.apply(); 
                        
                    }else if(sslpaytype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_PAY_SSL).apply();
                        String payload = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload",""));
                        String snissl = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYBugSNI",""));
                        edit.putString(Settings.CUSTOM_PAYLOAD_KEY, payload);
                        edit.putString(Settings.CUSTOM_SNI, snissl);
                        edit.apply();
                        
                    }else if (sslrptype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSL_RP).apply();
                        String payloadrp = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload",""));
                        String sslrp = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYBugSNI",""));
                        edit.putString(Settings.CUSTOM_PAYLOAD_KEY, payloadrp);
                        edit.putString(Settings.CUSTOM_SNI, sslrp);
                        edit.apply();
                        
                    }else if (slowdnstype){
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SLOWDNS).apply();
                        String chaveKey = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYchavKey", ""));
                        String serverNameKey = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYnvKey", ""));
                        String dnsKey = HSCryptB.decrypt(HSDevTeam, sp.getString("FLYdnsKey", ""));
                        edit.putString(Settings.CHAVE_KEY, chaveKey);
                        edit.putString(Settings.NAMESERVER_KEY, serverNameKey);
                        edit.putString(Settings.DNS_KEY, dnsKey);
                        edit.apply();
                        
                    }else {
                        prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_PROXY).apply();
                        String payload = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload",""));
                        edit.putString(Settings.CUSTOM_PAYLOAD_KEY, payload);
                        edit.apply();
                    }
                }
            }  
            else {
                if (prefs.getBoolean(Settings.CONFIG_INPUT_PASSWORD_KEY, false)) {
                    edit.putString(Settings.USUARIO_KEY, inputPwUser.getEditableText().toString());
                    edit.putString(Settings.SENHA_KEY, inputPwPass.getEditableText().toString());
                    edit.apply();
                }
            }
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadServerData() {
        try {
            SharedPreferences prefs = mConfig.getPrefsPrivate();
            SharedPreferences.Editor edit = prefs.edit();
            
            SharedPreferences myPreferenceones = getSharedPreferences("MY_PREFSONES",MODE_PRIVATE);
            int opn = myPreferenceones.getInt("STATUS_TRHEE",0);
	    	int honeblack = opn;
            parseSelectedServer(sp.getInt("ServerPos", 0));
 
            boolean ssltype = sp.getBoolean("SSLMethod", false);
            boolean sslpaytype = sp.getBoolean("SSLPayMethod", false);
            boolean sslrptype = sp.getBoolean("SSLRpMethod", false);
            boolean slowdnstype = sp.getBoolean("SlowDNSMethod", false);
            boolean directtype = sp.getBoolean("DirectMethod", false);
            boolean proxytype = sp.getBoolean("ProxyMethod", false);

           if (ssltype) {
                edit.putString(Settings.SERVIDOR_PORTA_KEY, HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsslPort", "")));
                
            }else if (sslpaytype){
                edit.putString(Settings.SERVIDOR_PORTA_KEY, HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsslPort", "")));      
                  
            }else if (sslrptype) {
                edit.putString(Settings.SERVIDOR_PORTA_KEY, HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsslPort", "")));
                
            }else if (slowdnstype){
                String server_ip = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYsHost", ""));
                String server_port = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsslPort", ""));
                edit.putString(Settings.SERVIDOR_KEY, server_ip);
				edit.putString(Settings.SERVIDOR_PORTA_KEY, server_port);
                
            } else if (directtype){
				String ssh_poqrt = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsPort", ""));
                edit.putString(Settings.SERVIDOR_PORTA_KEY, ssh_poqrt);
                
            } else if (proxytype) {
                String ssh_port = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsPort", ""));
                edit.putString(Settings.SERVIDOR_PORTA_KEY, ssh_port);      
                
            }else {
                edit.putString(Settings.SERVIDOR_PORTA_KEY, HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsPort", "")));
            }
            String server_host = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYsHost",""));
            String server_port = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsPort",""));
            String ssl_port = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYsslPort",""));
            String remote_proxy = HSCryptB.decrypt(HSDevTeam, sp.getString("FLYreHost",""));
            String remote_port = HSCryptC.decrypt(HSDevTeam, sp.getString("FLYrePort",""));
            String fly_user =  HSCryptE.decrypt(HSDevTeam, sp.getString("FLYUser",""));
            String fly_pass = HSCryptE.decrypt(HSDevTeam, sp.getString("FLYPass",""));
            String flypayload = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYBugPayload",""));
            String flysni = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYBugSNI",""));
            String flychaveKey = HSCryptD.decrypt(HSDevTeam, sp.getString("FLYchavKey",""));
            String flyserverNameKey = HSCryptA.decrypt(HSDevTeam, sp.getString("FLYnvKey",""));
            String flydnsKey = HSCryptB.decrypt(HSDevTeam, sp.getString("FLYdnsKey",""));
            String vip_user_token = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            
           //VIP Start
            final SharedPreferences myPrefo = getSharedPreferences("MY_PREFSONNE",MODE_PRIVATE);
            boolean vip_switchone = myPrefo.getBoolean("VIP_SWITCHONE", false);
            final SharedPreferences myPrefet = getSharedPreferences("MY_PREFSTWO",MODE_PRIVATE);
            boolean vip_switchtwo = myPrefet.getBoolean("VIP_SWITCHTWO", false);
        
            if(vip_switchone == true) {
            final SharedPreferences sp = getSharedPreferences("FLYVIP",MODE_PRIVATE);
            String vip_user = sp.getString("VipUser","");
            String vip_pass = sp.getString("VipPass","");
                
            edit.putString(Settings.USUARIO_KEY, vip_user);
            edit.putString(Settings.SENHA_KEY, vip_pass);
            edit.putString(Settings.SERVIDOR_KEY, server_host);
            edit.putString(Settings.PROXY_IP_KEY, remote_proxy);
            edit.putString(Settings.PROXY_PORTA_KEY, remote_port);
            edit.putString(Settings.CUSTOM_PAYLOAD_KEY, flypayload);
            edit.putString(Settings.CUSTOM_SNI, flysni);
            edit.putString(Settings.CHAVE_KEY, flychaveKey);
            edit.putString(Settings.NAMESERVER_KEY, flyserverNameKey);
            edit.putString(Settings.DNS_KEY, flydnsKey);
            edit.apply();           
                
            } else if (vip_switchtwo == true) {
            edit.putString(Settings.USUARIO_KEY, vip_user_token);
			edit.putString(Settings.SENHA_KEY, configs.HWIDPASS);
            edit.putString(Settings.SERVIDOR_KEY, server_host);
            edit.putString(Settings.PROXY_IP_KEY, remote_proxy);
            edit.putString(Settings.PROXY_PORTA_KEY, remote_port);
            edit.putString(Settings.CUSTOM_PAYLOAD_KEY, flypayload);
            edit.putString(Settings.CUSTOM_SNI, flysni);
            edit.putString(Settings.CHAVE_KEY, flychaveKey);
            edit.putString(Settings.NAMESERVER_KEY, flyserverNameKey);
            edit.putString(Settings.DNS_KEY, flydnsKey);
            edit.apply();           
                
           } else {
            edit.putString(Settings.USUARIO_KEY, fly_user);
            edit.putString(Settings.SENHA_KEY, fly_pass);
            edit.putString(Settings.SERVIDOR_KEY, server_host);
            edit.putString(Settings.PROXY_IP_KEY, remote_proxy);
            edit.putString(Settings.PROXY_PORTA_KEY, remote_port);
            edit.putString(Settings.CUSTOM_PAYLOAD_KEY, flypayload);
            edit.putString(Settings.CUSTOM_SNI, flysni);
            edit.putString(Settings.CHAVE_KEY, flychaveKey);
            edit.putString(Settings.NAMESERVER_KEY, flyserverNameKey);
            edit.putString(Settings.DNS_KEY, flydnsKey);
            edit.apply();           
   
            }
            //VIP END
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateConfig(final boolean isOnCreate) {
        new SecurePref(this, new SecurePref.OnUpdateListener() {
                @Override
                public void onUpdateListener(String result) {
                    try {
                        if (!result.contains("Error on getting data")) {
                            String json_data = decodeOrPlain(result);

                            // Manual update check: always allow user to apply latest config
                            // (avoids strict version-compare mismatch cases).
                            if (!isOnCreate) {
                                applyUpdateNow(result);
                                return;
                            }

                            // Auto check on app start keeps old version-compare behavior.
                            if (isNewVersion(json_data)) {
                                newUpdateDialog(result);
                            }
                        } else if(result.contains("Error on getting data") && !isOnCreate){
                            errorUpdateDialog(result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start(isOnCreate);
    }

    private String decodeOrPlain(String raw) {
        try {
            return AESCrypt.decrypt(configs.PASSWORD, raw);
        } catch (Exception ignored) {
            return raw;
        }
    }

    private boolean isNewVersion(String result) {
        try {
            String current = configs.getVersion();
            String update = new JSONObject(result).getString("FLYVersion");
            return configs.versionCompare(update, current);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private void welcomeNotif(){

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE); 
        Notification.Builder notification = new Notification.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.setChannelId(this.getPackageName() + "flyvpnpro.json");
            createNotification(notificationManager, this.getPackageName() + "flyvpnpro.json");
        }

        notification.setContentTitle(getString(R.string.app_name))
            .setContentText(("Config Updated"))
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icons))
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(Notification.PRIORITY_HIGH)
            .setShowWhen(true)
            .setSmallIcon(R.drawable.icons);
        notificationManager.notify(4130,notification.getNotification());
    }

    private void updateNotif(){

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE); 

        Notification.Builder notification = new Notification.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.setChannelId(this.getPackageName() + "FLYReleaseNotes");
            createNotification(notificationManager, this.getPackageName() + "FLYReleaseNotes");
        }

        notification.setContentTitle(getString(R.string.app_name))
            .setContentText(("New Update Available"))
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icons))
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(Notification.PRIORITY_HIGH)
            .setShowWhen(true)
            .setSmallIcon(R.drawable.update);
        notificationManager.notify(4130,notification.getNotification());
    }

    private void createNotification(NotificationManager notificationManager, String id)
    {
        NotificationChannel mNotif = new NotificationChannel(id, "flyvpnpro.json", NotificationManager.IMPORTANCE_HIGH);
        NotificationChannel mNotif1 = new NotificationChannel(id, "FLYReleaseNotes", NotificationManager.IMPORTANCE_HIGH);
        mNotif.setShowBadge(true);
        mNotif1.setShowBadge(true);
        notificationManager.createNotificationChannel(mNotif);
        // TODO: Implement this method
    }
    
    private void newUpdateDialog(final String result) throws JSONException, GeneralSecurityException{
        updateNotif();
        notif2();
        String json_data = decodeOrPlain(result);
        String notes = new JSONObject(json_data).getString("FLYReleaseNotes");
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.update_help, (ViewGroup) null);
        AlertDialog.Builder builer = new AlertDialog.Builder(this); 
        builer.setView(inflate); 
        ImageView iv = inflate.findViewById(R.id.icon);
        TextView title = inflate.findViewById(R.id.title);
        TextView ms = inflate.findViewById(R.id.message);
        TextView ok = inflate.findViewById(R.id.confirm);
		iv.setImageResource(R.drawable.update);
        title.setText("New Update Available");
        ms.setText(notes);
        ok.setText("Apply & Restart");
        final AlertDialog alert = builer.create(); 
        alert.setCanceledOnTouchOutside(false);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.getWindow().setGravity(Gravity.CENTER); 
        alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
        alert.show();
        ok.setOnClickListener(new View.OnClickListener() { 
                @Override 
                public void onClick(View v) { 
                    welcomeNotif();
                    // TODO: Implement this method
                    try
                    {
                        File file = new File(getFilesDir(), "flyvpnpro.json");
                        OutputStream out = new FileOutputStream(file);
                        out.write(result.getBytes());
                        out.flush();
                        out.close();
                        startActivity(getIntent());
						finish();
						overridePendingTransition(0, 0);        
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                
            });
        alert.show();
    }
    
    @SuppressLint("SetTextI18n")
    private void applyUpdateNow(String result) {
        try {
            File file = new File(getFilesDir(), "flyvpnpro.json");
            OutputStream out = new FileOutputStream(file);
            out.write(result.getBytes());
            out.flush();
            out.close();
            welcomeNotif();
            Toast.makeText(getApplicationContext(), "Config applied. Restarting...", Toast.LENGTH_SHORT).show();
            startActivity(getIntent());
            finish();
            overridePendingTransition(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Apply failed", Toast.LENGTH_LONG).show();
        }
    }

    private void noUpdateDialog() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
        AlertDialog.Builder builer = new AlertDialog.Builder(this); 
        builer.setView(inflate); 
        ImageView iv = inflate.findViewById(R.id.icon);
        TextView title = inflate.findViewById(R.id.title);
        TextView ms = inflate.findViewById(R.id.message);
        TextView ok = inflate.findViewById(R.id.confirm);
        iv.setImageResource(R.drawable.ai_bot);
        title.setText("No Update Available");
        ms.setText("There is a no new update found");
        ok.setText("OK");
        final AlertDialog alert = builer.create(); 
        alert.setCanceledOnTouchOutside(false);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.getWindow().setGravity(Gravity.CENTER); 
        alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
        alert.show();
        ok.setOnClickListener(new View.OnClickListener() { 
                @Override 
                public void onClick(View v) { 
                    try
                    {
                        alert.dismiss();


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }});

        alert.show();
    }

    private void errorUpdateDialog(String error) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
        AlertDialog.Builder builer = new AlertDialog.Builder(this); 
        builer.setView(inflate); 
        ImageView iv = inflate.findViewById(R.id.icon);
        TextView title = inflate.findViewById(R.id.title);
        TextView ms = inflate.findViewById(R.id.message);
        TextView ok = inflate.findViewById(R.id.confirm);
        iv.setImageResource(R.drawable.error);
        title.setText("Update Error");
        ms.setText("Please check your internet connection again  \nIf not, please contact the admin team");
        ok.setText("OK");
        final AlertDialog alert = builer.create(); 
        alert.setCanceledOnTouchOutside(false);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.getWindow().setGravity(Gravity.CENTER); 
        alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
        alert.show();
        ok.setOnClickListener(new View.OnClickListener() { 
                @Override 
                public void onClick(View v) { 
                    try
                    {
                        alert.dismiss();


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }});

        alert.show();
    }
    
    private void snack(String msg) {
        Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT).show();
    }

    void showSnackBar(String message)
    {
        View customPos = (View) findViewById(R.id.coordinator); 
        final Snackbar snac = Snackbar.make(customPos, message, Snackbar.LENGTH_LONG); 
        snac.getView().setBackgroundColor(ContextCompat.getColor(customPos.getContext(), R.color.white)); 
        snac.setActionTextColor(getResources().getColor(R.color.white)); 
        customPos = snac.getView(); 
        TextView setTxtGravity = (TextView) customPos.findViewById(com.google.android.material.R.id.snackbar_text); 
        setTxtGravity.setTextAlignment(customPos.TEXT_ALIGNMENT_CENTER); 
        snac.show(); 
	}
    
    private void restart_app() {
        Intent intent = new Intent(this, MainActivity.class);
        int i = 123456;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, i, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + ((long) 1000), pendingIntent);
        finish();
    }
   
	private String importer(Uri uri)
	{
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try
		{
			reader = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));

			String line = "";
			while ((line = reader.readLine()) != null)
			{
				builder.append(line);
			}
			reader.close();
		}
		catch (IOException e) {e.printStackTrace();}
		return builder.toString();
	} 
    
	/**
	 * Tunnel SSH
	 */
        
    @SuppressLint("SetTextI18n")
	public void startOrStopTunnel(Activity activity) {
        
		if (SkStatus.isTunnelActive()) {
            SharedPreferences prefs = mConfig.getPrefsPrivate();
            TunnelManagerHelper.stopSocksHttp(activity);
            cmTimer.stop();
            cmTimer.setText("00h:00m:00s");
        	} else { 
            cmTimer.setBase(SystemClock.elapsedRealtime());
            cmTimer.start();   
                     
            if (!TunnelUtils.isNetworkOnline(this)) {
				Toast.makeText(this, "Check your network connection!", Toast.LENGTH_SHORT).show();
                
			} else if (mConfig.getPrivString(Settings.USUARIO_KEY).isEmpty() ||
				mConfig.getPrivString(Settings.SENHA_KEY).isEmpty()) {
				Toast.makeText(this, "Please Login Frist Go VIP :(", Toast.LENGTH_SHORT).show();          
            
       	} else {
            final SharedPreferences myPrefo = getSharedPreferences("MY_PREFSONNE",MODE_PRIVATE);
            boolean vip_switchone = myPrefo.getBoolean("VIP_SWITCHONE", false);
                
	    	final SharedPreferences myPrefet = getSharedPreferences("MY_PREFSTWO",MODE_PRIVATE);
            boolean vip_switchtwo = myPrefet.getBoolean("VIP_SWITCHTWO", false);
                
//            String fly_user = sp.getString("FLYUser","");
            
            if(vip_switchone == true) {
		 	launchVPN();
			 drawerLayout.isDrawerOpen(GravityCompat.START);
             drawerLayout.closeDrawers();
			
		   } else  if (vip_switchtwo == true) {
	         launchVPN();
             drawerLayout.isDrawerOpen(GravityCompat.START);
             drawerLayout.closeDrawers();
 
	       } else {
		 	launchVPN();
             drawerLayout.isDrawerOpen(GravityCompat.START);
             drawerLayout.closeDrawers();
	
			}
         }
	  }
	}
    
     private void launchVPN() {
		Intent intent = VpnService.prepare(this);

        if (intent != null) {
            SkStatus.updateStateString("USER_VPN_PERMISSION", "", R.string.state_user_vpn_permission,
									   ConnectionStatus.LEVEL_WAITING_FOR_USER_INPUT);
            // Start the query
            try {
                startActivityForResult(intent, START_VPN_PROFILE);
            } catch (ActivityNotFoundException ane) {
                SkStatus.logError(R.string.no_vpn_support_image);
            }
        } else {
            SkStatus.updateStateString("USER_VPN_PERMISSION", "", R.string.state_user_vpn_permission,
                                       ConnectionStatus.LEVEL_WAITING_FOR_USER_INPUT);
            onActivityResult(START_VPN_PROFILE, Activity.RESULT_OK, null);
        }
		
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE)
        {
            if (resultCode == RESULT_OK) {
                try {
                    Uri uri = data.getData();
                    String intentData = importer(uri);
                    //String cipter = AESCrypt.decrypt(ConfigUtil.PASSW0RD, intentData);
                    File file = new File(getFilesDir(), "flyvpnpro.json");
                    OutputStream out = new FileOutputStream(file);
                    out.write(intentData.getBytes());
                    out.flush();
                    out.close();
                    restart_app();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		if (requestCode == START_VPN_PROFILE) {
            if (resultCode == Activity.RESULT_OK) {
				SharedPreferences prefs = mConfig.getPrefsPrivate();

				if (!TunnelUtils.isNetworkOnline(this)) {
					Toast.makeText(getApplicationContext(),"Without internet or in airplane mode",Toast.LENGTH_SHORT).show();
				} else
					TunnelManagerHelper.startSocksHttp(this);
				
			}
		}}
    
    public void offlineUpdate() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		startActivityForResult(intent, PICK_FILE);
	}
	
	public void setStarterButton(ImageView starterButton, Activity activity) {
        String state = SkStatus.getLastState();
        boolean isRunning = SkStatus.isTunnelActive();

        if (starterButton != null) {
            int resId;

            SharedPreferences prefsPrivate = new Settings(activity).getPrefsPrivate();

            if (ConfigParser.isValidadeExpirou(prefsPrivate
                                               .getLong(Settings.CONFIG_VALIDADE_KEY, 0))) {
                resId = R.string.expired;
                starterButton.setEnabled(false);

                if (isRunning) {
                    startOrStopTunnel(activity);
                }
            }
            else if (prefsPrivate.getBoolean(Settings.BLOQUEAR_ROOT_KEY, false) &&
                     ConfigParser.isDeviceRooted(activity)) {
                resId = R.string.blocked;
                starterButton.setEnabled(false);

                Toast.makeText(activity, R.string.error_root_detected, Toast.LENGTH_SHORT)
                    .show();

                if (isRunning) {
                    startOrStopTunnel(activity);
                }
            }
            else if (SkStatus.SSH_STARTING.equals(state)) {
                resId = R.string.stop;
                starterButton.setEnabled(false); 
				servLay.setEnabled(false);
            }
            else if (SkStatus.SSH_STOPPING.equals(state)) {
                resId = R.string.state_stopping;
                starterButton.setEnabled(false);
                
            }else if (SkStatus.SSH_DISCONNECTED.equals(state)){
                resId = R.string.start;
                starterButton.setEnabled(true);
				servLay.setEnabled(true);
                
            }else {
                resId = isRunning ? R.string.stop : R.string.start;
                starterButton.setEnabled(true);
            }
          //  starterButton.setText(resId);
        }
	}
	
	@Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
    }
  
	private boolean isMostrarSenha = false;
	
    @SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View p1)
	{
		SharedPreferences prefs = mConfig.getPrefsPrivate();

		switch (p1.getId()) {
			case R.id.activity_starterButtonMain:
			doSaveData();
			loadServerData();
			startOrStopTunnel(this);
            mShown = false;
            mShown2 = false;
            
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             v.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            }
            break;
                 
            case R.id.btnMenu:
                 showMenu();
                 break;
            
            case R.id.sheetvipopen:
                 drawerLayout.closeDrawers();
                 Intent vipopen = new Intent(MainActivity.this, VIPActivity.class);
                 startActivity(vipopen);
                 overridePendingTransition(R.anim.up_enter,R.anim.up_exit);      
                 break;
            
            case R.id.activity_mainInputProxyLayout:
				if (!prefs.getBoolean(Settings.CONFIG_PROTEGER_KEY, false)) {
					doSaveData();

					DialogFragment fragProxy = new ProxyRemoteDialogFragment();
					fragProxy.show(getSupportFragmentManager(), "proxyDialog");
				}
				break;
            
			case R.id.activity_mainAutorText:
				String url = "https://t.me/noobqueenn";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, getText(R.string.open_with)));
				break;
            
            case R.id.activity_mainInputShowPassImageButton:
				isMostrarSenha = !isMostrarSenha;
				if (isMostrarSenha) {
					inputPwPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
					inputPwShowPass.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_visibility_black_24dp));
				}
				else {
					inputPwPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					inputPwShowPass.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_visibility_off_black_24dp));
				}
			break;
            }
        }

       @SuppressLint("NonConstantResourceId")
       void showMenu() {
       PopupMenu popup = new PopupMenu(this, btnMenu);
       MenuInflater inflater = popup.getMenuInflater();
       inflater.inflate(R.menu.main_menu, popup.getMenu());
       popup.setOnMenuItemClickListener(
        p1 -> {
          switch (p1.getItemId()) {
                    
            case R.id.rate:
                  rateplaystore();
                  break;
                         
            case R.id.guide:
                  guides();
                  break;

            case R.id.tips:
                 walangLaman();
                 break;
                    
            case R.id.tips1:
                 clearz();
                 break;     
             
          }
          return true;
        });
    popup.show();
   }

	@Override
	public void onCheckedChanged(RadioGroup p1, int p2)
	{
		SharedPreferences.Editor edit = mConfig.getPrefsPrivate().edit();

		switch (p1.getCheckedRadioButtonId()) {
			case R.id.activity_mainSSHDirectRadioButton:
				edit.putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT);
				proxyInputLayout.setVisibility(View.GONE);
				break;

			case R.id.activity_mainSSHProxyRadioButton:
				edit.putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_PROXY);
				proxyInputLayout.setVisibility(View.VISIBLE);
				break;
		}

		edit.apply();
        
		doSaveData();
		doUpdateLayout();
	}

	protected void showBoasVindas() {
		new AlertDialog.Builder(this)
            . setTitle(R.string.attention)
            . setMessage(R.string.first_start_msg)
			. setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface di, int p) {
					// ok
				}
			})
			. setCancelable(false)
            . show();
	}
	
    @SuppressLint("ResourceType")
	@Override
    public void updateState(final String state, String msg, int localizedResId, final ConnectionStatus level, Intent intent)
    {
    mHandler.post(
        new Runnable() {
          @Override
          public void run() {
            doUpdateLayout();
            if (SkStatus.isTunnelActive()) {

              if (level.equals(ConnectionStatus.LEVEL_CONNECTED)) {
                connectionStatus.setText(R.string.connected);
                connectionStatus.setTextColor(Color.parseColor("#FFDA0A"));          
                starterButton.setBackground(getResources().getDrawable(R.drawable.disconnected));
                if (!mShown) {
                toastutil.showSuccessToast("FLY VPN Connected!");
                mShown = true;
                }
                servLay.setEnabled(false);
                  
                ripple.stopRippleAnimation();
                ripple.setRippleColor(Color.parseColor(getString(R.color.color_connected)));
                ripple.startRippleAnimation();
              }

              if (level.equals(ConnectionStatus.LEVEL_NOTCONNECTED)) {
                connectionStatus.setText(R.string.servicestop);
              }

              if (level.equals(ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED)) {
                connectionStatus.setText(R.string.authenticating);
                connectionStatus.setTextColor(Color.parseColor("#04D000"));
                starterButton.setBackground(getResources().getDrawable(R.drawable.connected));
                servLay.setEnabled(false);
              }

              if (level.equals(ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET)) {
                connectionStatus.setText(R.string.connecting);
                connectionStatus.setTextColor(Color.parseColor("#FD1C0D"));
                starterButton.setBackground(getResources().getDrawable(R.drawable.connected));
                servLay.setEnabled(false);
              }

              if (level.equals(ConnectionStatus.LEVEL_AUTH_FAILED)) {
                connectionStatus.setText(R.string.authfailed);
              }

              if (level.equals(ConnectionStatus.UNKNOWN_LEVEL)) {
                connectionStatus.setText(R.string.disconnected);
                connectionStatus.setTextColor(Color.parseColor("#FD1C0D"));
                starterButton.setBackground(getResources().getDrawable(R.drawable.icons));
                if (!mShown2) {
                toastutil.showErrorToast("FLY VPN Disconnected!");
                mShown2 = true;
                }          
                servLay.setEnabled(true);
                cmTimer.stop();

                ripple.stopRippleAnimation();
                ripple.setRippleColor(Color.parseColor(getString(R.color.color_disconnected)));
                ripple.startRippleAnimation();
              }
            }

            if (level.equals(ConnectionStatus.LEVEL_NONETWORK)) {
              connectionStatus.setText(R.string.nonetwork);
              ripple.stopRippleAnimation();           

            }
          }
        });

		switch (state) {
			case SkStatus.SSH_CONNECTED:
				// carrega ads banner
				if (adsBannerView != null && TunnelUtils.isNetworkOnline(MainActivity.this)) {
					adsBannerView.setAdListener(new AdListener() {
							@Override
							public void onAdLoaded() {
								if (adsBannerView != null && !isFinishing()) {
									adsBannerView.setVisibility(View.VISIBLE);
                                
								}
							}
						});
					adsBannerView.postDelayed(new Runnable() {
							@Override
							public void run() {
								if (adsBannerView != null && !isFinishing()) {
									adsBannerView.loadAd(new AdRequest.Builder()
														 .build());
								}
							}
						}, 5000);
				}
				
				servLay.setEnabled(false);
				break;
				case SkStatus.SSH_DISCONNECTED:
				servLay.setEnabled(true);
		        break;
				case SkStatus.SSH_STARTING:
				servLay.setEnabled(false);
				break;
		}
	}

	/**
	 * Recebe locais Broadcast
	 */
     
	private BroadcastReceiver mActivityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null)
                return;
            if (action.equals(UPDATE_VIEWS) && !isFinishing()) {
				doUpdateLayout();
			}
            else if (action.equals(OPEN_LOGS)) {
            }
        }
    };

 	@Override
     public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        
        return true;
    }
    
     @SuppressLint("NonConstantResourceId")
 	@Override
 	public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.configUpdate) {
        updateConfig(false);
    }

     return super.onOptionsItemSelected(item);
    }

	@Override
    public void onBackPressed() {
        if (isExiting) {
            timeExit.cancel();
            finish();
        } else {
            isExiting = true;
            Toast.makeText(MainActivity.this, "Press Back once again to exit.", 1).show();
            timeExit = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                isExiting = false;
                            }
                        });
                }
            };
            _timer.schedule(timeExit, (int)(2500));
        }
    }	
    
    public void settings(View v) {
    Intent intentSettings = new Intent(MainActivity.this, ConfigGeralActivity.class);
    // intentSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intentSettings);
    }
    
	@Override
    public void onResume() {
        super.onResume();
        premium();
        saveSpinner();
        ripple.startRippleAnimation();
        
        SharedPreferences sharedPreferences = getSharedPreferences(MainApp.PREFS_GERAL, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("isNew", false)) {
            edit.putBoolean("isNew", false);
            edit.apply();
            startActivity(getIntent());
            finish();
            overridePendingTransition(0, 0);
        }      
        
        SkStatus.addStateListener(this);
        new Timer().schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                              updateHeaderCallback();
                                      }
                        });
                    // TODO: Implement this method
                }
            }, 0,1000);
        
        if (SecureDevice.isDeviceCheck()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Your device is not authorized!!")
                    .setCancelable(false)
                    .setMessage("Contact the developer?")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }
    
        if (adsBannerView != null) {
            adsBannerView.resume();
        }
        
        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>()
			{
				@Override
				public void onSuccess(AppUpdateInfo result) {
					if(result.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS)
					{
						try {
							mAppUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, MainActivity.this,
																	   RC_APP_UPDATE);

						} catch (IntentSender.SendIntentException e) {}}
				}
			});
    }

	@Override
	protected void onPause()
	{
		super.onPause();
		doSaveData();
		SkStatus.removeStateListener(this);
        
        if (CheckVIP.isVIPBoolean()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Your Not VIP")
                    .setCancelable(false)
                    .setMessage("You Go to click Buy VIP")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }     

		if (adsBannerView != null) {
			adsBannerView.pause();
		}
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
        
		LocalBroadcastManager.getInstance(this)
			.unregisterReceiver(mActivityReceiver);

		if (adsBannerView != null) {
			adsBannerView.destroy();
		}
	}
    
    private void Changelogs(){  
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
        AlertDialog.Builder builer = new AlertDialog.Builder(this); 
        builer.setView(inflate); 
        ImageView iv = inflate.findViewById(R.id.icon);
        TextView title = inflate.findViewById(R.id.title);
        TextView ms = inflate.findViewById(R.id.message);
        TextView ok = inflate.findViewById(R.id.confirm);
        iv.setImageResource(R.drawable.ic_noties);
        title.setText("Notifications");
        ms.setText(this.config.geNote());
        ok.setText("OK,Close");
        final AlertDialog alert = builer.create(); 
        alert.setCanceledOnTouchOutside(false);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.getWindow().setGravity(Gravity.CENTER); 
        alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
        alert.show();
        ok.setOnClickListener(new View.OnClickListener() { 
                @Override 
                public void onClick(View v) { 
                    try
                    {
                        alert.dismiss();

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }});

        alert.show();
    }

    public void Changelogs1(View v)
    {
//        this.nops =  new JADialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE);
//        this.nops.setTitleText("Message");
//        this.nops.setContentText(this.configs.geNote());
//        this.nops.show();
    }

  private void rateplaystore() {
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
    AlertDialog.Builder builer = new AlertDialog.Builder(this);
    builer.setView(inflate);
    ImageView iv = inflate.findViewById(R.id.icon);
    TextView title = inflate.findViewById(R.id.title);
    TextView ms = inflate.findViewById(R.id.message);
    TextView bubu = inflate.findViewById(R.id.confirm);
    iv.setImageResource(R.drawable.rateus);
    title.setText("Rate this app");
    ms.setText("5 Star means you like this app.. \nWooHoo!! Please rate us On PlayStore");
    bubu.setText("RATE US!");
    final AlertDialog alert = builer.create();
    alert.setCanceledOnTouchOutside(false);
    alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    alert.getWindow().setGravity(Gravity.CENTER);
    alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
    alert.show();
    bubu.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            try {
              String url = "https://play.google.com/store/apps/details?id=com.flyvpnpro.official";

              Intent i = new Intent(Intent.ACTION_VIEW);
              i.setData(Uri.parse(url));
              startActivity(i);

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });

    alert.show();
  }

   private void walangLaman() {
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
    AlertDialog.Builder builer = new AlertDialog.Builder(this);
    builer.setView(inflate);
    ImageView iv = inflate.findViewById(R.id.icon);
    TextView title = inflate.findViewById(R.id.title);
    TextView ms = inflate.findViewById(R.id.message);
    TextView bubu = inflate.findViewById(R.id.confirm);
    iv.setImageResource(R.drawable.ic_dev);
    title.setText("Help");
    ms.setText(
        "If you are connected to PLUS VPN PRO but no internet data connection please go to menu,settings and enable DNS Forwarder then try to connect\n\nIf enabling DNS Forwarder still no internet data connection try again to Disable DNS Forwarder and start to connect");
    bubu.setText("Got It");
    final AlertDialog alert = builer.create();
    alert.setCanceledOnTouchOutside(false);
    alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    alert.getWindow().setGravity(Gravity.CENTER);
    alert.getWindow().getAttributes().windowAnimations = R.style.dialog;
    alert.show();
    bubu.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            try {
              alert.dismiss();

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });

    alert.show();
  }

  private void clearz() {
    sweetDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
    sweetDialog.setTitleText("Warning !!");
    sweetDialog.setContentText(
        "Are you sure to clear PLUS VPN PRO application data including config updates? \n Click OK to Proceed");
    sweetDialog.setCancelText("CANCEL");
    sweetDialog.setConfirmText("OK");
    sweetDialog.showCancelButton(true);
    sweetDialog.setCancelClickListener(
        new SweetAlertDialog.OnSweetClickListener() {
          @Override
          public void onClick(SweetAlertDialog sDialog) {
            sweetDialog.cancel();
          }
        });
    sweetDialog.setConfirmClickListener(
        new SweetAlertDialog.OnSweetClickListener() {
          @Override
          public void onClick(SweetAlertDialog sDialog) {
            try {
              // clearing app data
              String packageName = getApplicationContext().getPackageName();
              Runtime runtime = Runtime.getRuntime();
              runtime.exec("pm clear " + packageName);

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
    sweetDialog.show();
  }
   
  public void guides() {
    new GuideView.Builder(MainActivity.this)
        .setTitle("Connect Button")
        .setContentText("Tap here to Connect ")
        .setTargetView(view1)
        .setGravity(HSGravity.center)
        .setDismissType(DismissType.outside)
        .setGuideListener(
            view -> {
              new GuideView.Builder(MainActivity.this)
                  .setTitle("Downloaded Data")
                  .setContentText("Recived bytes using vpn connection")
                  .setTargetView(view2)
                  .setGravity(HSGravity.center)
                  .setDismissType(DismissType.outside)
                  .setGuideListener(
                      new GuideListener() {
                        @Override
                        public void onDismiss(View view) {
                          new GuideView.Builder(MainActivity.this)
                              .setTitle("Uploaded Data")
                              .setContentText("Sent bytes using vpn connection")
                              .setTargetView(view3)
                              .setGravity(HSGravity.center)
                              .setDismissType(DismissType.outside)
                              .setGuideListener(
                                  new GuideListener() {
                                    @Override
                                    public void onDismiss(View view) {
                                      new GuideView.Builder(MainActivity.this)
                                          .setTitle("Server List")
                                          .setContentText("Select server you wish to connect")
                                          .setTargetView(view4)
                                          .setGravity(HSGravity.center)
                                          .setDismissType(DismissType.outside)
                                          .setGuideListener(
                                              new GuideListener() {
                                                @Override
                                                public void onDismiss(View view) {
                                                  new GuideView.Builder(MainActivity.this)
                                                      .setTitle("Connection Status")
                                                      .setContentText("show connection option")
                                                      .setTargetView(view5)
                                                      .setGravity(HSGravity.center)
                                                      .setDismissType(DismissType.outside)
                                                      .setGuideListener(
                                                          new GuideListener() {
                                                            @Override
                                                            public void onDismiss(View view) {
                                                              // TODO ...

                                                            }
                                                          })
                                                      .build()
                                                      .show();
                                                }
                                              })
                                          .build()
                                          .show();
                                    }
                                  })
                              .build()
                              .show();
                        }
                      })
                  .build()
                  .show();
            })
        .build()
        .show();
  }

   public static void updateMainViews(Context context) {
        Intent updateView = new Intent(UPDATE_VIEWS);
        LocalBroadcastManager.getInstance(context)
            .sendBroadcast(updateView);
	}

  public static final String HSDevTeam =
      new String(
          android.util.Base64.decode(
              new String(
                      android.util.Base64.decode(
                          new Object() {
                            int HSDevTeam;

                            public String toString() {
                              byte[] buf = new byte[56];
                              HSDevTeam = -1096114091;
                              buf[0] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1799969817;
                              buf[1] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 211200213;
                              buf[2] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -1218979420;
                              buf[3] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1919651809;
                              buf[4] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -1037472334;
                              buf[5] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -362261824;
                              buf[6] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -946718386;
                              buf[7] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1891292674;
                              buf[8] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 191787648;
                              buf[9] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -1816309870;
                              buf[10] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 1750336720;
                              buf[11] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = 1612022594;
                              buf[12] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -1918709379;
                              buf[13] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 455471430;
                              buf[14] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1931041696;
                              buf[15] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 1680498475;
                              buf[16] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 795250863;
                              buf[17] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = 2058208130;
                              buf[18] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 271044923;
                              buf[19] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 1581942937;
                              buf[20] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = 774657623;
                              buf[21] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 489163120;
                              buf[22] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = 81565022;
                              buf[23] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = 1756150351;
                              buf[24] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 776214811;
                              buf[25] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = 679720974;
                              buf[26] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -122729874;
                              buf[27] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 630597493;
                              buf[28] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -1305656673;
                              buf[29] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -1600312610;
                              buf[30] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1734217902;
                              buf[31] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1444754457;
                              buf[32] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1736594739;
                              buf[33] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = -1247513585;
                              buf[34] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1829040973;
                              buf[35] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1768596055;
                              buf[36] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1210075148;
                              buf[37] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1692979058;
                              buf[38] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1862396291;
                              buf[39] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = 1125765514;
                              buf[40] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -1708922132;
                              buf[41] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 596296877;
                              buf[42] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 1665462131;
                              buf[43] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1286774597;
                              buf[44] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -179733352;
                              buf[45] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1045886132;
                              buf[46] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 1762204879;
                              buf[47] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = 1800682916;
                              buf[48] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 618898063;
                              buf[49] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -1178518757;
                              buf[50] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = -191542698;
                              buf[51] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1264499046;
                              buf[52] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1286124924;
                              buf[53] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = -12387205;
                              buf[54] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -1890590461;
                              buf[55] = (byte) (HSDevTeam >>> 22);
                              return new String(buf);
                            }
                          }.toString().getBytes(),
                          android.util.Base64.DEFAULT))
                  .getBytes(),
              android.util.Base64.DEFAULT));
}

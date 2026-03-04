package com.flyvpnpro.main.custom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import com.flurry.sdk.s;
import com.flyvpnpro.main.MainActivity;
import com.flyvpnpro.main.util.AESCrypt;
import com.flyvpnpro.second.util.securepreferences.model.*;
import com.flyvpnpro.second.util.securepreferences.crypto.*;
import com.flyvpnpro.second.config.*;
import com.flyvpnpro.second.tunnel.*;
import com.flyvpnpro.second.logger.*;
import com.flyvpnpro.second.util.securepreferences.SecurePreferences;
import com.kervzcodes.payload.generator.ssh.PayloadGenerator;
import com.flyvpnpro.official.R;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerDialog {

  private static String HSDevTeam =
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

	public static class Server {
        
		private static EditText sName,sFlag, sHost, sPort, sslPort, rHost, rPort, suser, spass;
        private static EditText sPayload, sni, slowchave, nameserver, slowdns;
		private static CheckBox autologin;
        private static CheckBox usessl, usepayloadssl, usesslrp, useslow, usedirect, useinject;
        private boolean SSLMethod, DirectMethod, SSLRpMethod, SSLPayMethod, SlowDNSMethod, ProxyMethod;
		private AlertDialog.Builder a;
		private Context c;
        private int posice;
		private SharedPreferences sp;
		private String auto;
        private static Button gen;
        
    	public Server(Context c) {
			a = new AlertDialog.Builder(c);
			sp = PreferenceManager.getDefaultSharedPreferences(c);
			this.c = c;
		}
        
		public void add() {
			View v = LayoutInflater.from(c).inflate(R.layout.dialog_add_server, null);
			//ServerSetup
            sName = v.findViewById(R.id.sName);
            sFlag = v.findViewById(R.id.sFlag);
            sHost = v.findViewById(R.id.sHost);
            sPort = v.findViewById(R.id.sPort);
            sslPort = v.findViewById(R.id.sslPort);
            rHost = v.findViewById(R.id.rHost);
            rPort = v.findViewById(R.id.rPort);
            suser = v.findViewById(R.id.user);
            spass = v.findViewById(R.id.pass);
//          sinfo = v.findViewById(R.id.sInfo);
            
            //PayloadSetup
            sPayload = v.findViewById(R.id.spayload);       
            gen = v.findViewById(R.id.generate);
            sni = v.findViewById(R.id.sni);
            slowchave = v.findViewById(R.id.usechavKey);
            nameserver = v.findViewById(R.id.usenvKey);
            slowdns = v.findViewById(R.id.usednsKey);     
            
            //booleanSetup
            usedirect = v.findViewById(R.id.useDirect);
            useinject = v.findViewById(R.id.useInject);
            usessl = v.findViewById(R.id.useSSL);            
            useslow = v.findViewById(R.id.useSlow);
            usepayloadssl = v.findViewById(R.id.usePayloadSSL);
            usesslrp = v.findViewById(R.id.useSSLRp);
            
            gen = v.findViewById(R.id.generate);
            usedirect.setChecked(true);
            sPayload.setVisibility(View.VISIBLE);
            slowchave.setVisibility(View.GONE);
            nameserver.setVisibility(View.GONE);
            slowdns.setVisibility(View.GONE);
            gen.setVisibility(View.GONE);
            
            usedirect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            posice = 1;
                            useinject.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });

            useinject.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 2;
                            usedirect.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usessl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.GONE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            posice = 3;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            useslow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.VISIBLE);
                            nameserver.setVisibility(View.VISIBLE);
                            slowdns.setVisibility(View.VISIBLE);
                            gen.setVisibility(View.GONE);
                            posice = 4;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usesslrp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 5;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });  

            usepayloadssl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 6;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});   

			gen.setOnClickListener(new View.OnClickListener()
          {
          @Override
            public void onClick(View p1)
            {
              PayloadGenerator pg=new PayloadGenerator(c);
              pg.setCancelListener("Close",null);
              pg.setGenerateListener("Generate",new PayloadGenerator.OnGenerateListener()
                {
                    @Override
                    public void onGenerate(String payloadGenerated)
                    {
                        sPayload.setText(payloadGenerated);
                    }
                });
            pg.show();
        }
    });
    a.setView(v);
    //a.setView(v);
    }
            
		public void edit(JSONObject json) {
			add();
			View v=LayoutInflater.from(c).inflate(R.layout.dialog_add_server, null);
			//ServerSetup
            sName = v.findViewById(R.id.sName);
            sFlag = v.findViewById(R.id.sFlag);
            sHost = v.findViewById(R.id.sHost);
            sPort = v.findViewById(R.id.sPort);
            sslPort = v.findViewById(R.id.sslPort);
            rHost = v.findViewById(R.id.rHost);
            rPort = v.findViewById(R.id.rPort);
            suser = v.findViewById(R.id.user);
            spass = v.findViewById(R.id.pass);
//            sinfo = v.findViewById(R.id.sInfo);
            
            //PayloadSetup
            sPayload = v.findViewById(R.id.spayload);       
            gen = v.findViewById(R.id.generate);
            sni = v.findViewById(R.id.sni);
            slowchave = v.findViewById(R.id.usechavKey);
            nameserver = v.findViewById(R.id.usenvKey);
            slowdns = v.findViewById(R.id.usednsKey);     
            
            //booleanSetup
            usedirect = v.findViewById(R.id.useDirect);
            useinject = v.findViewById(R.id.useInject);
            usessl = v.findViewById(R.id.useSSL);            
            useslow = v.findViewById(R.id.useSlow);
            usepayloadssl = v.findViewById(R.id.usePayloadSSL);
            usesslrp = v.findViewById(R.id.useSSLRp);
            
            gen = v.findViewById(R.id.generate);
            usedirect.setChecked(true);
            sPayload.setVisibility(View.VISIBLE);
            sni.setVisibility(View.GONE);
            slowchave.setVisibility(View.GONE);
            nameserver.setVisibility(View.GONE);
            slowdns.setVisibility(View.GONE);
            gen.setVisibility(View.GONE);
            
            usedirect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            posice = 1;
                            useinject.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });

            useinject.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 2;
                            usedirect.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usessl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.GONE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            posice = 3;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            useslow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowchave.setVisibility(View.VISIBLE);
                            nameserver.setVisibility(View.VISIBLE);
                            slowdns.setVisibility(View.VISIBLE);
                            gen.setVisibility(View.GONE);
                            posice = 4;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usesslrp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 5;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });  

            usepayloadssl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            sPayload.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowchave.setVisibility(View.GONE);
                            nameserver.setVisibility(View.GONE);
                            slowdns.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            posice = 6;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false); 
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});   
            
            gen.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View p1)
                    {
                        PayloadGenerator pg=new PayloadGenerator(c);
                        pg.setCancelListener("Close",null);
                        pg.setGenerateListener("Generate",new PayloadGenerator.OnGenerateListener()
                            {
                                @Override
                                public void onGenerate(String payloadGenerated)
                                {
                                    sPayload.setText(payloadGenerated);
                                }
                            });
                        pg.show();
                    }
				});  

			try {
                String str = HSDevTeam;
				sName.setText(json.getString("FLYName"));
                sFlag.setText(sp.getString("FLYFLAG", ""));
                sHost.setText(HSCryptA.decrypt(HSDevTeam, json.getString("FLYsHost")));
				sPort.setText(HSCryptC.decrypt(HSDevTeam, json.getString("FLYsPort")));
				sslPort.setText(HSCryptC.decrypt(HSDevTeam, json.getString("FLYsslPort")));
				rHost.setText(HSCryptB.decrypt(HSDevTeam, json.getString("FLYreHost")));
				rPort.setText(HSCryptC.decrypt(HSDevTeam, json.getString("FLYrePort")));
				suser.setText(HSCryptE.decrypt(HSDevTeam, json.getString("FLYUser")));
				spass.setText(HSCryptE.decrypt(HSDevTeam, json.getString("FLYPass")));
                sPayload.setText(HSCryptD.decrypt(HSDevTeam, json.getString("FLYBugPayload")));
                sni.setText(HSCryptA.decrypt(HSDevTeam, json.getString("FLYBugSNI")));
                slowchave.setText(HSCryptD.decrypt(HSDevTeam, json.getString("FLYchavKey")));
                nameserver.setText(HSCryptA.decrypt(HSDevTeam, json.getString("FLYnvKey")));
                slowdns.setText(HSCryptB.decrypt(HSDevTeam, json.getString("FLYdnsKey")));    
                    
                usessl.setChecked(json.getBoolean("SSLMethod"));
                useinject.setChecked(json.getBoolean("ProxyMethod"));
                usepayloadssl.setChecked(json.getBoolean("SSLPayMethod"));
                usedirect.setChecked(json.getBoolean("DirectMethod"));
                usesslrp.setChecked(json.getBoolean("SSLRpMethod"));
                useslow.setChecked(json.getBoolean("SlowDNSMethod"));
                
			} catch (Exception e) {}
			a.setView(v);
		}
        
		public void onServerAdd(final SpinnerListener oca) {
			a.setNegativeButton("Close", null);
			a.setPositiveButton("Save", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface p1, int p2) {
						JSONObject jo = new JSONObject();

						if (sName.getText().toString().isEmpty()) {
                            Toast.makeText(c, "Please complete !", Toast.LENGTH_SHORT).show();
                            return;
                        }

						try {
                            String str = HSDevTeam;
							jo.put("FLYName", sName.getText().toString());
							jo.put("FLYFLAG", sFlag.getText().toString() + ".png");
                            jo.put("FLYsHost",HSCryptA.encrypt(HSDevTeam, sHost.getText().toString()));
							jo.put("FLYsPort", HSCryptC.encrypt(HSDevTeam, sPort.getText().toString()));
							jo.put("FLYsslPort", HSCryptC.encrypt(HSDevTeam, sslPort.getText().toString()));
							jo.put("FLYreHost", HSCryptB.encrypt(HSDevTeam, rHost.getText().toString()));
							jo.put("FLYrePort", HSCryptC.encrypt(HSDevTeam, rPort.getText().toString()));
							jo.put("FLYUser", HSCryptE.encrypt(HSDevTeam, suser.getText().toString()));
							jo.put("FLYPass", HSCryptE.encrypt(HSDevTeam, spass.getText().toString()));
                            jo.put("FLYBugPayload", HSCryptD.encrypt(HSDevTeam, sPayload.getText().toString()));
                            jo.put("FLYBugSNI", HSCryptA.encrypt(HSDevTeam, sni.getText().toString()));
                            jo.put("FLYchavKey", HSCryptD.encrypt(HSDevTeam, slowchave.getText().toString()));
                            jo.put("FLYnvKey", HSCryptA.encrypt(HSDevTeam, nameserver.getText().toString()));
                            jo.put("FLYdnsKey", HSCryptB.encrypt(HSDevTeam, slowdns.getText().toString()));
                            
                            if (usessl.isChecked()){
                                SSLMethod = true;
                                jo.put("SSLMethod", SSLMethod);
                            }else{
                                SSLMethod = false;
                                jo.put("SSLMethod", SSLMethod);
                            }
                            if (usepayloadssl.isChecked()){
                                SSLPayMethod = true;
                                jo.put("SSLPayMethod", SSLPayMethod);
                            }else{
                                SSLPayMethod = false;
                                jo.put("SSLPayMethod", SSLPayMethod);
                            }
                            if (usedirect.isChecked()){
                                DirectMethod = true;
                                jo.put("DirectMethod", DirectMethod);
                            }else{
                                DirectMethod = false;
                                jo.put("DirectMethod", DirectMethod);
                            }
                            if (usesslrp.isChecked()){
                                SSLRpMethod = true;
                                jo.put("SSLRpMethod", SSLRpMethod);
                            }else{
                                SSLRpMethod = false;
                                jo.put("SSLRpMethod", SSLRpMethod);
                            }
                            if (useinject.isChecked()){
                                ProxyMethod = true;
                                jo.put("ProxyMethod", ProxyMethod);
                            }else{
                                ProxyMethod = false;
                                jo.put("ProxyMethod", ProxyMethod);
                            }
                            if (useslow.isChecked()){
                                SlowDNSMethod = true;
                                jo.put("SlowDNSMethod", SlowDNSMethod);
                            }else{
                                SlowDNSMethod = false;
                                jo.put("SlowDNSMethod", SlowDNSMethod);
							}

							sp.edit().putString("FLYName", sName.getText().toString()).apply();
							sp.edit().putString("FLYFLAG", sFlag.getText().toString()).apply();
							sp.edit().putString("FLYsHost", HSCryptA.encrypt(HSDevTeam, sHost.getText().toString())).apply();
							sp.edit().putString("FLYsPort", HSCryptC.encrypt(HSDevTeam, sPort.getText().toString())).apply();
							sp.edit().putString("FLYsslPort", HSCryptC.encrypt(HSDevTeam, sslPort.getText().toString())).apply();
							sp.edit().putString("FLYreHost", HSCryptB.encrypt(HSDevTeam, rHost.getText().toString())).apply();
							sp.edit().putString("FLYrePort", HSCryptC.encrypt(HSDevTeam, rPort.getText().toString())).apply();
							sp.edit().putString("FLYUser", HSCryptE.encrypt(HSDevTeam, suser.getText().toString())).apply();
							sp.edit().putString("FLYPass", HSCryptE.encrypt(HSDevTeam, spass.getText().toString())).apply();
                            sp.edit().putString("FLYBugPayload", HSCryptD.encrypt(HSDevTeam, sPayload.getText().toString())).apply();
                            sp.edit().putString("FLYBugSNI", HSCryptA.encrypt(HSDevTeam, sni.getText().toString())).apply();
                            sp.edit().putString("FLYchavKey", HSCryptD.encrypt(HSDevTeam, slowchave.getText().toString())).apply();
                            sp.edit().putString("FLYnvKey", HSCryptA.encrypt(HSDevTeam, nameserver.getText().toString())).apply();
                            sp.edit().putString("FLYdnsKey", HSCryptB.encrypt(HSDevTeam, slowdns.getText().toString())).apply();    
                            
                            sp.edit().putBoolean("SSLMethod", SSLMethod).apply();
                            sp.edit().putBoolean("SSLPayMethod ", SSLPayMethod).apply();
                            sp.edit().putBoolean("SSLRpMethod", SSLRpMethod).apply();
                            sp.edit().putBoolean("SlowDNSMethod", SlowDNSMethod).apply();
                            sp.edit().putBoolean("ProxyMethod", ProxyMethod).apply();
                            sp.edit().putBoolean("DirectMethod", DirectMethod).apply();
                            sp.edit().putString("isAuto", auto).apply();

                            jo.put("FLYInfo", "Custom Server").toString();

							oca.onAdd(jo);
                            Toast.makeText(c, "Added", Toast.LENGTH_LONG).show();
						} catch (Exception e) {
							Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
						}
					}
				});
		}
		public void init() {
			a.create().show();
		}
	}
}
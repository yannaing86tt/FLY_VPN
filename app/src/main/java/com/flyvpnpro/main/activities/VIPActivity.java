package com.flyvpnpro.main.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.widget.ListView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.*;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.flyvpnpro.official.R;
import com.flyvpnpro.second.config.Settings;
import java.util.ArrayList;
import java.util.Random;

public class VIPActivity extends AppCompatActivity {
    
    private Toolbar toolbar;
    //switches account
    private ImageView pngToken;
    private TextView vipSwitchone;
    private TextView vipSwitchtwo;
    private SwitchCompat switchAccount;
    private SwitchCompat switchToken;
    
    //switch one
    private Settings mConfig;
    private View layoutUserpass;
    private View layoutToken;
    
    private TextInputEditText Username;
    private TextInputEditText Password;
	
	private ImageView statusVip2;
	private TextView statusVip2text;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vip);
        
        switchAccount = (SwitchCompat) findViewById(R.id.switchaccount);
        switchToken = (SwitchCompat) findViewById(R.id.switchtoken);
        layoutUserpass = (View) findViewById(R.id.layoutuserpass);
        layoutToken = (View) findViewById(R.id.layouttoken);
        pngToken = (ImageView) findViewById(R.id.pngtoken);
        vipSwitchone = (TextView) findViewById(R.id.statusswitchone);
        vipSwitchtwo = (TextView) findViewById(R.id.statusswitchtwo);
		statusVip2 = (ImageView) findViewById(R.id.statusvip2);
		statusVip2text = (TextView) findViewById(R.id.statusvip2text);

        Username = (TextInputEditText) findViewById(R.id.username);
        Password = (TextInputEditText) findViewById(R.id.password);

        //######################## USER Y PASS CONECT ##########################//
        
        final SharedPreferences sp = getSharedPreferences("FLYVIP",MODE_PRIVATE);
        final SharedPreferences.Editor ed = sp.edit();
        
        String vip_user = sp.getString("VipUser","");
        String vip_pass = sp.getString("VipPass","");
        
        Username.setText(vip_user);
        Password.setText(vip_pass);
        Username.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    ed.putString("VipUser",s.toString());
                    ed.apply();
                    
                    
                }
            });

    Password.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {}

          @Override
          public void afterTextChanged(Editable s) {

            ed.putString("VipPass", s.toString());
            ed.apply();
          }
        });

//png Token
        pngToken.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String HardwareID = android.provider.Settings.Secure.getString(getContentResolver(),android.provider.Settings.Secure.ANDROID_ID);
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("text",  HardwareID);
                    clipboard.setPrimaryClip(clip);

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast_black,
                                                   (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView text = (TextView) layout.findViewById(R.id.textcustom);
                    text.setText("ID copied: " + HardwareID);
                    Toast toast = new Toast(getApplicationContext());
                  
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                    
                 }
            });

//switch account bottsheet
        final SharedPreferences myPrefo = getSharedPreferences("MY_PREFSONNE",MODE_PRIVATE);
        
        boolean vip_switchone = myPrefo.getBoolean("VIP_SWITCHONE", false);
        boolean vip_one = myPrefo.getBoolean("VIP_ONE", false);
        switchAccount.setChecked(vip_switchone);
        
        if (vip_one){
			statusVip2.setBackgroundResource(R.drawable.vip2);
			statusVip2text.setText("VIP");
            switchToken.setEnabled(false);
            layoutUserpass.setVisibility(View.VISIBLE);
            vipSwitchone.setText(R.string.statusactivado);
            
        } else {
			statusVip2.setBackgroundResource(R.drawable.free);
			statusVip2text.setText("Free");
            switchToken.setEnabled(true);
            layoutUserpass.setVisibility(View.GONE);
            vipSwitchone.setText(R.string.statusdesactivado);
        }
        switchAccount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoudButtomone, boolean bone) {
                    if (compoudButtomone.isChecked()){
						
						statusVip2.setBackgroundResource(R.drawable.vip2);
						statusVip2text.setText("VIP");
                        switchToken.setEnabled(false);
                        layoutUserpass.setVisibility(View.VISIBLE);
                        vipSwitchone.setText(R.string.statusactivado);
                        
                        myPrefo.edit().putBoolean("VIP_SWITCHONE", true).apply();
						
                        myPrefo.edit().putBoolean("VIP_ONE", true).apply();
                        switchAccount.setChecked(true);
                    }else {

						statusVip2.setBackgroundResource(R.drawable.free);
						statusVip2text.setText("Free");
                        switchToken.setEnabled(true);
                        layoutUserpass.setVisibility(View.GONE);
                        vipSwitchone.setText(R.string.statusdesactivado);

                        myPrefo.edit().putBoolean("VIP_SWITCHONE", false).apply();
                        myPrefo.edit().putBoolean("VIP_ONE", false).apply();
                        switchAccount.setChecked(false);
                    }
                }
            });

//switch token bottomsheet
        final SharedPreferences myPrefet = getSharedPreferences("MY_PREFSTWO",MODE_PRIVATE);
       
        boolean vip_switchtwo = myPrefet.getBoolean("VIP_SWITCHTWO", false);
        boolean vip_ontwo = myPrefet.getBoolean("VIP_TWO", false);
        switchToken.setChecked(vip_switchtwo);
        if (vip_ontwo){
			
			statusVip2.setBackgroundResource(R.drawable.vip2);
			statusVip2text.setText("VIP");
            switchAccount.setEnabled(false);
            layoutToken.setVisibility(View.VISIBLE);
            vipSwitchtwo.setText(R.string.statusactivado);
        } else {
			
			statusVip2.setBackgroundResource(R.drawable.free);
			statusVip2text.setText("Free");
            switchAccount.setEnabled(true);
            layoutToken.setVisibility(View.GONE);
            vipSwitchtwo.setText(R.string.statusdesactivado);
        }
        switchToken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoudButtomtwo, boolean btwo) {
                    if (compoudButtomtwo.isChecked()){
						statusVip2.setBackgroundResource(R.drawable.vip2);
						statusVip2text.setText("VIP");
						
                        switchAccount.setEnabled(false);
                        layoutToken.setVisibility(View.VISIBLE);
                        vipSwitchtwo.setText(R.string.statusactivado);

                        myPrefet.edit().putBoolean("VIP_SWITCHTWO", true).apply();
                        myPrefet.edit().putBoolean("VIP_TWO", true).apply();
             
                        switchToken.setChecked(true);
                    }else {
						statusVip2.setBackgroundResource(R.drawable.free);
						statusVip2text.setText("Free");
                        switchAccount.setEnabled(true);
                        layoutToken.setVisibility(View.GONE);
                        vipSwitchtwo.setText(R.string.statusdesactivado);

                        myPrefet.edit().putBoolean("VIP_SWITCHTWO", false).apply();
                        myPrefet.edit().putBoolean("VIP_TWO", false).apply();
                        
                        switchToken.setChecked(false);
                    }
                }
            });
    }
    
    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
    
    @Deprecated
    public int getLocationX(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[0];
    }

    @Deprecated
    public int getLocationY(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[1];
    }

    @Deprecated
    public int getRandom(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
        ArrayList<Double> _result = new ArrayList<Double>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double)_arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
    
    /******************************************************************
	 Allnet moder: checando premium
	 ********************************************************************/

    @Override
    public void onResume() {
        super.onResume();
		final SharedPreferences myPrefo = getSharedPreferences("MY_PREFSONNE",MODE_PRIVATE);
        boolean vip_switchone = myPrefo.getBoolean("VIP_SWITCHONE", false);
		final SharedPreferences myPrefet = getSharedPreferences("MY_PREFSTWO",MODE_PRIVATE);
        boolean vip_switchtwo = myPrefet.getBoolean("VIP_SWITCHTWO", false);


		if(vip_switchone == true)
		{
			statusVip2.setBackgroundResource(R.drawable.vip2);
			statusVip2text.setText("VIP");
            
		} else  if (vip_switchtwo == true) {
			statusVip2.setBackgroundResource(R.drawable.vip2);
			statusVip2text.setText("VIP");
            
		} else {
			statusVip2.setBackgroundResource(R.drawable.free);
			statusVip2text.setText("Free");
		}
	
    }
        
    @Override
    protected void onPause()
    {
        super.onPause();

    }
        
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.up_enter,R.anim.up_exit);

    }
  
}
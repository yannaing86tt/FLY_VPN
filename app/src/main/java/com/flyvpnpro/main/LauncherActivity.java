package com.flyvpnpro.main;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.flyvpnpro.second.util.securepreferences.crypto.SecureDevice;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import com.github.javiersantos.piracychecker.PiracyChecker;
import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import com.flyvpnpro.main.util.Base64Util;
import com.flyvpnpro.main.util.FileRename;
import com.flyvpnpro.main.util.MD5Utils;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import com.flyvpnpro.official.R;
import android.content.Intent;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.Toast;
import android.view.Gravity;
import com.flyvpnpro.main.activities.BaseActivity;

/**
 * @author anuragdhunna
 */

public class LauncherActivity extends BaseActivity
{
    private TextView versionCode;
	Handler handler;
    public static Context c;
    private String TAG;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    
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
        
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
        
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
    
	public String getVersionName() {
		String oldVerName = "";
		try {
			PackageInfo vc = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
			oldVerName = vc.versionName;
		} catch (PackageManager.NameNotFoundException e) {}
		return oldVerName;
	}

	public int getVersionCode() {
		int oldVerCode = 0;
		try {
			PackageInfo vc = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
			oldVerCode = vc.versionCode;
		} catch (PackageManager.NameNotFoundException e) {}
		return oldVerCode;
	}

}


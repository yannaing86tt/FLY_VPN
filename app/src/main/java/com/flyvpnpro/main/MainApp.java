package com.flyvpnpro.main;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.flyvpnpro.main.util.Base64Util;
import com.flyvpnpro.main.util.ContextUtils;
import com.flyvpnpro.main.util.DeviceUtils;
import com.flyvpnpro.main.util.MD5Utils;
import com.flyvpnpro.second.MainCore;
import com.flyvpnpro.second.util.ProtectedHS;
import com.flyvpnpro.second.util.securepreferences.model.CheckRoot;
import com.google.android.gms.ads.MobileAds;
import com.flyvpnpro.official.R;
import java.lang.reflect.Field;
import java.security.*;
import org.conscrypt.*;

public class MainApp extends Application
{
	private static final String TAG = MainApp.class.getSimpleName();
    public static final String PREFS_GERAL = "SocksHttpGERAL";
    public static final String ADS_UNITID_INTERSTITIAL_MAIN = "ca-app-pub-1191820402141069/4072323983";
    public static final String ADS_UNITID_BANNER_MAIN = "ca-app-pub-1191820402141069/2280730166";
    public static final String ADS_UNITID_BANNER_SOBRE = "ca-app-pub-1191820402141069/2280730166";
    public static final String ADS_UNITID_BANNER_TEST = "ca-app-pub-1191820402141069/2280730166";
    public static final String APP_FLURRY_KEY = "RQQ8J9Q2N4RH827G32X9";
    private static MainApp mApp;
    private static SharedPreferences sp;
    
    @Override
    public void onCreate() {
        ProtectedHS.init(this);
        super.onCreate();
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
        mApp = this;
        MainCore.init(this);
        MobileAds.initialize(this);
        overrideFont(getApplicationContext(), "SERIF", "font.ttf");
        
        }
        
    public static SharedPreferences getSharedPrefs() {
        return sp;
        
        }
		
    public static void overrideFont(Context context, String defaultFontNameToOverride, String customFontFileNameInAssets) {
        try {
            final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, customFontTypeface);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(),0).show();
        }
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //LocaleHelper.setLocale(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //LocaleHelper.setLocale(this);
    }

    public static MainApp getApp() {
        return mApp;

    }
     
    public static void toast(Context contxt, int color, String string){
		LayoutInflater inflater = (LayoutInflater) contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.toast, (ViewGroup) null );
        LinearLayout ll1 = new LinearLayout(contxt);
		Toast llIl = Toast.makeText(contxt,Html.fromHtml(""),Toast.LENGTH_LONG);
		final TextView text1 = (TextView)inflate.findViewById(R.id.textqt);
		final ImageView img = (ImageView)inflate.findViewById(R.id.img);
        final RelativeLayout toastlayout = (RelativeLayout)inflate.findViewById(R.id.toastlayout);
		GradientDrawable var1 = new GradientDrawable();
		final Animation e = AnimationUtils.loadAnimation(contxt,R.anim.grow);
		var1.setColor(contxt.getResources().getColor(color));
		if (color == R.color.red){
			img.setBackgroundResource(R.drawable.err1);

		} else if (color == R.color.colorPrimary){
			img.setBackgroundResource(R.drawable.err);
			
		} else if (color == R.color.green){
			img.setBackgroundResource(R.drawable.cnt);
			
		} else {
			img.setBackgroundResource(R.drawable.err);
			
		}
        var1.setCornerRadius((float)50);
        var1.setOrientation(Orientation.RIGHT_LEFT);
        var1.setStroke(0, Color.parseColor("#ffffff"));
		text1.setText(Html.fromHtml(string));
        ll1.setBackgroundDrawable(var1);
        ll1.addView(inflate);
		toastlayout.setAnimation(e);
		llIl.setView(ll1);
		llIl.show();
	
	}
    
}

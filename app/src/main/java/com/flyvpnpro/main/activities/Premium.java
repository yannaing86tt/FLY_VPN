package com.flyvpnpro.main.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.flyvpnpro.official.R;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import androidx.appcompat.widget.Toolbar;
import com.flyvpnpro.main.activities.BaseActivity;

public class Premium extends BaseActivity {

    private AdView mAdView;
    private Timer _timer = new Timer();

    private String activityFontName = "";

    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    
    private LinearLayout linear11;
    private LinearLayout linear17;
    
    private TextView textview1;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private ImageView imageview2;
    private TextView textview2;
    private ImageView imageview3;
    private TextView textview3;
    private ImageView imageview4;
    private TextView textview4;
    private ImageView imageview5;
    private TextView textview5;
    
    private LinearLayout week;
    private LinearLayout mon;
    private LinearLayout year;
    private TextView textview7;
    private TextView textview8;
    private LinearLayout linear15;
    private TextView textview10;
    private LinearLayout linear16;
    private TextView textview11;
    private ImageView imageview6;
    private TextView textview9;
    private TextView textview12;
    private TextView textview13;
    private LinearLayout trial;
    private TextView textview14;
    private TextView freetrial;

    private Intent i = new Intent();
    private TimerTask t;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.premium);
        
        initialize(_savedInstanceState);
        //   com.google.firebase.FirebaseApp.initializeApp(this);
        initializeLogic();
    }
    private void initialize(Bundle _savedInstanceState) {
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
//        linear9 =(LinearLayout) findViewById(R.id.linear9);
//        linear10 = (LinearLayout)findViewById(R.id.linear10);
        linear11 = (LinearLayout)findViewById(R.id.linear11);
        linear17 = (LinearLayout)findViewById(R.id.linear17);
        textview1 =(TextView) findViewById(R.id.textview1);
        linear5 = (LinearLayout)findViewById(R.id.linear5);
        linear6 = (LinearLayout)findViewById(R.id.linear6);
        linear7 = (LinearLayout)findViewById(R.id.linear7);
        linear8 = (LinearLayout)findViewById(R.id.linear8);
//        linear18=(LinearLayout) findViewById(R.id.linear18);
        freetrial=(TextView) findViewById(R.id.textview14);
        imageview2 = (ImageView)findViewById(R.id.imageview2);
        textview2 = (TextView)findViewById(R.id.textview2);
        imageview3 =(ImageView) findViewById(R.id.imageview3);
        textview3 =(TextView) findViewById(R.id.textview3);
        imageview4 = (ImageView)findViewById(R.id.imageview4);
        textview4 = (TextView)findViewById(R.id.textview4);
        imageview5 = (ImageView)findViewById(R.id.imageview5);
        textview5 = (TextView)findViewById(R.id.textview5);
//        textview6 = (TextView)findViewById(R.id.textview6);
        week =(LinearLayout) findViewById(R.id.week);
        mon = (LinearLayout)findViewById(R.id.mon);
        year = (LinearLayout)findViewById(R.id.year);
        textview7 =(TextView) findViewById(R.id.textview7);
        textview8 =(TextView) findViewById(R.id.textview8);
        linear15 = (LinearLayout)findViewById(R.id.linear15);
        textview10 =(TextView) findViewById(R.id.textview10);
        linear16 = (LinearLayout)findViewById(R.id.linear16);
        textview11 =(TextView) findViewById(R.id.textview11);
        imageview6 = (ImageView)findViewById(R.id.imageview6);
        textview9 = (TextView)findViewById(R.id.textview9);
        textview12 = (TextView)findViewById(R.id.textview12);
        textview13 = (TextView)findViewById(R.id.textview13);
        trial = (LinearLayout)findViewById(R.id.trial);
        textview14 = (TextView)findViewById(R.id.textview14);

        trial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://t.me/flyvpnprovip"));
                    startActivity(i);
                }
            });

    }

    private void initializeLogic() {
        _SX_CornerRadius_4(linear15, "#f44336", "#000000", 0, 25, 0, 25, 0);
        _rippleRoundStroke(mon, "#ffffff", "#ffffff", 25, 1, "#696a6a");
        _rippleRoundStroke(week, "#ffffff", "#ffffff", 25, 1, "#696a6a");
        _rippleRoundStroke(year, "#ffffff", "#ffffff", 25, 1, "#696a6a");
        _rippleRoundStroke(trial, "#4caf50", "#ffffff", 50, 0, "#696a6a");
//        _rippleRoundStroke(linear18, "#4caf50", "#ffffff", 50, 0, "#696a6a");
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            _Animator(trial, "scaleX", 0.7d, 500);
                            _Animator(trial, "scaleY", 0.7d, 500);
                            t = new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                _Animator(trial, "scaleX", 1, 500);
                                                _Animator(trial, "scaleY", 1, 500);
                                            }
                                        });
                                }
                            };
                            _timer.schedule(t, (int)(500));
                        }
                    });
            }
        };

        _timer.scheduleAtFixedRate(t, (int)(0), (int)(1500));
        }
       /* t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            _Animator(linear18, "scaleX", 0.7d, 400);
                            _Animator(linear18, "scaleY", 0.7d, 400);
                            t = new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                _Animator(linear18, "scaleX", 0.9d, 400);
                                                _Animator(linear18, "scaleY", 0.9d, 400);
                                            }
                                        });
                                }
                            };
                            _timer.schedule(t, (int)(500));
                        }
                    });
            }
        };

        _timer.scheduleAtFixedRate(t, (int)(0), (int)(1000));
        _changeActivityFont("en_light"); 
    }   */




    public void _SX_CornerRadius_4(final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
        android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();

        gd.setColor(Color.parseColor(_color1));

        gd.setStroke((int)_str, Color.parseColor(_color2));

        gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});

        _view.setBackground(gd);

        _view.setElevation(4);
    }


    public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
        android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
        GG.setColor(Color.parseColor(_focus));
        GG.setCornerRadius((float)_round);
        GG.setStroke((int) _stroke,
                     Color.parseColor("#" + _strokeclr.replace("#", "")));
        android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
        _view.setBackground(RE);
    }


    public void _Animator(final View _view, final String _propertyName, final double _value, final double _duration) {
        
        ObjectAnimator anim = new ObjectAnimator();
        anim.setTarget(_view);
        anim.setPropertyName(_propertyName);
        anim.setFloatValues((float)_value);
        anim.setDuration((long)_duration);
        anim.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        anim.start();
    }


    public void _changeActivityFont(final String _fontname) {
        activityFontName = _fontname.trim();
        if (activityFontName.contains(".ttf")) {
            activityFontName = activityFontName.replace(".ttf", "");
        }
        overrideFonts(this,getWindow().getDecorView()); 
    } 
    private void overrideFonts(final android.content.Context context, final View v) {
        try {
            Typeface activityTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + activityFontName + ".ttf");
            if ((v instanceof ViewGroup)) {
                ViewGroup activityFontGroup = (ViewGroup) v;
                for (int i = 0;
                     i < activityFontGroup.getChildCount();
                i++) {
                    View child = activityFontGroup.getChildAt(i);
                    overrideFonts(context, child);
                }
            }
            else {
                if ((v instanceof TextView)) {
                    ((TextView) v).setTypeface(activityTypeFace);
                }
                else {
                    if ((v instanceof EditText )) {
                        ((EditText) v).setTypeface(activityTypeFace);
                    }
                    else {
                        if ((v instanceof Switch )) {
                            ((Switch) v).setTypeface(activityTypeFace);
                        }
                        else {
                            if ((v instanceof CheckBox )) {
                                ((CheckBox) v).setTypeface(activityTypeFace);
                            }
                            else {
                                if ((v instanceof Button)) {
                                    ((Button) v).setTypeface(activityTypeFace);
                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e){ e.toString();
        }
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
    
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }
   @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(R.anim.up_enter,R.anim.up_exit);
    }

      @Override
    protected void onResume()
    {
        // TODO: Implement this method
        super.onResume();
//        premium();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    protected void onPause()
    {
        // TODO: Implement this method
        super.onPause();

        if (mAdView != null) {
            mAdView.pause();
        }
    }

    @Override
    protected void onDestroy()
    {
        // TODO: Implement this method
        super.onDestroy();

        if (mAdView != null) {
            mAdView.destroy();
        }
    }

}
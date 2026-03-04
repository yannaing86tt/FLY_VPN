package com.flyvpnpro.main.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.flyvpnpro.main.activities.BaseActivity;
import com.flyvpnpro.main.LicenseActivity;
import com.flyvpnpro.official.R;
import com.flyvpnpro.main.util.Utils;


public class AboutActivity extends BaseActivity implements OnClickListener {

    private AdView adsBannerView;
    private View changelog, license, dev, credits , update;
    private AlertDialog.Builder ab;
    private TextView app_info_text;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);

        MobileAds.initialize(this);
        mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    // Code to be executed when an ad finishes loading.
                }


                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                }


                @Override
                public void onAdClosed() {
                    // Code to be executed when when the user is about to return
                    // to the app after tapping on an ad.
                }
            });

        changelog = findViewById(R.id.changelog3);
        license = findViewById(R.id.license);
        dev = findViewById(R.id.developer);
        update = findViewById(R.id.updatecheck);

        changelog.setOnClickListener(this);
        license.setOnClickListener(this);
        dev.setOnClickListener(this);
        update.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    

        PackageInfo pinfo = Utils.getAppInfo(this);
        if (pinfo != null) {
            String version_nome = pinfo.versionName;
            int version_code = pinfo.versionCode;
            String header_text = String.format("%s (%d)", version_nome, version_code);
            app_info_text = (TextView) findViewById(R.id.appVersion);
            app_info_text.setText(header_text);
        }

    }


    @Override
    public void onClick(View view) {
        // TODO: Implement this method
        int id = view.getId();
        if (id == R.id.changelog3) {
            changelog3();
        } else if (id == R.id.license) {
            license();
        } else if (id == R.id.updatecheck) {
            startActivity(new Intent("android.intent.action.VIEW", 
                                     Uri.parse("https://play.google.com/store/apps/details?id=com.flyvpnpro.official")));
        } else if (id == R.id.developer) {
            startActivity(new Intent("android.intent.action.VIEW", 
                                     Uri.parse("https://t.me/YanNaingLyn")));
        }
    }

    private void changelog3() {
        // TODO: Implement this method
        ab = new AlertDialog.Builder(this);
        ab.setTitle("Whats new??");
        ab.setMessage(Html.fromHtml("• Free SSH Site Support <br> • New Custom Setup Support \n(SSH/SSL)(WebSocket)(SSL+PAY) \n(Direct)(SSL+RP)(SlowDNS)️ <br> • DNS Server & Slow DNS <br> • New Premium Feature <br> • Fixed Android 6.0 -> 13 Supported"));
        ab.setPositiveButton(android.R.string.ok, null);
        ab.create().show();
    }

    private void license() {
        // TODO: Implement this method
        startActivity(new Intent(this, LicenseActivity.class));
    }

    @Override
    protected void onResume()
    {
        // TODO: Implement this method
        super.onResume();

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

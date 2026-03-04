package com.flyvpnpro.main.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.appcompat.widget.Toolbar;
import com.flyvpnpro.main.activities.BaseActivity;
import com.flyvpnpro.official.R;
import com.flyvpnpro.main.preference.SettingsPreference;
import com.flyvpnpro.main.preference.SettingsSSHPreference;
import com.flyvpnpro.second.util.ProtectedHS;

public class ConfigGeralActivity extends BaseActivity
implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
{
    public static String OPEN_SETTINGS_SSH = "openSSHScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO: Implement this method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        PreferenceFragmentCompat preference = new SettingsPreference();
        Intent intent = getIntent();

        String action = intent.getAction();
        if (action != null && action.equals(OPEN_SETTINGS_SSH)) {
            setTitle(R.string.settings_ssh);
            preference = new SettingsSSHPreference();
        }

        // add preference settings
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_configLinearLayout, preference)
            .commit();

        // toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      
        ProtectedHS.CharlieProtect();
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        // Instantiate the new Fragment
        final Bundle bundle = pref.getExtras();
        final Fragment fragment = Fragment.instantiate(this, pref.getFragment(), bundle);

        fragment.setTargetFragment(caller, 0);

        // Replace the existing Fragment with the new Fragment
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_configLinearLayout, fragment)
            .addToBackStack(null)
            .commit();

        return true;
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
}
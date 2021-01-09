package vv.vignesh.flashlauncher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity  {
    public static final String
            KEY_PREF_EXAMPLE_SWITCH = "example_switch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);


        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
//        getSupportFragmentManager().beginTransaction()
//                .replace(android.R.id.content, new SettingsFragment())
//                .commit();

        SettingsFragment firstFragment = new SettingsFragment();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        firstFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();

//        SharedPreferences sharedPref =
//                PreferenceManager.getDefaultSharedPreferences(this);
//        Boolean switchPref = sharedPref.getBoolean
//                (SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false);
//        Toast.makeText(this, switchPref.toString(), Toast.LENGTH_SHORT).show();


    }


}

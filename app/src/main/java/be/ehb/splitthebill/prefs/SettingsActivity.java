package be.ehb.splitthebill.prefs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import be.ehb.splitthebill.R;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getFragmentManager().beginTransaction().add(R.id.frag_container, new SettingsFragment()).commit();
    }
}

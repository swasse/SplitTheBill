package be.ehb.splitthebill.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import be.ehb.splitthebill.R;
import be.ehb.splitthebill.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        // Display the fragment as the main content.
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, SettingsFragment.newInstance()) //content -> references framelayout
                .commit();
    }


}
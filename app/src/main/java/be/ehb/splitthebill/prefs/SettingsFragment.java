package be.ehb.splitthebill.prefs;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import be.ehb.splitthebill.R;

/**
 * Created by davidvansteertegem on 05/02/16.
 */
public class SettingsFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

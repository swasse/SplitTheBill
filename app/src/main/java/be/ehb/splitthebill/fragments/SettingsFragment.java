package be.ehb.splitthebill.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import be.ehb.splitthebill.R;



public class SettingsFragment extends PreferenceFragmentCompat {

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
    }
}

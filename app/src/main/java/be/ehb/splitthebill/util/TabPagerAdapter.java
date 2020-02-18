package be.ehb.splitthebill.util;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import be.ehb.splitthebill.R;
import be.ehb.splitthebill.fragments.AboutFragment;
import be.ehb.splitthebill.fragments.SettingsFragment;
import be.ehb.splitthebill.fragments.SplitBillFragment;


public class TabPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] screens = {SplitBillFragment.newInstance(),
            SettingsFragment.newInstance(),
            AboutFragment.newInstance()
    };

    public TabPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return screens[position];
    }

    @Override
    public int getCount() {
        return screens.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (screens[position].getArguments() != null) {
            return (CharSequence) screens[position].getArguments().get("title");
        }
        return super.getPageTitle(position);
    }
}

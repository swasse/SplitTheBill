package be.ehb.splitthebill.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import be.ehb.splitthebill.R;
import be.ehb.splitthebill.fragments.AboutFragment;
import be.ehb.splitthebill.fragments.SplitBillFragment;


public class TabPagerAdapter extends FragmentPagerAdapter {

    AppCompatActivity activity;

    public TabPagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return SplitBillFragment.newInstance();

            case 1: return AboutFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return activity.getResources().getString(R.string.txt_tab_split);

            case 1: return activity.getResources().getString(R.string.txt_tab_about);
        }
        return super.getPageTitle(position);
    }
}

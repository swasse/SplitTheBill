package be.ehb.splitthebill.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import be.ehb.splitthebill.R;


public class AboutFragment extends Fragment {

    public static AboutFragment newInstance() {
        AboutFragment af = new AboutFragment();
        Bundle args = new Bundle();
        args.putCharSequence("title", "About");
        af.setArguments(args);
        return af;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);

    }
}

package be.ehb.splitthebill.main;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import be.ehb.splitthebill.R;


public class SplitBillFragment extends Fragment {


    EditText etSubtotal, etTip, etPartySize;
    TextView tvTotal;
    Button btnCalculate;
    View.OnClickListener calcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double subtotal = Double.valueOf(etSubtotal.getText().toString());
            double tip = Double.valueOf(etTip.getText().toString());
            double partySize = Double.valueOf(etPartySize.getText().toString());

            double total = (subtotal+tip)/partySize;

            tvTotal.setText(""+total);
        }
    };

    public SplitBillFragment() {
        // Required empty public constructor
    }

    public static SplitBillFragment newInstance() {
        SplitBillFragment fragment = new SplitBillFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_split_bill, container, false);

        etSubtotal = (EditText) rootView.findViewById(R.id.et_subtotal);
        etTip = (EditText) rootView.findViewById(R.id.et_tip);
        etPartySize = (EditText) rootView.findViewById(R.id.et_party_size);

        tvTotal = (TextView) rootView.findViewById(R.id.tv_total);

        btnCalculate = (Button) rootView.findViewById(R.id.btn_calc_total);
        btnCalculate.setOnClickListener(calcListener);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String defaultTip = sp.getString("pref_tip","0");
        etTip.setText(defaultTip);
    }
}

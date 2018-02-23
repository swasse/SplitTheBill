package be.ehb.splitthebill.fragments;


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

import java.util.Locale;

import be.ehb.splitthebill.R;


public class SplitBillFragment extends Fragment {

    //UI
    private EditText etSubtotal, etTip, etPartySize;
    private TextView tvTotal;
    private Button btnCalculate;
    //Listener
    View.OnClickListener calcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            double subtotal = 0, tip = 0, partySize = 0;

            if (etSubtotal.getText().length() != 0)
                subtotal = Double.valueOf(etSubtotal.getText().toString());
            if (etTip.getText().length() != 0)
                tip = Double.valueOf(etTip.getText().toString());
            if (etPartySize.getText().length() != 0)
                partySize = Double.valueOf(etPartySize.getText().toString());

            if(subtotal == 0){
                tvTotal.setText("Eating for free or wadde?");
                return;
            }

            if(partySize == 0){
                tvTotal.setText("Like no one has to pay eh sjarel");
                return;
            }

            double total = (subtotal + tip) / partySize;
            tvTotal.setText(String.format("%.2f the man", total));
            //trukken van de foor
            //tvTotal.setText(""+total);
        }
    };

    public SplitBillFragment() {
        // Required empty public constructor
    }

    public static SplitBillFragment newInstance() {
        return new SplitBillFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_split_bill, container, false);

        etSubtotal = rootView.findViewById(R.id.et_subtotal);
        etTip =  rootView.findViewById(R.id.et_tip);
        etPartySize =  rootView.findViewById(R.id.et_party_size);

        tvTotal =  rootView.findViewById(R.id.tv_total);

        btnCalculate = rootView.findViewById(R.id.btn_calc_total);
        btnCalculate.setOnClickListener(calcListener);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String defaultTip = sp.getString("pref_tip", "0");
        etTip.setText(defaultTip);
    }
}

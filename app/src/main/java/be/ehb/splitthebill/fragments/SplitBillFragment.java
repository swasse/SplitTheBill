package be.ehb.splitthebill.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import be.ehb.splitthebill.R;


public class SplitBillFragment extends Fragment {

    //UI
    private EditText etSubtotal, etTip, etPartySize;
    private TextView tvTotal;
    //Listener
    private View.OnClickListener calcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            double subtotal = 0, tip = 0, partySize = 0;

            if (etSubtotal.getText().toString().matches("[0-9].?[0-9]{0,2}"))
                subtotal = Double.valueOf(etSubtotal.getText().toString());
            else {
                tvTotal.setText(R.string.warning_invalid_number);
                return;
            }
            if (etTip.getText().toString().matches("[0-9]?.?[0-9]{0,2}")){
                if (!etTip.getText().toString().isEmpty()) {
                    tip = Double.valueOf(etTip.getText().toString());
                }
            } else {
                tvTotal.setText(R.string.warning_invalid_number);
                return;
            }
            if (etPartySize.getText().toString().matches("[0-9]+.?[0-9]{0,2}"))
                partySize = Double.valueOf(etPartySize.getText().toString());
            else {
                tvTotal.setText(R.string.warning_invalid_number);
                return;
            }

            double total = (subtotal + tip) / partySize;
            tvTotal.setText(String.format(Locale.getDefault() ,"%.2f %s", total, getResources().getString(R.string.the_man)));
            //trukken van de foor
            //tvTotal.setText(""+total);
        }
    };

    public static SplitBillFragment newInstance() {
        SplitBillFragment sbf = new SplitBillFragment();
        Bundle args = new Bundle();
        args.putCharSequence("title", "Split it!");
        sbf.setArguments(args);
        return sbf;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_split_bill, container, false);

        etSubtotal = rootView.findViewById(R.id.et_subtotal);
        etTip =  rootView.findViewById(R.id.et_tip);
        etPartySize =  rootView.findViewById(R.id.et_party_size);
        tvTotal =  rootView.findViewById(R.id.tv_total);
        Button btnCalculate = rootView.findViewById(R.id.btn_calc_total);
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

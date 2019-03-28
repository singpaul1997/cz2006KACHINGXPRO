package com.example.cz2006kachingx;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentfirst extends Fragment {

    int firstpage_basecurr;
    int firstpage_targetcurr;
    final String sgd = "Singapore Dollar";
    final String usd = "US Dollar";
    final String mrg = "Malaysian Ringgit";
    final String aud = "Australian Dollar";
    final String eur = "Euro";
    final String bpd = "British Pound";
    int sorting;

    public fragmentfirst() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisview = inflater.inflate(R.layout.fragment_fragmentfirst, container, false);
        return thisview;
    }

    public void onViewCreated(View thisview, Bundle savedInstanceState) {
        super.onViewCreated(thisview, savedInstanceState);
        final View newview = thisview;
        //setup of spinner and onitemselectedlistener
        final Spinner basecurrencyspinner = (Spinner) thisview.findViewById(R.id.firstpage_base);
        final Spinner targetcurrencyspinner = (Spinner) thisview.findViewById(R.id.firstpage_target);
        final ArrayAdapter<CharSequence> adapter_full = ArrayAdapter.createFromResource(getActivity(), R.array.listofcurrency, R.layout.list_item);
        adapter_full.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> adapter_part = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerswitch, R.layout.list_item);
        adapter_part.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        basecurrencyspinner.setAdapter(adapter_full);
        targetcurrencyspinner.setAdapter(adapter_full);
        basecurrencyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                final String itemb = parent.getItemAtPosition(pos).toString();
                switch (itemb) {
                    case sgd:
                        targetcurrencyspinner.setAdapter(adapter_full);
                        firstpage_basecurr = 0;
                        break;
                    case usd:
                        targetcurrencyspinner.setAdapter(adapter_part);
                        firstpage_basecurr = 1;
                        break;
                    case mrg:
                        targetcurrencyspinner.setAdapter(adapter_part);
                        firstpage_basecurr = 2;
                        break;
                    case aud:
                        targetcurrencyspinner.setAdapter(adapter_part);
                        firstpage_basecurr = 3;
                        break;
                    case eur:
                        targetcurrencyspinner.setAdapter(adapter_part);
                        firstpage_basecurr = 4;
                        break;
                    case bpd:
                        targetcurrencyspinner.setAdapter(adapter_part);
                        firstpage_basecurr = 5;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                targetcurrencyspinner.setAdapter(adapter_full);

                firstpage_basecurr = 0;

            }
        });

        targetcurrencyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                final String itema = parent.getItemAtPosition(pos).toString();
                switch (itema) {
                    case sgd:
                        basecurrencyspinner.setAdapter(adapter_full);
                        firstpage_targetcurr = 0;
                        break;
                    case usd:
                        basecurrencyspinner.setAdapter(adapter_part);
                        firstpage_targetcurr = 1;
                        break;
                    case mrg:
                        basecurrencyspinner.setAdapter(adapter_part);
                        firstpage_targetcurr = 2;
                        break;
                    case aud:
                        basecurrencyspinner.setAdapter(adapter_part);
                        firstpage_targetcurr = 3;
                        break;
                    case eur:
                        basecurrencyspinner.setAdapter(adapter_part);
                        firstpage_targetcurr = 4;
                        break;
                    case bpd:
                        basecurrencyspinner.setAdapter(adapter_part);
                        firstpage_targetcurr = 5;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                basecurrencyspinner.setAdapter(adapter_full);

                firstpage_targetcurr = 0;

            }
        });
        sorting = 1;
        RadioGroup selectby = thisview.findViewById(R.id.sorting);
        selectby.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sort_rate:
                        sorting = 1;
                        break;
                    case R.id.sort_location:
                        sorting = 2;
                        break;
                }

        }
    });
        Button Search = (Button)thisview.findViewById(R.id.search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sorting==1){
                    Fragment fragment = new fragmentextend0();
                    Bundle bundle = new Bundle();
                    bundle.putInt("base", firstpage_basecurr);
                    bundle.putInt("tar", firstpage_targetcurr);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_first, fragment).addToBackStack(null).commit();
                }else if (sorting==2){
                    Fragment fragment = new fragmentextend1();
                    Bundle bundle = new Bundle();
                    bundle.putInt("base", firstpage_basecurr);
                    bundle.putInt("tar", firstpage_targetcurr);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_first, fragment).addToBackStack(null).commit();

                }
            }
        });





    }
}

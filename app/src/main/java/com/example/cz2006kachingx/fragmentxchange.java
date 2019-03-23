package com.example.cz2006kachingx;


import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentxchange extends Fragment  {


    int currency_base;
    int currency_target;
    final String sgd = "Singapore Dollar";
    final String usd = "US Dollar";
    final String mrg = "Malaysian Ringgit";
    final String aud = "Australian Dollar";
    final String eur = "Euro";
    final String bpd = "British Pound";
    int input = 0;
    TextView result;
    public fragmentxchange() {
        // Required empty public constructor
    }


    public void onViewCreated(View thisview, Bundle savedInstanceState){
        super.onViewCreated(thisview, savedInstanceState);
        final View newview = thisview;
        //setup of spinner and onitemselectedlistener
        Spinner basecurrencyspinner = (Spinner) thisview.findViewById(R.id.basecurrency);
        Spinner targetcurrencyspinner = (Spinner) thisview.findViewById(R.id.targetcurrency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.listofcurrency, R.layout.list_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        targetcurrencyspinner.setAdapter(adapter);
        //get information from database
        DBHandler dbHandler = new DBHandler(getActivity(), null, null, 1);
        String tempstring = dbHandler.findcolumn(1).exchange_rate;
        final rate currencyrates = new rate(dbHandler.findcolumn(1).exchange_rate);
        //setup user input value
        final EditText inputexchange = thisview.findViewById(R.id.exchangeinput);
        //spinner2 listener
        targetcurrencyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String itema = parent.getItemAtPosition(pos).toString();
                switch(itema){
                    case sgd:
                        currency_target = 0;
                        break;
                    case usd:
                        currency_target = 1;
                        break;
                    case mrg:
                        currency_target = 2;
                        break;
                    case aud:
                        currency_target = 3;
                        break;
                    case eur:
                        currency_target = 4;
                        break;
                    case bpd:
                        currency_target = 5;
                        break;
                }
                double base = Double.parseDouble(currencyrates.rates[currency_base]);
                double target = Double.parseDouble(currencyrates.rates[currency_target]);
                result = newview.findViewById(R.id.exchangeresult);
                //if input is given
                if (input == 1) {
                    double amount = currencyrates.calculateRate(base, target,Double.parseDouble(inputexchange.getText().toString()));
                    result.setText(String.valueOf(amount));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currency_target = 0;
            }
        });


        basecurrencyspinner.setAdapter(adapter);
        //spinner1 listener
        basecurrencyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                final String itemb = parent.getItemAtPosition(pos).toString();
                switch(itemb){
                    case sgd:
                        currency_base = 0;
                        break;
                    case usd:
                        currency_base = 1;
                        break;
                    case mrg:
                        currency_base = 2;
                        break;
                    case aud:
                        currency_base = 3;
                        break;
                    case eur:
                        currency_base = 4;
                        break;
                    case bpd:
                        currency_base = 5;
                        break;
                }
                double base = Double.parseDouble(currencyrates.rates[currency_base]);
                double target = Double.parseDouble(currencyrates.rates[currency_target]);
                result = newview.findViewById(R.id.exchangeresult);
                //same if input is given
                if (input == 1) {
                    double amount = currencyrates.calculateRate(base, target,Double.parseDouble(inputexchange.getText().toString()));
                    result.setText(String.valueOf(amount));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currency_base=0;
            }
        });


        //listener for input
        inputexchange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //set input to 1
                input = 1;
                SpannableString spannableString = new SpannableString(s);
                double base = Double.parseDouble(currencyrates.rates[currency_base]);
                double target = Double.parseDouble(currencyrates.rates[currency_target]);
                result = newview.findViewById(R.id.exchangeresult);
                double amount = currencyrates.calculateRate(base, target,Double.parseDouble(s.toString()));
                result.setText(String.valueOf(amount));
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisview = inflater.inflate(R.layout.fragment_fragmentxchange, container, false);
        return thisview;
    }}

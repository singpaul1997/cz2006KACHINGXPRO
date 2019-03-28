package com.example.cz2006kachingx;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentextend0 extends Fragment {
    final int size = 3;

    public fragmentextend0() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container.removeAllViews();
        DBHandler dbHandler = new DBHandler(getActivity(),null,null,1);
        CurrencyExchange[] array_exchange = new CurrencyExchange[size];
        for (int a=0;a<size;a++){
 
        }
        View newview = inflater.inflate(R.layout.fragment_fragmentextend0, container, false);
        return newview;
    }
    public void
}

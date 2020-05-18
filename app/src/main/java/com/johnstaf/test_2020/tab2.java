package com.johnstaf.test_2020;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab2 extends Fragment {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String text;
    private TextView test1;

    public tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        super.onCreate(savedInstanceState);

        test1 = v.findViewById(R.id.test1);

        loadData();
        updateViews();


        // Inflate the layout for this fragment
        return v;
    }



    public void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
    }

    public void updateViews() {
        test1.setText(text);
    }
}

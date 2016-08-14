package com.teamwork.discover.fragment.BigDataFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.teamwork.discover.R;

import com.teamwork.discover.MyView.MWRateView.MyMWRatePieView;

/**
 * Created by pcx on 2016/8/7.
 */

public class MaleFemaleRateFragment extends Fragment {
    private Spinner mSpinner_college;
    private Spinner mSpinner_specialty;
    private ArrayAdapter<String> arrayAdapter_college;
    private ArrayAdapter<String> arrayAdapter_specialty;
    private static String college_array = null;
    private static String specialty_array = null;
    private static int mark = 0x1;
    private static MyMWRatePieView myMWRatePieView = null;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mwratepiefragment, container, false);
        myMWRatePieView = (MyMWRatePieView) view.findViewById(R.id.mw_MyMWRatePieView);
        mSpinner_college = (Spinner) view.findViewById(R.id.sp_college);
        mSpinner_college.setPrompt(getResources().getString(R.string.choose_college));
        mSpinner_specialty = (Spinner) view.findViewById(R.id.sp_specialty);
        mSpinner_specialty.setPrompt(getResources().getString(R.string.choose_specialty));
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayAdapter_college = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.college_name));
        arrayAdapter_college.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner_college.setVisibility(View.VISIBLE);

        mSpinner_college.setAdapter(arrayAdapter_college);

        arrayAdapter_specialty = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.specialty_name));
        arrayAdapter_specialty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner_college.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        mSpinner_specialty.setAdapter(arrayAdapter_specialty);
        mSpinner_specialty.setVisibility(View.VISIBLE);
        mSpinner_specialty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                specialty_array = (String) adapterView.getItemAtPosition(i);
                myMWRatePieView.setData(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

}

package com.teamwork.discover.Fragment.BigDataFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.teamwork.discover.R;

import com.teamwork.discover.Data.DifficultSubjectRate;
import com.teamwork.discover.MyView.MWRateView.DifficultRateView.DifficultRatePieView;
import com.teamwork.discover.MyView.MWRateView.DifficultRateView.MySubjectRoudRect;

/**
 * Created by pcx on 2016/8/7.
 */

public class DifficultSubjectFragment extends Fragment {
    private Spinner spinner;
    private ArrayAdapter <String>arrayAdapter;
    private DifficultSubjectRate difficultSubjectRate = new DifficultSubjectRate();
    private DifficultRatePieView difficultRatePieView;
    private MySubjectRoudRect mySubjectRoudRect;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.difficultsubjectfragment, container, false);
        spinner = (Spinner) view.findViewById(R.id.sp_difficult);
        difficultRatePieView = (DifficultRatePieView) view.findViewById(R.id.mv_difficult_pie);
        mySubjectRoudRect = (MySubjectRoudRect) view.findViewById(R.id.mv_subject);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                difficultSubjectRate.difficult_college);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setVisibility(View.VISIBLE);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                difficultRatePieView.setData(i);
                mySubjectRoudRect.setData(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

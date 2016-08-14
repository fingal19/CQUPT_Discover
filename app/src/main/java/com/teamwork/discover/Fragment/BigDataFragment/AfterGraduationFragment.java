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

import com.teamwork.discover.data.GraduateRate;
import com.teamwork.discover.MyView.MWRateView.AfterGraduate.GraduatePieView;

/**
 * Created by pcx on 2016/8/7.
 */

public class AfterGraduationFragment extends Fragment {
    private Spinner spinner;
    private ArrayAdapter <String>arrayAdapter;
    private GraduateRate graduateRate = new GraduateRate();
    private GraduatePieView graduatePieView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.graduatefragment, container, false);
        spinner = (Spinner) view.findViewById(R.id.sp_graduate);
        graduatePieView = (GraduatePieView) view.findViewById(R.id.mv_ag);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                graduateRate.graduate_college);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setVisibility(View.VISIBLE);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                graduatePieView.setData(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

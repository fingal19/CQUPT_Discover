package com.teamwork.discover.Fragment.NewbieFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamwork.discover.R;

/**
 * Created by pcx on 2016/8/5.
 */

public class RouteToSchoolFragment extends Fragment{
    private TextView mTextView_airport_title;
    private TextView mTextView_airport_details;
    private TextView mTextView_train_title;
    private TextView mTextView_train_details;
    private TextView mTextView_motor_title;
    private TextView mTextView_motor_details;
    private TextView mTextView_wharf_title;
    private TextView mTextView_wharf_details;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.routetoschoolfragment,container,false);
        mTextView_airport_title = (TextView) view.findViewById(R.id.routeToSchool_airport_1);
        mTextView_airport_details = (TextView) view.findViewById(R.id.routeToSchool_airport_2);
        mTextView_train_title = (TextView) view.findViewById(R.id.routeToSchool_rainStation_1);
        mTextView_train_details = (TextView) view.findViewById(R.id.routeToSchool_rainStation_2);
        mTextView_motor_title = (TextView) view.findViewById(R.id.routeToSchool_motorStation_1);
        mTextView_motor_details = (TextView) view.findViewById(R.id.routeToSchool_motorStation_2);
        mTextView_wharf_title = (TextView) view.findViewById(R.id.routeToSchool_shop_1);
        mTextView_wharf_details = (TextView) view.findViewById(R.id.routeToSchool_shop_2);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView_airport_title.setText(R.string.rout_airport);
        mTextView_airport_details.setText(R.string.route_airport_details);
        mTextView_train_title.setText(R.string.route_train);
        mTextView_train_details.setText(R.string.route_train_details);
        mTextView_motor_title.setText(R.string.route_motor);
        mTextView_motor_details.setText(R.string.route_motor_details);
        mTextView_wharf_title.setText(R.string.route_wharf);
        mTextView_wharf_details.setText(R.string.route_wharf_details);
    }
}

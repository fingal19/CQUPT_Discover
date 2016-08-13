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

public class DormitorySituationFragment extends Fragment {
    private TextView mTextView_1;
    private TextView mTextView_2;
    private TextView mTextView_3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dormitorysituationfragment,container,false);
        mTextView_1 = (TextView) view.findViewById(R.id.tv_dor_details_1);
        mTextView_2 = (TextView) view.findViewById(R.id.tv_dor_details_2);
        mTextView_3 = (TextView) view.findViewById(R.id.tv_dor_details_3);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mTextView_1.setText(R.string.oldDormitory_details);
        mTextView_2.setText(R.string.fourPeopleDor_details);
        mTextView_3.setText(R.string.sixPeopleDor_details);
    }

}

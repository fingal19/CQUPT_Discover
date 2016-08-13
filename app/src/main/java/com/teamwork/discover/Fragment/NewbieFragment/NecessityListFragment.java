package com.teamwork.discover.Fragment.NewbieFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamwork.discover.R;

/**
 * Created by pcx on 2016/8/6.
 */

public class NecessityListFragment extends Fragment {
    private TextView mTextView_important;
    private TextView mTextView_important_details;
    private TextView mTextView_notIgnore;
    private TextView mTextView_notIgnore_details;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.necessitylist,container,false);
        mTextView_important = (TextView) view.findViewById(R.id.tv_important);
        mTextView_important_details = (TextView) view.findViewById(R.id.tv_important_details);
        mTextView_notIgnore = (TextView) view.findViewById(R.id.tv_notIgnore);
        mTextView_notIgnore_details = (TextView) view.findViewById(R.id.tv_notIgnore_details);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView_important.setText(R.string.important_things);
        mTextView_important_details.setText(R.string.important_things_details);
        mTextView_notIgnore.setText(R.string.notIgnore);
        mTextView_notIgnore_details.setText(R.string.notIgnore_details);
    }
}

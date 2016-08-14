package com.teamwork.discover.fragment.NewbieFragment;

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

public class QQGroupFragment extends Fragment {
    private TextView mTextView_fresh;
    private TextView mTextView_fresh_qq;
    private TextView mTextView_townsman;
    private TextView mTextView_townsman_qq;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.qqgroup,container,false);
        mTextView_fresh = (TextView) view.findViewById(R.id.tv_group_fresh);
        mTextView_fresh_qq = (TextView) view.findViewById(R.id.tv_group_fresh_qqNum);
        mTextView_townsman = (TextView) view.findViewById(R.id.tv_group_townsman);
        mTextView_townsman_qq = (TextView) view.findViewById(R.id.tv_group_townsman_qqNum);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView_fresh.setText(R.string.fresh);
        mTextView_fresh_qq.setText(R.string.fresh_qqGroupNum);
        mTextView_townsman.setText(R.string.towmsman);
        mTextView_townsman_qq.setText(R.string.townsman_qqGroupNum);
    }
}

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

public class EntrancethingsFragment extends Fragment {
    private TextView mTextView_report;
    private TextView mTextView_report_details;
    private TextView mTextView_safe;
    private TextView mTextView_safe_details;
    private TextView mTextView_bonus;
    private TextView mTextView_bonus_details;
    private TextView mTextView_handBook;
    private TextView mTextView_handBook_details;
    private TextView mTextView_expansion_re;
    private TextView mTextView_expansion_bonus;
    private TextView mTextView_expasion_hand;
    private boolean hasClick = false;
    private final int max = 2;
    private final int maxLine = 350;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.entrancethingsfragment,container,false);
        mTextView_report = (TextView) view.findViewById(R.id.entranceThings_reporter_1);
        mTextView_report_details = (TextView) view.findViewById(R.id.entranceThings_reporter_2);
        mTextView_safe = (TextView) view.findViewById(R.id.entranceThings_safety_1);
        mTextView_safe_details = (TextView) view.findViewById(R.id.entranceThings_safety_2);
        mTextView_bonus = (TextView) view.findViewById(R.id.entranceThings_bonus_1);
        mTextView_bonus_details = (TextView) view.findViewById(R.id.entranceThings_bonus_2);
        mTextView_handBook = (TextView) view.findViewById(R.id.entranceThings_handbook_1);
        mTextView_handBook_details = (TextView) view.findViewById(R.id.entranceThings_handbook_2);
        mTextView_expansion_re = (TextView) view.findViewById(R.id.tv_expansion_reporter);
        mTextView_expansion_bonus = (TextView) view.findViewById(R.id.tv_expansion_bonus);
        mTextView_expasion_hand = (TextView) view.findViewById(R.id.tv_expansion_handbook);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mTextView_report.setText(R.string.report);
        mTextView_report_details.setText(R.string.report_details);
        mTextView_safe.setText(R.string.safe);
        mTextView_safe_details.setText(R.string.safe_details);
        mTextView_bonus.setText(R.string.bonus);
        mTextView_bonus_details.setText(R.string.bonus_details);
        mTextView_handBook.setText(R.string.handBook);
        mTextView_handBook_details.setText(R.string.handBook_details);
        mTextView_expansion_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasClick == false){
                    mTextView_report_details.setMaxLines(maxLine);
                    mTextView_expansion_re.setText(R.string.packUp);
                    hasClick = true;
                }else {
                    mTextView_report_details.setMaxLines(max);
                    mTextView_expansion_re.setText(R.string.expansion);
                    hasClick = false;
                }
            }
        });
        mTextView_expansion_bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasClick == false){
                    mTextView_bonus_details.setMaxLines(maxLine);
                    mTextView_expansion_bonus.setText(R.string.packUp);
                    hasClick = true;
                }else {
                    mTextView_bonus_details.setMaxLines(max);
                    mTextView_expansion_bonus.setText(R.string.expansion);
                    hasClick = false;
                }
            }
        });
        mTextView_expasion_hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasClick == false){
                   mTextView_handBook_details.setMaxLines(maxLine);
                    mTextView_expasion_hand.setText(R.string.packUp);
                    hasClick = true;
                }else {
                    mTextView_handBook_details.setMaxLines(max);
                    mTextView_expasion_hand.setText(R.string.expansion);
                    hasClick = false;
                }
            }
        });
    }
}

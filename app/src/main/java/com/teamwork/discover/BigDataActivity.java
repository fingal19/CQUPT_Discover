package com.teamwork.discover;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.teamwork.discover.adapter.ViewPagerAdapter.TabViewPagerAdapter;
import com.teamwork.discover.fragment.BigDataFragment.DifficultSubjectFragment;
import com.teamwork.discover.fragment.BigDataFragment.AfterGraduationFragment;
import com.teamwork.discover.fragment.BigDataFragment.MaleFemaleRateFragment;

public class BigDataActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private MaleFemaleRateFragment mMaleFemaleRateFragment;
    private DifficultSubjectFragment mDifficultSubjectFragment;
    private AfterGraduationFragment mAfterGraduationFragment;

    private List<Fragment> list_fragment;
    private List<String> list_title;
    private TabViewPagerAdapter mTabViewPagerAdapter;
    private TextView mTextView_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include_tab);
       mTextView_tv = (TextView) findViewById(R.id.tittle_tv);
        mTextView_tv.setText("大数据");
        initControl();
    }

    public void initControl(){
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);

        mMaleFemaleRateFragment = new MaleFemaleRateFragment();
        mDifficultSubjectFragment = new DifficultSubjectFragment();
        mAfterGraduationFragment = new AfterGraduationFragment();

        list_fragment = new ArrayList<>();
        list_fragment.add(mMaleFemaleRateFragment);
        list_fragment.add(mDifficultSubjectFragment);
        list_fragment.add(mAfterGraduationFragment);

        list_title = new ArrayList<>();
        list_title.add(getString(R.string.mfRate));
        list_title.add(getString(R.string.difficultSubject));
        list_title.add(getString(R.string.afterGraduation));


        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //add tab name
        for (int i = 0; i < 2; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(list_title.get(i)));
        }

        mTabViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager(), list_fragment, list_title);

        //加载viewpager
        mViewPager.setAdapter(mTabViewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(mTabViewPagerAdapter);
    }
}

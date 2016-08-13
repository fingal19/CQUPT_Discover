package com.teamwork.discover;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.teamwork.discover.Adapter.ViewPagerAdapter.TabViewPagerAdapter;
import com.teamwork.discover.Fragment.NewbieFragment.DailyLifeFragment;
import com.teamwork.discover.Fragment.NewbieFragment.DormitorySituationFragment;
import com.teamwork.discover.Fragment.NewbieFragment.EntrancethingsFragment;
import com.teamwork.discover.Fragment.NewbieFragment.NearbyCateFragment;
import com.teamwork.discover.Fragment.NewbieFragment.NearbyScenicFragment;
import com.teamwork.discover.Fragment.NewbieFragment.NecessityListFragment;
import com.teamwork.discover.Fragment.NewbieFragment.QQGroupFragment;
import com.teamwork.discover.Fragment.NewbieFragment.RouteToSchoolFragment;

public class NewStrategyActivity extends AppCompatActivity{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private EntrancethingsFragment mEntrancethingsFragment;
    private RouteToSchoolFragment mRouteToSchoolFragment;
    private DormitorySituationFragment mDormitorySituationFragment;
    private NecessityListFragment mNecessityListFragment;
    private QQGroupFragment mQQGroupFragment;
    private DailyLifeFragment mDailyLifeFragment;
    private NearbyCateFragment mNearbyCateFragment;
    private NearbyScenicFragment mNearbyScenicFragment;

    private List<Fragment> list_fragment;
    private List<String> list_title;
    private TabViewPagerAdapter mTabViewPagerAdapter;

    private TextView mTextView_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_include_tab);
        initControl();
    }

    public void initControl(){
        mTextView_tv = (TextView) findViewById(R.id.tittle_tv);
        mTextView_tv.setText("新手攻略");

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);

        mEntrancethingsFragment = new EntrancethingsFragment();
        mRouteToSchoolFragment = new RouteToSchoolFragment();
        mDormitorySituationFragment = new DormitorySituationFragment();
        mNecessityListFragment = new NecessityListFragment();
        mQQGroupFragment = new QQGroupFragment();
        mDailyLifeFragment = new DailyLifeFragment();
        mNearbyCateFragment = new NearbyCateFragment();
        mNearbyScenicFragment = new NearbyScenicFragment();

        list_fragment = new ArrayList<>();
        list_fragment.add(mEntrancethingsFragment);
        list_fragment.add(mRouteToSchoolFragment);
        list_fragment.add(mDormitorySituationFragment);
        list_fragment.add(mNecessityListFragment);
        list_fragment.add(mQQGroupFragment);
        list_fragment.add(mDailyLifeFragment);
        list_fragment.add(mNearbyCateFragment);
        list_fragment.add(mNearbyScenicFragment);

        list_title = new ArrayList<>();
        list_title.add(getString(R.string.entrance));
        list_title.add(getString(R.string.route));
        list_title.add(getString(R.string.dormitory));
        list_title.add(getString(R.string.necessity));
        list_title.add(getString(R.string.qq_group));
        list_title.add(getString(R.string.dailyLife));
        list_title.add(getString(R.string.nearbyCate));
        list_title.add(getString(R.string.nearbyScenic));

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //add tab name
        for (int i = 0; i < 8; i++) {
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

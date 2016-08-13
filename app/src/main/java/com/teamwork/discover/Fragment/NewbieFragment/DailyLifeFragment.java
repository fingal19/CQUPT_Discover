package com.teamwork.discover.Fragment.NewbieFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.discover.R;

import java.util.ArrayList;
import java.util.List;

import com.teamwork.discover.Adapter.RecycleAdapter.NewbieRVAdapter;
import com.teamwork.discover.Bean.NewbieLifeTextBean;
import com.teamwork.discover.Data.DailyLifeData;

/**
 * Created by pcx on 2016/8/6.
 */

public class DailyLifeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NewbieRVAdapter mNewbieRVAdapter;
    private DailyLifeData mDailyLifeData = new DailyLifeData();
    private NewbieLifeTextBean mNewbieLifeTextBean = new NewbieLifeTextBean();
    private List<NewbieLifeTextBean> list = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recycle_fragment,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNewbieLifeTextBean.setName_place_list(mDailyLifeData.dailyLfe_name);
        mNewbieLifeTextBean.setLocal_list(mDailyLifeData.dailyLfe_local);
        mNewbieLifeTextBean.setIntro_list(mDailyLifeData.dailyLife_intro);
        list.add(mNewbieLifeTextBean);
        mRecyclerView.setAdapter(mNewbieRVAdapter = new NewbieRVAdapter(list));
    }

}

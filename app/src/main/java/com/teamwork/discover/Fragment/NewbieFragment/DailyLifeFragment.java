package com.teamwork.discover.fragment.NewbieFragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.discover.R;

import java.util.ArrayList;
import java.util.List;

import com.teamwork.discover.adapter.RecycleAdapter.NewbieRVAdapter;
import com.teamwork.discover.bean.BitmapUrlBean;
import com.teamwork.discover.bean.NewbieLifeTextBean;
import com.teamwork.discover.com.teamwork.discover.tool.NetWork;
import com.teamwork.discover.data.DailyLifeData;
import com.teamwork.discover.data.DataUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pcx on 2016/8/6.
 */

public class DailyLifeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private static NewbieRVAdapter mNewbieRVAdapter;
    private DailyLifeData mDailyLifeData = new DailyLifeData();
    private NewbieLifeTextBean mNewbieLifeTextBean = new NewbieLifeTextBean();
    private List<NewbieLifeTextBean> list = new ArrayList<>();
    private static List<String> urlList = new ArrayList<>();
    private DataUrl dataUrl = new DataUrl();
    private NetWork mNetWork = new NetWork();
    private List<Bitmap> bitmapList = new ArrayList<>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 4:
                    bitmapList = (List<Bitmap>) msg.obj;
                    mRecyclerView.setAdapter(new NewbieRVAdapter(list,bitmapList));
                    break;
                default:
                    break;
            }

        }
    };
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
        mNewbieRVAdapter = new NewbieRVAdapter(list,bitmapList);
        mRecyclerView.setAdapter(mNewbieRVAdapter );

        new Thread(){
            public void run(){
                mNetWork = new NetWork();

                Message msg = Message.obtain();


                String data = mNetWork.getJson(dataUrl.lifeUrl,"0","19");
                paserData(data);
                msg.what = 4;
                List<Bitmap> bitmapList = new ArrayList<Bitmap>();
                for (int i = 0;i < urlList.size();i++){
                    bitmapList.add(mNetWork.getBitmap(urlList.get(i)));
                    Log.d(">>>>>>>>>>>>","pppppppp");
                }
                msg.obj = bitmapList;
                handler.sendMessage(msg);
            }
        }.start();
    }

    public BitmapUrlBean paserData(String l){
        BitmapUrlBean bitmapUrlBean = null;
        Log.d("----------->","paser");
        try{
            JSONObject json  = new JSONObject(l);
            int code = json.getInt("status");
            Log.d(">>>>>>>>>>>>","lll");
            if (code == 200) {
                JSONArray bodyJson = json.getJSONArray("data");
                for (int i = 0;i < bodyJson.length();i++) {
                    Log.d("<<<<<<<<<<<<",",,,,,,,,,");
                    JSONObject pageJson = bodyJson.getJSONObject(i);
                    JSONArray songJson = pageJson.getJSONArray("photo");
                    JSONObject photoHson = songJson.getJSONObject(0);
                    String a = photoHson.optString("photo_src");
                    Log.d("---------------->",a);
                    Log.d("<<<<<<<<<<<<",",,,,,,,,,");
                    urlList.add(photoHson.optString("photo_src"));
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return bitmapUrlBean;
    }

}

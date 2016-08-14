package com.teamwork.discover.fragment.NewbieFragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.discover.R;
import com.teamwork.discover.bean.BitmapUrlBean;
import com.teamwork.discover.com.teamwork.discover.tool.NetWork;
import com.teamwork.discover.data.DataUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcx on 2016/8/5.
 */

public class DormitorySituationFragment extends Fragment {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private TextView mTextView_1;
    private TextView mTextView_2;
    private TextView mTextView_3;

    private NetWork mNetWork;
    private DataUrl dataurl = new DataUrl();

    private static List<String> list = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (msg.obj != null)
                        imageView1.setImageBitmap((Bitmap) msg.obj);
                case 2:
                    if (msg.obj != null)
                        imageView2.setImageBitmap((Bitmap) msg.obj);
                case 3:
                    if (msg.obj != null)
                        imageView3.setImageBitmap((Bitmap) msg.obj);
                default:
                    break;
                    }

        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dormitorysituationfragment,container,false);
        imageView1 = (ImageView) view.findViewById(R.id.iv_dor_1);
        imageView2 = (ImageView) view.findViewById(R.id.iv_dor_2);
        imageView3 = (ImageView) view.findViewById(R.id.iv_dor_3);
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


        new Thread(){
            public void run(){
                mNetWork = new NetWork();

                Message msg1 = Message.obtain();
                Message msg2 = Message.obtain();
                Message msg3 = Message.obtain();

                String data = mNetWork.getJson(dataurl.dorUrl,"0","4");
                paserData(data);
                msg1.what = 1;
                msg1.obj = mNetWork.getBitmap(list.get(0));
                handler.sendMessage(msg1);
                msg2.what = 2;
                msg2.obj = mNetWork.getBitmap(list.get(1));
                handler.sendMessage(msg2);
                msg3.what = 3;
                msg3.obj = mNetWork.getBitmap(list.get(2));
                handler.sendMessage(msg3);
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
                for (int i = 0;i < 3;i++) {
                    Log.d("<<<<<<<<<<<<",",,,,,,,,,");
                    JSONObject pageJson = bodyJson.getJSONObject(i);
                    JSONArray songJson = pageJson.getJSONArray("photo");
                    JSONObject photoHson = songJson.getJSONObject(0);
                    String a = photoHson.optString("photo_src");
                    Log.d("---------------->",a);
                    Log.d("<<<<<<<<<<<<",",,,,,,,,,");
                    list.add(photoHson.optString("photo_src"));
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return bitmapUrlBean;
    }

}

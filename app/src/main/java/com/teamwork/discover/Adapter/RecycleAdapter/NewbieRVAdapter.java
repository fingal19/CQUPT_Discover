package com.teamwork.discover.Adapter.RecycleAdapter;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.teamwork.discover.R;
import java.util.List;
import com.teamwork.discover.Bean.NewbieLifeTextBean;

/**
 * Created by pcx on 2016/8/6.
 */

public class NewbieRVAdapter extends MyRecycleAdapter<NewbieLifeTextBean, NewbieRVAdapter.NewbieViewHolder> {
    private List<Bitmap> bitmapList;

    public NewbieRVAdapter(List list) {
        super(list);
    }


    @Override
    public void onBindViewHolder(NewbieRVAdapter.NewbieViewHolder holder, int position) {
        if (dataList.size() != 0) {
            holder.textView_name.setText(dataList.get(0).getName_place_list()[position]);
            holder.textView_local.setText(dataList.get(0).getLocal_list()[position]);
            holder.textView_intro.setText(dataList.get(0).getIntro_list()[position]);
        }
    }


    @Override
    public NewbieRVAdapter.NewbieViewHolder createMyViewHolder(ViewGroup parent, int viewType) {
        NewbieRVAdapter.NewbieViewHolder holder = new NewbieRVAdapter.NewbieViewHolder(parent, R.layout.newbie_recycle_item);
        return holder;
    }
    @Override
    public int getItemCount() {
        if (dataList.size() != 0)
        return dataList.get(0).getName_place_list().length;

        return 0;
    }


    class NewbieViewHolder extends BaseRecyclerViewHolder {
        private ImageView imageView;
        private TextView textView_name;
        private TextView textView_local;
        private TextView textView_intro;


        public NewbieViewHolder(ViewGroup parent, @LayoutRes int resId) {
            super(parent, resId);
            textView_name = getView(R.id.tv_rv_item_name);
            textView_local = getView(R.id.tv_rv_item_local);
            textView_intro = getView(R.id.tv_rv_item_intro);
            TextPaint tp = textView_name.getPaint();
            tp.setFakeBoldText(true);
            imageView = getView(R.id.iv_newbie);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            textView_name = getView(R.id.tv_rv_item_name);
            textView_local = getView(R.id.tv_rv_item_local);
        }

        @Override
        public void setData(List<Bitmap> data) {
            bitmapList = data;
        }
    }
}

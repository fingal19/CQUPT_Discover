package com.teamwork.discover.Adapter.RecycleAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import inter.IOnItemClickListener;

/**
 * Created by pcx on 2016/8/6.
 */

public abstract class MyRecycleAdapter<ItemDataType,H extends BaseRecyclerViewHolder> extends RecyclerView.Adapter<H> {
    public List<ItemDataType> dataList ;
    private IOnItemClickListener mIOnItemClickListener;


    public MyRecycleAdapter(List<ItemDataType> list){
        this.dataList = list;
        if (this.dataList == null)
            this.dataList = new ArrayList<>();

    }

    public H onCreateViewHolder(ViewGroup parent, int viewType){
        return createMyViewHolder(parent,viewType);
    }

    @Override
    public abstract void onBindViewHolder(final H holder,int position);

    public abstract H createMyViewHolder(ViewGroup parent,int viewType);

    public void setOnItemClickListener(IOnItemClickListener mIOnItemClickListener) {
        this.mIOnItemClickListener = mIOnItemClickListener;
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 填充数据,此方法会清空以前的数据
     *
     * @param list 需要显示的数据
     */
    public void fillList(List<ItemDataType> list) {
        dataList.clear();
        dataList.addAll(list);
    }

    /**
     * 更新数据
     *
     * @param holder item对应的holder
     * @param data   item的数据
     */
    public void updateItem(H holder, ItemDataType data) {
        dataList.set(holder.getLayoutPosition(), data);
    }

    /**
     * 获取一条数据
     *
     * @param holder item对应的holder
     * @return 该item对应的数据
     */
    public ItemDataType getItem(H holder) {
        return dataList.get(holder.getLayoutPosition());
    }

    /**
     * 获取一条数据
     *
     * @param position item的位置
     * @return item对应的数据
     */
    public ItemDataType getItem(int position) {
        return dataList.get(position);
    }

}

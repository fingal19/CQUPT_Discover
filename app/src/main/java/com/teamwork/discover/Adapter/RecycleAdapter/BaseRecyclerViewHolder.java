package com.teamwork.discover.Adapter.RecycleAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by pcx on 2016/8/6.
 */

public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder{

    public BaseRecyclerViewHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId,parent,false));
    }

    protected <T extends View>T getView(@IdRes int viewId){
        return (T) (itemView.findViewById(viewId));
    }

    /**
     * 获取Context实例
     * @return context
     */
    protected Context getContext() {
        return itemView.getContext();
    }

    /**
     * 设置数据
     * @param data 要显示的数据对象
     */
    public abstract void setData(List<Bitmap> data);
}


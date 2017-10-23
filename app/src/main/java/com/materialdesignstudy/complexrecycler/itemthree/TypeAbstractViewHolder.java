package com.materialdesignstudy.complexrecycler.itemthree;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.materialdesignstudy.complexrecycler.itemone.DataModel;

/**
 * Created by HLQ on 2017/10/22
 */
public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T dataModel);

}

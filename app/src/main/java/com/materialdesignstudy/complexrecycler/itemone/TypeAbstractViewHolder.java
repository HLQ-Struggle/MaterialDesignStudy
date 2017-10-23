package com.materialdesignstudy.complexrecycler.itemone;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder封装类
 * Created by HLQ on 2017/10/22
 */
public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 数据绑定
     *
     * @param dataModel 数据源 由于我们模拟数据实体类暂定为DataModel 这里直接传入这个即可
     *                  后期可根据项目实际需求去设置 也可以直接写为T
     */
    public abstract void bindHolder(DataModel dataModel);

}

package com.materialdesignstudy.complexrecycler.itemone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.materialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HLQ on 2017/10/22
 */
public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<DataModel> mDataList = new ArrayList<>();

    public OneAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> dataModelList) {
        this.mDataList.addAll(dataModelList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 通过获取不同的viewType，返回对应的ViewHolder以及引入的布局文件进行渲染，从而实现复杂布局实现
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 由于子类ViewHolder继承自TypeAbstractViewHolder，这里可以直接通过强制转化去绑定数据
        // 这也是我们为什么要对ViewHolder进行封装的一点优势
        ((TypeAbstractViewHolder) holder).bindHolder(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).type;
    }
}

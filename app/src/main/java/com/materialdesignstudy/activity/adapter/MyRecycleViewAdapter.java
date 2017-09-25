package com.materialdesignstudy.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.List;

/**
 * Created by HLQ on 2017/9/25 0025.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    private final List<String> mStrlist;

    public MyRecycleViewAdapter(List<String> strList) {
        mStrlist = strList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(parent.getContext(), R.layout.item_recycle_view, parent));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) { // 数据绑定
        holder.tvShow.setText(mStrlist.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvShow;

        public ViewHolder(View itemView) {
            super(itemView);
            tvShow = (TextView) itemView.findViewById(R.id.id_item_r);
        }

    }

}

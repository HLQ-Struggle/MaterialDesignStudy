package com.materialdesignstudy.coordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.List;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/04
 * desc   :
 * version: 1.0
 */
public class FabRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList;

    public FabRecycleAdapter(List<String> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myHolder = (MyViewHolder) holder;
        myHolder.tvItem.setText(mList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.id_item_r);
        }
    }

}

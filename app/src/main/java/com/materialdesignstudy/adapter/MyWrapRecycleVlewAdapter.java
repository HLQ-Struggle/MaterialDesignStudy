package com.materialdesignstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.List;

/**
 * Created by HLQ on 2017/10/17
 */

public class MyWrapRecycleVlewAdapter extends RecyclerView.Adapter<MyWrapRecycleVlewAdapter.ViewHolder> {

    private List<String> mStrList;

    public MyWrapRecycleVlewAdapter(List<String> strList) {
        this.mStrList=strList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_recy,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvText.setText(mStrList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            tvText= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

}

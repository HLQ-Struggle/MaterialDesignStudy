package com.materialdesignstudy.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.List;

/**
 * Created by HLQ on 2017/9/25
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    private final List<String> mStrList;

    /**
     * 接收数据源
     *
     * @param strList
     */
    public MyRecycleViewAdapter(List<String> strList) {
        mStrList = strList;
    }

    /**
     * 创建视图
     *
     * @param parent   父容器
     * @param viewType view类型 可用于后期进行多布局兼容
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 引入布局
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false));
        return viewHolder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvShow.setText(mStrList.get(position));
    }

    /**
     * 获取item个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mStrList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvShow;

        /**
         * 实例化 View 布局优化
         *
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            tvShow = (TextView) itemView.findViewById(R.id.id_item_r);
        }

    }

}

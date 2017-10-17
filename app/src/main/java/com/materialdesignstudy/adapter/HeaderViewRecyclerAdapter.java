package com.materialdesignstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by HLQ on 2017/10/12
 * 模仿ListView添加头部时 中间的adapter
 */

public class HeaderViewRecyclerAdapter extends RecyclerView.Adapter {

    private RecyclerView.Adapter mAdapter;

    private ArrayList<View> mHeaderViewInfos;
    private ArrayList<View> mFooterViewInfos;

    public HeaderViewRecyclerAdapter(ArrayList<View> headerViewInfos, ArrayList<View> footerViewInfos, RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        if (headerViewInfos == null) {
            mHeaderViewInfos = new ArrayList<>();
        } else {
            mHeaderViewInfos = headerViewInfos;
        }
        if (footerViewInfos == null) {
            mFooterViewInfos = new ArrayList<>();
        } else {
            mFooterViewInfos = footerViewInfos;
        }
    }

    /**
     * 判断当前条目类型 通过类型指定相关视图
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        // 头部
        if (position < numHeaders) {
            return RecyclerView.INVALID_TYPE;
        }
        // 正常内容载体
        int adapterCount = 0;
        int adjPosition = position - numHeaders;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        // 底部
        return RecyclerView.INVALID_TYPE - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RecyclerView.INVALID_TYPE) {// 头部
            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {
            return new HeaderViewHolder(mFooterViewInfos.get(0));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders = getHeadersCount();
        // 头部
        if (position < numHeaders) {
            return;
        }
        int adapterCount = 0;
        int adjPosition = position - numHeaders;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mAdapter.onBindViewHolder(holder, adjPosition);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    public int getFootersCount() {
        return mFooterViewInfos.size();
    }

    public int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

}

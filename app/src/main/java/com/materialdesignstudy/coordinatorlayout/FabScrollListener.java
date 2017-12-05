package com.materialdesignstudy.coordinatorlayout;

import android.support.v7.widget.RecyclerView;

/**
 * author : HeLiquan
 * e-mail : 925954424@qq.com
 * time   : 2017/12/04
 * desc   :
 * version: 1.0
 */
public class FabScrollListener extends RecyclerView.OnScrollListener {

    // 滑动偏移量小于20 不考虑
    private static final int THRESHOLD = 20;

    // 滑动累加
    private int mDistance = 0;

    private HideScrollListener mHideScrollListener;

    // 是否可见
    private boolean mIsVisible = true;

    public FabScrollListener(HideScrollListener hideScrollListener) {
        this.mHideScrollListener = hideScrollListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        // dy：Y轴方向滑动时偏移量
        // dy 为正数时 代表向上滑动 反之 代表向下滑动
        // 滑动偏移量大于设定值 并且 当前处于可见状态 隐藏
        if (mDistance > THRESHOLD && mIsVisible) { // ToolBar 隐藏
            mHideScrollListener.onHide();
            mDistance = 0;
            mIsVisible = false;
        }
        // 滑动偏移量小于-设定值 并且 当前处于不可见状态 显示
        if (mDistance < -THRESHOLD && !mIsVisible) { // ToolBar显示
            mHideScrollListener.onShow();
            mDistance = 0;
            mIsVisible = true;
        }
        if (mIsVisible && dy > 0 || (!mIsVisible && dy < 0)) {
            mDistance += dy;
        }
    }
}

package com.materialdesignstudy.activity.ltem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/**
 * 分割线 Created by HLQ on 2017/9/26
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOrientation = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int[] attrs = new int[]{android.R.attr.listDivider};

    public DividerItemDecoration(Context context, int orientation) {
        // 引用系统属性样式
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("非法参数枚举类型");
        }
        mOrientation = orientation;
    }

    /**
     * 1. 获得条目偏移量
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // 首先获取条目之间的间隙宽度 也就是Rect矩形区域
        if (mOrientation == LinearLayoutManager.VERTICAL) { // 垂直
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else { // 水平
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }

    /**
     * 2. RecycleView回调此函数 开发者需自己实现绘制分割线
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayoutManager.VERTICAL) { // 垂直
            drawVertical(c, parent);
        } else { // 水平
            drawHorizontal(c, parent);
        }
        super.onDraw(c, parent, state);
    }

    /**
     * 绘制水平分割线
     *
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDivider.getIntrinsicHeight();
            // 设置绘制位置
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(child));
            int right = left + mDivider.getIntrinsicHeight();
            // 设置绘制位置
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

}

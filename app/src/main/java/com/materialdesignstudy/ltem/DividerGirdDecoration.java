package com.materialdesignstudy.ltem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by HLQ on 2017/9/27
 */

public class DividerGirdDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int[] attrs = new int[]{android.R.attr.listDivider};

    public DividerGirdDecoration(Context context) {
        // 引用系统属性样式
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c, parent);
        drawHorizontal(c, parent);
    }

    /**
     * 绘制水平分割线
     *
     * @param c
     * @param parent
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        // 获取item个数
        int childCount = parent.getChildCount();
        // 每一个item都需要绘制间隔线
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getLeft() - params.leftMargin;
            int right = child.getRight() + params.rightMargin;
            int top = child.getBottom() - params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    /**
     * 绘制垂直间隔线
     *
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        // 获取item个数
        int childCount = parent.getChildCount();
        // 每一个item都需要绘制间隔线
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + mDivider.getIntrinsicWidth();
            int top = child.getTop() - params.topMargin;
            int bottom = child.getBottom() + params.bottomMargin;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        // 偏移量 代表左上右下分别对应上一个的偏移值
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();
        if (isLastRow(parent)) { // 代表当前是最后一行 不绘制底部
            bottom = 0;
        }
        if (isLastCol(itemPosition, parent)) { // 代表当前是最后一列 不绘制右侧
            right = 0;
        }
        outRect.set(0, 0, right, bottom);
    }

    /**
     * 是否是最后一行
     *
     * @return
     */
    private boolean isLastRow(RecyclerView parent) {
        int spanCount = getSpanCount(parent);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int childCount = parent.getAdapter().getItemCount();
            int lastRowCount = childCount % spanCount;
            if (lastRowCount == 0 || lastRowCount < spanCount) { // 最后一行情况：1)被整除 2)小于列数
                return true;
            }
        }
        return false;
    }

    /**
     * 是否是最后一列
     *
     * @return
     */
    private boolean isLastCol(int itemPosition, RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            // 拿到当前有多少列
            int spanCount = getSpanCount(parent);
            if ((itemPosition + 1) % spanCount == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取列数
     * @param parent
     * @return
     */
    private int getSpanCount(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            // 拿到当前有多少列
            int spanCount = gridLayoutManager.getSpanCount();
            return spanCount;
        }
        return 0;
    }

}

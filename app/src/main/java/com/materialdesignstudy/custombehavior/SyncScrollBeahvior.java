package com.materialdesignstudy.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/11
 * desc   :
 * version: 1.0
 */
public class SyncScrollBeahvior extends CoordinatorLayout.Behavior<View> {

    public SyncScrollBeahvior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL)
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        // child 要执行动画
        int scrollY= target.getScrollY();
        child.setScrollY(scrollY);
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    // 快速滑动的惯性移动 松开手指后还会有滑动效果
    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        ((NestedScrollView)child).fling((int) velocityY);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}

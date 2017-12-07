package com.materialdesignstudy.parallel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/06
 * desc   : 自定义HorizontalScrollView 拦截事件处理避免滑动手机时，手动滑动手机内容时，内容随事件滑动
 * version: 1.0
 */
public class MyScrollView extends HorizontalScrollView {

    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}

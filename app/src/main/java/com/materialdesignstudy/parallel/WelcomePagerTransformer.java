package com.materialdesignstudy.parallel;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.materialdesignstudy.R;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/06
 * desc   : pager切换效果实现
 * version: 1.0
 */
public class WelcomePagerTransformer implements ViewPager.PageTransformer, ViewPager.OnPageChangeListener {

    // 定义滑动角度
    private static final float ROT_MOD = -15f;

    private int mPageIndex;
    private boolean mPageChanged = true;

    /**
     * 此方法是滑动的时候每一个页面View都会调用该方法
     * view:当前的页面
     * position:当前滑动的位置
     * 视差效果：在View正常滑动的情况下，给当前View或者当前view里面的每一个子view来一个加速度
     * 而且每一个加速度大小不一样。
     */
    @Override
    public void transformPage(View view, float position) {
        // 实例化
        ViewGroup v = view.findViewById(R.id.rl);
        final MyScrollView scrollView = v.findViewById(R.id.scrollview);
        View bg1 = v.findViewById(R.id.imageView0);
        View bg2 = v.findViewById(R.id.imageView0_2);
        View bg_container = v.findViewById(R.id.bg_container);
        // 获取颜色值
        int bg1_green = view.getContext().getResources().getColor(R.color.bg1_green);
        int bg2_blue = view.getContext().getResources().getColor(R.color.bg2_blue);
        // 获取Tag 找到当前的位置以及View
        Integer tag = (Integer) view.getTag();
        View parent = (View) view.getParent();
        // 颜色估值器 颜色渐变类
        ArgbEvaluator evaluator = new ArgbEvaluator();
        int color = bg1_green;
        if (tag.intValue() == mPageIndex) {
            switch (mPageIndex) {
                case 0:
                    color = (int) evaluator.evaluate(Math.abs(position), bg1_green, bg2_blue);
                    break;
                case 1:
                    color = (int) evaluator.evaluate(Math.abs(position), bg2_blue, bg1_green);
                    break;
                case 2:
                    color = (int) evaluator.evaluate(Math.abs(position), bg1_green, bg2_blue);
                    break;
                default:
                    break;
            }
            // 设置整个viewpager的背景颜色
            parent.setBackgroundColor(color);
        }
        if (position == 0) {
            // pageChanged作用--解决问题：只有在切换页面的时候才展示平移动画，如果不判断则会只是移动一点点当前页面松开也会执行一次平移动画
            if (mPageChanged) {
                bg1.setVisibility(View.VISIBLE);
                bg2.setVisibility(View.VISIBLE);
                ObjectAnimator animator_bg1 = ObjectAnimator.ofFloat(bg1, "translationX", 0, -bg1.getWidth());
                // 设置动画执行时间
                animator_bg1.setDuration(400);
                animator_bg1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        scrollView.smoothScrollTo((int) (scrollView.getWidth() * animation.getAnimatedFraction()), 0);
                    }
                });
                animator_bg1.start();
                ObjectAnimator animator_bg2 = ObjectAnimator.ofFloat(bg2, "translationX", bg2.getWidth(), 0);
                animator_bg2.setDuration(400);
                animator_bg2.start();
                mPageChanged = false;
            }
        } else if (position == -1 || position == 1) { // 效果回复默认
            bg2.setTranslationX(0);
            bg1.setTranslationX(0);
            scrollView.smoothScrollTo(0, 0);
        } else if (position < 1 && position > -1) {
            final float width = bg1.getWidth();
            final float height = bg1.getHeight();
            final float rotation = ROT_MOD * position * -1.25f;
            // 这里不去分别处理bg1、bg2，而是用包裹的父容器执行动画，目的是避免难以处理两个bg的属性位置恢复。
            bg_container.setPivotX(width * 0.5f);
            bg_container.setPivotY(height);
            bg_container.setRotation(rotation);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mPageIndex = position;
        mPageChanged = true;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
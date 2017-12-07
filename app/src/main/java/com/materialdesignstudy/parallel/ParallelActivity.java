package com.materialdesignstudy.parallel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.materialdesignstudy.R;

public class ParallelActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private int[] mLayouts = {
            R.layout.welcome1,
            R.layout.welcome2,
            R.layout.welcome3
    };
    private WelcomePagerTransformer mTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallel);
        mViewPager = findViewById(R.id.viewpager);

        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager());
        // 设置fragment预加载页
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);

        mTransformer = new WelcomePagerTransformer();
        // 监听滑动时，当前View在ViewPager中的Index 也可以进行动画效果设置 例如3D翻转等
        mViewPager.setPageTransformer(true, mTransformer);
        // 监听当前滑动的页面方向
        mViewPager.setOnPageChangeListener(mTransformer);
    }

    class WelcomePagerAdapter extends FragmentPagerAdapter {

        public WelcomePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new TranslateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", mLayouts[position]);
            bundle.putInt("pageIndex", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return mLayouts.length;
        }
    }

}


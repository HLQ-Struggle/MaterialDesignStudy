package com.materialdesignstudy.coordinatorLayout2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.materialdesignstudy.R;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerActivity.MyPagerAdapter mAdapter;

    private String[] titles = {
            "今日头条", "热点新闻", "娱乐",
            "房地产", "体育", "科技",
            "互联网", "CSDN Blog", "体育",
            "APK Bus", "健康医疗", "民生"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
    }

    private void initView() {
        // 实例化
        mTabLayout = (TabLayout) findViewById(R.id.id_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        //1.TabLayout和Viewpager关联
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabUnselected(TabLayout.Tab arg0) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 被选中的时候回调
                mViewPager.setCurrentItem(tab.getPosition(), true);
            }

        });
        //2.ViewPager滑动关联tabLayout
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        //设置tabLayout的标签来自于PagerAdapter
        mTabLayout.setTabsFromPagerAdapter(adapter);
        mViewPager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", titles[position]);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

    public void getGo(View view) {
        startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class));
    }

}

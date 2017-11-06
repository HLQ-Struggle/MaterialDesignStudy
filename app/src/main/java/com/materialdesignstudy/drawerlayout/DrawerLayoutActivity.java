package com.materialdesignstudy.drawerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.materialdesignstudy.R;

/**
 * MaterialDesign 侧滑DrawerLayout create by heliquan at 2017年10月19日
 * 源自于v4包中 继承ViewGroup
 */
public class DrawerLayoutActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        mToolBar = (Toolbar) findViewById(R.id.id_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.i_drawerlayout);

        // 将ActionBar替换成toolbar
        setSupportActionBar(mToolBar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.string_open, R.string.string_close);
        // 同步状态
        drawerToggle.syncState();
        // 设置侧滑监听
        mDrawerLayout.setDrawerListener(drawerToggle);

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // 绘制 slideOffset范围：0~1
                View content=mDrawerLayout.getChildAt(0); // 拿到第0个布局
                // 设置左侧滑动效果
                View menu=drawerView;
                float scale=1-slideOffset;
                float leftScale= (float) (1-0.3*scale);
                menu.setScaleX(leftScale); // 反过来滑动范围是 1~0.7
                menu.setScaleY(leftScale); // 反过来滑动范围是 1~0.7
                // 设置右侧滑动效果
                float rightScale=(float) (0.7+0.3*scale);
                content.setScaleX(rightScale);
                content.setScaleY(rightScale);
                content.setTranslationX(menu.getMeasuredWidth()*(1-scale)); // 0~width
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // 抽屉打开
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 抽屉被关闭
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // 状态发生改变回调

            }
        });
    }

    public void clickMe(View view) {
        Toast.makeText(this, "点我了", Toast.LENGTH_SHORT).show();
    }

}

package com.materialdesignstudy.coordinatorlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.materialdesignstudy.R;
import com.materialdesignstudy.coordinatorlayout.behavior.BehaviorActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * CoordinatorLayout
 * 1. 监听滑动
 * 2. fab执行显示or隐藏的动画
 */
public class CoordinatorLayoutActivity extends AppCompatActivity implements HideScrollListener {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ImageButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_rv);
        mFab = (ImageButton) findViewById(R.id.id_fab);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        setTitle("HLQ-Blog");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addOnScrollListener(new FabScrollListener(this));
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            sList.add("Hi Every One " + i);
        }
        FabRecycleAdapter adapter = new FabRecycleAdapter(sList);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public void onHide() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(30));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(mFab.getHeight() + params.bottomMargin)
                .setInterpolator(new AccelerateInterpolator(3));
    }

    @Override
    public void onShow() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
        mFab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }

    public void getUseBehavior(View view) {
        startActivity(new Intent(this, BehaviorActivity.class));
    }

}

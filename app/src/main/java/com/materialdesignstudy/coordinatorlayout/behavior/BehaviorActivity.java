package com.materialdesignstudy.coordinatorlayout.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.materialdesignstudy.R;
import com.materialdesignstudy.coordinatorlayout.FabRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/05
 * desc   :
 * version: 1.0
 */
public class BehaviorActivity extends AppCompatActivity  {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ImageButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_rv);
        mFab = (ImageButton) findViewById(R.id.id_fab);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        setTitle("HLQ-Blog");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            sList.add("Hi Every One " + i);
        }
        FabRecycleAdapter adapter = new FabRecycleAdapter(sList);
        mRecyclerView.setAdapter(adapter);
    }

}
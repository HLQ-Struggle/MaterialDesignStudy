package com.materialdesignstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.materialdesignstudy.R;
import com.materialdesignstudy.activity.adapter.MyRecycleViewAdapter;
import com.materialdesignstudy.activity.adapter.MyStaggeredAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView Study
 * 谷歌推出替代ListView、GirdView工具
 * 具有高度解耦和
 */
public class RecycleViewActivity extends AppCompatActivity {

    private RecycleViewActivity selfActivity = RecycleViewActivity.this;

    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter myAdapter;
    private MyStaggeredAdapter myStaggerAdapter;

    private ArrayList<String> mStrList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initView();
    }

    private List<String> initData() {
        for (int i = 0; i < 60; i++) {
            mStrList.add("item:" + i);
        }
        return mStrList;
    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
//        myAdapter = new MyRecycleViewAdapter(initData());
        // LayoutManager 布局拜访管理器(线性摆放、瀑布流)
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity)); // 默认垂直
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity,LinearLayoutManager.HORIZONTAL,false)); // 设置水平
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity,LinearLayoutManager.HORIZONTAL,true)); // 设置水平 且数据从右侧开始展示
//        mRecyclerView.setLayoutManager(new GridLayoutManager(selfActivity,3)); // GirdView 效果

        myStaggerAdapter=new MyStaggeredAdapter(initData());
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(myStaggerAdapter);
    }
}

package com.materialdesignstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.materialdesignstudy.R;
import com.materialdesignstudy.activity.adapter.MyRecycleViewAdapter;
import com.materialdesignstudy.activity.adapter.MyStaggeredAdapter;
import com.materialdesignstudy.activity.ltem.DividerGirdDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView Study
 * 谷歌推出替代ListView、GirdView工具
 * 低耦合 高内聚
 */
public class RecycleViewActivity extends AppCompatActivity {

    private RecycleViewActivity selfActivity = RecycleViewActivity.this;

    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter myAdapter;
    private MyStaggeredAdapter myStaggerAdapter;

    private ArrayList<String> mStrList = new ArrayList<>();
    private RecyclerView.ItemDecoration itemDecoration;

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("HLQ", "---->RecycleViewActivity onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initView();
    }

    private List<String> initData() {
        for (int i = 0; i < 58; i++) {
            mStrList.add("item:" + i);
        }
        printStack();
        return mStrList;
    }

    /**
     * 输出方法执行顺序
     */
    private void printStack() {
        RuntimeException runtimeException = new RuntimeException("HLQ_Test");
        runtimeException.fillInStackTrace();
        Log.w("HLQ_Struggle", "执行顺序：" + this, runtimeException);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        myAdapter = new MyRecycleViewAdapter(initData());
        // LayoutManager 布局拜访管理器(线性摆放、瀑布流)
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity)); // 默认垂直
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity, LinearLayoutManager.VERTICAL, false)); // 设置垂直
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity,LinearLayoutManager.HORIZONTAL,false)); // 设置水平
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity,LinearLayoutManager.HORIZONTAL,true)); // 设置水平 且数据从右侧开始展示
        mRecyclerView.setLayoutManager(new GridLayoutManager(selfActivity, 3)); // GirdView 效果
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
//        myStaggerAdapter = new MyStaggeredAdapter(initData());
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new DividerGirdDecoration(selfActivity));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(selfActivity, LinearLayoutManager.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(selfActivity, LinearLayoutManager.HORIZONTAL));
    }

    private boolean isChange = false;

    public void showChange(View view) {
        if (itemDecoration != null)
            mRecyclerView.removeItemDecoration(itemDecoration);
        if (!isChange) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity, LinearLayoutManager.HORIZONTAL, false)); // 设置水平
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity)); // 默认垂直
        }
        isChange = !isChange;
    }

}

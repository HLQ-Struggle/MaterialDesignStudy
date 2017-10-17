package com.materialdesignstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.materialdesignstudy.R;
import com.materialdesignstudy.adapter.MyRecycleViewAdapter;
import com.materialdesignstudy.adapter.MyStaggeredAdapter;
import com.materialdesignstudy.ltem.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 高内聚 低耦合
 */
public class ChangeRecycleViewActivity extends AppCompatActivity {

    private ChangeRecycleViewActivity selfActivity = ChangeRecycleViewActivity.this;

    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter myAdapter;
    private MyStaggeredAdapter myStaggerAdapter;

    private ArrayList<String> mStrList = new ArrayList<>();

    private boolean isChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_recycle_view);
        initView();
    }

    private List<String> initData() {
        for (int i = 0; i < 58; i++) {
            mStrList.add("item:" + i);
        }
        return mStrList;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_change_recycle);
        // LayoutManager 布局摆放管理器(线性摆放、瀑布流)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity)); // 默认垂直
        myStaggerAdapter = new MyStaggeredAdapter(initData());
        myStaggerAdapter.setOnItemClickListener(new MyStaggeredAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(selfActivity, "点击了item：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        myStaggerAdapter.setOnItemLongClickListener(new MyStaggeredAdapter.onItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(selfActivity, "长按了item：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(myStaggerAdapter);
        // 设置条目的动画效果
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(selfActivity,LinearLayoutManager.VERTICAL));
    }

    /**
     * 点击动态改变RecycleView布局
     *
     * @param view
     */
    public void showChange(View view) {
        if (!isChange) {
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(selfActivity));
        }
        isChange = !isChange;
    }

    public void addItem(View view) {
        myStaggerAdapter.addItemData(2);
    }

    public void removeItem(View view) {
        myStaggerAdapter.removeItemData(2);
    }

}

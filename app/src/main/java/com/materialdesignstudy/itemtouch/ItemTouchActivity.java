package com.materialdesignstudy.itemtouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.materialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 为RecycleView添加交互动画
 */
public class ItemTouchActivity extends AppCompatActivity implements StartDragListener{

    private RecyclerView mRecycleView;
    private ItemAdapter mAdapter;
    private ItemTouchHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch);

        mRecycleView = (RecyclerView) findViewById(R.id.id_item_touch);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemAdapter(getData(),this);
        mRecycleView.setAdapter(mAdapter);

        // RecycleView item触摸帮助类 例如 滑动 拖动
        helper =new ItemTouchHelper(new BaseItemTouchHelperCallback(mAdapter));
        // 绑定RecycleView
        helper.attachToRecyclerView(mRecycleView);

    }

    private List<String> getData() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strList.add("今天天气好晴朗，处处好风光，报数：" + i);
        }
        return strList;
    }

    @Override
    public void onStartDrag(ItemAdapter.ViewHolder viewHolder) {
        helper.startDrag(viewHolder);
    }
}

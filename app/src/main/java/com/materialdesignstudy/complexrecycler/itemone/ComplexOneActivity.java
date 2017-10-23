package com.materialdesignstudy.complexrecycler.itemone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.materialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 复杂布局实现
 * Created by HLQ on 2017/10/22
 */
public class ComplexOneActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private OneAdapter mOneAdapter;

    // 颜色值
    private int mColor[] = {android.R.color.holo_red_light,
            android.R.color.holo_green_light,
            android.R.color.holo_blue_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complec_one);
        initItem();
        initData();
    }

    private void initData() {
        List<DataModel> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int type = (int) ((Math.random() * 3) + 1); // 随机type
            DataModel dataModel = new DataModel();
            dataModel.avatarColor = mColor[type - 1];
            dataModel.type = type;
            dataModel.name = "name" + i;
            dataModel.content = "content:" + i;
            dataModel.contentColor = mColor[(type + 1) % 3];
            dataList.add(dataModel);
        }
        mOneAdapter.addList(dataList);
        mOneAdapter.notifyDataSetChanged();
    }

    private void initItem() {
        mRecyclerView = findViewById(R.id.id_recy);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mOneAdapter = new OneAdapter(this);
        mRecyclerView.setAdapter(mOneAdapter);
    }
}

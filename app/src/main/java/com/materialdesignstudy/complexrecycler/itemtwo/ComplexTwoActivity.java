package com.materialdesignstudy.complexrecycler.itemtwo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;
import com.materialdesignstudy.complexrecycler.itemone.OneAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用RecyclerView实现ListView+GridView混排效果
 * create by heliquan at 2017年10月23日
 * 重点关注setSpanSizeLookup即可 获取当前跨度
 */
public class ComplexTwoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private OneAdapter mOneAdapter;

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
        for (int i = 0; i < 30; i++) {
            // 模拟不同itemType
            int type;
            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i < 10 || i > 20) {
                type = 2;
            } else {
                type = 3;
            }
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
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recy);
        // 更换显示布局样式为GirdLayoutManager
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // 获取当前位置下的ItemViewType
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                // 由于item1和item2可以正常显示 而item3需要横跨2列
                // 所以需要在这里对item3进行单独处理
                if (type == DataModel.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount(); // item3需要横跨2列
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mOneAdapter = new OneAdapter(this);
        mRecyclerView.setAdapter(mOneAdapter);
        // 为了显示效果更好 在此添加分割线
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize(); // 获取当前位置的 item 跨度大小
                int spanIndex = layoutParams.getSpanIndex(); // 获取每行排列 item 个数
                outRect.top = 20;
                // 如果当前跨度不等于当前索引 表示当前不属于item3
                if (spanSize != gridLayoutManager.getSpanCount()) { // 针对item1，item2做分割线处理
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });
    }
}

package com.materialdesignstudy.complexrecycler.itemthree;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同Model如何实现混排
 * create by heliquan at 2017年10月23日
 */
public class ComplexThreeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TwoAdapter mOneAdapter;

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
        List<DataModelOne> oneList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModelOne dataModel = new DataModelOne();
            dataModel.name = "name" + i;
            dataModel.avatatColor = mColor[0];
            oneList.add(dataModel);
        }
        List<DataModelTwo> twoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModelTwo dataModel = new DataModelTwo();
            dataModel.name = "name" + i;
            dataModel.avatatColor = mColor[1];
            dataModel.content = "content:" + i;
            twoList.add(dataModel);
        }
        List<DataModelThree> threeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModelThree dataModel = new DataModelThree();
            dataModel.name = "name" + i;
            dataModel.avatatColor = mColor[2];
            dataModel.content = "content:" + i;
            dataModel.contentColor = mColor[2];
            threeList.add(dataModel);
        }
        mOneAdapter.addList(oneList,twoList,threeList);
        mOneAdapter.notifyDataSetChanged();
    }

    private void initItem() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recy);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mOneAdapter = new TwoAdapter(this);
        mRecyclerView.setAdapter(mOneAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
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

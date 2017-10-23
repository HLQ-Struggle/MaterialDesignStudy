package com.materialdesignstudy.complexrecycler.itemthree;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HLQ on 2017/10/22
 */
public class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    private LayoutInflater mLayoutInflater;
    private List<Integer> mTypes = new ArrayList<>(); // 存放type
    private Map<Integer, Integer> mPositions = new HashMap<>(); // 存放type下包含数据itemCount
    private List<DataModelOne> mOneList = new ArrayList<>();
    private List<DataModelTwo> mTwoList = new ArrayList<>();
    private List<DataModelThree> mThreeList = new ArrayList<>();

    public TwoAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModelOne> oneList, List<DataModelTwo> twoList, List<DataModelThree> threeList) {
        addListByType(TYPE_ONE, oneList);
        addListByType(TYPE_TWO, twoList);
        addListByType(TYPE_THREE, threeList);
        this.mOneList = oneList;
        this.mTwoList = twoList;
        this.mThreeList = threeList;
    }

    private void addListByType(int type, List list) {
        mPositions.put(type, mTypes.size());
        for (int i = 0; i < list.size(); i++) {
            mTypes.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mPositions.get(viewType);
        switch (viewType) {
            case DataModel.TYPE_ONE:
                ((TypeAbstractViewHolder) holder).bindHolder(mOneList.get(realPosition));
                break;
            case DataModel.TYPE_TWO:
                ((TypeAbstractViewHolder) holder).bindHolder(mTwoList.get(realPosition));
                break;
            case DataModel.TYPE_THREE:
                ((TypeAbstractViewHolder) holder).bindHolder(mThreeList.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mTypes.get(position);
    }
}

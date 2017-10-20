package com.materialdesignstudy.itemtouch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by HLQ on 2017/10/17
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements ItemTouchMoveListener {

    private StartDragListener mStartDragListener;
    private List<String> mStrList;

    public ItemAdapter(List<String> strList, StartDragListener dragListener) {
        this.mStrList = strList;
        mStartDragListener = dragListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_touch, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvTitle.setText(mStrList.get(position));
        holder.ivIcon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStrList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mStrList, fromPosition, toPosition); // 数据交换
        notifyItemMoved(fromPosition, toPosition); // 刷新界面UI
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        // 移除item
        mStrList.remove(position);
        // 更新移除掉item位置
        notifyItemRemoved(position);
        return true;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivIcon;
        private TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.id_app_item_touch_title);
            ivIcon = (ImageView) itemView.findViewById(R.id.id_app_item_touch_icon);
        }
    }

}

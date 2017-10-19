package com.materialdesignstudy.itemtouch;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by HLQ on 2017/10/17
 */
public class BaseItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchMoveListener mMoveListener;

    public BaseItemTouchHelperCallback(ItemTouchMoveListener moveListener) {
        this.mMoveListener = moveListener;
    }

    // 判断当前操作
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 判断用户当前的操作：向上、向下拖动 左右侧滑
        // 而所对应的状态标识分别为：ItemTouchHelper.UP ItemTouchHelper.DOWN ItemTouchHelper.LEFT ItemTouchHelper.RIGHT
//        int upFlag=ItemTouchHelper.UP; // 1 0*0001
//        int downFlag=ItemTouchHelper.DOWN; // 2 0*0010
        // 监听拖动方向为 上下
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // 监听侧滑方向
//        int swipeFlags = 0; // 不监听
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT; // 监听左右侧滑动
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    // 移动时回调
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        boolean result = mMoveListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return result;
    }

    // 侧滑时回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mMoveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    // 是否允许长按拖拽效果
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        // 判断选中状态
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) { // 不是闲置状态
            viewHolder.itemView.setBackgroundColor(Color.BLUE);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
        // 关于复用导致空白 解决方案一
//        viewHolder.itemView.setAlpha(1);
//        viewHolder.itemView.setScaleX(1);
//        viewHolder.itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }

    // 重绘item
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) { // 侧滑时增加特效
            // dx:水平方向移动的偏移量(负：往左 正：往右) 范围：0~View.getWidth() 0~1
            // 透明度
            viewHolder.itemView.setAlpha(alpha);
            // 缩放
            viewHolder.itemView.setScaleX(alpha);
            viewHolder.itemView.setScaleY(alpha);
        }
        if (alpha == 0) { // item划出时 恢复之前状态 解决由于复用导致划出空白bug 方案二
            viewHolder.itemView.setAlpha(1);
            viewHolder.itemView.setScaleX(1);
            viewHolder.itemView.setScaleY(1);
        }
        // 判断滑动偏移量是否超出屏幕一半时 就设置其当前停留在一般的位置
//        if(Math.abs(dX)<=viewHolder.itemView.getWidth()/2){
//            viewHolder.itemView.setTranslationX(-0.5f*viewHolder.itemView.getWidth());
//        }else{
//            viewHolder.itemView.setTranslationX(dX);
//        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}

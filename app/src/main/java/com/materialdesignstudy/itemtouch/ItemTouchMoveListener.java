package com.materialdesignstudy.itemtouch;

/**
 * Created by HLQ on 2017/10/18
 */
public interface ItemTouchMoveListener {

    /**
     * 拖拽时调用并进行相应操作 例如刷新界面UI
     *
     * @param fromPosition 从某个位置开始拖动
     * @param toPosition   到某个位置结束拖动
     * @return
     */
    boolean onItemMove(int fromPosition, int toPosition);

    /**
     * 移动Item
     *
     * @param position 移除位置
     * @return
     */
    boolean onItemRemove(int position);

}

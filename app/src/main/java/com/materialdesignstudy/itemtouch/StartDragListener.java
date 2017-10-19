package com.materialdesignstudy.itemtouch;

/**
 * Created by HLQ on 2017/10/18
 */

public interface StartDragListener {

    /**
     * 该接口用于需要主动回调拖拽效果
     * @param viewHolder
     */
    void onStartDrag(ItemAdapter.ViewHolder viewHolder);

}

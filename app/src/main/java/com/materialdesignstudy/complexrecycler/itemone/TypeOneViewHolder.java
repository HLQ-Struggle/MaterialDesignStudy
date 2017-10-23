package com.materialdesignstudy.complexrecycler.itemone;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;

/**
 * Created by HLQ on 2017/10/22
 */
public class TypeOneViewHolder extends TypeAbstractViewHolder {

    public ImageView avatar;
    public TextView name;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        // 初始化控件
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        // 为了区分item 这里为item设置背景颜色
        itemView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        // 数据绑定
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
    }

}

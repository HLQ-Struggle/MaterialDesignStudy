package com.materialdesignstudy.complexrecycler.itemone;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;

/**
 * Created by HLQ on 2017/10/22
 */
public class TypeTwoViewHolder extends TypeAbstractViewHolder {

    public ImageView avatar;
    public TextView name, content;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }

}

package com.materialdesignstudy.complexrecycler.itemthree;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;

/**
 * Created by HLQ on 2017/10/22
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder<DataModelOne> {

    public ImageView avatar;
    public TextView name;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void bindHolder(DataModelOne dataModel) {
        avatar.setBackgroundResource(dataModel.avatatColor);
        name.setText(dataModel.name);
    }

}

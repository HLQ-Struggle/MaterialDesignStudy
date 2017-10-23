package com.materialdesignstudy.complexrecycler.itemthree;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;

/**
 * Created by HLQ on 2017/10/22 0022.
 */

public class TypeTwoViewHolder extends TypeAbstractViewHolder<DataModelTwo> {

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
    public void bindHolder(DataModelTwo dataModel) {
        avatar.setBackgroundResource(dataModel.avatatColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }

}

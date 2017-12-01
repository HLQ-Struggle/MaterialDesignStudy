package com.materialdesignstudy.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.materialdesignstudy.R;

/**
 * CardView Study
 * 首先需要导入依赖：
 * implementation 'com.android.support:cardview-v7:26.0.2'
 */
public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    }
}

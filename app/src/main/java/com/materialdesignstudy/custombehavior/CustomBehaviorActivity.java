package com.materialdesignstudy.custombehavior;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.materialdesignstudy.R;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/11
 * desc   : 自定义Behavior
 * version: 1.0
 */
public class CustomBehaviorActivity extends AppCompatActivity {

    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustom_behavior);
        initView();
    }

    private void initView() {
        mTv1 = (TextView) findViewById(R.id.id_tv);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 10);
            }
        });
    }

    public void getNestedScrollView(View view){
        startActivity(new Intent(this,NestedScrollViewAct.class));
    }

}

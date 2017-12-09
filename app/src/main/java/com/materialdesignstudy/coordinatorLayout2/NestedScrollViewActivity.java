package com.materialdesignstudy.coordinatorLayout2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.materialdesignstudy.R;

public class NestedScrollViewActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nestedscrollview);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        setTitle("HLQ-Blog");
    }

    public void displaySnackbar(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

}

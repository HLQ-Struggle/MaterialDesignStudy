package com.materialdesignstudy.navigationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.materialdesignstudy.R;

public class NavigationActivity extends AppCompatActivity {

    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navugation);
        initView();
    }

    private void initView() {
        mNavigationView = (NavigationView) findViewById(R.id.id_nv);
        View headView = mNavigationView.getChildAt(0);
        headView.findViewById(R.id.id_nv_head_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "点击了头像", Toast.LENGTH_SHORT).show();
            }
        });
        headView.findViewById(R.id.id_nv_head_username).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "点击了用户名称", Toast.LENGTH_SHORT).show();
            }
        });
        // 设置item选中事件
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_call_me) {
                    Toast.makeText(NavigationActivity.this, "当前点击了给我打电话", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(NavigationActivity.this, "当前点击了：" + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

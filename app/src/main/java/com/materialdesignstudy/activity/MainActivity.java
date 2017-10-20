package com.materialdesignstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.materialdesignstudy.R;
import com.materialdesignstudy.drawerlayout.DrawerLayoutActivity;
import com.materialdesignstudy.itemtouch.ItemTouchActivity;
import com.materialdesignstudy.navigationview.NavigationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("HLQ", "---->Main onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSupportUse(View view) {
        startActivity(new Intent(MainActivity.this, SupportUseActivity.class));
    }

    public void showRecycleView(View view) {
        startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));
    }

    public void showChangeRecycleView(View view) {
        startActivity(new Intent(MainActivity.this, ChangeRecycleViewActivity.class));
    }

    public void addView(View view) {
        startActivity(new Intent(MainActivity.this, WrapRecycleViewActivity.class));
    }

    public void addUseAnim(View view) {
        startActivity(new Intent(MainActivity.this, ItemTouchActivity.class));
    }

    public void userMDDrawerLayout(View view) {
        startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class));
    }

    public void useNavigationView(View view) {
        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
    }

}

package com.materialdesignstudy.snackbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.materialdesignstudy.R;

/**
 * create by heliquan at 2017年10月20日
 * Snackbar 介于Toast和Dialog之间
 * Toast只能提示 却无法进行交互
 * Dialog打断用户操作 某些情况体验不好
 */
public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
    }

    public void showCustomToast(View view){
        Toast.makeText(this,"弹弹弹",Toast.LENGTH_SHORT).show();
    }

}

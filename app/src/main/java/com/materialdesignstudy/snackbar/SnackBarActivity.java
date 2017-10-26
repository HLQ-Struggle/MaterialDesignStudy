package com.materialdesignstudy.snackbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
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

    public void showToast(View view) {
        Toast.makeText(this, "弹弹弹", Toast.LENGTH_SHORT).show();
    }

    public void showCustomToast(View view) {
        // 初始化控件
        Toast result = new Toast(this);
        // 获取LayoutInflater实例
        LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 渲染布局
        View v = inflate.inflate(R.layout.item_custom_toast, null);
        // 随心设置内容
        TextView tv = (TextView) v.findViewById(R.id.id_text);
        tv.setText("Hello，我是自定义Toast内容");
        // 设置填充内容
        result.setView(v);
        // 设置时间
        result.setDuration(Toast.LENGTH_SHORT);
        // 设置居中
        result.setGravity(0, 0, 0);
        result.show();
    }

    public void showSnackBar(View view) {
        Snackbar snackbar = Snackbar.make(view, "SnackStudy", Snackbar.LENGTH_SHORT);
        // 设置交互事件
        snackbar.setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(null);
            }
        });
        // 设置颜色
        snackbar.setActionTextColor(Color.RED);
        View snackbarView = snackbar.getView();
        // 设置内容颜色
        TextView tvContent = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        tvContent.setTextColor(Color.YELLOW);
        // 设置背景色
        snackbarView.setBackgroundColor(Color.BLUE);
        // 设置内容图标
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.ic_launcher_round);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvContent.setCompoundDrawables(drawable, drawable, drawable, drawable);   // 给TextView左边添加图标
        tvContent.setGravity(Gravity.CENTER_VERTICAL);  // 让文字居中
        tvContent.setCompoundDrawablePadding(130); // 设置padding
        snackbar.show();
    }

}

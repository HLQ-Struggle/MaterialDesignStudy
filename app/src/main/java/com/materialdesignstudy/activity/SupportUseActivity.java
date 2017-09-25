package com.materialdesignstudy.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.materialdesignstudy.R;

/**
 * 兼容性控件使用
 */
public class SupportUseActivity extends AppCompatActivity {

    private ProgressBar bar;
    private SwipeRefreshLayout srl;
    private AppCompatButton abtn;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_use);
        initView();
    }

    private void initView() {
        bar = (ProgressBar) findViewById(R.id.id_pro);
        bar.setMax(100);
        bar.setProgress(50);

        srl = (SwipeRefreshLayout) findViewById(R.id.id_srl);
        srl.setSize(SwipeRefreshLayout.LARGE);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // 下拉完毕 加载更多数据
//                srl.setRefreshing(false);
            }
        });
        srl.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //设置进度条的背景颜色
        srl.setProgressBackgroundColorSchemeColor(Color.YELLOW);
        //设置下拉多少距离开始刷新
        srl.setDistanceToTriggerSync(70);

        String[] items = {"条目0", "条目1", "条目2", "条目3", "条目4", "条目5", "条目6",};
        //数据
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        abtn = (AppCompatButton) findViewById(R.id.id_abtn);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SupportUseActivity.this, view);
                popup.getMenuInflater()
                        .inflate(R.menu.main, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("哇咔咔");
        builder.setPositiveButton("嗯嗯好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("555No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void showSupportDialog(View view) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("哇咔咔");
        builder.setPositiveButton("嗯嗯好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("555No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void showPopup(View view) {
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(adapter);
        //设置锚点，弹出的位置是相对于v的位置
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setWidth(200);
        listPopupWindow.setHeight(500);
        listPopupWindow.show();
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "点了第" + position, 0).show();
                listPopupWindow.dismiss();
            }
        });
    }

}

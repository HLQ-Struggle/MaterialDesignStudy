package com.materialdesignstudy.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.materialdesignstudy.R;

/**
 * ToolBar SearchView使用
 */
public class ToolBarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // 将ActionBar替换为Toolbar
        setSupportActionBar(mToolbar);
        // 设置navigationIcon监听事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        // 设置默认呈现搜索框
        searchView.setIconified(false);
        // 设置不关闭SearchView
//        searchView.setIconifiedByDefault(false);
        ImageView imageView = searchView.findViewById(R.id.search_go_btn);
        imageView.setImageResource(R.drawable.abc_ic_voice_search_api_material);
        imageView.setVisibility(View.VISIBLE);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this, "准备说话了么", Toast.LENGTH_SHORT).show();
            }
        });
        // 设置提交按钮可见
        searchView.setSubmitButtonEnabled(true);

        // 设置Hint以及Hint颜色
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
        searchAutoComplete.setHint("请输入要搜索内容");
        searchAutoComplete.setHintTextColor(Color.YELLOW);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(ToolBarActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("HLQ_Struggle", "--->:" + newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

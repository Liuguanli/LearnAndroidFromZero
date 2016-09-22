package com.hi.baidu.learnandroidfromzero.activity;

import java.util.Arrays;
import java.util.List;

import com.hi.baidu.learnandroidfromzero.adapter.MainAdapter;
import com.hi.baidu.learnandroidfromzero.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private MainAdapter adapter;
    private ListView mListView;

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        List<String> list =
                Arrays.asList(new String[] {"四大组件", "网络", "动画", "常用控件", "日志", "从零搭建Android", "学习Android底层", "单测",
                });

        adapter = new MainAdapter<String>(list, this);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.help:
                return true;
            case R.id.search:
                return true;
            case R.id.more:
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        // TODO Auto-generated method stub
//        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
//            //通过发射机制根据类名获取setOptionalIconsVisible(boolean visible)方法，并为其设置true
//            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
//                try {
//                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                    method.setAccessible(true);
//                    method.invoke(menu, true);
//                } catch (Exception e) {
//                }
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==3) {
            Toast.makeText(MainActivity.this, (String) adapter.getDateResc().get(i), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, UIComponentAvtivity.class);
            intent.setClass(MainActivity.this, RecycleViewActivity.class);
            startActivity(intent);
        }
    }
}

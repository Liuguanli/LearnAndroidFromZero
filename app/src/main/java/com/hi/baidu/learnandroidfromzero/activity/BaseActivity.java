package com.hi.baidu.learnandroidfromzero.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liuguanli on 16/9/21.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void initView();
    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }


}

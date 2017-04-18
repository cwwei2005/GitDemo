package com.example.hlp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.TitlieMyUI;

/**
 * Created by Administrator on 2017/4/15.
 */

public class MyMsgActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_msg);

        initUI();
    }

    private void initUI() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_my_msg);
        title.getEdit().setVisibility(View.GONE);
    }
}

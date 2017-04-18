package com.example.hlp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.Item01MyUI;
import com.example.hlp.myui.TitlieMyUI;

/**
 * Created by Administrator on 2017/4/15.
 */

public class UserActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initUI();
        initTitle();
    }

    private void initUI() {
        Item01MyUI device_manage = (Item01MyUI) findViewById(R.id.device_manage);
        device_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, DeviceManageActivity.class);
                startActivity(intent);
            }
        });
        Item01MyUI office_manage = (Item01MyUI) findViewById(R.id.office_manage);
        office_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, OfficeManageActivity.class);
                startActivity(intent);
            }
        });
        Item01MyUI my_msg = (Item01MyUI) findViewById(R.id.my_msg);
        my_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, MyMsgActivity.class);
                startActivity(intent);
            }
        });
        Item01MyUI about_us = (Item01MyUI) findViewById(R.id.about_us);
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initTitle() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_user);
        TextView edit = title.getEdit();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, EditUserInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}

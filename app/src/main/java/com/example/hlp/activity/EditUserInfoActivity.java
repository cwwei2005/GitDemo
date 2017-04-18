package com.example.hlp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.TitlieMyUI;

/**
 * Created by Administrator on 2017/4/15.
 */

public class EditUserInfoActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);

        initTitle();
    }

    private void initTitle() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_edit_info);
        TextView back = title.getBack();
        TextView edit = title.getEdit();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edit.setVisibility(View.GONE);
    }
}

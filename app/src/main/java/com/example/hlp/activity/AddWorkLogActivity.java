package com.example.hlp.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.db.OfficeDatabase;
import com.example.hlp.db.OfficeDbOption;
import com.example.hlp.myui.TitlieMyUI;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/17.
 */

public class AddWorkLogActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_log);

        iniTitle();
    }

    private void iniTitle() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_add_log);
        TextView finish = title.getEdit();
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLog();
                finish();
            }
        });
    }

    private void writeLog() {
        SimpleDateFormat formatter = new SimpleDateFormat    ("yyyy年MM月dd日    HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String time = formatter.format(curDate);
        EditText et = (EditText) findViewById(R.id.et_log);
        OfficeDbOption dbOption = OfficeDbOption.getInstance(this);
        dbOption.insert(time, et.getText().toString());
    }
}

package com.example.hlp.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.adapter.TextAdapter;
import com.example.hlp.db.OfficeDbOption;
import com.example.hlp.myui.TitlieMyUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */

public class WorkLogActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_log);

        iniTitle();
        initData();
    }

    private void iniTitle() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_work_log);
        ImageView add = title.getImageView();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkLogActivity.this, AddWorkLogActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        List data = new ArrayList();
        getData(data);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        TextAdapter adapter = new TextAdapter(this, R.layout.adapter_log, data);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

    private void getData(List data) {
        OfficeDbOption dbOption = OfficeDbOption.getInstance(this);
        Cursor cursor = dbOption.query();
        while (cursor.moveToNext()){
            String time = cursor.getString(0);
            String descr = cursor.getString(1);
            android.util.Log.d("tag", "....");
            data.add(new WorkLog(time, descr));
        }
    }

    public class WorkLog{
        String time;
        String data;
        public WorkLog(String time, String data){
            this.time = time;
            this.data = data;
        }

        public String getTime(){
            return this.time;
        }
        public String getDescr(){
            return this.data;
        }
    }
}

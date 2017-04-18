package com.example.hlp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.TitlieMyUI;

/**
 * Created by Administrator on 2017/4/15.
 */

public class OfficeManageActivity extends BaseActivity {
    private GridView gv;
    private int[] iconId;
    private String[] iconName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_manage);

        initUI();
    }

    private void initUI() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_office_manage);
        title.getEdit().setVisibility(View.GONE);

        gv = (GridView)findViewById(R.id.id_gv);
        iconName = new String[]{"工作日志","配件申请","维修申请","工作审批","任务","工作汇报","文档","项目","xxxx"};
        iconId = new int[]{R.drawable.sjlr, R.drawable.pjs, R.drawable.wxsq, R.drawable.ratify, R.drawable.task,
                R.drawable.report, R.drawable.file, R.drawable.product,R.mipmap.ic_launcher};
        gv.setAdapter(new GridViewdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(OfficeManageActivity.this, WorkLogActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(OfficeManageActivity.this, PartsApplyActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(OfficeManageActivity.this, RepairApplyActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(OfficeManageActivity.this, WorkApprovalActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(OfficeManageActivity.this, TaskActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(OfficeManageActivity.this, WorkReportActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(OfficeManageActivity.this, DocumentActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(OfficeManageActivity.this, ProjectActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    class GridViewdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = View.inflate(OfficeManageActivity.this, R.layout.gridview_item, null);
            }
            ImageView iv = (ImageView)view.findViewById(R.id.iv);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            iv.setImageResource(iconId[i]);
            tv.setText(iconName[i]);
            return view;
        }
    }
}

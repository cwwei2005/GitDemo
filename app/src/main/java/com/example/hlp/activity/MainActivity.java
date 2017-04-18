package com.example.hlp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hlp.activitytest.R;

public class MainActivity extends BaseActivity{

    private TextView tv_version;
    private ProgressBar pb_load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
        initData();
    }

    private void initUI() {
        tv_version = (TextView)findViewById(R.id.tv_version);
        pb_load = (ProgressBar)findViewById(R.id.pb_update);
    }

    private void initData() {
        if (getLocalCode() < getServLetCode()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("更新新版本？");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //// TODO: 2017/4/13  去更新
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //// TODO: 2017/4/13 跳转到登陆页面
                    dialog.dismiss();
                    toLoginActivity();
                }
            });
            builder.show();
        }else {
            //跳转到登陆页面
            toLoginActivity();
        }
    }

    private int getLocalCode(){
        int localCode=0;
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(), 0);
            localCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localCode;
    }

    private int getServLetCode(){
        return 2;
    }

    @Override
    public void onBackPressed() {
        //跳转到登陆页面
        finish();
    }



    private void toLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
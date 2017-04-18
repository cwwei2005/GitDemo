package com.example.hlp;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MyApplication extends Application {
    private static Context context = null;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        x.Ext.init(this);
//        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能
    }
    public static Context getContext(){
        return context;
    }
}

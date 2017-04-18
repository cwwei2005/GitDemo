package com.example.hlp.utils;

import android.widget.Toast;

import com.example.hlp.MyApplication;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ShowUtils {
    public static void toast(String value){
        Toast.makeText(MyApplication.getContext(), value, Toast.LENGTH_SHORT).show();
    }
}

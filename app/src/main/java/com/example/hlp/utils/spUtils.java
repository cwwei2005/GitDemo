package com.example.hlp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hlp.MyApplication;

/**
 * Created by Administrator on 2017/4/13.
 */

/**
 * sharedprefences
 */
public class spUtils {
    private static SharedPreferences sp = null;
    public static void writeBoolean(String fileNmae, String key, boolean value){
        if (sp == null){
            sp = MyApplication.getContext().getSharedPreferences(fileNmae, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }
    public static boolean readBoolean(String fileNmae, String key, boolean value){
        if (sp == null){
            sp = MyApplication.getContext().getSharedPreferences(fileNmae, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, value);
    }

    public static void writeString(String fileNmae, String key, String value){
        if (sp == null){
            sp = MyApplication.getContext().getSharedPreferences(fileNmae, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }
    public static String readString(String fileNmae, String key, String value){
        if (sp == null){
            sp = MyApplication.getContext().getSharedPreferences(fileNmae, Context.MODE_PRIVATE);
        }
        return sp.getString(key, value);
    }
}

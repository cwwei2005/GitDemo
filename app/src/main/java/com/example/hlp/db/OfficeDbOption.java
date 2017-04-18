package com.example.hlp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2017/4/17.
 */

public class OfficeDbOption {
    private static OfficeDbOption  officeDbOption = null;
    private static SQLiteDatabase db;

    private OfficeDbOption(){
        //
    }
    public static OfficeDbOption getInstance(Context context){
        if (officeDbOption == null){
            officeDbOption = new OfficeDbOption();
            OfficeDatabase officeDb = new OfficeDatabase(context, "office.db", null, 1);
            db = officeDb.getWritableDatabase();
        }
        return officeDbOption;
    }

    public void insert(String time, String data){
        ContentValues value = new ContentValues();
        value.put("time", time);
        value.put("description", data);
        db.insert("workLog",null,value);
    }
    public void update(){
        //
    }
    public void delete(){
        //
    }
    public Cursor query(){
        Cursor cursor = db.query("workLog", new String[] {"time", "description"},null,null,null,null,null);
        return cursor;
    }
}

package com.example.hlp.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hlp.activity.WorkLogActivity;
import com.example.hlp.activitytest.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */

public class TextAdapter extends BaseAdapter {
    Context context;
    int id;
    List list;
    public TextAdapter(Context context, int resource, List list){
        this.context = context;
        this.id = resource;
        this.list = list;
    }
    @Override
    public int getCount() {
//        return 0;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null){
            view = View.inflate(context, id, null);
            TextView time = (TextView) view.findViewById(R.id.tv_time);
            TextView descr = (TextView) view.findViewById(R.id.tv_descr);
            WorkLogActivity.WorkLog obj = (WorkLogActivity.WorkLog) list.get(position);
            time.setText(obj.getTime());
            descr.setText(obj.getDescr());
        }
        return view;
    }
}

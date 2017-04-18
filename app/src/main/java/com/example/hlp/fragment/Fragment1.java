package com.example.hlp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hlp.activitytest.R;

/**
 * Created by Administrator on 2017/4/18.
 */

public class Fragment1 extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        tv = (TextView) view.findViewById(R.id.tv);
        return view;
    }

    public TextView getTextView(){
        return tv;
    }
}
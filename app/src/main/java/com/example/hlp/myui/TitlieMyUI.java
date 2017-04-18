package com.example.hlp.myui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hlp.MyApplication;
import com.example.hlp.activitytest.R;

/**
 * Created by Administrator on 2017/4/15.
 */

public class TitlieMyUI extends RelativeLayout {
    private static final String PATH = "http://schemas.android.com/apk/res/com.example.hlp.activitytest";
    private TextView tv_back;
    private TextView tv_title;
    private TextView tv_edit;
    private ImageView iv_add;

    public TitlieMyUI(Context context) {
        this(context, null);
    }

    public TitlieMyUI(Context context, AttributeSet attrs) {
        this(context,attrs, 0);
    }

    public TitlieMyUI(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.myui_title, this);
        tv_back = (TextView) view.findViewById(R.id.tv_back);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_edit = (TextView) view.findViewById(R.id.tv_edit);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        initAttrs(attrs);
        tv_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });
    }

    private void initAttrs(AttributeSet attrs) {
        String text = attrs.getAttributeValue(PATH, "title");
        if(text != null){
            tv_title.setText(text);
        }
        text = attrs.getAttributeValue(PATH, "edit");
        if(text != null){
            tv_edit.setText(text);
        }
        String visibility = attrs.getAttributeValue(PATH, "editVisibility");//是否隐藏编辑控件
        if(visibility != null){
            if(visibility.equals("false")){
                tv_edit.setVisibility(GONE);
            }else{
                tv_edit.setVisibility(VISIBLE);
            }
        }
        visibility = attrs.getAttributeValue(PATH, "addVisibility");//是否隐藏编辑控件
        if(visibility != null){
            if(visibility.equals("false")){
                iv_add.setVisibility(GONE);
            }else{
                iv_add.setVisibility(VISIBLE);
            }
        }
    }

    public TextView getBack(){
        return tv_back;
    }
    public TextView getEdit(){
        return tv_edit;
    }
    public ImageView getImageView(){
        return iv_add;
    }
}

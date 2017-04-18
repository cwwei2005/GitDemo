package com.example.hlp.myui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hlp.activitytest.R;

/**
 * Created by Administrator on 2017/4/15.
 */

public class Item01MyUI extends RelativeLayout {

    private ImageView iv_icon;
    private ImageView iv_next;
    private TextView tv_item_text;
    private static final String PATH = "http://schemas.android.com/apk/res/com.example.hlp.activitytest";

    public Item01MyUI(Context context) {
        this(context, null);
    }

    public Item01MyUI(Context context, AttributeSet attrs) {
        this(context,attrs, 0);
    }

    public Item01MyUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.myui_item_01, this);
        iv_icon = (ImageView) view.findViewById(R.id.iv_item_icon);
//        iv_next = (ImageView) view.findViewById(R.id.iv_next);
        tv_item_text = (TextView) view.findViewById(R.id.tv_item_text);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        int  icon = Integer.parseInt(attrs.getAttributeValue(PATH, "icon").substring(1));
        iv_icon.setImageResource(icon);
//        icon = Integer.parseInt(attrs.getAttributeValue(PATH, "next").substring(1));
//        iv_next.setImageResource(icon);
        String text = attrs.getAttributeValue(PATH, "text1");
//        String textSize = attrs.getAttributeValue(PATH, "textSize");
        tv_item_text.setText(text);
//        tv_item_text.setTextSize(Float.parseFloat(textSize));
    }
}

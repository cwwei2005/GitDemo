package com.example.hlp.myui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/4/15.
 */

public class EditTextClear extends EditText {
    public EditTextClear(Context context) {
        this(context, null);
    }

    public EditTextClear(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditTextClear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEditText();
    }

    private void initEditText() {
    }
}

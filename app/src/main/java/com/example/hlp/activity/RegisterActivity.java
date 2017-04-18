package com.example.hlp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.utils.ContentValues;
import com.example.hlp.utils.ShowUtils;
import com.example.hlp.utils.SmsUtil;
import com.example.hlp.utils.spUtils;

/**
 * Created by Administrator on 2017/4/13.
 */

public class RegisterActivity extends BaseActivity {

    EditText et_name;
    EditText et_pwd;
    EditText et_phone;
    EditText et_verificationCode;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
        initData();
    }

    private void initUI() {
        et_name = (EditText)findViewById(R.id.et_name);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_verificationCode = (EditText)findViewById(R.id.et_verification_code);
        Button bt_getVerificationCode = (Button)findViewById(R.id.bt_verification_code);
        bt_getVerificationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsUtil.requestVerificationCode();
            }
        });
        Button bt_register = (Button)findViewById(R.id.bt_register);
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        final TextView tv_login = (TextView)findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterLogin();
            }
        });
        final TextView tv_forgetPwd = (TextView)findViewById(R.id.tv_forgetPwd);
        tv_forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterForgetPwd();
            }
        });
        final TextView tv_back2webSite = (TextView)findViewById(R.id.tv_back2website);
        tv_back2webSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back2webSite();
            }
        });
    }

    private void enterLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void enterForgetPwd() {
        Intent intent = new Intent(this, ForgetPwdActivity.class);
        startActivity(intent);
    }

    private void register() {
        ShowUtils.toast("注册成功");
    }

    private void back2webSite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://113.140.70.73"));
        startActivity(intent);
    }

    private void initData() {
        //
    }
}
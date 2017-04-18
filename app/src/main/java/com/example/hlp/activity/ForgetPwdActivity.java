package com.example.hlp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.utils.ShowUtils;
import com.example.hlp.utils.SmsUtil;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ForgetPwdActivity extends BaseActivity {

    EditText et_name;
    EditText et_pwd;
    EditText et_pwd2;
    EditText et_verificationCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initUI();
        initData();
    }

    private void initUI() {
        et_name = (EditText)findViewById(R.id.et_name);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        et_pwd2 = (EditText)findViewById(R.id.et_phone);
        et_verificationCode = (EditText)findViewById(R.id.et_verification_code);

        Button bt_getVerificationCode = (Button)findViewById(R.id.bt_get_verification_code);
        bt_getVerificationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsUtil.requestVerificationCode();
            }
        });
        Button bt_resetPwd = (Button)findViewById(R.id.bt_reset_pwd);
        bt_resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPwd();
            }
        });
        final TextView tv_register = (TextView)findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterRegister();
            }
        });
        final TextView tv_login = (TextView)findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterLogin();
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

    private void resetPwd() {
        ShowUtils.toast("重置成功");
    }

    private void enterRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
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

package com.example.hlp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.EditTextClear;
import com.example.hlp.utils.ContentValues;
import com.example.hlp.utils.HttpUtil;
import com.example.hlp.utils.MD5Utils;
import com.example.hlp.utils.ShowUtils;
import com.example.hlp.utils.spUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/13.
 */

public class LoginActivity extends BaseActivity {

    private EditText et_name;
    private EditText et_pwd;
    private CheckBox cb_remember;
    ProgressDialog pd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        initData();
    }

    private void initUI() {
        pd = new ProgressDialog(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        cb_remember = (CheckBox)findViewById(R.id.cb_remember);
        final TextView tv_back2webSite = (TextView)findViewById(R.id.tv_back2website);
        tv_back2webSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back2webSite();
            }
        });
        final TextView tv_register = (TextView)findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        final TextView tv_forgetPwd = (TextView)findViewById(R.id.tv_forgetPwd);
        tv_forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetPwd();
            }
        });
        Button bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if (TextUtils.isEmpty(et_name.getText())){
            ShowUtils.toast("用户名不能为空");
        }else {
            if (TextUtils.isEmpty(et_pwd.getText())){
                ShowUtils.toast("密码不能为空");
            }else {
//                pd.setTitle("登录中");
                pd.show();
                String name = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                if (cb_remember.isChecked()){
                    //
                }else {
                    spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_NAME, "");
                    spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_PWD, "");
                    spUtils.writeBoolean(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_REMEMBER, false);
                }
                if (httpConnect("http://113.140.70.73/login", name, pwd)){
                    //登录成功
//                    if (cb_remember.isChecked()){
//                        String encoderPwd = pwd;//MD5Utils.encoder(pwd+"加盐");不加密
//                        spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_NAME, name);
//                        spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_PWD, encoderPwd);
//                        spUtils.writeBoolean(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_REMEMBER, true);
//                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                        startActivity(intent);
//                    }
                }
            }
        }
    }

    private boolean httpConnect(String url, final String name, final String pwd) {
        final boolean[] bool = {false};
        OkHttpClient client = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("userName", name);
        builder.add("password", pwd);
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = client.newCall(request);

        //test for no newwork  *************************************************
        pd.dismiss();
        final String htmlStr =  "successes";//htmlStr={"success":true}
        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                ShowUtils.toast(htmlStr);
            }
        });
        if (true){//登录成功
//                    bool[0] = true;
            if (cb_remember.isChecked()){
                String encoderPwd = pwd;//MD5Utils.encoder(pwd+"加盐");不加密
                spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_NAME, name);
                spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_PWD, encoderPwd);
                spUtils.writeBoolean(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_REMEMBER, true);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
            return  true;
        }
//        *************************************************

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                SystemClock.sleep(1000);
                pd.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ShowUtils.toast("onFailure");
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                pd.dismiss();
                final String htmlStr =  response.body().string();//htmlStr={"success":true}
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        ShowUtils.toast(htmlStr);
                    }
                });
                if (htmlStr.contains("true")){//登录成功
//                    bool[0] = true;
                    if (cb_remember.isChecked()){
                        String encoderPwd = pwd;//MD5Utils.encoder(pwd+"加盐");不加密
                        spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_NAME, name);
                        spUtils.writeString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_PWD, encoderPwd);
                        spUtils.writeBoolean(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_REMEMBER, true);
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
//        return bool[0];
        return false;
    }



    private void forgetPwd() {
        Intent intent = new Intent(this, ForgetPwdActivity.class);
        startActivity(intent);
    }

    private void register() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void back2webSite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://113.140.70.73"));
        startActivity(intent);
    }

    private void initData() {
        boolean cb = spUtils.readBoolean(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_REMEMBER, false);
        if (cb){
            cb_remember.setChecked(true);
            String name = spUtils.readString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_NAME, "");
            String pwd = spUtils.readString(ContentValues.SP_FILE_LOGIN_INFO, ContentValues.SP_KEY_LOGIN_PWD, "");
            et_name.setText(name);
            et_pwd.setText(pwd);
        }
    }
}

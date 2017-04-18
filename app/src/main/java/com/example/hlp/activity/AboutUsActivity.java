package com.example.hlp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.myui.TitlieMyUI;

/**
 * Created by Administrator on 2017/4/15.
 */

public class AboutUsActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        initUI();
    }

    private void initUI() {
        TitlieMyUI title = (TitlieMyUI) findViewById(R.id.title_about_us);
        title.getEdit().setVisibility(View.GONE);

        final TextView salePhone = (TextView) findViewById(R.id.tv_sale_phone);
        salePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = salePhone.getText().toString().substring(5);
                normalDialog(data);
            }
        });
        final TextView partsPhone = (TextView) findViewById(R.id.tv_parts_phone);
        partsPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = partsPhone.getText().toString().substring(5);
                normalDialog(data);
            }
        });
        final TextView servicePhone = (TextView) findViewById(R.id.tv_service_phone);
        servicePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = servicePhone.getText().toString().substring(5);
                normalDialog(data);
            }
        });
        final TextView website = (TextView) findViewById(R.id.tv_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = website.getText().toString().substring(5);
//                normalDialog(data);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(data));
                startActivity(intent);
            }
        });
    }

    private void normalDialog(final String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("是否呼叫电话 "+data);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callPhone(data);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void callPhone(String data) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+data));
        startActivity(intent);
    }
}

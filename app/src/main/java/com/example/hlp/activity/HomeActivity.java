package com.example.hlp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hlp.activitytest.R;
import com.example.hlp.utils.Utils;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * Created by Administrator on 2017/4/13.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    private RollPagerView rollPagerView;
    private PieChartView pieChart;
    private PieChartData pieChardata;
    List<SliceValue> values = new ArrayList<SliceValue>();
    private int[] data = {111,11};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
        initData();
    }

    private void initUI() {
        Button bt_user = (Button) findViewById(R.id.bt_user);
        bt_user.setOnClickListener(this);
        Button bt_map = (Button) findViewById(R.id.bt_map);
        bt_map.setOnClickListener(this);
        Button bt_userEnter = (Button) findViewById(R.id.bt_user_enter);
        bt_userEnter.setOnClickListener(this);
        Button bt_yunweiEnter = (Button) findViewById(R.id.bt_yunwei_enter);
        bt_yunweiEnter.setOnClickListener(this);
        rollPagerView = (RollPagerView) findViewById(R.id.rpv);
        setRollPageView();
        pieChart = (PieChartView) findViewById(R.id.pie_chart);
        setPie();
//        SearchView sv_search = (SearchView) findViewById(R.id.sv_search);
    }

    private void setPie() {
        pieChart.setOnValueTouchListener(selectListener);//设置点击事件监听
        setPieChartData();
        initPieChart();
    }

    /**
     * 获取数据
     */
    private void setPieChartData(){
        int[] color = {Color.BLUE, Color.GRAY};
        for (int i = 0; i < 2/*data.length*/; ++i) {
            SliceValue sliceValue = new SliceValue((float) data[i], color[i]);//这里的颜色是我写了一个工具类 是随机选择颜色的
            values.add(sliceValue);
        }
    }


    /**
     * 初始化
     */
    private void initPieChart() {
        pieChardata = new PieChartData();
        pieChardata.setHasLabels(true);//显示表情
        pieChardata.setHasLabelsOnlyForSelected(false);//不用点击显示占的百分比
        pieChardata.setHasLabelsOutside(false);//占的百分比是否显示在饼图外面
        pieChardata.setHasCenterCircle(true);//是否是环形显示
        pieChardata.setValues(values);//填充数据
        pieChardata.setCenterCircleColor(Color.WHITE);//设置环形中间的颜色
        pieChardata.setCenterCircleScale(0.4f);//设置环形的大小级别
        pieChardata.setCenterText1("已开机设备");//环形中间的文字1
        pieChardata.setCenterText1Color(Color.BLUE);//文字颜色
        pieChardata.setCenterText1FontSize(18);//文字大小

        pieChardata.setCenterText2("未开机设备");
        pieChardata.setCenterText2Color(Color.GRAY);
        pieChardata.setCenterText2FontSize(18);
        /**这里也可以自定义你的字体   Roboto-Italic.ttf这个就是你的字体库*/
//      Typeface tf = Typeface.createFromAsset(this.getAssets(), "Roboto-Italic.ttf");
//      data.setCenterText1Typeface(tf);

        pieChart.setPieChartData(pieChardata);
        pieChart.setValueSelectionEnabled(true);//选择饼图某一块变大
        pieChart.setAlpha(0.9f);//设置透明度
        pieChart.setCircleFillRatio(0.8f);//设置饼图大小

    }

    /**
     * 监听事件
     */
    private PieChartOnValueSelectListener selectListener = new PieChartOnValueSelectListener() {

        @Override
        public void onValueDeselected() {
            // TODO Auto-generated method stub

        }

        @Override
        public void onValueSelected(int arg0, SliceValue value) {
            // TODO Auto-generated method stub
            Toast.makeText(HomeActivity.this, "Selected: " + value.getValue(), Toast.LENGTH_SHORT).show();
        }
    };

    private void setRollPageView() {
        //设置播放时间间隔
        rollPagerView.setPlayDelay(1500);
        //设置透明度
        rollPagerView.setAnimationDurtion(1000);
        //设置适配器
        rollPagerView.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        rollPagerView.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

    private void initData() {
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.bt_user:
                intent = new Intent(this, UserActivity.class);
                break;
            case R.id.bt_map:
                intent = new Intent(this, MapActivity.class);
                break;
            case R.id.bt_user_enter:
                intent = new Intent(this, UserEndterActivity.class);
                break;
            case R.id.bt_yunwei_enter:
                intent = new Intent(this, YunWeiActivity.class);
                break;
        }
        startActivity(intent);
    }

    //rollpageview
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.banner_a,
                R.drawable.banner_b,
                R.drawable.banner_c,
                R.drawable.banner_d,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}

package com.example.hlp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.hlp.activitytest.R;
import com.example.hlp.adapter.MyFragmentPagerAdapter;
import com.example.hlp.fragment.Fragment1;
import com.example.hlp.fragment.Fragment2;
import com.example.hlp.myui.TitlieMyUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/15.
 */

public class UserEndterActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

//viewPager + fragment: 需要适配器FragmentPageAdapter或FragmentStatePagerAdapter，这里用 FragmentPageAdapter
    private ViewPager vpager;
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static final int PAGE_FIVE = 4;
    public static final int PAGE_SIX = 5;
    public static final int PAGE_SEVEN = 6;

    private TextView tv1, tv2,tv3,tv4,tv5,tv6,tv7;

    private int selectItemIndex = 0;
    LinearLayout ll;
    private int screenWidth;//屏幕宽度
    HorizontalScrollView hsv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_enter);

        initTitle();
        initUI();
        setNav();
    }

    private void initTitle() {
        TextView tv_back = (TextView) findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SearchView sv = (SearchView) findViewById(R.id.sv);//SearchView: 使用android.weight
    }

    private void initUI() {
        hsv = (HorizontalScrollView) findViewById(R.id.hsv);
        ll = (LinearLayout) findViewById(R.id.ll);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);
        tv5 = (TextView) findViewById(R.id.tv_5);
        tv6 = (TextView) findViewById(R.id.tv_6);
        tv7 = (TextView) findViewById(R.id.tv_7);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());//创建自定义适配器对象
        vpager = (ViewPager) findViewById(R.id.vp);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);//0：显示当前第0页
        vpager.addOnPageChangeListener(this);//注册页面切换事件监听
        tv1.setTextColor(Color.RED);
    }

    //重写viewpager页面切换的方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {//根据滑动页去滚动HorizontalScrollView的标签
        vpager.setCurrentItem(position);
        selectType(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    Fragment1 fragment1 = (Fragment1) mAdapter.getItem(0);
                    Log.d("tag", "haha");
                    break;
                case PAGE_TWO:
                    Log.d("tag", "haha");
                    break;
                case PAGE_THREE:
                    Log.d("tag", "haha");
                    break;
                case PAGE_FOUR:
                    Log.d("tag", "haha");
                    break;
                case PAGE_FIVE:
                    Log.d("tag", "haha");
                    break;
                case PAGE_SIX:
                    Log.d("tag", "haha");
                    break;
                case PAGE_SEVEN:
                    Log.d("tag", "haha");
                    break;
            }
        }
    }

    private void setNav() {
        //获得屏幕总宽度
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        //设置每个item的宽度
//        itemWidth = screenWidth/type.size();
        List<TextView> list = new ArrayList<>();
        list.add(tv1);
        list.add(tv2);
        list.add(tv3);
        list.add(tv4);
        list.add(tv5);
        list.add(tv6);
        list.add(tv7);

        for(int i=0;i<7;i++){
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
//            //设置外边距
//            params.leftMargin = 10;
//            params.rightMargin = 10;
//            //创建Textview实例
//            TextView localTextView = new TextView(this);
//            //设置tv的属性
//            localTextView.setText(type.get(i));
//            localTextView.setTextSize(15.0f);
//            localTextView.setPadding(5, 9, 5, 9);
//            localTextView.setGravity(Gravity.CENTER);
//            if(i == 0){
//                localTextView.setTextColor(Color.RED);
//            }else{
//                localTextView.setTextColor(Color.parseColor("#666666"));
//            }
//            if(selectItemIndex == i){
//                localTextView.setSelected(true);
//            }
//            //设置每个tv的点击监听
            TextView tv = list.get(i);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0; i<ll.getChildCount(); i++){
                        TextView tv = (TextView) ll.getChildAt(i);
                        if(tv == v){
                            tv.setSelected(true);
                            vpager.setCurrentItem(i);//该方法执行后会调用 selectType
                        }else{
                            tv.setSelected(false);
                        }
                    }
                }
            });
//            nav_ll.addView(localTextView, i, params);
        }
    }

    private void selectType(int position) {
        selectItemIndex = position;
        //通过自动滚动
        for(int i=0;i<ll.getChildCount();i++){
            TextView tv0 = (TextView) ll.getChildAt(position);
            int k = tv0.getMeasuredWidth();
            int l = tv0.getLeft();
            int j = l+k/2-screenWidth/2;//计算要滚动到的位置
            hsv.smoothScrollTo(j, 0);
        }
        //判断哪一个tv被选中设置字体颜色
        for(int i=0;i<ll.getChildCount();i++){
            TextView view = (TextView) ll.getChildAt(i);
            if(position == i){
                view.setTextColor(Color.RED);
                view.setSelected(true);
            }else{
                view.setTextColor(Color.parseColor("#666666"));
                view.setSelected(false);
            }
        }
    }
}

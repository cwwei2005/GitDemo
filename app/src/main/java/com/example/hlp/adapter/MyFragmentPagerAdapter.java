package com.example.hlp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.hlp.activity.UserEndterActivity;
import com.example.hlp.fragment.Fragment1;
import com.example.hlp.fragment.Fragment2;
import com.example.hlp.fragment.Fragment3;
import com.example.hlp.fragment.Fragment4;
import com.example.hlp.fragment.Fragment5;
import com.example.hlp.fragment.Fragment6;
import com.example.hlp.fragment.Fragment7;

/**
 * Created by Administrator on 2017/4/18.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 7;
    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    private Fragment3 fragment3 = null;
    private Fragment4 fragment4 = null;
    private Fragment5 fragment5 = null;
    private Fragment6 fragment6 = null;
    private Fragment7 fragment7 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        fragment6 = new Fragment6();
        fragment7 = new Fragment7();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case UserEndterActivity.PAGE_ONE:
                fragment = fragment1;
                break;
            case UserEndterActivity.PAGE_TWO:
                fragment = fragment2;
                break;
            case UserEndterActivity.PAGE_THREE:
                fragment = fragment3;
                break;
            case UserEndterActivity.PAGE_FOUR:
                fragment = fragment4;
                break;
            case UserEndterActivity.PAGE_FIVE:
                fragment = fragment5;
                break;
            case UserEndterActivity.PAGE_SIX:
                fragment = fragment6;
                break;
            case UserEndterActivity.PAGE_SEVEN:
                fragment = fragment7;
                break;
        }
        return fragment;
    }

}
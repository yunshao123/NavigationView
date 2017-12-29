package com.navigationview.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2017/12/29
 * @Time 14:23
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {
    private int COUNT=2;
    private String[] strs=new String[]{"选项卡1","选项卡2"};
    private List<Fragment> frameLayouts;
    public TabLayoutAdapter(FragmentManager fm,List<Fragment> frameLayouts){
        super(fm);
        this.frameLayouts = frameLayouts;
    }

    @Override
    public Fragment getItem(int position) {
        return frameLayouts == null  ? null : frameLayouts.get(position);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strs[position];
    }
}

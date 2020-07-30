package com.rhby.edu.jianxin.adapter.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MainViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragments.get(arg0);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

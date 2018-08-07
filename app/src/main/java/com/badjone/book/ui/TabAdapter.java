package com.badjone.book.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author BadJone
 * @data 2018/8/4.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String[] tabList;
    private ArrayList<Fragment> fragments;

    public TabAdapter(FragmentManager fm, String[] tabs, ArrayList<Fragment> fragments) {
        super(fm);
        this.tabList = tabs;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (tabList == null) || (tabList.length == 0) || (tabList.length <= position) || (tabList[position] == null) ? null : tabList[position];
    }
}

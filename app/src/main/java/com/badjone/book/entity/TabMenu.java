package com.badjone.book.entity;

import com.blankj.utilcode.util.Utils;
import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @author wugx
 * @data 2018/2/25.
 */

public class TabMenu implements CustomTabEntity {
    public String title;
    public int selectedId;
    public int unSelectedId;

    public TabMenu(String title, int selectedId, int unSelectedId) {
        this.title = title;
        this.selectedId = selectedId;
        this.unSelectedId = unSelectedId;
    }

    public TabMenu(int title, int selectedId, int unSelectedId) {
        this.title = Utils.getApp().getString(title);
        this.selectedId = selectedId;
        this.unSelectedId = unSelectedId;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedId;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedId;
    }
}

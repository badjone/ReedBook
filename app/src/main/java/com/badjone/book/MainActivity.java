package com.badjone.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.badjone.book.entity.TabMenu;
import com.badjone.book.ui.BookFragment;
import com.badjone.book.ui.HomeFragment;
import com.badjone.book.ui.MeFragment;
import com.badjone.book.ui.TabAdapter;
import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVpMain;
    private CommonTabLayout mCtlMain;
    private ArrayList<Fragment> fragments;

    private String[] tabs = {"精选", "分类", "我的"};
    public int[] unSelecteds = {R.mipmap.ic_home_green_100_36dp, R.mipmap.ic_book_green_100_36dp, R.mipmap.ic_account_box_green_100_36dp};
    public int[] selecteds = {R.mipmap.ic_home_red_700_36dp, R.mipmap.ic_book_red_700_36dp, R.mipmap.ic_account_box_red_700_36dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        initTitle();

        initView();
        initData();
        initListener();


    }

    DrawerLayout drawer;

    private void initTitle() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.dl_main_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.txt_open,
                R.string.txt_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nv_main_draw);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.item_home) {
                    ToastUtils.showShort("home");

                } else if (id == R.id.item_set) {

                    ToastUtils.showShort("set");
                }

                drawer = findViewById(R.id.dl_main_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    private void initListener() {
        mCtlMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCtlMain.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        initTabs();

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new BookFragment());
        fragments.add(new MeFragment());

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabs, fragments);
        mVpMain.setAdapter(tabAdapter);
    }

    private void initTabs() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        for (int i = 0; i < tabs.length; i++) {
            mTabEntities.add(new TabMenu(tabs[i], selecteds[i], unSelecteds[i]));
        }
        mCtlMain.setTabData(mTabEntities);
    }

    private void initView() {
        mVpMain = findViewById(R.id.vp_main);
        mCtlMain = findViewById(R.id.ctl_main);
    }
}

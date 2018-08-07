package com.badjone.book.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badjone.book.R;
import com.badjone.book.widget.ArcLineView;

/**
 * @author BadJone
 * @data 2018/8/4.
 */

public class HomeFragment extends Fragment {
    private ArcLineView mArcView;
    public int mStartColor[];
    public int mEndColor[];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);

//        mStartColor = new int[]{
//                getResources().getColor(R.color.start_color)
//                , getResources().getColor(R.color.page1_start_color)
//                , getResources().getColor(R.color.page2_start_color)
//                , getResources().getColor(R.color.page3_start_color)};
//        mEndColor = new int[]{
//                getResources().getColor(R.color.end_color)
//                , getResources().getColor(R.color.page1_end_color)
//                , getResources().getColor(R.color.page2_end_color)
//                , getResources().getColor(R.color.page3_end_color)};
//
//        mArcView.setColor(getResources().getColor(R.color.start_color), getResources().getColor(R.color.end_color));


        mStartColor = new int[]{
                Color.RED,
        };
        mEndColor = new int[]{
                Color.RED
        };

        mArcView.setColor(Color.RED, Color.RED);

        return view;
    }

    private void initView(View view) {
        mArcView = (ArcLineView) view.findViewById(R.id.arc_view);
    }
}

package com.congda.baselibrary.adapter;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class EmojiViewPagerAdapter extends PagerAdapter {

    private  List<View> mViewList;

    public EmojiViewPagerAdapter(List<View> mViewList) {
        this.mViewList=mViewList;
    }

    @Override
    public int getCount() {
        if(mViewList==null){
            return 0;
        }else {
            return  mViewList.size();
        }
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }
}
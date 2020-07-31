package com.congda.baselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.congda.baselibrary.R;
import com.congda.baselibrary.adapter.EmojiViewPagerAdapter;
import com.congda.baselibrary.adapter.RecycleViewPagerdapter;
import com.congda.baselibrary.bean.IMEmojiBean;

import java.util.ArrayList;
import java.util.List;

public class IMViewPagerEmoji extends LinearLayout  implements  ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private LinearLayout mllcontain ;
    private  int  lastpositon ;
    private int pageSize =10;
    private List<IMEmojiBean> datas= new ArrayList<>();

    public IMViewPagerEmoji(Context context) {
        super(context);
        initView(context);
    }

    public IMViewPagerEmoji(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public IMViewPagerEmoji(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_viewpager_title, this);
        viewPager = view.findViewById(R.id.view_pager);
        mllcontain = view.findViewById(R.id.llcontain);
    }

    public void setData(Context context, List<IMEmojiBean>data){
        this.datas=data;
        initData(context);
    }
    public void setpageSize( int pageSize){
        this.pageSize=pageSize;
    }


    private void initData(Context context){
        int pageCount = (int)Math.ceil(datas.size() * 1.0 / pageSize);
        List<View> viewList = new ArrayList();
        for (int i = 0; i <pageCount ; i++) { //每个页面都是inflate出一个新实例
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_home_emoji_vp,null);
            RecyclerView recyclerView = view1.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(context,  pageSize/2));
            RecycleViewPagerdapter adapter = new RecycleViewPagerdapter(context, i, pageSize,datas);
            recyclerView.setAdapter(adapter);
            viewList.add(view1);

            View view= LayoutInflater.from(context).inflate(R.layout.item_home_emoji_dot, viewPager, false);
            ImageView iv_dot = view.findViewById(R.id.iv_dot);
            if(i==0){
                iv_dot.setEnabled(true);
            }else {
                iv_dot.setEnabled(false);
            }
            mllcontain.addView(view);
        }
        EmojiViewPagerAdapter mAdapter =new EmojiViewPagerAdapter(viewList);
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ( mllcontain.getChildAt(position).findViewById(R.id.iv_dot)).setEnabled(true);
        ( mllcontain.getChildAt(lastpositon).findViewById(R.id.iv_dot)).setEnabled(false);
        lastpositon=position;
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

}

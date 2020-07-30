package com.rhby.edu.jianxin.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.utils.IMStatusBarUtil;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.adapter.viewpager.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class GuideActivity extends IMBaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.vp_guide)
    ViewPager viewPager;
    @BindView(R.id.llcontain)
    LinearLayout llcontain;
    @BindView(R.id.tv_open)
    TextView tv_open;
    private int currentIndex = 0;
    // 底部小点图片
    private ImageView[] dots ;
    private List<View> views=new ArrayList<>();
    // 引导页图片资源
    private int[] pics = {R.layout.layout_guide_one, R.layout.layout_guide_two, R.layout.layout_guide_three};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initStatusBar() {
        super.initStatusBar();
        IMStatusBarUtil.setLightMode(this);
    }

    @Override
    protected void initView() {
        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view= LayoutInflater.from(this).inflate(pics[i], null);
            views.add(view);
        }
        initDots();
        // 初始化adapter
        GuideViewPagerAdapter adapter = new GuideViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }
    private void initDots() {
        dots=new ImageView[pics.length];
        for (int i = 0; i < pics.length; i++) {
            dots[i]=(ImageView)llcontain.getChildAt(i);
            dots[i].setEnabled(false);
            dots[i].setTag(i);
        }
        currentIndex=0;
        dots[currentIndex].setEnabled(true);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_open})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_open:
                startActivity(MainActivity.class,true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /**
     * 设置当前指示点
     */
    private  void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        if(position==pics.length-1){
            tv_open.setVisibility(View.VISIBLE);
        }else {
            tv_open.setVisibility(View.INVISIBLE);
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }
}

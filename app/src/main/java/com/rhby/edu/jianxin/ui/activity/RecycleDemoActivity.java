package com.rhby.edu.jianxin.ui.activity;

import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.widget.IMNavigarUtils;
import com.congda.baselibrary.utils.IMScreenUtil;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.adapter.viewpager.MainViewPagerAdapter;
import com.rhby.edu.jianxin.ui.fragment.MainSecondFragment;
import com.rhby.edu.jianxin.ui.fragment.mvp.view.ListFirstFragment;
import com.rhby.edu.jianxin.ui.fragment.mvp.view.ListSecondFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class RecycleDemoActivity extends IMBaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magic_indicator;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.view)
    View view;

    private  List<String> datas=new ArrayList<>();
    private  List<Fragment> fragments=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycle;
    }

    @Override
    protected void initView() {
        //设置mTopView高度为状态栏高度
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height= IMScreenUtil.getStatusHeight(this);
        view.setLayoutParams(layoutParams);
        datas.add("列表一");
        datas.add("多布局列表二");
        datas.add("列表三");
        CommonNavigator commonNavigator = IMNavigarUtils.with(this).setNavigas(datas, view_pager);
        magic_indicator.setNavigator(commonNavigator);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        fragments.add(new ListFirstFragment());
        fragments.add(new ListSecondFragment());
        fragments.add(new MainSecondFragment());
        MainViewPagerAdapter pagerAdapter =new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        view_pager.setAdapter(pagerAdapter);
        ViewPagerHelper.bind(magic_indicator, view_pager);
    }
}

package com.rhby.edu.jianxin.ui.activity;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.utils.IMStatusBarUtil;
import com.congda.baselibrary.widget.IMViewPagerSlide;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.adapter.viewpager.MainViewPagerAdapter;
import com.rhby.edu.jianxin.ui.fragment.MainFirstFragment;
import com.rhby.edu.jianxin.ui.fragment.MainFourthFragment;
import com.rhby.edu.jianxin.ui.fragment.MainSecondFragment;
import com.rhby.edu.jianxin.ui.fragment.MainThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cc.shinichi.library.tool.ui.ToastUtil;
/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class MainActivity extends IMBaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.tabs)
    LinearLayout tabs;
    @BindView(R.id.viewpage)
    IMViewPagerSlide viewpager;
    @BindView(R.id.ctv_tab1)
    CheckedTextView ctv_tab1;
    @BindView(R.id.ctv_tab2)
    CheckedTextView ctv_tab2;
    @BindView(R.id.ctv_tab3)
    CheckedTextView ctv_tab3;
    @BindView(R.id.ctv_tab4)
    CheckedTextView ctv_tab4;

    private  long exitTime;
    private  int mLastIndex;
    private MainViewPagerAdapter mAdapter;
    private LinearLayout[]  mLinearLayout;
    private List<Fragment>  mFragments =new ArrayList<>();

    private MainFirstFragment mfirstFragment;
    private MainSecondFragment msecondFragment;
    private MainThirdFragment mthirdFragment;
    private MainFourthFragment mfourthFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initStatusBar() {
        IMStatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        IMStatusBarUtil.setLightMode(this);
    }

    @Override
    protected void initView() {
        setSwipeBackEnable(false);
        mfirstFragment = new MainFirstFragment();
        msecondFragment= new MainSecondFragment();
        mthirdFragment = new MainThirdFragment();
        mfourthFragment= new MainFourthFragment();
        mFragments.add(mfirstFragment);
        mFragments.add(msecondFragment);
        mFragments.add(mthirdFragment);
        mFragments.add(mfourthFragment);
    }

    @Override
    protected void initListener() {
        viewpager.setCanScrollble(false);
        viewpager.setOffscreenPageLimit(4);
        viewpager.addOnPageChangeListener(this);
    }
    @Override
    protected void initData() {
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpager.setAdapter(mAdapter);
        initTabs();
    }

    private void initTabs() {
        mLinearLayout = new LinearLayout[tabs.getChildCount()];
        for (int i = 0; i < tabs.getChildCount(); i++) {
            mLinearLayout[i] = (LinearLayout) tabs.getChildAt(i);
            mLinearLayout[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < mLinearLayout.length; i++) {
            if (view == mLinearLayout[i]) {
                if (i == mLastIndex) {
                    break;
                }
                ((CheckedTextView)(mLinearLayout[i].getChildAt(0))).setChecked(true);
                viewpager.setCurrentItem(i, false);
                mLastIndex = i;
            }else {
                ((CheckedTextView)(mLinearLayout[i].getChildAt(0))).setChecked(false);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == mLastIndex) {
            return;
        }
        ((CheckedTextView)mLinearLayout[position].getChildAt(0)).setChecked(true);
        ((CheckedTextView)mLinearLayout[mLastIndex].getChildAt(0)).setChecked(false);
        mLastIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtil.getInstance()._short(this, "再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
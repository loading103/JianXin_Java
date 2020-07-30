package com.rhby.edu.jianxin.ui.fragment;

import android.view.View;
import android.widget.Button;

import com.congda.baselibrary.base.IMBaseFragment;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.ui.activity.SettingActivity;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.SplashContract;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class MainFirstFragment extends IMBaseFragment {
    @BindView(R.id.common_top)
    IMCommonTitleView   commonTitleView;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button   btn2;
    @Override
    protected int getLayoutId() {
        return  R.layout.fragment_first;
    }

    @Override
    protected void initView() {
        commonTitleView.setTopTitle("首页");
        commonTitleView.setTopLeftGone();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    @OnClick({R.id.btn1,R.id.btn2})
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
//                startActivity(DemoActivity.class,false);
                break;
            case R.id.btn2:
                startActivity(SettingActivity.class,false);
                break;
        }
    }
}

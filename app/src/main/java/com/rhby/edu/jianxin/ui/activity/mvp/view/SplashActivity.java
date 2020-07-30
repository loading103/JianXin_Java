package com.rhby.edu.jianxin.ui.activity.mvp.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.congda.baselibrary.app.IMSConfig;
import com.congda.baselibrary.base.IMBaseMvpActivity;
import com.congda.baselibrary.service.IMStartServiceDemo;
import com.congda.baselibrary.utils.IMCutTimeDownView;
import com.congda.baselibrary.utils.IMNetworkUtils;
import com.congda.baselibrary.utils.IMPreferenceUtil;
import com.congda.baselibrary.utils.IMResourceUtil;
import com.congda.baselibrary.utils.IMStatusBarUtil;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.utils.glide.IMImageLoadUtil;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.bean.SplashAdBean;
import com.rhby.edu.jianxin.ui.activity.GuideActivity;
import com.rhby.edu.jianxin.ui.activity.MainActivity;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.SplashContract;
import com.rhby.edu.jianxin.ui.activity.mvp.presenter.SplashPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class SplashActivity extends IMBaseMvpActivity<SplashPresenter> implements SplashContract.View, IMCutTimeDownView.OnFinishListener {
    @BindView(R.id.iv_bg)
    ImageView iv_bg;
    @BindView(R.id.skipTv)
    IMCutTimeDownView skipTv;
    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        //开启监听网络的服务，处理一开始不开网进去app的情况
        Intent intent =new Intent(this, IMStartServiceDemo.class);
        startService(intent);
        if(isFirstOpen()){
            return;
        }
        if(!IMNetworkUtils.isNetworkAvailable(this)){
            IMToastUtil.getInstance()._short(IMResourceUtil.getString(R.string.net_no_good));
            setNoDataMethod();
            return;
        }
        skipTv.setOnFinishListener(this);
        mPresenter.getSplashData();
    }

    /**
     * 判断是不是第一次进去app
     */
    private Boolean isFirstOpen() {
        if (IMPreferenceUtil.getPreference_Boolean(IMSConfig.FIRST_OPEN, true)) {
            IMPreferenceUtil.setPreference_Boolean(IMSConfig.FIRST_OPEN, false);
            startActivity(GuideActivity.class,true);
            return  true;
        }
        return false;
    }

    @Override
    public void setOnFinishListener() {
        startActivity(MainActivity.class,true);
    }

    @Override
    public void setSplashData(List<SplashAdBean> result) {
        if(skipTv==null){
            return;
        }
        if(result==null || result.size()==0){
            setNoDataMethod();
            return;
        }
        skipTv.setTotalTime(3000);
        IMImageLoadUtil.CommonSplashImageLoadCp(this, result.get(0).getAdsImgUrl(), iv_bg);
    }

    /**
     * 没有数据，三秒后直接跳转
     */
    private void setNoDataMethod() {
        if(skipTv!=null){
            skipTv.setVisibility(View.GONE);
            skipTv.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(MainActivity.class,true);
                }
            },3000);
        }
    }
}

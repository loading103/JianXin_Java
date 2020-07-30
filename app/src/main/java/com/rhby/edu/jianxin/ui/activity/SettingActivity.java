package com.rhby.edu.jianxin.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.utils.glide.IMGlideCacheUtil;
import com.congda.baselibrary.widget.IMComLinearView;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog;
import com.rhby.edu.jianxin.R;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class SettingActivity extends IMBaseActivity implements SwitchButton.OnCheckedChangeListener {
    @BindView(R.id.common_top)
    IMCommonTitleView commonTitleView;
    @BindView(R.id.sov1)
    IMComLinearView sov1;
    @BindView(R.id.sov2)
    IMComLinearView sov2;
    @BindView(R.id.sov3)
    IMComLinearView sov3;
    @BindView(R.id.sov4)
    IMComLinearView sov4;
    @BindView(R.id.sov5)
    IMComLinearView sov5;
    @BindView(R.id.btn_exit)
    TextView btn_exit;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        commonTitleView.setTopTitle("系统设置");
    }

    @Override
    protected void initListener() {
        SwitchButton switchButton1 = sov1.getSwitchButton();
        switchButton1.setTag(1);
        switchButton1.setOnCheckedChangeListener(this);
        SwitchButton switchButton2 = sov2.getSwitchButton();
        switchButton2.setTag(2);
        switchButton2.setOnCheckedChangeListener(this);
        SwitchButton switchButton3 = sov3.getSwitchButton();
        switchButton3.setTag(3);
        switchButton3.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.sov4,R.id.sov5,R.id.btn_exit})
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.sov4:
                cleanCache();
                break;
            case R.id.sov5:
                break;
            case R.id.btn_exit:
                finish();
                break;
        }
    }

    /**
     * 清楚缓存
     */
    private void cleanCache () {
        IMIosCommonDiglog diglog = new IMIosCommonDiglog(this);
        String cacheSize= IMGlideCacheUtil.getInstance().getCacheSize(this);
        diglog.showCommonDiglog("是否需要清除" + cacheSize + "缓存数据?", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IMGlideCacheUtil.getInstance().clearImageAllCache(SettingActivity.this);
            }
        });
    }

    @Override
    public void onCheckedChanged(SwitchButton view, boolean isChecked) {
        switch ((int) view.getTag()) {
            case 1:
                sov1.getSwitchButton().setChecked(isChecked);
                showChecked(isChecked,1);
                break;
            case 2:
                sov2.getSwitchButton().setChecked(isChecked);
                showChecked(isChecked,2);
                break;
            case 3:
                sov3.getSwitchButton().setChecked(isChecked);
                showChecked(isChecked,3);
                break;
        }
    }


    public void  showChecked(Boolean isChecked,int pos ){
        if(isChecked){
            IMToastUtil.getInstance()._short(String.format("打开%s",pos));
        }else{
            IMToastUtil.getInstance()._short(String.format("%s%s","关闭",pos));
        }
    }
}

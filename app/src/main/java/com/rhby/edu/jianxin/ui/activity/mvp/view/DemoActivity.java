package com.rhby.edu.jianxin.ui.activity.mvp.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.congda.baselibrary.app.IMSConfig;
import com.congda.baselibrary.base.IMBaseMvpActivity;
import com.congda.baselibrary.service.IMBindServiceDemo;
import com.congda.baselibrary.utils.IMSavePhotoUtil;
import com.congda.baselibrary.utils.IMTimePickerUtils;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog;
import com.congda.baselibrary.widget.dialog.IMSheetViewDialog;
import com.congda.baselibrary.widget.dialogfragment.IMLoginAgreeDialog;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.ui.activity.RecycleDemoActivity;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.DemoContract;
import com.rhby.edu.jianxin.ui.activity.mvp.presenter.DemoPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin 创建时间：2020/7/30
 */
public class DemoActivity extends IMBaseMvpActivity<DemoPresenter> implements DemoContract.View, IMSheetViewDialog.Callback {
    @BindView(R.id.commonTitleView)
    IMCommonTitleView commonTitleView;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn10)
    Button btn10;
    @BindView(R.id.btn11)
    Button btn11;
    @BindView(R.id.btn12)
    Button btn12;
    @BindView(R.id.btn13)
    Button btn13;
    @BindView(R.id.iv1)
    ImageView iv1;

    private Boolean isBind;
    private TimePickerView pvTime;
    private ServiceConnection mConn;
    private OptionsPickerView pvOptions;
    private IMBindServiceDemo mServiceDemo;

    @Override
    protected DemoPresenter createPresenter() {
        return new DemoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initView() {
        commonTitleView.setTopTitle("Demo列表");
        commonTitleView.setTopRightText("保存");
    }

    @Override
    protected void initData() {
        //初始化时间选择器
        pvTime=IMTimePickerUtils.getPickView(this);
        //初始化内容联动
        List<String> food =new ArrayList();
        food.add("A");
        food.add("B");
        food.add("C");
        pvOptions= IMTimePickerUtils.getOptionsPickerView(this,food);

    }

    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,
            R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.iv1,R.id.re_top_right})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                btn1OnClick();
                break;
            case R.id.btn2:
                btn2OnClick();
                break;
            case R.id.btn3:
                btn3OnClick();
                break;
            case R.id.btn4:
                btn4OnClick();
                break;
            case R.id.btn5:
                btn5OnClick();
                break;
            case R.id.btn6:
                btn6OnClick();
                break;
            case R.id.btn7:
                btn7OnClick();
                break;
            case R.id.btn8:
                btn8OnClick();
                break;
            case R.id.btn9:
                btn9OnClick();
                break;
            case R.id.btn10:
                btn10OnClick();
                break;
            case R.id.btn11:
                btn11OnClick();
                break;
            case R.id.btn12:
                btn12OnClick();
                break;
            case R.id.btn13:
                btn13OnClick();
                break;
            case R.id.iv1:
                break;
            case R.id.re_top_right:
                IMToastUtil.getInstance()._short("保存");
                break;
        }
    }
    private void btn1OnClick() {
        showLoadingDialog();
        btn1.postDelayed(new Runnable() {
            @Override
            public void run() {
                dissLoadingDialog();
            }
        },2000);
    }

    private void btn2OnClick() {
        mPresenter.showSheetView(this);
    }

    private void btn3OnClick() {
       new IMSheetViewDialog().shows(getSupportFragmentManager(),this);
    }

    private void btn4OnClick() {
        IMIosCommonDiglog diglog =new IMIosCommonDiglog(this);
        diglog.showCommonDiglog("测试测试 心情好", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("测试测试 心情好");
            }
        });
    }

    private void btn5OnClick() {
        mPresenter.showBigImageView(this);
    }

    private void btn6OnClick() {
        Bundle bundle=new Bundle();
        bundle.putString("url","http://baidu.com");
        startActivity(ComWebViewActivity.class,bundle,false);
    }

    private void btn7OnClick() {
        if(!new File(IMSConfig.PICTURI_PATH+"app_logo.jpg").exists()){
            IMSavePhotoUtil.saveDrawableIcon(R.mipmap.app_logo,"app_logo");
        }else{
            showMessage("本地已有图片，不保存");
        }
    }

    private void btn8OnClick() {
        pvTime.show(btn8);
    }

    private void btn9OnClick() {
        pvOptions.show();
    }

    private void btn10OnClick() {
        IMTimePickerUtils.initJsonData(this);
    }

    private void btn11OnClick() {
        startActivity(RecycleDemoActivity.class,false);
    }

    private void btn12OnClick() {
        IMToastUtil.getInstance()._short("开启Service");
        Intent intent =new Intent(DemoActivity.this, IMBindServiceDemo.class);
        mConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IMBindServiceDemo.MyBind bind = (IMBindServiceDemo.MyBind) service;
                mServiceDemo = bind.getService();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        };
        isBind = bindService(intent, mConn, Context.BIND_AUTO_CREATE);
    }

    private void btn13OnClick() {
        IMLoginAgreeDialog loginDiglog = new IMLoginAgreeDialog();
        loginDiglog.show(getSupportFragmentManager(), "LoginAgreeDialogFragment");
    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0:
            case 1:
            case 2:
                IMToastUtil.getInstance()._short(position+"");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService();
    }

    /**
     * 关闭bind服务
     */
    private void stopService() {
        if (isBind) {
            showMessage("关闭Service");
            unbindService(mConn);
            if (mServiceDemo != null) {
                mServiceDemo.stopSelf();
            }
            isBind = false;
        }
    }
}

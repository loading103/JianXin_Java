package com.rhby.edu.jianxin.ui.activity.mvp.view;

import android.content.ServiceConnection;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.congda.baselibrary.base.IMBaseMvpActivity;
import com.congda.baselibrary.service.IMBindServiceDemo;
import com.congda.baselibrary.utils.IMTimePickerUtils;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.DemoContract;
import com.rhby.edu.jianxin.ui.activity.mvp.presenter.DemoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin 创建时间：2020/7/30
 */
public class DemoActivity extends IMBaseMvpActivity<DemoPresenter> implements DemoContract.View{
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
    }

    private void btn2OnClick() {
    }

    private void btn3OnClick() {
    }

    private void btn4OnClick() {
    }

    private void btn5OnClick() {

    }

    private void btn6OnClick() {

    }

    private void btn7OnClick() {

    }

    private void btn8OnClick() {

    }

    private void btn9OnClick() {

    }

    private void btn10OnClick() {

    }

    private void btn11OnClick() {

    }

    private void btn12OnClick() {
    }

    private void btn13OnClick() {
    }
}

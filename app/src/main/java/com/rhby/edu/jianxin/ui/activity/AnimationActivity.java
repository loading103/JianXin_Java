package com.rhby.edu.jianxin.ui.activity;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.utils.IMAnimatorUtil;
import com.congda.baselibrary.utils.IMStopClickFast;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.rhby.edu.jianxin.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class AnimationActivity extends IMBaseActivity {
    @BindView(R.id.commonTitleView)
    IMCommonTitleView commonTitleView;
    @BindView(R.id.tv_anim1)
    CheckedTextView tv_anim1;
    @BindView(R.id.tv_anim2)
    CheckedTextView tv_anim2;
    @BindView(R.id.tv_anim3)
    CheckedTextView tv_anim3;
    @BindView(R.id.tv_anim4)
    CheckedTextView tv_anim4;
    @BindView(R.id.tv_anim5)
    CheckedTextView tv_anim5;
    @BindView(R.id.im_iv_open)
    ImageView im_iv_open;
    @BindView(R.id.im_iv_add)
    ImageView im_iv_add;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;

    private IMAnimatorUtil animtor;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initView() {
        commonTitleView.setTopTitle("基本动画");
    }

    @Override
    protected void initListener() {
        animtor= new IMAnimatorUtil(this);
    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.tv_anim1,R.id.tv_anim2,R.id.tv_anim3,R.id.tv_anim4,R.id.tv_anim5,R.id.tv1})
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.tv_anim1:
                if(IMStopClickFast.isFastClick()){
                    animtor.performAnim(tv_anim1.isChecked(),tv_anim1);
                    tv_anim1.setChecked(!tv_anim1.isChecked());
                }
                break;
            case R.id.tv_anim2:
                animtor.objectAnimation(tv_anim2.isChecked(),lin1);
                tv_anim2.setChecked(!tv_anim2.isChecked());
                break;
            case R.id.tv_anim3:
                animtor.FrameAnimation(im_iv_open);
                break;
            case R.id.tv_anim4:
                animtor.roteAnimation(im_iv_add,tv_anim4.isChecked());
                break;
            case R.id.tv_anim5:
                animtor.translAnimation(lin1,tv_anim5.isChecked());
                tv_anim5.setChecked(!tv_anim5.isChecked());
                break;
            case R.id.tv1:
                IMToastUtil.getInstance()._short("iv1");
                break;
        }
    }
}

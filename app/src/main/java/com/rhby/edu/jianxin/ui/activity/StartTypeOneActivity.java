package com.rhby.edu.jianxin.ui.activity;

import android.text.TextUtils;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.congda.baselibrary.base.IMBaseActivity;
import com.rhby.edu.jianxin.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class StartTypeOneActivity extends IMBaseActivity {
    @BindView(R.id.iv_1)
    ImageView iv_1;
    @BindView(R.id.btn_1)
    Button btn_1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_start_type1;
    }

    @Override
    protected void initView() {
        String type = getIntent().getStringExtra("type");
        if(TextUtils.isEmpty(type)){
            return;
        }
        if(type.equals("3")){
            //分解效果
            getWindow().setEnterTransition( new Explode().setDuration(1500));
            getWindow().setExitTransition( new Explode().setDuration(1500));
        }
        if(type.equals("4")){
            //浅入浅出
            getWindow().setEnterTransition( new Fade().setDuration(1000));
            getWindow().setExitTransition( new Fade().setDuration(1000));
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    @OnClick({R.id.btn_1,R.id.iv_1})
    public void  onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
            case R.id.iv_1:
               onBackPressed();
                break;
        }

    }
}

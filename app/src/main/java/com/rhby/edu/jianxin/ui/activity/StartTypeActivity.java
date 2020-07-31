package com.rhby.edu.jianxin.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.utils.IMStopClickFast;
import com.congda.baselibrary.utils.IMToastUtil;
import com.rhby.edu.jianxin.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class StartTypeActivity extends IMBaseActivity {
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.iv_1)
    ImageView iv_1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_start_type;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.iv_1})
    public void  onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, StartTypeOneActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, iv_1, "iv_1").toBundle());
                break;
            case R.id.btn2:
                Pair pair =new Pair<View, String>(iv_1, "iv_1");
                Pair pairText =new  Pair<View, String>(btn1, "btn_1");
                startActivity(new Intent(this, StartTypeOneActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, pair, pairText).toBundle());
                break;
            case R.id.btn3:
                Intent intent =new Intent(this, StartTypeOneActivity.class);
                intent.putExtra("type","3");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn4:
                Intent intent1 =new Intent(this, StartTypeOneActivity.class);
                intent1.putExtra("type","4");
                startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.iv_1:
                IMToastUtil.getInstance()._short("iv1");
                break;
        }

    }
}

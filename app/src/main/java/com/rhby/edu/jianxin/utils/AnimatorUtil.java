package com.rhby.edu.jianxin.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.congda.baselibrary.utils.IMDensityUtil;
import com.rhby.edu.jianxin.app.MyApplication;


public class AnimatorUtil {

    private long lastTime=0;

    private  AnimationDrawable animationDrawable;

    public AnimatorUtil() {
    }

    /**
     * 帧动画
     */
    @SuppressLint("WrongConstant")
    public    void  FrameAnimation(View view) {
        if(animationDrawable!=null){
            animationDrawable.stop();
            animationDrawable=null;
        }
        animationDrawable = (AnimationDrawable) ((ImageView)view).getDrawable();
        //判断是否在运行
        if(!animationDrawable.isRunning()){
            //开启帧动画
            animationDrawable.setOneShot(true); //为true时 转一次  停留在最后一帧
            animationDrawable.start();
        }else {
            animationDrawable.selectDrawable(0);//暂停时留在第一帧
            animationDrawable.stop();
        }
    }

    public void performAnim(boolean show, View mTvStase){
        //属性动画对象
        ValueAnimator va ; //高度
        ValueAnimator va_alpha ; //透明度
        if(show){
            //显示view，高度从0变到height值
            if(mTvStase.getVisibility()== View.VISIBLE){
                return;
            }
            va = ValueAnimator.ofInt(0, IMDensityUtil.dip2px(MyApplication.getContext(),35));
            va_alpha = ValueAnimator.ofFloat(0, 0.7f);
        }else{
            //隐藏view，高度从height变为0
            if(System.currentTimeMillis()-lastTime<1000){
                return;
            }
            lastTime=System.currentTimeMillis();
            va = ValueAnimator.ofInt(IMDensityUtil.dip2px(MyApplication.getContext(),35),0);
            va_alpha = ValueAnimator.ofFloat(0.7f, 0f);
        }
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取当前的height值
                int h =(Integer)valueAnimator.getAnimatedValue();
                //动态更新view的高度
                mTvStase.getLayoutParams().height = h;
                mTvStase.requestLayout();
            }
        });
        va_alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float alpha =(float)valueAnimator.getAnimatedValue();
                mTvStase.setAlpha(alpha);
            }
        });
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (show) {
                    mTvStase.setVisibility(View.VISIBLE);
                }
                super.onAnimationStart(animation);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!show) {
                    mTvStase.setVisibility(View.GONE);
                }
            }
        });
        va.setDuration(1000);
        va_alpha.setDuration(1000);
        va.start();
        va_alpha.start();
    }



}
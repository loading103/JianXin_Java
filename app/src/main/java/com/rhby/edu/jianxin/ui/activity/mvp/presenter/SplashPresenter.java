package com.rhby.edu.jianxin.ui.activity.mvp.presenter;


import android.os.Handler;

import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.net.BaseObserver;
import com.congda.baselibrary.rx.RxSchedulers;
import com.congda.baselibrary.utils.IMToastUtil;
import com.rhby.edu.jianxin.bean.SplashAdBean;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.SplashContract;
import com.rhby.edu.jianxin.ui.activity.mvp.model.SplashModel;

import java.util.List;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class SplashPresenter extends BasePresenter<SplashContract.Model,SplashContract.View> {

    public Handler handler=new Handler();
    public boolean loadSuccess=false;

    @Override
    protected SplashContract.Model createModel() {
        return new SplashModel();
    }

    public void getSplashData() {
        handlerLoadedFail();
        getModel().getGetAdJson()
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver<List<SplashAdBean>>(getView(),false) {
                    @Override
                    public void onSuccess(List<SplashAdBean>result) {
                        if(loadSuccess){
                            return;
                        }
                        loadSuccess=true;
                        getView().setSplashData(result);
                    }

                    @Override
                    public void onFailure(String code,String errMsg, boolean isNetError) {
                        if(loadSuccess){
                            return;
                        }
                        loadSuccess=true;
                        IMToastUtil.getInstance()._short(errMsg);
                        getView().setSplashData(null);
                    }
                });
    }

    /**
     * 请求接口五秒还没返回，就跳转
     */
    private void handlerLoadedFail() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(loadSuccess){
                    return;
                }
                loadSuccess=true;
                getView().setSplashData(null);
            }
        },5000);
    }
}

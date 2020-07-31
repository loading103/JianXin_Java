package com.rhby.edu.jianxin.ui.fragment.mvp.presenter;

import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.net.BaseObserver;
import com.congda.baselibrary.net.TypeOneBaseHttpResult;
import com.congda.baselibrary.net.TypeOneBaseObserve;
import com.congda.baselibrary.rx.RxSchedulers;
import com.congda.baselibrary.utils.IMToastUtil;
import com.rhby.edu.jianxin.bean.BannerBean;
import com.rhby.edu.jianxin.bean.SplashAdBean;
import com.rhby.edu.jianxin.ui.fragment.mvp.contract.ListFirstContract;
import com.rhby.edu.jianxin.ui.fragment.mvp.model.ListFirstModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class ListFirstPresenter extends BasePresenter<ListFirstContract.Model, ListFirstContract.View>{
    @Override
    protected ListFirstContract.Model createModel() {
        return new ListFirstModel();
    }


    /**
     * 获取banner
     */
    public  void getBannerData() {
        getModel().getBannList()
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new TypeOneBaseObserve<List<BannerBean>>(getView(),false) {
                    @Override
                    public void onSuccess(List<BannerBean>result) {
                        if(result == null){
                            return;
                        }
                        getView().hanedBannerData(result);
                    }

                    @Override
                    public void onFailure(String code,String errMsg, boolean isNetError) {
                        IMToastUtil.getInstance()._short(errMsg);
                    }
                });
    }


   public void getListData() {
        List<String>  list = new ArrayList<>();
       for (int i = 0; i < 30; i++) {
           list.add(String.format("模拟数据%s",i+""));
       }
        getView().hanedListData(list);
    }
}

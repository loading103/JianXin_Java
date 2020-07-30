package com.rhby.edu.jianxin.ui.activity.mvp.presenter;


import com.congda.baselibrary.mvp.BasePresenter;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.DemoContract;
import com.rhby.edu.jianxin.ui.activity.mvp.model.DemoModel;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class DemoPresenter extends BasePresenter<DemoContract.Model,DemoContract.View> {


    @Override
    protected DemoContract.Model createModel() {
        return new DemoModel();
    }

}

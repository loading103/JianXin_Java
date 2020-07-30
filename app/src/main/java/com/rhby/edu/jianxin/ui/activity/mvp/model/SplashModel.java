package com.rhby.edu.jianxin.ui.activity.mvp.model;

import com.congda.baselibrary.mvp.BaseModel;
import com.congda.baselibrary.net.BaseHttpResult;
import com.rhby.edu.jianxin.bean.CommonBean;
import com.rhby.edu.jianxin.bean.SplashAdBean;
import com.rhby.edu.jianxin.bean.VersonBeanData;
import com.rhby.edu.jianxin.net.repository.RetrofitUtils;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.SplashContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class SplashModel extends BaseModel implements SplashContract.Model {

    @Override
    public Observable<BaseHttpResult<List<SplashAdBean>>> getGetAdJson() {
        return RetrofitUtils.getHttpService().httpGetAdJson();
    }

    @Override
    public Observable<BaseHttpResult<VersonBeanData>> CheckedVersion(String systemType) {
        return null;
    }
}

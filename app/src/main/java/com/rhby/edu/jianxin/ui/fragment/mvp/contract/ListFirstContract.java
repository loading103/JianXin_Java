package com.rhby.edu.jianxin.ui.fragment.mvp.contract;

import com.congda.baselibrary.mvp.IModel;
import com.congda.baselibrary.mvp.IView;
import com.congda.baselibrary.net.TypeOneBaseHttpResult;
import com.rhby.edu.jianxin.bean.BannerBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public interface ListFirstContract {
    interface View extends IView {
        void hanedBannerData(List<BannerBean> baseHttpResult);
        void hanedListData(List<String>bean);
    }

    interface Model extends IModel {
        Observable<TypeOneBaseHttpResult<List<BannerBean>>> getBannList();
    }
}

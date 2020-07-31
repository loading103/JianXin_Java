package com.rhby.edu.jianxin.ui.fragment.mvp.model;

import com.congda.baselibrary.mvp.BaseModel;
import com.congda.baselibrary.net.TypeOneBaseHttpResult;
import com.rhby.edu.jianxin.bean.BannerBean;
import com.rhby.edu.jianxin.net.repository.RetrofitUtils;
import com.rhby.edu.jianxin.ui.fragment.mvp.contract.ListFirstContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class ListFirstModel extends BaseModel implements ListFirstContract.Model{
    @Override
    public Observable<TypeOneBaseHttpResult<List<BannerBean>>> getBannList() {
        return  RetrofitUtils.getHttpService().getBanner();
    }
}

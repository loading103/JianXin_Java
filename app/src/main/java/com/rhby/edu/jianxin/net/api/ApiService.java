package com.rhby.edu.jianxin.net.api;

import com.congda.baselibrary.net.BaseHttpResult;
import com.rhby.edu.jianxin.bean.SplashAdBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public interface ApiService {

    @POST("front-ads/get")
    Observable <BaseHttpResult<List<SplashAdBean>>>  httpGetAdJson();
}

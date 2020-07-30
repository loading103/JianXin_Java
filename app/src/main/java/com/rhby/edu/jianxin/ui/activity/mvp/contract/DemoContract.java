package com.rhby.edu.jianxin.ui.activity.mvp.contract;



import com.congda.baselibrary.mvp.IModel;
import com.congda.baselibrary.mvp.IView;
import com.congda.baselibrary.net.BaseHttpResult;
import com.rhby.edu.jianxin.bean.SplashAdBean;
import com.rhby.edu.jianxin.bean.VersonBeanData;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public interface DemoContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
    }

    interface Model extends IModel {

    }
}

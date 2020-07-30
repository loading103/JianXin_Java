package com.congda.baselibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.congda.baselibrary.app.IMBaseApplication;


/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class IMToastUtil {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public IMToastUtil() {

    }

    public static IMToastUtil getInstance() {
        return IMToastUtil.InnerClass.instance;
    }

    public void _short( final String text) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IMBaseApplication.getContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void _long( final String text) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IMBaseApplication.getContext(), text, Toast.LENGTH_LONG).show();
            }
        });
    }

    private static class InnerClass {
        private static IMToastUtil instance = new IMToastUtil();
    }
}

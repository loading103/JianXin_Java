package com.congda.baselibrary.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.congda.baselibrary.app.IMBaseApplication;


/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */

public class IMResourceUtil {

    private static Resources sResources;

    static {
        sResources = IMBaseApplication.getContext().getResources();
    }

    public static String getString(int res) {
        return sResources.getString(res);
    }

    public static Drawable getDrawable(int res) {
        return sResources.getDrawable(res);
    }

    public static int getColor(int res) {
        return sResources.getColor(res);
    }

}

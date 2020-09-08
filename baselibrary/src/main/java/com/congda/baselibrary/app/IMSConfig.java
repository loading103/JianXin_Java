package com.congda.baselibrary.app;

import android.os.Environment;

import java.io.File;

public class IMSConfig {

    public static final String BASE_URL="https://www.wanandroid.com/";
    public static final String BASE_VIDEO_URL="http://47.75.111.156/";
//    public static final String BASE_URL="http://api.teliao.cc/tomato-app/";

    public static final String APP_PACKNAME = "com.rhby.edu.jianxin";

    public static final String BUGLY_APPID = "c08e7834d0";
    /**
     * (本带缓存路径)
     * mnt/sdcard/ 即为SD卡根路径
     */
    public static final String COMMON_PATH = Environment.getExternalStorageDirectory().getPath()+"/jinxin";

    public static final String PICTURI_PATH =   COMMON_PATH+"/photo/";

    public static final String VIDEO_PATH   =   COMMON_PATH+"/video/";

    public static final String FILE_PATH    =   COMMON_PATH+"/file/";

    static {
        File picdir = new File(VIDEO_PATH);
        if (!picdir.exists()) {
            picdir.mkdirs();
        }
        File videodir = new File(PICTURI_PATH);
        if (!videodir.exists()) {
            videodir.mkdirs();
        }
        File filrdir = new File(FILE_PATH);
        if (!filrdir.exists()) {
            filrdir.mkdirs();
        }
    }
}

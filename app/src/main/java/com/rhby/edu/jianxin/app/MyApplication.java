package com.rhby.edu.jianxin.app;


import com.congda.baselibrary.app.IMBaseApplication;

public class MyApplication extends IMBaseApplication {

    private   static  MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
    public static MyApplication getInstance() {
        return instance;
    }
}

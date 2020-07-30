package com.rhby.edu.jianxin.interfaces;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.just.agentweb.AgentWeb;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class AndroidInterface {
    private Handler deliver = new Handler(Looper.getMainLooper());
    private AgentWeb agent;
    private Context context;

    public AndroidInterface(AgentWeb agent, Context context) {
        this.agent = agent;
        this.context = context;
    }

    @JavascriptInterface
    public void ChoosePickure(String token) {

    }

    @JavascriptInterface
    public void recordAudio(final String msg) {
        Log.i("WOLF", "Thread:" + msg);
    }


}

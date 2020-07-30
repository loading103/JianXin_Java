package com.congda.baselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecycleView嵌套RecycleView防止内部RecycleView不能点击滑动
 */
public class IMRecycleView extends RecyclerView {

    public IMRecycleView(@NonNull Context context) {
        super(context);
    }

    public IMRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IMRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //父层ViewGroup不要拦截点击事件
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
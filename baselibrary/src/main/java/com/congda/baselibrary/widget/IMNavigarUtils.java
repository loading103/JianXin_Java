package com.congda.baselibrary.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidx.viewpager.widget.ViewPager;

import com.congda.baselibrary.R;
import com.congda.baselibrary.utils.IMResourceUtil;
import com.congda.baselibrary.utils.IMScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class IMNavigarUtils {
    public Context context;
    private static IMNavigarUtils sInstance;

    public static IMNavigarUtils with(Context context) {
        sInstance = new IMNavigarUtils(context);
        return sInstance;
    }

    public IMNavigarUtils(Context context) {
        this.context = context;
    }

    public CommonNavigator setNavigas(List<String> datas, ViewPager view_pager) {
        CommonNavigator commonNavigator = new CommonNavigator(context);
        CommonNavigatorAdapter adapter = new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                if (datas == null) {
                    return 0;
                } else {
                    return datas.size();
                }
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
//                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context)
                SimplePagerTitleView colorTransitionPagerTitleView = new IMScaleTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setTextSize(16f);
                colorTransitionPagerTitleView.setNormalColor(IMResourceUtil.getColor(R.color.color_666666));
                colorTransitionPagerTitleView.setSelectedColor(IMResourceUtil.getColor(R.color.colorPrimary));
                colorTransitionPagerTitleView.setText(datas.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view_pager.setCurrentItem(index, true);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineHeight((float) UIUtil.dip2px(context, 3.0));
                linePagerIndicator.setLineWidth((float) UIUtil.dip2px(context, 30.0));
                linePagerIndicator.setRoundRadius((float) UIUtil.dip2px(context, 6.0));
                linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                linePagerIndicator.setColors(IMResourceUtil.getColor(R.color.colorPrimary));
                return linePagerIndicator;
            }
        };
        commonNavigator.setAdapter(adapter);
        return commonNavigator;
    }
}

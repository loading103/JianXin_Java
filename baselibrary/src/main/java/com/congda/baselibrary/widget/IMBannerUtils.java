package com.congda.baselibrary.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidx.viewpager.widget.ViewPager;

import com.congda.baselibrary.R;
import com.congda.baselibrary.adapter.ImageBannerAdapter;
import com.congda.baselibrary.utils.IMNumIndicator;
import com.congda.baselibrary.utils.IMResourceUtil;
import com.congda.baselibrary.utils.IMScaleTransitionPagerTitleView;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.util.BannerUtils;

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
public class IMBannerUtils {
    public Context context;
    private static IMBannerUtils sInstance;

    public static IMBannerUtils with(Context context) {
        sInstance = new IMBannerUtils(context);
        return sInstance;
    }

    public IMBannerUtils(Context context) {
        this.context = context;
    }

    public void setBanner(Banner banner, List<String>imgs, OnBannerListener OnBannerListener) {
        banner.setAdapter( new ImageBannerAdapter(imgs))
                //数字指示器
//               .setIndicator(new IMNumIndicator(context))
//               .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                //圆点指示器
                .setIndicator(new CircleIndicator(context))
                .setIndicatorSelectedColorRes(R.color.color_666666)
                .setIndicatorNormalColorRes(R.color.color_f5f5f5)
                .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
                .setIndicatorSpace((int)BannerUtils.dp2px(10f))
                .setIndicatorMargins(new IndicatorConfig.Margins((int)BannerUtils.dp2px(5f)))
                .setIndicatorWidth(20, 20)
                .setOnBannerListener(OnBannerListener)
//              .setPageTransformer(ZoomOutPageTransformer())
                //添加画廊效果(可以和其他PageTransformer组合使用，比如AlphaPageTransformer，注意但和其他带有缩放的PageTransformer会显示冲突)
                .setBannerGalleryEffect(18, 10)
                //添加透明效果(画廊配合透明效果更棒)
                .addPageTransformer(new AlphaPageTransformer())
//              .addOnPageChangeListener(listener2!!)
                .start();
    }
}

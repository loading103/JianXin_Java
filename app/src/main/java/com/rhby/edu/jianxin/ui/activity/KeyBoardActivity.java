package com.rhby.edu.jianxin.ui.activity;

import com.congda.baselibrary.base.IMBaseActivity;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.congda.baselibrary.widget.IMViewPagerEmoji;
import com.rhby.edu.jianxin.R;
import com.congda.baselibrary.bean.IMEmojiBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class KeyBoardActivity extends IMBaseActivity {
    @BindView(R.id.commonTitleView)
    IMCommonTitleView  commonTitleView;
    @BindView(R.id.vp_title)
    IMViewPagerEmoji vp_title;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager;
    }
    @Override
    protected void initView() {
        commonTitleView.setTopTitle("分页标题栏");
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
       List<IMEmojiBean> datas =new ArrayList();
        datas.add(new IMEmojiBean("美食", R.mipmap.ic_category_0));
        datas.add(new IMEmojiBean("电影", R.mipmap.ic_category_1));
        datas.add(new IMEmojiBean("酒店住宿", R.mipmap.ic_category_2));
        datas.add(new IMEmojiBean("生活服务", R.mipmap.ic_category_3));
        datas.add(new IMEmojiBean("KTV", R.mipmap.ic_category_4));
        datas.add(new IMEmojiBean("旅游", R.mipmap.ic_category_5));
        datas.add(new IMEmojiBean("学习培训", R.mipmap.ic_category_6));
        datas.add(new IMEmojiBean("汽车服务", R.mipmap.ic_category_7));
        datas.add(new IMEmojiBean("摄影写真", R.mipmap.ic_category_8));
        datas.add(new IMEmojiBean("休闲娱乐", R.mipmap.ic_category_10));
        datas.add(new IMEmojiBean("丽人", R.mipmap.ic_category_11));
        datas.add(new IMEmojiBean("运动健身", R.mipmap.ic_category_12));
        datas.add(new IMEmojiBean("大保健", R.mipmap.ic_category_13));
        datas.add(new IMEmojiBean("团购", R.mipmap.ic_category_14));
        datas.add(new IMEmojiBean("景点", R.mipmap.ic_category_16));
        datas.add(new IMEmojiBean("全部分类", R.mipmap.ic_category_15));
        datas.add(new IMEmojiBean("休闲娱乐1", R.mipmap.ic_category_10));
        datas.add(new IMEmojiBean("丽人1", R.mipmap.ic_category_11));
        datas.add(new IMEmojiBean("运动健身1", R.mipmap.ic_category_12));
        datas.add(new IMEmojiBean("大保健1", R.mipmap.ic_category_13));
        datas.add(new IMEmojiBean("团购1", R.mipmap.ic_category_14));
        datas.add(new IMEmojiBean("景点1", R.mipmap.ic_category_16));
        datas.add(new IMEmojiBean("全部分类1", R.mipmap.ic_category_15));
        vp_title.setData(this,datas);
    }
}

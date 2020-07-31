package com.rhby.edu.jianxin.ui.fragment.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.congda.baselibrary.base.IMBaseFragment;
import com.congda.baselibrary.base.IMBaseMvpFragment;
import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.utils.IMToastUtil;
import com.congda.baselibrary.widget.IMBannerUtils;
import com.congda.baselibrary.widget.IMCommonTitleView;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.adapter.recycleview.RecycleDemodapter;
import com.rhby.edu.jianxin.bean.BannerBean;
import com.rhby.edu.jianxin.ui.activity.mvp.view.ComWebViewActivity;
import com.rhby.edu.jianxin.ui.fragment.mvp.contract.ListFirstContract;
import com.rhby.edu.jianxin.ui.fragment.mvp.presenter.ListFirstPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class ListFirstFragment extends IMBaseMvpFragment<ListFirstPresenter> implements ListFirstContract.View, OnLoadMoreListener, OnRefreshListener, OnItemClickListener, OnBannerListener {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Banner banner;
    private RecycleDemodapter adapter;
    private List<String> datas=new ArrayList<>();
    private List<BannerBean> bannerdatas=new ArrayList<>();
    @Override
    protected ListFirstPresenter createPresenter() {
        return new ListFirstPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycle_first;
    }

    @Override
    protected void initView() {
        imRefreshUtils.initRefreshMore(refreshLayout,this,this);
        imRefreshUtils.initVRecycle(recyclerView);
        adapter =new RecycleDemodapter();
        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInRight);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        adapterAddView();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getBannerData();
        mPresenter.getListData();
    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加入头部和空布局
     */
    private void adapterAddView() {
        View viewHead  = LayoutInflater.from(getActivity()).inflate(R.layout.layout_banner, null);
        View viewEmept = LayoutInflater.from(getActivity()).inflate(R.layout.layout_recycle_empty, null);
        banner = viewHead.findViewById(R.id.banner);
        adapter.addHeaderView(viewHead);
        adapter.setEmptyView(viewEmept);
    }
    @Override
    public void hanedBannerData(List<BannerBean> bean) {
        bannerdatas = bean;
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < bean.size(); i++) {
            imgs.add(bean.get(i).getImagePath());
        }
        IMBannerUtils.with(getActivity()).setBanner(banner, imgs, this);
    }
    @Override
    public void hanedListData(List<String> bean) {
        datas=bean;
        adapter.setNewData(bean);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh(2000);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        IMToastUtil.getInstance()._short(datas.get(position));
    }

    @Override
    public void OnBannerClick(Object data, int position) {
        Bundle bundle=new Bundle();
        bundle.putString("url", bannerdatas.get(position).getUrl());
        startActivity(ComWebViewActivity.class,bundle,false);
    }

    public void onResume() {
        super.onResume();
        banner.start();
    }

    public void onPause() {
        super.onPause();
        banner.stop();
    }

    public void onDestroy() {
        super.onDestroy();
        banner.destroy();
    }
}

package com.rhby.edu.jianxin.ui.fragment.mvp.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.congda.baselibrary.base.IMBaseMvpFragment;
import com.congda.baselibrary.widget.IMyChatHeadView;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.adapter.recycleview.RecycleSecondapter;
import com.rhby.edu.jianxin.bean.TagsBean;
import com.rhby.edu.jianxin.ui.fragment.mvp.contract.ListScondContract;
import com.rhby.edu.jianxin.ui.fragment.mvp.presenter.ListSecondPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class ListSecondFragment  extends IMBaseMvpFragment<ListSecondPresenter> implements ListScondContract.View, OnRefreshListener {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecycleSecondapter adapter;
    private List<TagsBean> datas = new ArrayList<>();
    @Override
    protected ListSecondPresenter createPresenter() {
        return new ListSecondPresenter();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycle_scound;
    }

    @Override
    protected void initView() {
        refreshLayout.setRefreshHeader(new IMyChatHeadView(getActivity()));
        imRefreshUtils.initRefresh(refreshLayout,this);
        imRefreshUtils.initVRecycle(recyclerView);
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        List<TagsBean> getdata = mPresenter.getdata();
        datas.addAll(getdata);
        adapter=new RecycleSecondapter(datas);
        adapter.setAnimationWithDefault( BaseQuickAdapter.AnimationType.ScaleIn);
//        adapter.setNewData(datas);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh(2000);
        datas.addAll(mPresenter.getdata());
        adapter.notifyDataSetChanged();
    }
}

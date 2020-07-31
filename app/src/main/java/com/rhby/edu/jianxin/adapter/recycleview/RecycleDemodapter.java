package com.rhby.edu.jianxin.adapter.recycleview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rhby.edu.jianxin.R;

public class RecycleDemodapter extends  BaseQuickAdapter<String, BaseViewHolder>  {

    public RecycleDemodapter() {
        super(R.layout.item_recycle_type_first);
    }

    @Override
    protected void convert(BaseViewHolder helper, String bean) {
        helper.setText(R.id.tv_content, bean);
    }

}
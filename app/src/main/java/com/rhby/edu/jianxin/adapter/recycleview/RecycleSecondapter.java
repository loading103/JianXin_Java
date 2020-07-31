package com.rhby.edu.jianxin.adapter.recycleview;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.congda.baselibrary.utils.glide.IMImageLoadUtil;
import com.rhby.edu.jianxin.R;
import com.rhby.edu.jianxin.bean.TagsBean;

import java.util.List;

public class RecycleSecondapter extends BaseMultiItemQuickAdapter<TagsBean, BaseViewHolder> {
    public final int TYPE_ONE =1;
    public final int TYPE_TWO =2;
    public final int TYPE_THREE =3;
    public RecycleSecondapter(List<TagsBean> datas) {
        super(datas);
        addItemType(TYPE_ONE, R.layout.item_recycle_type_first);
        addItemType(TYPE_TWO, R.layout.item_recycle_type_second);
        addItemType(TYPE_THREE, R.layout.item_recycle_type_three);
    }

    @Override
    protected void convert(BaseViewHolder helper, TagsBean bean) {
        if (bean != null) {
            switch(bean.getItemType()){
                case  TYPE_ONE:
                    helper.setText(R.id.tv_content,"第一种布局");
                    break;
                case  TYPE_TWO:
                    helper.setText(R.id.tv_content,"第二种布局");
                    IMImageLoadUtil.CommonImageLoadCp(getContext(),bean.getHeadurl(),helper.getView(R.id.iv_content));
                    break;
                case  TYPE_THREE:
                    helper.setText(R.id.tv_content,"第三种布局");
                    IMImageLoadUtil.CommonImageLoadCp(getContext(),bean.getUrl(),helper.getView(R.id.iv_content));
                    IMImageLoadUtil.CommonImageLoadCp(getContext(),bean.getHeadurl(),helper.getView(R.id.iv_content_2));
                    break;
            }
        }
    }
}
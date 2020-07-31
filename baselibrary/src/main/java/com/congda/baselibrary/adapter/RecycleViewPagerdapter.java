package com.congda.baselibrary.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.congda.baselibrary.R;
import com.congda.baselibrary.bean.IMEmojiBean;
import com.congda.baselibrary.utils.IMToastUtil;

import java.util.ArrayList;
import java.util.List;


public class RecycleViewPagerdapter extends RecyclerView.Adapter<RecycleViewPagerdapter.ViewHolder> {
    private  int  page =-1;
    private int  pageSize =-1;
    private  List<IMEmojiBean>  datas =new ArrayList<>();

    public RecycleViewPagerdapter(Context mcontext, int page, int pageSize, List<IMEmojiBean> datas) {
        this.page = page;
        this.pageSize = pageSize;
        this.datas = datas;
    }
    @Override
    public int getItemCount() {
        if (datas.size() > (page + 1) * pageSize){
            return pageSize;
        }  else {
            return  datas.size() - page * pageSize;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_emoji, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        int pos = position + page * pageSize;
        holder.name.setText(datas.get(pos).getName());
        holder.imageView.setImageResource(datas.get(pos).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IMToastUtil.getInstance()._short(datas.get(pos).getName());
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position + page * pageSize;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.entrance_image);
            name =  itemView.findViewById(R.id.entrance_name);
        }
    }
}
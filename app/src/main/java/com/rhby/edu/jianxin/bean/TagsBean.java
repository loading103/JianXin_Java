package com.rhby.edu.jianxin.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class TagsBean implements Serializable, MultiItemEntity {
    private String name;
    private String url;
    private String headurl;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public TagsBean(String name, String url, String headurl, int type) {
        this.name = name;
        this.url = url;
        this.headurl = headurl;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
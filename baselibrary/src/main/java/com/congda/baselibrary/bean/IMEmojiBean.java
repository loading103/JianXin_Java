package com.congda.baselibrary.bean;

/**
 * @author：jianxin 创建时间：2020/7/31
 */
public class IMEmojiBean {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public IMEmojiBean(String name, int image) {
        this.name = name;
        this.image = image;
    }
}

package com.nsh.articlegure;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */

public class DataGetter {
    private String info, img, likes;

    public DataGetter() {
        this.img = " ";
        this.info = " ";
        this.likes = " ";
    }

    public DataGetter(String img, String likes, String info) {
        this.info = info;
        this.img = img;
        this.likes = likes;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getLikes() {
        return likes;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }


}

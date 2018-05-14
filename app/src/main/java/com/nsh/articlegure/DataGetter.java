package com.nsh.articlegure;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */

public class DataGetter {
    String text,img,like;


    public void DataGetter(String text,String img,String like){
        this.text=text;
        this.img=img;
        this.like=like;
    }

    public void setTex(String text) {
        this.text = text;
    }

    public String getTex() {
        return text;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getLike() {
        return like;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

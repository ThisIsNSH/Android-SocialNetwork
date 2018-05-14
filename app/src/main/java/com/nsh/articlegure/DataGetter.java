package com.nsh.articlegure;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */

public class DataGetter {
    String text,img,likes;


    public void DataGetter(String text,String img,String likes){
        this.text=text;
        this.img=img;
        this.likes=likes;
    }

    public void setTex(String text) {
        this.text = text;
    }

    public String getTex() {
        return text;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getLikes() {
        return likes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

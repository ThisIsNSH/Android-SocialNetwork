package com.nsh.articlegure;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */

public class Feed {

    String info,imgUrl,like;

    public Feed(){}
    public Feed(String info,String imgUrl,String like)
    {
        this.info=info;
        this.imgUrl=imgUrl;
        this.like=like;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public String getLike() {
        return like;
    }
    public String getInfo() {
        return info;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setLike(String like) {
        this.like = like;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}

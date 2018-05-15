package com.nsh.articlegure;

import android.support.annotation.Keep;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */
@IgnoreExtraProperties
@Keep
public class Feed {

    private String info, imgUrl, like;

    public Feed() {
    }

    public Feed(String info, String imgUrl, String like) {
        this.info = info;
        this.imgUrl = imgUrl;
        this.like = like;
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

}

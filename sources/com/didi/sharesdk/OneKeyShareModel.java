package com.didi.sharesdk;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;

public class OneKeyShareModel {
    public Bitmap bitmap;
    public String content;
    public HashMap<String, String> extra;
    public String imgPath;
    public String imgUrl;
    private String mPlatform;
    public String phone = "";
    public List<String> recipients;
    public boolean silent = true;
    public String smsMessage = "";
    public String title;
    public String titleUrl = "";
    public String type = "";
    public String url;

    public OneKeyShareModel(String str) {
        this.mPlatform = str;
    }

    public void setPlatform(String str) {
        this.mPlatform = str;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public String toString() {
        return "OneKeyShareModel{title='" + this.title + '\'' + ", titleUrl='" + this.titleUrl + '\'' + ", content='" + this.content + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", imgPath='" + this.imgPath + '\'' + ", bitmap=" + this.bitmap + ", url='" + this.url + '\'' + ", silent=" + this.silent + ", mPlatform='" + this.mPlatform + '\'' + ", phone='" + this.phone + '\'' + ", smsMessage='" + this.smsMessage + '\'' + '}';
    }
}

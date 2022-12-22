package com.didi.onekeyshare.entity;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class OneKeyShareInfo implements Serializable {
    public String content = "";
    public String customName = "";
    public HashMap<String, String> extra;
    public Bitmap imageData;
    public String imagePath;
    public String imageUrl;
    public String phone = "";
    public SharePlatform platform = SharePlatform.UNKNOWN;
    public List<String> recipients;
    public String smsMessage = "";
    public String title = "";
    public String type;
    public String url;

    public String toString() {
        return "OneKeyShareInfo{platform=" + this.platform + ", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", url='" + this.url + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imagePath='" + this.imagePath + '\'' + ", imageData=" + this.imageData + ", phone='" + this.phone + '\'' + ", smsMessage='" + this.smsMessage + '\'' + ", customName='" + this.customName + '\'' + '}';
    }
}

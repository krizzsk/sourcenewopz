package com.didi.onekeyshare.entity;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ShareInfo implements Serializable {
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_WEB = "web";
    public String content = "";
    public String customName = "";
    public HashMap<String, String> extra;
    public transient Bitmap imageData;
    public String imagePath;
    public String imageUrl;
    public String phone = "";
    public List<SharePlatform> platforms;
    public List<String> recipients;
    public ShareInstrInfo shareInstrInfo;
    public String smsMessage = "";
    public String title = "";
    public String type = "";
    public String url;
}

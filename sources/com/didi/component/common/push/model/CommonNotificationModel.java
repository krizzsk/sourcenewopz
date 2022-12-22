package com.didi.component.common.push.model;

import com.google.gson.annotations.SerializedName;

public class CommonNotificationModel {
    @SerializedName("content")
    public String content;
    @SerializedName("link")
    public String link;
    @SerializedName("title")
    public String title;
}

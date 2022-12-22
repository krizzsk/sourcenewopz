package com.sdk.poibase.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RpcPoiBaseInfoTag implements Serializable {
    @SerializedName("background_color")
    public String background_color;
    @SerializedName("content_color")
    public String content_color;
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public String type;

    public String toString() {
        return "RpcPoiBaseInfoTag{name='" + this.name + '\'' + ", type='" + this.type + '\'' + ", content_color='" + this.content_color + '\'' + ", background_color='" + this.background_color + '\'' + '}';
    }
}

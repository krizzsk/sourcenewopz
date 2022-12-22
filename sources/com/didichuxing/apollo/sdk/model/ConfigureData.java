package com.didichuxing.apollo.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConfigureData implements Serializable {
    @SerializedName("baseUrl")
    private String baseUrl;
    @SerializedName("interval")
    private Integer interval;
    @SerializedName("isLoop")
    private boolean isLoop;
    @SerializedName("nameSpace")
    private String nameSpace;

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer num) {
        this.interval = num;
    }

    public String getNameSpace() {
        return this.nameSpace;
    }

    public void setNameSpace(String str) {
        this.nameSpace = str;
    }

    public boolean getIsLoop() {
        return this.isLoop;
    }

    public void setIsLoop(boolean z) {
        this.isLoop = z;
    }
}

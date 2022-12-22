package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ActionType implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}

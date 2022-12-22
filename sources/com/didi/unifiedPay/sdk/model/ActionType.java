package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ActionType implements Serializable {
    public static final int ACTION_FEE_DOUBT = 5;
    public static final int ACTION_TYPE_CANCEL_RULE = 3;
    public static final int ACTION_TYPE_D_CURRENCY = 4;
    public static final int ACTION_TYPE_ENTERPRISE = 2;
    public static final int ACTION_TYPE_FEE_DETAIL = 1;
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}

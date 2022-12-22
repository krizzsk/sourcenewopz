package com.didi.soda.customer.p165h5.hybird.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* renamed from: com.didi.soda.customer.h5.hybird.model.GuideParamModel */
public class GuideParamModel {
    public static final String ACTION_GET = "get";
    public static final String ACTION_SET = "set";
    @SerializedName("action")
    public String action;
    @SerializedName("itemId")
    public String itemId;
    @SerializedName("params")
    public HashMap<String, String> params;
    @SerializedName("shopId")
    public String shopId;
}

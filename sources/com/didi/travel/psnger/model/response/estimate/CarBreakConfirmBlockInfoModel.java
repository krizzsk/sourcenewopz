package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarBreakConfirmBlockInfoModel implements BffGsonStruct {
    @SerializedName("params")
    public JsonObject params;
    @SerializedName("url")
    public String url;
}

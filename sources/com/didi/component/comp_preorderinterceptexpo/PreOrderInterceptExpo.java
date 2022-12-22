package com.didi.component.comp_preorderinterceptexpo;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class PreOrderInterceptExpo implements BffGsonStruct {
    @SerializedName("com_type")
    public String comType;
    @SerializedName("data")
    public PreOrderInterceptData data;
}

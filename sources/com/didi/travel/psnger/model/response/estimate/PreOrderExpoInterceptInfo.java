package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class PreOrderExpoInterceptInfo implements BffGsonStruct {
    @SerializedName("displayed_scheme")
    public String displayedScheme;
    @SerializedName("intercept_scheme")
    public String interceptScheme;
    public boolean show;
}

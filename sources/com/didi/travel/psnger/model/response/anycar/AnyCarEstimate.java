package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class AnyCarEstimate implements BffGsonStruct {
    @SerializedName("data")
    public AnyCarResponse anyCarResponse;
}

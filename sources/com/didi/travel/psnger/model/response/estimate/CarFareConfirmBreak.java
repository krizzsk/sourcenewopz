package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CarFareConfirmBreak implements BffGsonStruct {
    @SerializedName("cancel")
    public String cancelText = "";
    @SerializedName("confirm")
    public String confirmText = "";
    @SerializedName("fare_text")
    public String farText = "";
    @SerializedName("fare_title")
    public String fareTitle = "";
    @SerializedName("link")
    public String link;
    @SerializedName("link_text")
    public String linkText = "";
}

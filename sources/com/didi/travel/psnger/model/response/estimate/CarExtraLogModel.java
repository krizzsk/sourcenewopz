package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class CarExtraLogModel {
    @SerializedName("dynamic")
    public String dynamic;
    @SerializedName("dynamic_times")
    public String dynamicTimes;
    @SerializedName("eta")
    public String eta;
    @SerializedName("has_tips")
    public String hasTip;
    @SerializedName("origin_fee")
    public String originFee;
    @SerializedName("price_estimated")
    public String priceEstimated;
}

package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class MultiEstimateData {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errorNo;
    @SerializedName("data")
    public EstimateResponse estimateResponse;
}

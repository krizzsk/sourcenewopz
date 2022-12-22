package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class OrderParams {
    @SerializedName("available_status")
    public int availableStatus;
    @SerializedName("bubble_id")
    public String bubbleId;
    @SerializedName("carpool_show")
    public int carPoolShow;
    @SerializedName("combo_id")
    public int comboId;
    @SerializedName("count_price_type")
    public int countPriceType;
    @SerializedName("estimate_price")
    public float feeAmount;
    @SerializedName("scene_type")
    public int sceneType;
    @SerializedName("user_estimate_id")
    public String userEstimateId;
}

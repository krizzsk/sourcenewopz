package com.didi.entrega.customer.foundation.tracker.model;

import com.google.gson.annotations.SerializedName;

public class HomeRealExposureModelV2 {
    @SerializedName("delivery_fee")
    public String deliveryFee;
    @SerializedName("delivery_time")
    public int deliveryTime;
    @SerializedName("delivery_type")
    public int deliveryType;
    @SerializedName("is_coupon_logo")
    public int hasCouponLogo;
    @SerializedName("is_recommend_reason")
    public int hasRecInfo;
    @SerializedName("id")

    /* renamed from: id */
    public String f20047id;
    @SerializedName("location")
    public String location;
    @SerializedName("rec_id")
    public String recId;
    @SerializedName("status")
    public int status;
    @SerializedName("type")
    public String type;
}

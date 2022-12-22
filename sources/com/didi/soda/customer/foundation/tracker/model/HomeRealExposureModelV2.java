package com.didi.soda.customer.foundation.tracker.model;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class HomeRealExposureModelV2 {
    @SerializedName("absolute_position")
    public int absolutePosition;
    @SerializedName("activity_info")
    public JsonArray activityInfos;
    @SerializedName("category_id")
    public String cateId;
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
    public String f41103id;
    @SerializedName("index")
    public int index;
    @SerializedName("is_shop_logo")
    public int isShopLogo;
    @SerializedName("location")
    public String location;
    @SerializedName("module")
    public String module;
    @SerializedName("page")
    public String page;
    @SerializedName("rec_id")
    public String recId;
    @SerializedName("status")
    public int status;
    @SerializedName("type")
    public String type;
}

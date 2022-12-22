package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DeductionInfo implements Serializable {
    public static final int TYPE_COUPON = 1;
    public static final int TYPE_MERCHANT = 9;
    public static final int TYPE_RIGHT_DEDUCTION = 3;
    @SerializedName("activity_id")
    public String activityId;
    @SerializedName("cost")
    public long cost;
    @SerializedName("coupon_id")
    public String couponId;
    @SerializedName("deduction")
    public String deduction;
    public String deduction_id;
    public String info;
    @SerializedName("name")
    public String name;
    @SerializedName("status")
    public int status;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}

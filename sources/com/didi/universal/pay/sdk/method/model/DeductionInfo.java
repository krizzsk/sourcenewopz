package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DeductionInfo implements Serializable {
    public static final int TYPE_COUPON = 1;
    public static final int TYPE_PREPAY = 2;
    public static final int TYPE_RIGHT_DACHEJIN = 6;
    public static final int TYPE_RIGHT_DEDUCTION = 3;
    public static final int TYPE_RIGHT_YUEKA = 5;
    public static final int TYPE_SMOOTH_CARD = 8;
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

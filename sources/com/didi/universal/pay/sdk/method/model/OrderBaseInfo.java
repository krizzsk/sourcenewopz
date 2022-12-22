package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OrderBaseInfo implements Serializable {
    @SerializedName("end_addr")
    public String endAddr;
    @SerializedName("publish_time")
    public long publishTime;
    @SerializedName("should_pay_fee")
    public long shouldPayFee;
    @SerializedName("start_addr")
    public String startAddr;
    @SerializedName("total_fee")
    public long totalFee;
}

package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TransactionFee implements Serializable {
    @SerializedName("actual_pay")
    public long actualPay;
    @SerializedName("actual_pay_display")
    public String actualPayDisplay;
    public boolean enabled;
    @SerializedName("explanation")
    public String explanation;
    @SerializedName("should_pay")
    public long shouldPay;
    @SerializedName("should_pay_display")
    public String shouldPayDisplay;
}

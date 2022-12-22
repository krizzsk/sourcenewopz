package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PayPayModel implements Serializable {
    @SerializedName("app_pay_string")
    public String appPayString;
    @SerializedName("pay_string")
    public String payString;
}

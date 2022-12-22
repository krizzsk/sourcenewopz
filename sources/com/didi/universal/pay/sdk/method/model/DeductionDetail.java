package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;

public class DeductionDetail {
    @SerializedName("fee_id")
    public String deductionId;
    @SerializedName("fee_label")
    public String deductionLabel;
    @SerializedName("fee_type")
    public int deductionType;
    @SerializedName("fee_url")
    public String deductionUrl;
    @SerializedName("fee_value")
    public String deductionValue;
}

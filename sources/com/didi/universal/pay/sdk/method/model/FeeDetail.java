package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FeeDetail {
    @SerializedName("children")
    public List<FeeDetail> childList;
    @SerializedName("fee_info")
    public String feeInfo;
    @SerializedName("fee_label")
    public String feeLabel;
    @SerializedName("fee_type")
    public int feeType;
    @SerializedName("fee_value")
    public String feeValue;
}

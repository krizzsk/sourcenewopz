package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VisaPayModel implements Serializable {
    @SerializedName("isNeedBindCard")
    public boolean isNeedBindCard;
}

package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VisaPayModel implements Serializable {
    @SerializedName("isNeedBindCard")
    public boolean isNeedBindCard;
}

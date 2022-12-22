package com.didi.sdk.global.balance.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class BalanceDetail implements Serializable {
    @SerializedName("currency")
    public String currency;
    @SerializedName("currencySymbol")
    public String currencySymbol;
    @SerializedName("transDetailDesc")
    public String transDetailDesc;
    @SerializedName("transDetailUrl")
    public String transDetailUrl;
    @SerializedName("value")
    public String value;
}

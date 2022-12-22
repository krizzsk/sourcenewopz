package com.didi.sdk.global.balance.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class BalanceAccount implements Serializable {
    @SerializedName("balanceDetail")
    public BalanceDetail balanceDetail;
    @SerializedName("isActive")
    public Boolean isActive;
    @SerializedName("message")
    public String message;
    @SerializedName("rechargeDetail")
    public TopUpMethodDetail topUpMethodDetail;
}

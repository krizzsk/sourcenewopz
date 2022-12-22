package com.didi.sdk.global.balance.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class BalancePageResponse implements Serializable {
    @SerializedName("data")
    public BalanceAccountData data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}

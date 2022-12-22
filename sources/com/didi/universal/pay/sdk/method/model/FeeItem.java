package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FeeItem implements Serializable {
    @SerializedName("amount")
    public long amount;
    @SerializedName("deduction")
    public String deduction;
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public int type;
}

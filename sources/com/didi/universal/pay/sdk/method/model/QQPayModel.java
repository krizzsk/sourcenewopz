package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class QQPayModel implements Serializable {
    @SerializedName("appId")
    public String appId;
    @SerializedName("bargainorId")
    public String bargainorId;
    @SerializedName("nonce")
    public String nonce;
    @SerializedName("sig")
    public String sign;
    @SerializedName("tokenId")
    public String tokenId;
}

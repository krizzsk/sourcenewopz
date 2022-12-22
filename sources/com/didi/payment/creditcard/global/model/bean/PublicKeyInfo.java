package com.didi.payment.creditcard.global.model.bean;

import com.didi.sdk.fastframe.entity.RpcBase;
import com.google.gson.annotations.SerializedName;

public class PublicKeyInfo extends RpcBase {
    @SerializedName("channel_id")
    public int channelId;
    @SerializedName("key")
    public String publicKey;
}

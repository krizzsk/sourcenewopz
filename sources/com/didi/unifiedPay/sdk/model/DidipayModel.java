package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DidipayModel implements Serializable {
    @SerializedName("merchant_id")
    public String merchant_id;
    @SerializedName("nonceStr")
    public String nonceStr;
    @SerializedName("out_trade_no")
    public String out_trade_no;
    @SerializedName("prepayid")
    public String prepayid;
    @SerializedName("sign")
    public String sign;
    @SerializedName("sign_type")
    public String sign_type;
    @SerializedName("timeStamp")
    public String timeStamp;
}

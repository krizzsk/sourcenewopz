package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WeixinPayModel implements Serializable {
    @SerializedName("appid")
    public String appId;
    @SerializedName("noncestr")
    public String nonceStr;
    @SerializedName("package")
    public String packageName;
    @SerializedName("partnerid")
    public String partnerId;
    @SerializedName("prepayid")
    public String prepayId;
    @SerializedName("sign")
    public String sign;
    @SerializedName("timestamp")
    public String timestamp;
}

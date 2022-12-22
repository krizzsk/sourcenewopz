package com.didi.payment.paymethod.server.global.response;

import com.google.gson.annotations.SerializedName;

public class BalanceQueryResp extends BaseResp {
    @SerializedName("apiKey")
    public String apiKey;
    @SerializedName("apiSecret")
    public String apiSecret;
    @SerializedName("balance")
    public String balance;
    @SerializedName("balanceTitle")
    public String balanceTitle;
    @SerializedName("balanceUnit")
    public String balanceUnit;
    @SerializedName("paypayTopupUrl")
    public String paypayTopupUrl;
    @SerializedName("userSignPhone")
    public String userSignPhone;
}

package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletBoletoResp implements Serializable {
    @SerializedName("accountEmail")
    public String accountEmail;
    @SerializedName("amount")
    public BalanceResp.AmountRichInfo amount;
    @SerializedName("createTime")
    public String createTime;
    @SerializedName("currency")
    public String currency;
    @SerializedName("expiryTime")
    public String expiryTime;
    @SerializedName("receiverEmail")
    public String receiverEmail;
    @SerializedName("status")
    public String status;
    @SerializedName("typeableLine")
    public String typeableLine;
    @SerializedName("url")
    public String url;
}

package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletBoletoHistoryResp implements Serializable {
    @SerializedName("data")
    public List<WalletBoletoResp> data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}

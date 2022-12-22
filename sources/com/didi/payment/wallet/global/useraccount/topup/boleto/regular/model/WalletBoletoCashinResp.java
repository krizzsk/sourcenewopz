package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletBoletoCashinResp implements Serializable {
    @SerializedName("data")
    public WalletBoletoResp data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}

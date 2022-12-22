package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletBoletoSendEmailResp implements Serializable {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}

package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AddressPatchResp implements Serializable {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}

package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ListFragmentExtraState implements Serializable {
    @SerializedName("countryCode")
    public String countryCode;

    public ListFragmentExtraState(String str) {
        this.countryCode = str;
    }
}

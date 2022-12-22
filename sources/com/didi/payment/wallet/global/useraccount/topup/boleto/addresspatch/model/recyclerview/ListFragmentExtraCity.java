package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ListFragmentExtraCity implements Serializable {
    @SerializedName("countryCode")
    public String countryCode;
    @SerializedName("stateCode")
    public String stateCode;

    public ListFragmentExtraCity(String str, String str2) {
        this.countryCode = str;
        this.stateCode = str2;
    }
}

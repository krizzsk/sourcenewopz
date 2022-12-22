package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AddressFromZipCodeResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("city")
        public String city;
        @SerializedName("complement")
        public String complement;
        @SerializedName("neighborhood")
        public String neighborhood;
        @SerializedName("number")
        public String number;
        @SerializedName("state")
        public String state;
        @SerializedName("streetName")
        public String streetName;
        @SerializedName("zipCode")
        public String zipCode;
    }
}

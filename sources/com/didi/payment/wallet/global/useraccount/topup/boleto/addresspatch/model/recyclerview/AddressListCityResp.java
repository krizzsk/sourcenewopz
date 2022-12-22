package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AddressListCityResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("cityList")
        public List<String> cityList;
        @SerializedName("countryCode")
        public String countryCode;
        @SerializedName("stateCode")
        public String stateCode;
    }
}

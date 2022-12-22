package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AddressListStateResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("countryCode")
        public String countryCode;
        @SerializedName("stateList")
        public List<StateBean> stateList;
    }

    public static class StateBean implements Serializable {
        @SerializedName("stateCode")
        public String stateCode;
        @SerializedName("stateName")
        public String stateName;
    }
}

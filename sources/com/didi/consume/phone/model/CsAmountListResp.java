package com.didi.consume.phone.model;

import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CsAmountListResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class Amount implements Serializable {
        @SerializedName("amount")
        public String amount;
        public PayRichInfo cashBackAmount;
        @SerializedName("currencySymbol")
        public String currencySymbol;
        public String disabled;
        @SerializedName("metadata")
        public String metadata;
        @SerializedName("payAmount")
        public String payAmount;
        public boolean selected;
    }

    public static class DataBean implements Serializable {
        public PayRichInfo cashBackMessage;
        public String disabledReason;
        @SerializedName("fastPayInfo")
        public FastPayData fastPayData;
        public Boolean fraudStatus;
        @SerializedName("hasCoupons")
        public Boolean hasCoupons;
        @SerializedName("items")
        public List<Amount> items;
    }
}

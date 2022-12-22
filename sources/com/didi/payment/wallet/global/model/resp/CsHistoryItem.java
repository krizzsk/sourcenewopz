package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.view.PayRichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsHistoryItem implements Serializable {
    @SerializedName("afterDiscountAmountDisplay")
    public String afterDiscountAmountDisplay;
    public String amount;
    @SerializedName("cancelTitle")
    public String cancelTitle;
    @SerializedName("cashbackAmountDisplay")
    public String cashbackAmountDisplay;
    @SerializedName("content")
    public PayRichInfo content;
    @SerializedName("couponAmountDisplay")
    public String couponAmountDisplay;
    @SerializedName("couponId")
    public String couponId;
    public String currencySymbol;
    @SerializedName("title")
    public String name;
    public String orderId;
    @SerializedName("longOrderId")
    public String orderIdLong;
    public int orderType;
    @SerializedName("originalAmountDisplay")
    public String originalAmountDisplay;
    @SerializedName("paidBy")
    public String payType;
    @SerializedName("status")
    public PayRichInfo statusDesc;
    @SerializedName("date")
    public String statusTime;

    public String toString() {
        return "title:" + this.name + " oid:" + this.orderId + " datetime= " + this.statusTime;
    }
}

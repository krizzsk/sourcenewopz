package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: NextFeeDetailPayment */
class NextFeeDetailPaymentRaw implements Serializable {
    @SerializedName("isDisplay")
    public int isDisplay;
    @SerializedName("isLatestPayed")
    public int isLatestPayed;
    @SerializedName(alternate = {"act_url"}, value = "payment_act_url")
    public String paymentActUrl;
    @SerializedName("extra_msg")
    public String paymentExtMsg;
    @SerializedName("icon_url")
    public String paymentIconUrl;
    @SerializedName("payment_mode")
    public int paymentMode;
    @SerializedName("payment_name")
    public String paymentName;
    @SerializedName("warn_msg")
    public String paymentWarnMsg;

    NextFeeDetailPaymentRaw() {
    }
}

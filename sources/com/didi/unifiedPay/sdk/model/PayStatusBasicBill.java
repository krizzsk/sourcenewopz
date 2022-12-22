package com.didi.unifiedPay.sdk.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PayStatusBasicBill extends BasicBill {
    @SerializedName("actual_pay_fee")
    public String actualPayFee;
    @SerializedName("actual_pay_fee_display")
    public String actualPayFeeDisplay;
    @SerializedName("payment_method_list")
    public List<PayMethod> paymentMethods;

    public static class PayMethod {
        @SerializedName("channel_name")
        public String channelName;
        @SerializedName("fee_value_display")
        public String feeValueDisplay;
        @SerializedName("icon")
        public String icon;
        @SerializedName("preferential_channel")
        public boolean preferentialChannel;
    }

    public boolean showCrossFee() {
        return !TextUtils.equals(this.actualPayFeeDisplay, this.totalFeeDisplay);
    }
}

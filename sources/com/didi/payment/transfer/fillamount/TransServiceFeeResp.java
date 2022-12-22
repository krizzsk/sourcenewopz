package com.didi.payment.transfer.fillamount;

import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;

public class TransServiceFeeResp extends TransBaseResp {
    public WithDraw data;

    public static class WithDraw {
        @SerializedName("fastPayInfo")
        public FastPayData fastPayData;
        public boolean isSameCpf;
        @SerializedName("maxTransferAmount")
        public int maxTransferAmountInFen;
        public String maxTransferAmountLabel;
        public String symbol;
        public String unableAmountBtnLabel;
        public String unableAmountDesc;
        public String unableAmountLabel;
        public int userAvailableAmount;
        public int userBlockAmount;
        @SerializedName("withdrawFee")
        public int withdrawFeeInFen;
        public String withdrawFeeLabel;
        @SerializedName("withdrawMaxAmount")
        public int withdrawMaxAmountInFen;
        public WithDrawFeeMsg withdrawMg;
        @SerializedName("without99payMaxAmount")
        public int without99payMaxAmountInFen;
    }

    public static class WithDrawFeeMsg {
        public String desc;
        public String redirectUrl;
        public String title;
    }
}

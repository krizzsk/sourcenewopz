package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletCreateOrderResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("orderId")
        public String orderId;
        @SerializedName("outTradeId")
        public String outTradeId;
    }
}

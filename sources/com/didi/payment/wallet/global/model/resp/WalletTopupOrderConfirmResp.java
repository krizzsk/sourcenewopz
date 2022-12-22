package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletTopupOrderConfirmResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        public String orderId;
        public String outTradeId;
        public String subTitle;
        public String title;
    }
}

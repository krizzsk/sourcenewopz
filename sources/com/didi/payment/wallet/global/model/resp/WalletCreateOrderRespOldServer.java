package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletCreateOrderRespOldServer extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("biz_content")
        public String bizContent;
        @SerializedName("sign")
        public String sign;
        @SerializedName("sign_type")
        public String signType;
    }
}

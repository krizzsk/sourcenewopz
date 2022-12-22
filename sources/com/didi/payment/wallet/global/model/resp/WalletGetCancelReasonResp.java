package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletGetCancelReasonResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        public List<Reason> cancelReasons;
        public String subTitle;
        public String title;
    }

    public static class Reason implements Serializable {
        public String content;

        /* renamed from: id */
        public String f31754id;
    }
}

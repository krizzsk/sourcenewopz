package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.view.PayRichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletBalanceHistoryResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("nextIndex")
        public int nextIndex;
        @SerializedName("statement")
        public List<StatementBean> statement;
        @SerializedName("topupBtn")
        public TopUpBtn topupBtn;
    }

    public static class StatementBean implements Serializable {
        @SerializedName("amountText")
        public PayRichInfo amountText;
        @SerializedName("timeStamp")
        public Long time;
        @SerializedName("title")
        public String title;
        @SerializedName("transDate")
        public String transDate;
        @SerializedName("transDateTitle")
        public String transDateTitle;
        @SerializedName("transId")
        public String transId;
    }

    public static class TopUpBtn implements Serializable {
        @SerializedName("link")
        public String link;
        @SerializedName("notice")
        public String notice;
        @SerializedName("text")
        public String text;
    }
}

package com.didi.payment.wallet.global.model.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletBalanceInterestResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("day")
        public InterestSetInfo daySet;
        @SerializedName("meta")
        public MetaInfo metaInfo;
        @SerializedName("month")
        public InterestSetInfo monthSet;
        @SerializedName("total")
        public InterestSetInfo totalSet;
    }

    public static class InterestInfo implements Serializable {
        @SerializedName("amountFen")
        public double amount;
        @SerializedName("items")
        public String[] amountItems;
        @SerializedName("amount")
        public String amountText;
        @SerializedName("date")
        public String date;
    }

    public static class InterestSetInfo implements Serializable {
        @SerializedName("details")
        public InterestInfo[] infoList;
        @SerializedName("startDate")
        public String startDate;
    }

    public static class MetaInfo implements Serializable {
        @SerializedName("endDate")
        public String currentDate;
        @SerializedName("defaultAmount")
        public String defaultAmount;
        @SerializedName("defaultAmountValue")
        public String defaultAmountValue;
        @SerializedName("items_title")
        public String[] interestTitles;
        @SerializedName("introductionTitle")
        public String introductionTitle;
        @SerializedName("introductions")
        public List<String> introductions;
        @SerializedName("symbol")
        public String symbol;
        @SerializedName("symbolAfterValue")
        public int symbolAfterValue;
        @SerializedName("topupBtn")
        public TopUpBtn topupBtn;
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

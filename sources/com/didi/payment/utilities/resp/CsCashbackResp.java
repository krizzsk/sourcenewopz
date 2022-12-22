package com.didi.payment.utilities.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsCashbackResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class AmountFormatted implements Serializable {
        @SerializedName("assembled")
        public String assembled;
        @SerializedName("symbol")
        public String symbol;
        @SerializedName("symbolAfterValue")
        public String symbolAfterValue;
        @SerializedName("value")
        public String value;
    }

    public static class CashBackData implements Serializable {
        @SerializedName("activityId")
        public int activityId;
        @SerializedName("activityType")
        public int activityType;
        @SerializedName("cashbackAmount")
        public int cashbackAmount;
        @SerializedName("cashbackAmountFormatted")
        public AmountFormatted cashbackAmountFormatted;
        @SerializedName("cashbackDisplay")
        public String cashbackDisplay;
    }

    public static class CouponData implements Serializable {
        @SerializedName("activityId")
        public String activityId;
        @SerializedName("activityType")
        public int activityType;
        @SerializedName("afterCouponAmountFormatted")
        public AmountFormatted afterCouponAmountFormatted;
        @SerializedName("batchNo")
        public String batchNo;
        @SerializedName("couponAmount")
        public int couponAmount;
        @SerializedName("couponAmountFormatted")
        public AmountFormatted couponAmountFormatted;
        @SerializedName("couponId")
        public String couponId;
        @SerializedName("utcOffset")
        public int utcOffset;
    }

    public static class DataBean implements Serializable {
        @SerializedName("cashbackData")
        public CashBackData cashbackData;
        @SerializedName("couponData")
        public CouponData couponData;
        @SerializedName("couponLinkUrl")
        public String couponLinkUrl;
        @SerializedName("payAmountFen")
        public int payAmountFen;
        @SerializedName("totalAmount")
        public String totalAmount;
        @SerializedName("totalAmountFen")
        public int totalAmountFen;
        @SerializedName("totalAmountFormatted")
        public AmountFormatted totalAmountFormatted;
    }
}

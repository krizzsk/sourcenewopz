package com.didi.consume.phone.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsVoucherResponse {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("afterCouponAmount")
        public int afterCouponAmount;
        @SerializedName("batchNo")
        public String batchNo;
        @SerializedName("couponAmount")
        public int couponAmount;
        @SerializedName("couponId")
        public String couponId;
        @SerializedName("couponLinkUrl")
        public String couponLinkUrl;
        @SerializedName("currencySymbol")
        public String currencySymbol;
        @SerializedName("formattedAfterCouponAmount")
        public String formattedAfterCouponAmount;
        @SerializedName("formattedCouponAmount")
        public String formattedCouponAmount;
        @SerializedName("formattedOriginalAmount")
        public String formattedOriginalAmount;
        @SerializedName("hasCoupons")
        public boolean hasCoupons;
        public boolean isSelectNoVoucher = false;
        @SerializedName("originalAmount")
        public int originalAmount;
        @SerializedName("utcOffset")
        public int utcOffset;
    }
}

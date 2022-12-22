package com.didi.payment.utilities.resp;

public class CsCouponResp {
    public CsCouponData data;

    public static class CsCouponData {
        public int afterCouponAmount;
        public String batchNo;
        public int couponAmount;
        public String couponId;
        public String couponLinkUrl;
        public String currencySymbol;
        public String formattedAfterCouponAmount;
        public String formattedCouponAmount;
        public String formattedOriginalAmount;
        public boolean hasCoupons;
        public transient boolean isSelectNoVoucher = false;
        public int originalAmount;
        public int utcOffset;
    }
}

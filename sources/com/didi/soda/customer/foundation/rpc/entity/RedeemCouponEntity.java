package com.didi.soda.customer.foundation.rpc.entity;

public class RedeemCouponEntity implements IEntity {
    private static final long serialVersionUID = -5809056130182326903L;
    public String activityId;
    public String batchId;
    public String bindTime;
    public String bindTimeDisplay;
    public String couponAmount;
    public CouponAmountSplitEntity couponAmountSplit;
    public String couponId;
    public int couponType;
    public int couponTypeInt;
    public String currency;
    public int deductionAmount;
    public int discount;
    public String discountDesc;
    public String discountShow;
    public String enableTime;
    public String enableTimeDisplay;
    public String expireTime;
    public String expireTimeDisplay;
    public String img;
    public String invalidLogoUrl;
    public String limitInfo;
    public String logoUrl;
    public String maxAmount;
    public String name;
    public int originalPrice;
    public int payType;
    public String remark;
    public String reserved;
    public int status;

    public static class CouponAmountSplitEntity implements IEntity {
        public static final long serialVersionUID = -1069847671633023007L;
        public String display;
        public String number;
        public int position;
        public String sign;
        public String symbol;
    }
}

package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class CouponEntity implements IEntity {
    private static final long serialVersionUID = 7502098646431781076L;
    public String activityName;
    public String batchId;
    public List<ButtonInfo> buttons;
    public String couponAmount;
    public int couponBusinessType;
    public String couponId;
    public int couponTypeInt;
    public String currency;
    public String currencyMark;
    public String description;
    public String discountDesc;
    public String discountShow;
    public String discountStr;
    public ExpireInfo expireInfo;
    public String expireStr;
    public String extStr;
    public int newUser;
    public String rlCustomLogo;

    public static class ExpireInfo implements IEntity {
        private static final long serialVersionUID = -8082596058637724585L;
        public String note;
        public int style;
    }

    public class ButtonInfo implements IEntity {
        private static final long serialVersionUID = -8082596058637724586L;
        public String redirectUrl;
        public String text;

        public ButtonInfo() {
        }
    }
}

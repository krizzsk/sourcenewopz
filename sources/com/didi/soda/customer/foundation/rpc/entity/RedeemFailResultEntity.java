package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class RedeemFailResultEntity implements IEntity {
    private static final long serialVersionUID = 4183815503796129344L;
    public String bannerImage;
    public String bannerUrl;
    public String contentTitle;
    public List<CouponEntity> couponList;
}

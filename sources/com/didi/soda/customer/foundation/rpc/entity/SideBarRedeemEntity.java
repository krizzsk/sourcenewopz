package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class SideBarRedeemEntity implements IEntity {
    private static final long serialVersionUID = 8192930013942513259L;
    public String bannerContent;
    public String bannerTitle;
    public String bannerUrl;
    public List<RedeemCouponEntity> couponList;
    public String domain;
    public String path;
    public int resultCode;
    public String ridapp;
}

package com.didi.payment.utilities.resp;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;

public class CsOrderCouponModel {
    public int afterCouponAmount;
    public String batchNo;
    public int couponAmount;
    public String couponId;
    public String hasCoupons = SDKConsts.BOOLEAN_FALSE;
    public int originalAmount;
    public int utcOffset;
}

package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "paymentThreeDSDetails")
public class PaymentThreeDSDetails {
    public String auth_details;
    public int channelId;
    public String reference;
    public String shopper;
    public String vendor;
}

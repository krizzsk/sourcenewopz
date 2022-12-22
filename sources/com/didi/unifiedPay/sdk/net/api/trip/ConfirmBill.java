package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "billConfirmPay")
public class ConfirmBill {
    public static final int CONFIRM_TYPE_ACCEPT = 1;
    public static final int CONFIRM_TYPE_NOT_ACCEPT = 2;
    public int action_type;

    public ConfirmBill(int i) {
        this.action_type = i;
    }
}

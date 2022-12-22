package com.didi.universal.pay.sdk.net.api.trip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "billConfirmPay")
public class ConfirmBill implements Serializable {
    public static final int CONFIRM_TYPE_ACCEPT = 1;
    public static final int CONFIRM_TYPE_NOT_ACCEPT = 2;
    public int action_type;

    public ConfirmBill(int i) {
        this.action_type = i;
    }
}

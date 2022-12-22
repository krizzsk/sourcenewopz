package com.didi.universal.pay.sdk.net.api.trip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "getPayStatus")
public class GetPayStatus implements Serializable {
    public String out_token;
    public String out_trade_id;
}

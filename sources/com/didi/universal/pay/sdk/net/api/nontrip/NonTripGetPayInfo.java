package com.didi.universal.pay.sdk.net.api.nontrip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "getPayInfo")
public class NonTripGetPayInfo implements Serializable {
    public String biz_content;
    public String out_trade_id;
    public String sign;
    public String sign_type;
}

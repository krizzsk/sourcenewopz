package com.didi.universal.pay.sdk.net.api.trip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "getPayInfo")
public class GetPayInfo implements Serializable {
    public String out_token;
    public int page_type;
}

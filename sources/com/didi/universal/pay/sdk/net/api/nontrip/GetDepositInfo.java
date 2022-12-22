package com.didi.universal.pay.sdk.net.api.nontrip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "getDepositInfo")
public class GetDepositInfo implements Serializable {
    public String biz_content;
    public String sign;
    public String sign_type;
}

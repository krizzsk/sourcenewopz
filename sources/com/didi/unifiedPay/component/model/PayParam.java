package com.didi.unifiedPay.component.model;

import java.io.Serializable;
import java.util.Map;

public class PayParam implements Serializable {
    public static final PayParam EMPTY_PARAM = new PayParam();
    public int bid;
    public String bizContent;
    public String oid;
    public Map<String, Object> omegaAttrs;
    public String outTradeId;
    public boolean pixPrepay;
    public String sid;
    public String sign;
    public String signType;
}

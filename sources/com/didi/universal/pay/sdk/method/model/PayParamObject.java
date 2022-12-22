package com.didi.universal.pay.sdk.method.model;

import java.io.Serializable;

public class PayParamObject implements Serializable {
    public int channelId;
    public int needPwd;
    public int needSign;
    public SignObj signData;
    public String wxAppId;
}

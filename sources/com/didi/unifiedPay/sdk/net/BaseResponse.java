package com.didi.unifiedPay.sdk.net;

import com.google.gson.JsonElement;
import java.io.Serializable;

public class BaseResponse implements Serializable {
    public JsonElement data;
    public String errmsg;
    public int errno;
}

package com.didi.universal.pay.sdk.net.model;

import com.google.gson.JsonElement;
import java.io.Serializable;

public class BaseResponse implements Serializable {
    public JsonElement data;
    public String errmsg;
    public int errno;
}

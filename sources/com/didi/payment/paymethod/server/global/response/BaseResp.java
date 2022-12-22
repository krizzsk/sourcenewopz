package com.didi.payment.paymethod.server.global.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseResp implements Serializable {
    @SerializedName("errmsg")
    public String errMsg;
    @SerializedName("errno")
    public int errNo;
}

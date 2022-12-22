package com.didi.payment.paymethod.server.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseResponse implements Serializable {
    @SerializedName("errmsg")
    public String errMsg;
    @SerializedName("errno")
    public int errNo;
}

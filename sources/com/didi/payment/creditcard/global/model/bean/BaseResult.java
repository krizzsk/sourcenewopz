package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseResult implements Serializable {
    @SerializedName("errmsg")
    public String errMsg;
    @SerializedName("errno")
    public int errNo;
}

package com.didi.payment.commonsdk.net;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WBaseResp implements Serializable {
    public static final int ERROR_CODE_FAILURE = -900;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public WBaseResp onRequestFail() {
        this.errno = -900;
        this.errmsg = "catch exception when execute request...";
        return this;
    }
}

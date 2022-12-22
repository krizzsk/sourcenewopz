package com.didi.payment.transfer.net;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TransBaseResp implements Serializable {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public void rebuildSelf() {
    }

    public static boolean isValid(TransBaseResp transBaseResp) {
        return transBaseResp != null && transBaseResp.errno == 0;
    }
}

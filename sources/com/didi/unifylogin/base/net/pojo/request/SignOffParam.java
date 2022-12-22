package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SignOffParam extends BaseParam implements Serializable {
    @SerializedName("sign_reason")
    private String signReason;
    private String ticket;

    public SignOffParam(Context context, int i) {
        super(context, i);
    }

    public SignOffParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public SignOffParam setSignReason(String str) {
        this.signReason = str;
        return this;
    }
}

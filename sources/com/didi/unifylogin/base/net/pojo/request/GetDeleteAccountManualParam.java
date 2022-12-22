package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class GetDeleteAccountManualParam extends BaseParam implements Serializable {
    private String ticket;

    public GetDeleteAccountManualParam(Context context, int i) {
        super(context, i);
    }

    public GetDeleteAccountManualParam setTicket(String str) {
        this.ticket = str;
        return this;
    }
}

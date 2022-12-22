package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class ListDeleteAccountReasonsParam extends BaseParam implements Serializable {
    private String ticket;

    public ListDeleteAccountReasonsParam(Context context, int i) {
        super(context, i);
    }

    public ListDeleteAccountReasonsParam setTicket(String str) {
        this.ticket = str;
        return this;
    }
}

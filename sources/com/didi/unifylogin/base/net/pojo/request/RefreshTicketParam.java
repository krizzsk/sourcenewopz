package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class RefreshTicketParam extends BaseParam implements Serializable {
    private int returncell;
    private String ticket;

    public RefreshTicketParam(Context context, int i) {
        super(context, i);
    }

    public RefreshTicketParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public RefreshTicketParam setReturncell(int i) {
        this.returncell = i;
        return this;
    }
}

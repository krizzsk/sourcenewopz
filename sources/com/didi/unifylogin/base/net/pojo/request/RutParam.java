package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class RutParam extends BaseParam implements Serializable {
    private String level;
    private String ticket;

    public RutParam(Context context, int i) {
        super(context, i);
    }

    public RutParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public RutParam setLevel(String str) {
        this.level = str;
        return this;
    }
}

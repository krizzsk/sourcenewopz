package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class LawClickedParam extends BaseParam implements Serializable {
    private String ticket;

    public LawClickedParam(Context context, int i) {
        super(context, i);
    }

    public LawClickedParam setTicket(String str) {
        this.ticket = str;
        return this;
    }
}

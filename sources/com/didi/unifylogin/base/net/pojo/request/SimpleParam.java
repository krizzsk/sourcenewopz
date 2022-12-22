package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class SimpleParam extends BaseParam implements Serializable {
    private String cell;
    private String ticket;

    public SimpleParam(Context context, int i) {
        super(context, i);
    }

    public SimpleParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SimpleParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getTicket() {
        return this.ticket;
    }
}

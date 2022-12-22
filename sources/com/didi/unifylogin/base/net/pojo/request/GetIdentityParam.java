package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class GetIdentityParam extends BaseParam implements Serializable {
    String cell;

    public GetIdentityParam(Context context, int i) {
        super(context, i);
    }

    public GetIdentityParam setCell(String str) {
        this.cell = str;
        return this;
    }
}

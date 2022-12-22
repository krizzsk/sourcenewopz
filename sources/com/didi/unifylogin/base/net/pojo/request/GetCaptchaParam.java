package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class GetCaptchaParam extends BaseParam implements Serializable {
    private String cell;

    public GetCaptchaParam(Context context, int i) {
        super(context, i);
    }

    public GetCaptchaParam setCell(String str) {
        this.cell = str;
        return this;
    }
}

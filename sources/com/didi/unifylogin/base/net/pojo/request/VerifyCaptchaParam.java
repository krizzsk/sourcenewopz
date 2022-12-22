package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class VerifyCaptchaParam extends BaseParam implements Serializable {
    private String captcha_code;
    private String cell;

    public VerifyCaptchaParam(Context context, int i) {
        super(context, i);
    }

    public VerifyCaptchaParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public VerifyCaptchaParam setCaptcha_code(String str) {
        this.captcha_code = str;
        return this;
    }
}

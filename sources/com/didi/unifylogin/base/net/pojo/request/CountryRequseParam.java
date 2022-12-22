package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class CountryRequseParam extends BaseParam implements Serializable {
    private String md5;

    public CountryRequseParam(Context context) {
        super(context, -1);
    }

    public CountryRequseParam setMd5(String str) {
        this.md5 = str;
        return this;
    }
}

package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RegByKeyParam extends BaseParam implements Serializable {
    @SerializedName("reg_key")
    private String regKey;

    public RegByKeyParam(Context context, int i) {
        super(context, i);
    }

    public RegByKeyParam setRegKey(String str) {
        this.regKey = str;
        return this;
    }
}

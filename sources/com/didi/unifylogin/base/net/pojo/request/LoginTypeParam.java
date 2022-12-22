package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LoginTypeParam extends BaseParam implements Serializable {
    @SerializedName("os_type")
    private String osType = "android";

    public LoginTypeParam(Context context, int i) {
        super(context, i);
    }
}

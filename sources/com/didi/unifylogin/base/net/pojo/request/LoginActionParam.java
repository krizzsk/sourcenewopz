package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;

public class LoginActionParam extends SimpleParam {
    @SerializedName("auth_channel")
    public String authChannel;
    @SerializedName("force_code_login")
    public boolean forceCodeLogin;
    @SerializedName("user_type")
    private int usertype;

    public LoginActionParam(Context context, int i) {
        super(context, i);
    }

    public LoginActionParam setUsertype(int i) {
        this.usertype = i;
        return this;
    }

    public int getUsertype() {
        return this.usertype;
    }

    public LoginActionParam setForceCodeLogin(boolean z) {
        this.forceCodeLogin = z;
        return this;
    }

    public LoginActionParam setAuthChannel(String str) {
        this.authChannel = str;
        return this;
    }
}

package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;

public class SetPasswordParamByEmail extends BaseParam {
    private String code;
    private String email;
    private String password;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;

    public SetPasswordParamByEmail(Context context, int i) {
        super(context, i);
    }

    public String getEmail() {
        return this.email;
    }

    public SetPasswordParamByEmail setEmail(String str) {
        this.email = str;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public SetPasswordParamByEmail setPassword(String str) {
        this.password = str;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public SetPasswordParamByEmail setCode(String str) {
        this.code = str;
        return this;
    }
}

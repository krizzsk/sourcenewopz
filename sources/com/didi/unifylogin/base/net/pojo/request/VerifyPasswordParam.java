package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VerifyPasswordParam extends BaseParam implements Serializable {
    private String cell;
    private String password;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;
    private String ticket;

    public VerifyPasswordParam(Context context, int i) {
        super(context, i);
    }

    public VerifyPasswordParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public VerifyPasswordParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public VerifyPasswordParam setPassword(String str) {
        this.password = str;
        return this;
    }

    public VerifyPasswordParam setPasswordEncrypt(int i) {
        this.passwordEncrypt = i;
        return this;
    }
}

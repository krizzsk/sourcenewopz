package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResetPasswordParam extends BaseParam implements Serializable {
    private String cell;
    @SerializedName("new_password")
    private String newPassword;
    private String password;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;
    private String ticket;

    public ResetPasswordParam(Context context, int i) {
        super(context, i);
    }

    public ResetPasswordParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public ResetPasswordParam setPassword(String str) {
        this.password = str;
        return this;
    }

    public ResetPasswordParam setNewPassword(String str) {
        this.newPassword = str;
        return this;
    }

    public ResetPasswordParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public ResetPasswordParam setPasswordEncrypt(int i) {
        this.passwordEncrypt = i;
        return this;
    }
}

package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SetPasswordParam extends BaseParam implements Serializable {
    private String cell;
    @SerializedName("new_password")
    private String newPassword;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;
    private String ticket;

    public SetPasswordParam(Context context, int i) {
        super(context, i);
    }

    public SetPasswordParam setNewPassword(String str) {
        this.newPassword = str;
        return this;
    }

    public SetPasswordParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public SetPasswordParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SetPasswordParam setPasswordEncrypt(int i) {
        this.passwordEncrypt = i;
        return this;
    }
}

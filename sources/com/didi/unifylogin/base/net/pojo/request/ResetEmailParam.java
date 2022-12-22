package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResetEmailParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    @SerializedName("new_email")
    private String newEmail;
    private String ticket;

    public ResetEmailParam(Context context, int i) {
        super(context, i);
    }

    public ResetEmailParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public ResetEmailParam setNewEmail(String str) {
        this.newEmail = str;
        return this;
    }

    public ResetEmailParam setCode(String str) {
        this.code = str;
        return this;
    }

    public ResetEmailParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public ResetEmailParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getCode() {
        return this.code;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getNewEmail() {
        return this.newEmail;
    }
}

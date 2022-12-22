package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DeleteAccountParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    private String ticket;

    public DeleteAccountParam(Context context, int i) {
        super(context, i);
    }

    public DeleteAccountParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public DeleteAccountParam setCode(String str) {
        this.code = str;
        return this;
    }

    public DeleteAccountParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public DeleteAccountParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }
}

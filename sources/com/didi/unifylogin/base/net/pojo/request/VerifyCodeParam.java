package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VerifyCodeParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    private String email;

    public VerifyCodeParam(Context context, int i) {
        super(context, i);
    }

    public VerifyCodeParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public VerifyCodeParam setCode(String str) {
        this.code = str;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public String getEmail() {
        return this.email;
    }

    public VerifyCodeParam setEmail(String str) {
        this.email = str;
        return this;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public VerifyCodeParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }
}

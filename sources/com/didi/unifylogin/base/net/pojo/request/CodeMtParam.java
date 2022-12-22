package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class CodeMtParam extends BaseParam implements Serializable {
    private String cell;
    private int code_type;
    private String email;
    private String os_type = "android";

    public CodeMtParam(Context context, int i) {
        super(context, i);
    }

    public CodeMtParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public CodeMtParam setCodeType(int i) {
        this.code_type = i;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public int getCode_type() {
        return this.code_type;
    }

    public String getEmail() {
        return this.email;
    }

    public CodeMtParam setEmail(String str) {
        this.email = str;
        return this;
    }
}

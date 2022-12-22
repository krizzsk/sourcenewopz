package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SignInByFaceParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    @SerializedName("session_id")
    private String sessionId;

    public SignInByFaceParam(Context context, int i) {
        super(context, i);
    }

    public SignInByFaceParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SignInByFaceParam setCode(String str) {
        this.code = str;
        return this;
    }

    public SignInByFaceParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public SignInByFaceParam setSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getCode() {
        return this.code;
    }
}

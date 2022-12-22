package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SignInByCodeParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    private String email;
    @SerializedName("id_no")
    private String idNum;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("mfa_version")
    private int mfaVersion;
    private String name;
    @SerializedName("sign_reason")
    private String signReason;
    private long uid;
    @SerializedName("verify_session_id")
    private String verifySessionId;

    public SignInByCodeParam setUid(long j) {
        this.uid = j;
        return this;
    }

    public SignInByCodeParam(Context context, int i) {
        super(context, i);
    }

    public SignInByCodeParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SignInByCodeParam setCode(String str) {
        this.code = str;
        return this;
    }

    public SignInByCodeParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public SignInByCodeParam setName(String str) {
        this.name = str;
        return this;
    }

    public SignInByCodeParam setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public SignInByCodeParam setIdNum(String str) {
        this.idNum = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public SignInByCodeParam setEmail(String str) {
        this.email = str;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public SignInByCodeParam setSignReason(String str) {
        this.signReason = str;
        return this;
    }

    public String getVerifySessionId() {
        return this.verifySessionId;
    }

    public SignInByCodeParam setVerifySessionId(String str) {
        this.verifySessionId = str;
        return this;
    }

    public int getMfaVersion() {
        return this.mfaVersion;
    }

    public SignInByCodeParam setMfaVersion(int i) {
        this.mfaVersion = i;
        return this;
    }
}

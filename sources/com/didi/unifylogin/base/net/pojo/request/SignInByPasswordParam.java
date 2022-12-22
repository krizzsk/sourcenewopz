package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SignInByPasswordParam extends BaseParam implements Serializable {
    private String cell;
    private String email;
    @SerializedName("login_type")
    private int loginType;
    @SerializedName("mfa_version")
    private int mfaVersion;
    private String password;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;
    @SerializedName("sign_reason")
    private String signReason;
    @SerializedName("uid")
    private long uid;
    @SerializedName("verify_session_id")
    private String verifySessionId;

    public SignInByPasswordParam(Context context, int i) {
        super(context, i);
    }

    public SignInByPasswordParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SignInByPasswordParam setPassword(String str) {
        this.password = str;
        return this;
    }

    public SignInByPasswordParam setSignReason(String str) {
        this.signReason = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public SignInByPasswordParam setEmail(String str) {
        this.email = str;
        return this;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public SignInByPasswordParam setLoginType(int i) {
        this.loginType = i;
        return this;
    }

    public SignInByPasswordParam setUid(long j) {
        this.uid = j;
        return this;
    }

    public String getVerifySessionId() {
        return this.verifySessionId;
    }

    public SignInByPasswordParam setVerifySessionId(String str) {
        this.verifySessionId = str;
        return this;
    }

    public SignInByPasswordParam setPasswordEncrypt(int i) {
        this.passwordEncrypt = i;
        return this;
    }

    public int getMfaVersion() {
        return this.mfaVersion;
    }

    public SignInByPasswordParam setMfaVersion(int i) {
        this.mfaVersion = i;
        return this;
    }
}

package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;

public class AuthParam extends BaseParam {
    @SerializedName("auth_channel")
    private String authChannel;
    @SerializedName("id_token")
    private String idToken;
    private String method;
    private String operator;
    @SerializedName("sign_reason")
    private String signReason;
    private String ticket;

    public AuthParam(Context context, int i) {
        super(context, i);
    }

    public AuthParam setIdToken(String str) {
        this.idToken = str;
        return this;
    }

    public AuthParam setAuthChannel(String str) {
        this.authChannel = str;
        return this;
    }

    public AuthParam setMethod(String str) {
        this.method = str;
        return this;
    }

    public AuthParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public AuthParam setOperator(String str) {
        this.operator = str;
        return this;
    }

    public AuthParam setSignReason(String str) {
        this.signReason = str;
        return this;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public String getAuthChannel() {
        return this.authChannel;
    }

    public String getMethod() {
        return this.method;
    }

    public String getTicket() {
        return this.ticket;
    }
}

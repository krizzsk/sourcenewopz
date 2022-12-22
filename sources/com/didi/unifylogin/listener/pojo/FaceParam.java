package com.didi.unifylogin.listener.pojo;

public class FaceParam {

    /* renamed from: a */
    private String f44816a;

    /* renamed from: b */
    private String f44817b;

    /* renamed from: c */
    private int f44818c;

    public String getSessionId() {
        return this.f44816a;
    }

    public FaceParam setSessionId(String str) {
        this.f44816a = str;
        return this;
    }

    public String getAccessToken() {
        return this.f44817b;
    }

    public FaceParam setAccessToken(String str) {
        this.f44817b = str;
        return this;
    }

    public void setBizCode(int i) {
        this.f44818c = i;
    }

    public int getBizCode() {
        return this.f44818c;
    }
}

package com.didi.map.global.component.slideCars.api;

public class ClientConfigParam {

    /* renamed from: a */
    private String f26157a;

    /* renamed from: b */
    private String f26158b;

    /* renamed from: c */
    private String f26159c;

    /* renamed from: d */
    private String f26160d;

    /* renamed from: e */
    private int f26161e;

    /* renamed from: f */
    private String f26162f;

    public ClientConfigParam(String str, String str2, String str3, String str4, int i, String str5) {
        this.f26157a = str;
        this.f26158b = str2;
        this.f26159c = str3;
        this.f26160d = str4;
        this.f26161e = i;
        this.f26162f = str5;
    }

    public String getLocale() {
        return this.f26157a;
    }

    public void setLocale(String str) {
        this.f26157a = str;
    }

    public String getMapType() {
        return this.f26158b;
    }

    public void setMapType(String str) {
        this.f26158b = str;
    }

    public String getIdfa() {
        return this.f26159c;
    }

    public void setIdfa(String str) {
        this.f26159c = str;
    }

    public String getOriginId() {
        return this.f26160d;
    }

    public void setOriginId(String str) {
        this.f26160d = str;
    }

    public int getMixFlag() {
        return this.f26161e;
    }

    public void setMixFlag(int i) {
        this.f26161e = i;
    }

    public String getA3Token() {
        return this.f26162f;
    }

    public void setA3Token(String str) {
        this.f26162f = str;
    }
}

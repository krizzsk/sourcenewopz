package com.didi.beatles.p099im.p100db.entity;

/* renamed from: com.didi.beatles.im.db.entity.IMUserDaoEntity */
public class IMUserDaoEntity {

    /* renamed from: a */
    private long f9203a;

    /* renamed from: b */
    private String f9204b;

    /* renamed from: c */
    private String f9205c;

    /* renamed from: d */
    private int f9206d;

    /* renamed from: e */
    private String f9207e;

    /* renamed from: f */
    private String f9208f;

    public IMUserDaoEntity() {
    }

    public IMUserDaoEntity(long j, String str, String str2, int i, String str3, String str4) {
        this.f9203a = j;
        this.f9204b = str;
        this.f9205c = str2;
        this.f9206d = i;
        this.f9207e = str3;
        this.f9208f = str4;
    }

    public long getUser_id() {
        return this.f9203a;
    }

    public void setUser_id(long j) {
        this.f9203a = j;
    }

    public String getUser_name() {
        return this.f9204b;
    }

    public void setUser_name(String str) {
        this.f9204b = str;
    }

    public String getAvatar_url() {
        return this.f9205c;
    }

    public void setAvatar_url(String str) {
        this.f9205c = str;
    }

    public int getM_icon() {
        return this.f9206d;
    }

    public void setM_icon(int i) {
        this.f9206d = i;
    }

    public String getReserveStr1() {
        return this.f9207e;
    }

    public void setReserveStr1(String str) {
        this.f9207e = str;
    }

    public String getReserveStr2() {
        return this.f9208f;
    }

    public void setReserveStr2(String str) {
        this.f9208f = str;
    }
}

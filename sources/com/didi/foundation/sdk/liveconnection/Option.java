package com.didi.foundation.sdk.liveconnection;

import android.content.Context;

public class Option {

    /* renamed from: a */
    private Context f21188a;

    /* renamed from: b */
    private String f21189b;

    /* renamed from: c */
    private String f21190c;

    /* renamed from: d */
    private int f21191d;

    /* renamed from: e */
    private String f21192e;

    /* renamed from: f */
    private int f21193f;

    /* renamed from: g */
    private double f21194g;

    /* renamed from: h */
    private double f21195h;

    /* renamed from: i */
    private int f21196i;

    /* renamed from: j */
    private int f21197j;

    /* renamed from: k */
    private String f21198k;

    public Option() {
    }

    public Option(Context context, String str, String str2, int i, String str3, int i2, double d, double d2, int i3, int i4, String str4) {
        this.f21188a = context;
        this.f21189b = str;
        this.f21190c = str2;
        this.f21191d = i;
        this.f21192e = str3;
        this.f21193f = i2;
        this.f21194g = d;
        this.f21195h = d2;
        this.f21196i = i3;
        this.f21197j = i4;
        this.f21198k = str4;
    }

    public String getAppId() {
        return this.f21198k;
    }

    public Context getContext() {
        return this.f21188a;
    }

    public void setAppId(String str) {
        this.f21198k = str;
    }

    public void setContext(Context context) {
        this.f21188a = context;
    }

    public String getPhone() {
        return this.f21189b;
    }

    public void setPhone(String str) {
        this.f21189b = str;
    }

    public String getToken() {
        return this.f21190c;
    }

    public void setToken(String str) {
        this.f21190c = str;
    }

    public int getRole() {
        return this.f21191d;
    }

    public void setRole(int i) {
        this.f21191d = i;
    }

    public String getIp() {
        return this.f21192e;
    }

    public void setIp(String str) {
        this.f21192e = str;
    }

    public int getPort() {
        return this.f21193f;
    }

    public void setPort(int i) {
        this.f21193f = i;
    }

    public double getLatitude() {
        return this.f21194g;
    }

    public void setLatitude(double d) {
        this.f21194g = d;
    }

    public double getLongitude() {
        return this.f21195h;
    }

    public void setLongitude(double d) {
        this.f21195h = d;
    }

    public int getCityId() {
        return this.f21196i;
    }

    public void setCityId(int i) {
        this.f21196i = i;
    }

    public int getFlowTag() {
        return this.f21197j;
    }

    public void setFlowTag(int i) {
        this.f21197j = i;
    }
}

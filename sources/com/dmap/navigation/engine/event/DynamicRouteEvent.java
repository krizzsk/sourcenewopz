package com.dmap.navigation.engine.event;

public class DynamicRouteEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51878a;

    /* renamed from: b */
    private final String f51879b;

    /* renamed from: c */
    private final String f51880c;

    /* renamed from: d */
    private final int f51881d;

    /* renamed from: e */
    private final int f51882e;

    public DynamicRouteEvent(int i, String str, String str2, int i2, int i3) {
        this.f51878a = i;
        this.f51879b = str;
        this.f51880c = str2;
        this.f51881d = i2;
        this.f51882e = i3;
    }

    public int getOffsetTime() {
        return this.f51878a;
    }

    public String getMoney() {
        return this.f51879b;
    }

    public String getMsg() {
        return this.f51880c;
    }

    public int getType() {
        return this.f51881d;
    }

    public int getAbTest() {
        return this.f51882e;
    }
}

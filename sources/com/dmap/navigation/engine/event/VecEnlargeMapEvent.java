package com.dmap.navigation.engine.event;

import android.graphics.drawable.Drawable;

public class VecEnlargeMapEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51979a;

    /* renamed from: b */
    private final String f51980b;

    /* renamed from: c */
    private final String f51981c;

    /* renamed from: d */
    private Drawable f51982d;

    public VecEnlargeMapEvent(int i, String str, String str2) {
        this.f51979a = i;
        this.f51981c = str;
        this.f51980b = str2;
    }

    public String toString() {
        return "VecEnlargeMapEvent{updateType=" + this.f51979a + ", key='" + this.f51980b + '\'' + ", url='" + this.f51981c + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f51979a;
    }

    public String getKey() {
        return this.f51980b;
    }

    public String getUrl() {
        return this.f51981c;
    }

    public Drawable getDrawable() {
        return this.f51982d;
    }

    public void setDrawable(Drawable drawable) {
        this.f51982d = drawable;
    }
}

package com.dmap.navigation.engine.event;

import android.graphics.drawable.Drawable;

public class EnlargeMapEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51885a;

    /* renamed from: b */
    private final String f51886b;

    /* renamed from: c */
    private final String f51887c;

    /* renamed from: d */
    private Drawable f51888d;

    public EnlargeMapEvent(int i, String str, String str2) {
        this.f51885a = i;
        this.f51886b = str;
        this.f51887c = str2;
    }

    public String toString() {
        return "EnlargeMapEvent{updateType=" + this.f51885a + ", backgroundPicUrl='" + this.f51886b + '\'' + ", arrowPicUrl='" + this.f51887c + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f51885a;
    }

    public String getBackgroundPicUrl() {
        return this.f51886b;
    }

    public String getArrowPicUrl() {
        return this.f51887c;
    }

    public Drawable getDrawable() {
        return this.f51888d;
    }

    public void setDrawable(Drawable drawable) {
        this.f51888d = drawable;
    }
}

package com.didi.map.global.component.slideCars.navigator;

public class CarNavigatorConfigParam {
    public static final int SKIP = 1;
    public static final int SLIDE = 2;

    /* renamed from: a */
    private int f26186a = 2;

    /* renamed from: b */
    private long f26187b;

    /* renamed from: c */
    private boolean f26188c = true;

    /* renamed from: d */
    private boolean f26189d = true;

    /* renamed from: e */
    private boolean f26190e;

    public int getRenderStrategy() {
        return this.f26186a;
    }

    public void setRenderStrategy(int i) {
        this.f26186a = i;
    }

    public long getSlidingTime() {
        return this.f26187b;
    }

    public void setSlidingTime(long j) {
        this.f26187b = j;
    }

    public boolean isFadeAnimInEnable() {
        return this.f26188c;
    }

    public void setFadeAnimInEnable(boolean z) {
        this.f26188c = z;
    }

    public boolean isFadeAnimOutEnable() {
        return this.f26189d;
    }

    public void setFadeAnimOutEnable(boolean z) {
        this.f26189d = z;
    }

    public boolean isAngleSensitive() {
        return this.f26190e;
    }

    public void setAngleSensitive(boolean z) {
        this.f26190e = z;
    }
}

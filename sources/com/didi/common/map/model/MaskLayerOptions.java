package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

@Deprecated
public final class MaskLayerOptions extends IMapElementOptions {

    /* renamed from: a */
    private int f10885a = 0;

    /* renamed from: b */
    private long f10886b = 0;

    public MaskLayerOptions color(int i) {
        this.f10885a = i;
        return this;
    }

    public int getColor() {
        return this.f10885a;
    }

    public MaskLayerOptions animationDuration(long j) {
        this.f10886b = j;
        return this;
    }

    public long getAnimationDuration() {
        return this.f10886b;
    }
}

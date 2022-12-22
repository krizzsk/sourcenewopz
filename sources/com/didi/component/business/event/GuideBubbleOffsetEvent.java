package com.didi.component.business.event;

import androidx.core.util.Pools;
import com.didi.component.common.util.GLog;

public class GuideBubbleOffsetEvent {

    /* renamed from: a */
    private static final String f11300a = "GuideBubbleOffsetEvent";

    /* renamed from: d */
    private static final Pools.SynchronizedPool<GuideBubbleOffsetEvent> f11301d = new Pools.SynchronizedPool<>(2);

    /* renamed from: b */
    private int f11302b;

    /* renamed from: c */
    private int f11303c;

    private GuideBubbleOffsetEvent() {
    }

    public static GuideBubbleOffsetEvent obtain() {
        GuideBubbleOffsetEvent acquire = f11301d.acquire();
        return acquire != null ? acquire : new GuideBubbleOffsetEvent();
    }

    public void recycle() {
        try {
            f11301d.release(this);
        } catch (IllegalStateException e) {
            GLog.m7969e(f11300a, "GuideBubbleOffsetEvent pool recycle", e);
        }
    }

    public void fillData(int i, int i2) {
        this.f11302b = i;
        this.f11303c = i2;
    }

    public int getInitialPixel() {
        return this.f11302b;
    }

    public int getLeftPixel() {
        return this.f11303c;
    }
}

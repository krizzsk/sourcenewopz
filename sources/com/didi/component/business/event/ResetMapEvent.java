package com.didi.component.business.event;

import androidx.core.util.Pools;
import com.didi.common.map.model.Padding;
import com.didi.component.common.util.GLog;

public class ResetMapEvent {

    /* renamed from: a */
    private static final String f11306a = "ResetMapEvent";

    /* renamed from: c */
    private static final Pools.SynchronizedPool<ResetMapEvent> f11307c = new Pools.SynchronizedPool<>(2);

    /* renamed from: b */
    private Padding f11308b;

    private ResetMapEvent() {
    }

    public static ResetMapEvent obtain() {
        ResetMapEvent acquire = f11307c.acquire();
        return acquire != null ? acquire : new ResetMapEvent();
    }

    public void recycle() {
        try {
            f11307c.release(this);
        } catch (IllegalStateException e) {
            GLog.m7969e(f11306a, "ResetMapEvent pool recycle", e);
        }
    }

    public void fillData(int i, int i2, int i3, int i4) {
        Padding padding = this.f11308b;
        if (padding == null) {
            this.f11308b = new Padding(i, i2, i3, i4);
            return;
        }
        padding.left = i;
        this.f11308b.top = i2;
        this.f11308b.right = i3;
        this.f11308b.bottom = i4;
    }

    public Padding getPadding() {
        return this.f11308b;
    }
}

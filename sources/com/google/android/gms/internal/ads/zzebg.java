package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzebg<V> extends zzebd<V> implements zzebt<V> {
    protected zzebg() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbbd */
    public abstract zzebt<? extends V> zzbbc();

    public void addListener(Runnable runnable, Executor executor) {
        zzbbc().addListener(runnable, executor);
    }
}

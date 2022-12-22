package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzebm<V> {
    private final boolean zzicu;
    private final zzdza<zzebt<? extends V>> zzidq;

    private zzebm(boolean z, zzdza<zzebt<? extends V>> zzdza) {
        this.zzicu = z;
        this.zzidq = zzdza;
    }

    public final <C> zzebt<C> zzb(Callable<C> callable, Executor executor) {
        return new zzeav(this.zzidq, this.zzicu, executor, callable);
    }

    /* synthetic */ zzebm(boolean z, zzdza zzdza, zzebk zzebk) {
        this(z, zzdza);
    }
}

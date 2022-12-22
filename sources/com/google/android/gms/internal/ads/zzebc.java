package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzebc<V> extends zzebl<V> {
    zzebc() {
    }

    public static <V> zzebc<V> zzg(zzebt<V> zzebt) {
        if (zzebt instanceof zzebc) {
            return (zzebc) zzebt;
        }
        return new zzebe(zzebt);
    }

    public final <X extends Throwable> zzebc<V> zza(Class<X> cls, zzdxw<? super X, ? extends V> zzdxw, Executor executor) {
        zzeaf zzeaf = new zzeaf(this, cls, zzdxw);
        addListener(zzeaf, zzebv.zza(executor, zzeaf));
        return zzeaf;
    }

    public final <X extends Throwable> zzebc<V> zza(Class<X> cls, zzear<? super X, ? extends V> zzear, Executor executor) {
        zzeag zzeag = new zzeag(this, cls, zzear);
        addListener(zzeag, zzebv.zza(executor, zzeag));
        return zzeag;
    }

    public final zzebc<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzebc) zzebh.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzebc<T> zzb(zzear<? super V, T> zzear, Executor executor) {
        zzdyi.checkNotNull(executor);
        zzeaj zzeaj = new zzeaj(this, zzear);
        addListener(zzeaj, zzebv.zza(executor, zzeaj));
        return zzeaj;
    }

    public final <T> zzebc<T> zza(zzdxw<? super V, T> zzdxw, Executor executor) {
        zzdyi.checkNotNull(zzdxw);
        zzeam zzeam = new zzeam(this, zzdxw);
        addListener(zzeam, zzebv.zza(executor, zzeam));
        return zzeam;
    }
}

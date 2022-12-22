package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzl<T> {
    public Executor executor;
    public T zzgdh;

    public static <T> zzbzl<T> zzb(T t, Executor executor2) {
        return new zzbzl<>(t, executor2);
    }

    public zzbzl(T t, Executor executor2) {
        this.zzgdh = t;
        this.executor = executor2;
    }
}

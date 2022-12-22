package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzesl<T> {
    private final List<zzesn<T>> zzjfg;
    private final List<zzesn<Collection<T>>> zzjfh;

    private zzesl(int i, int i2) {
        this.zzjfg = zzerz.zzil(i);
        this.zzjfh = zzerz.zzil(i2);
    }

    public final zzesl<T> zzau(zzesn<? extends T> zzesn) {
        this.zzjfg.add(zzesn);
        return this;
    }

    public final zzesl<T> zzav(zzesn<? extends Collection<? extends T>> zzesn) {
        this.zzjfh.add(zzesn);
        return this;
    }

    public final zzesj<T> zzbnn() {
        return new zzesj<>(this.zzjfg, this.zzjfh);
    }
}

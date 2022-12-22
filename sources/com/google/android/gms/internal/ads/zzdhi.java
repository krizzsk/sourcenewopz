package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhi<T> implements zzesa<zzdhd<T>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzhgt;

    private zzdhi(zzesn<Executor> zzesn, zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzesn2) {
        this.zzeyl = zzesn;
        this.zzhgt = zzesn2;
    }

    public static <T> zzdhi<T> zzbc(zzesn<Executor> zzesn, zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzesn2) {
        return new zzdhi<>(zzesn, zzesn2);
    }

    public static <T> zzdhd<T> zza(Executor executor, Set<zzdhe<? extends zzdhb<T>>> set) {
        return new zzdhd<>(executor, set);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzhgt.get());
    }
}

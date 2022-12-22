package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddm implements zzesa<zzddh> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzazs> zzhdo;

    private zzddm(zzesn<Executor> zzesn, zzesn<zzazs> zzesn2) {
        this.zzeyl = zzesn;
        this.zzhdo = zzesn2;
    }

    public static zzddm zzat(zzesn<Executor> zzesn, zzesn<zzazs> zzesn2) {
        return new zzddm(zzesn, zzesn2);
    }

    public static zzddh zza(Executor executor, zzazs zzazs) {
        return new zzddh(executor, zzazs);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzhdo.get());
    }
}

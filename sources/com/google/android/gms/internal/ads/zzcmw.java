package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmw implements zzesa<Set<zzbzl<zzbtq>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmy> zzgma;
    private final zzcmo zzgoz;

    private zzcmw(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        this.zzgoz = zzcmo;
        this.zzgma = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcmw zzf(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        return new zzcmw(zzcmo, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(zzcmo.zzf(this.zzgma.get(), this.zzeyl.get()));
    }
}

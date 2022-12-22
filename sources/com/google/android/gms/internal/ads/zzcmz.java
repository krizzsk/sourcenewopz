package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmz implements zzesa<Set<zzbzl<zzdtm>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmy> zzgma;
    private final zzcmo zzgoz;

    private zzcmz(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        this.zzgoz = zzcmo;
        this.zzgma = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcmz zzh(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        return new zzcmz(zzcmo, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(zzcmo.zzh(this.zzgma.get(), this.zzeyl.get()));
    }
}

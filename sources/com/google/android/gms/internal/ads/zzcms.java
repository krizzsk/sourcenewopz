package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcms implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmy> zzgma;
    private final zzcmo zzgoz;

    private zzcms(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        this.zzgoz = zzcmo;
        this.zzgma = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcms zzc(zzcmo zzcmo, zzesn<zzcmy> zzesn, zzesn<Executor> zzesn2) {
        return new zzcms(zzcmo, zzesn, zzesn2);
    }

    public static Set<zzbzl<zzbuj>> zza(zzcmo zzcmo, zzcmy zzcmy, Executor executor) {
        return (Set) zzesg.zzbd(zzcmo.zzc(zzcmy, executor));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgoz, this.zzgma.get(), this.zzeyl.get());
    }
}

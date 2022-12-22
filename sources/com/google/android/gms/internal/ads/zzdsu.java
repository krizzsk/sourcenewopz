package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdsu {
    private final E zzhsw;
    private final List<zzebt<?>> zzhsz;
    private final /* synthetic */ zzdss zzhta;

    private zzdsu(zzdss zzdss, E e, List<zzebt<?>> list) {
        this.zzhta = zzdss;
        this.zzhsw = e;
        this.zzhsz = list;
    }

    public final <O> zzdsy<O> zzb(Callable<O> callable) {
        zzebm<V> zzk = zzebh.zzk(this.zzhsz);
        zzebt<C> zzb = zzk.zzb(zzdsx.zzhez, zzbat.zzekj);
        zzdss zzdss = this.zzhta;
        return new zzdsy(zzdss, this.zzhsw, (String) null, zzb, this.zzhsz, zzk.zzb(callable, zzdss.zzgka), (zzdsv) null);
    }
}

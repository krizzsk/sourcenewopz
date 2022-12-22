package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdsw {
    private final E zzhsw;
    private final /* synthetic */ zzdss zzhta;

    private zzdsw(zzdss zzdss, E e) {
        this.zzhta = zzdss;
        this.zzhsw = e;
    }

    public final <O> zzdsy<O> zze(zzebt<O> zzebt) {
        return new zzdsy(this.zzhta, this.zzhsw, (String) null, zzdss.zzhsu, Collections.emptyList(), zzebt, (zzdsv) null);
    }

    public final <O> zzdsy<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzhta.zzgka);
    }

    private final <O> zzdsy<O> zza(Callable<O> callable, zzebs zzebs) {
        return new zzdsy(this.zzhta, this.zzhsw, (String) null, zzdss.zzhsu, Collections.emptyList(), zzebs.zze(callable), (zzdsv) null);
    }

    public final zzdsy<?> zza(zzdsq zzdsq, zzebs zzebs) {
        return zza(new zzdsz(zzdsq), zzebs);
    }
}

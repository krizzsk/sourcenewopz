package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcap implements zzesa<Set<zzbzl<zzbtm>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcap(zzcak zzcak, zzesn<zzbrx> zzesn) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
    }

    public static zzcap zza(zzcak zzcak, zzesn<zzbrx> zzesn) {
        return new zzcap(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}

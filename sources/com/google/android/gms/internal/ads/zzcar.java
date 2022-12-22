package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcar implements zzesa<Set<zzbzl<zzbxb>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcar(zzcak zzcak, zzesn<zzbrx> zzesn) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
    }

    public static zzcar zzb(zzcak zzcak, zzesn<zzbrx> zzesn) {
        return new zzcar(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}

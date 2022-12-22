package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcax implements zzesa<Set<zzbzl<zzbsy>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcax(zzcak zzcak, zzesn<zzbrx> zzesn) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
    }

    public static zzcax zze(zzcak zzcak, zzesn<zzbrx> zzesn) {
        return new zzcax(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdr.zzb(this.zzfvz.get()));
    }
}

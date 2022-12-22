package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdtj extends zzbxq<zzdtm> implements zzdte<zzdth> {
    zzdtj(Set<zzbzl<zzdtm>> set) {
        super(set);
    }

    public final void zza(zzdst<zzdth, ?> zzdst) {
        zza(new zzdti(zzdst));
    }

    public final void zzb(zzdst<zzdth, ?> zzdst) {
        zza(new zzdtl(zzdst));
    }

    public final void zza(zzdst<zzdth, ?> zzdst, Throwable th) {
        zza(new zzdtk(zzdst, th));
    }

    public final void zzc(zzdst<zzdth, ?> zzdst) {
        zza(new zzdtn(zzdst));
    }
}

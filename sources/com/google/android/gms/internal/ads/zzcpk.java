package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpk implements zzcpp {
    private final zzebs zzgka;
    private final Map<String, zzesn<zzcpp>> zzgrq;
    /* access modifiers changed from: private */
    public final zzbvh zzgrr;

    public zzcpk(Map<String, zzesn<zzcpp>> map, zzebs zzebs, zzbvh zzbvh) {
        this.zzgrq = map;
        this.zzgka = zzebs;
        this.zzgrr = zzbvh;
    }

    public final zzebt<zzdpi> zzh(zzauj zzauj) {
        this.zzgrr.zzd(zzauj);
        zzebt<zzdpi> immediateFailedFuture = zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL));
        for (String trim : ((String) zzww.zzra().zzd(zzabq.zzdav)).split(",")) {
            zzesn zzesn = this.zzgrq.get(trim.trim());
            if (zzesn != null) {
                immediateFailedFuture = zzebh.zzb(immediateFailedFuture, zzcnp.class, new zzcpn(zzesn, zzauj), this.zzgka);
            }
        }
        zzebh.zza(immediateFailedFuture, new zzcpm(this), zzbat.zzekj);
        return immediateFailedFuture;
    }
}

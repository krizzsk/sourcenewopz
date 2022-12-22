package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdrn {
    private HashMap<zzdrf, zzdrm<? extends zzbpc>> zzhro = new HashMap<>();

    public final <AdT extends zzbpc> zzdrm<AdT> zza(zzdrf zzdrf, Context context, zzdqs zzdqs, zzdru<AdT> zzdru) {
        zzdrm<AdT> zzdrm = this.zzhro.get(zzdrf);
        if (zzdrm != null) {
            return zzdrm;
        }
        zzdqy zzdqy = new zzdqy(zzdrc.zza(zzdrf, context));
        zzdrm<AdT> zzdrm2 = new zzdrm<>(zzdqy, new zzdrr(zzdqy, zzdqs, zzdru));
        this.zzhro.put(zzdrf, zzdrm2);
        return zzdrm2;
    }
}

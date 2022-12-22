package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcfk implements zzbtq {
    private final zzcdr zzgeo;
    private final zzcdv zzgfq;

    public zzcfk(zzcdr zzcdr, zzcdv zzcdv) {
        this.zzgeo = zzcdr;
        this.zzgfq = zzcdv;
    }

    public final void onAdImpression() {
        if (this.zzgeo.zzaov() != null) {
            zzbfi zzaou = this.zzgeo.zzaou();
            zzbfi zzaot = this.zzgeo.zzaot();
            if (zzaou == null) {
                zzaou = zzaot != null ? zzaot : null;
            }
            if (this.zzgfq.zzaok() && zzaou != null) {
                zzaou.zza("onSdkImpression", (Map<String, ?>) new ArrayMap());
            }
        }
    }
}

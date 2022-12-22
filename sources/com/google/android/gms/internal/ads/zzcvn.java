package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvn implements zzcta<zzdqd, zzcuv> {
    private final zzckb zzgph;

    public zzcvn(zzckb zzckb) {
        this.zzgph = zzckb;
    }

    public final zzctb<zzdqd, zzcuv> zzf(String str, JSONObject jSONObject) throws zzdpq {
        zzdqd zzd = this.zzgph.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzctb<>(zzd, new zzcuv(), str);
    }
}

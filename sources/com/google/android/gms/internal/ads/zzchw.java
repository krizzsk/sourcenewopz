package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzchw implements zzear {
    private final String zzdkl;
    private final zzchu zzglk;
    private final JSONObject zzgll;

    zzchw(zzchu zzchu, String str, JSONObject jSONObject) {
        this.zzglk = zzchu;
        this.zzdkl = str;
        this.zzgll = jSONObject;
    }

    public final zzebt zzf(Object obj) {
        return this.zzglk.zza(this.zzdkl, this.zzgll, (zzbfi) obj);
    }
}

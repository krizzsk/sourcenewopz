package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbks implements zzbkm {
    private final zzaxx zzedp;

    zzbks(zzaxx zzaxx) {
        this.zzedp = zzaxx;
    }

    public final void zzi(JSONObject jSONObject) {
        int i;
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa") ? 1 : 0;
        }
        this.zzedp.zzdh(i);
    }
}

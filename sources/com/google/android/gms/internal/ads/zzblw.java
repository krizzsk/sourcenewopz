package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblw implements zzesa<JSONObject> {
    private final zzesn<zzdot> zzfvi;

    private zzblw(zzesn<zzdot> zzesn) {
        this.zzfvi = zzesn;
    }

    public static zzblw zzc(zzesn<zzdot> zzesn) {
        return new zzblw(zzesn);
    }

    public final /* synthetic */ Object get() {
        return zzblx.zza(this.zzfvi.get());
    }
}

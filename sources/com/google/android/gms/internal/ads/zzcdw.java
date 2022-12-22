package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdw implements zzesa<zzcdu> {
    private final zzesn<JSONObject> zzflg;
    private final zzesn<zzdot> zzfvi;

    public zzcdw(zzesn<zzdot> zzesn, zzesn<JSONObject> zzesn2) {
        this.zzfvi = zzesn;
        this.zzflg = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcdu(this.zzfvi.get(), this.zzflg.get());
    }
}

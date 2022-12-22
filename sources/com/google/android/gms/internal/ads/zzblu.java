package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzblu implements Runnable {
    private final JSONObject zzfvb;
    private final zzblv zzfvn;

    zzblu(zzblv zzblv, JSONObject jSONObject) {
        this.zzfvn = zzblv;
        this.zzfvb = jSONObject;
    }

    public final void run() {
        this.zzfvn.zzj(this.zzfvb);
    }
}

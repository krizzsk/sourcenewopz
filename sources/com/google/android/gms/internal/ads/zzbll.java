package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbll implements Runnable {
    private final zzbfi zzewn;
    private final JSONObject zzfvb;

    zzbll(zzbfi zzbfi, JSONObject jSONObject) {
        this.zzewn = zzbfi;
        this.zzfvb = jSONObject;
    }

    public final void run() {
        this.zzewn.zzb("AFMA_updateActiveView", this.zzfvb);
    }
}

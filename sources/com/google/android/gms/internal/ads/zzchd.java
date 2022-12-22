package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzchd implements zzqw {
    private final zzbfi zzewn;

    zzchd(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    public final void zza(zzqx zzqx) {
        zzbfi zzbfi = this.zzewn;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqx.zzbrt ? "1" : "0");
        zzbfi.zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }
}

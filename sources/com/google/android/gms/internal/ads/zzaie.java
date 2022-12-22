package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaie implements zzaig<zzbfi> {
    zzaie() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        if (map.keySet().contains("start")) {
            zzbfi.zzbg(true);
        }
        if (map.keySet().contains("stop")) {
            zzbfi.zzbg(false);
        }
    }
}

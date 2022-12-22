package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaif implements zzaig<zzbfi> {
    zzaif() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        if (map.keySet().contains("start")) {
            zzbfi.zzaef().zzadt();
        } else if (map.keySet().contains("stop")) {
            zzbfi.zzaef().zzadu();
        } else if (map.keySet().contains("cancel")) {
            zzbfi.zzaef().zzadv();
        }
    }
}

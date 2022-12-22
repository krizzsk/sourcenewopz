package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaic implements zzaig<zzbfi> {
    zzaic() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbfi.zzkr();
        } else if ("resume".equals(str)) {
            zzbfi.zzks();
        }
    }
}

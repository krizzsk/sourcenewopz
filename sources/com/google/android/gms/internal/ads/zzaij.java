package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaij implements zzaig<zzbfi> {
    private final zzaii zzdja;

    public zzaij(zzaii zzaii) {
        this.zzdja = zzaii;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzd.zzc("Fail to parse float", e);
        }
        this.zzdja.zzac(equals);
        this.zzdja.zza(equals2, f);
        zzbfi.zzac(equals);
    }
}

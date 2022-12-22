package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzarb {
    private final zzbfi zzdkm;
    private final boolean zzdrg;
    private final String zzdrh;

    public zzarb(zzbfi zzbfi, Map<String, String> map) {
        this.zzdkm = zzbfi;
        this.zzdrh = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdrg = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdrg = true;
        }
    }

    public final void execute() {
        int i;
        if (this.zzdkm == null) {
            zzd.zzez("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdrh)) {
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdrh)) {
            i = 6;
        } else if (this.zzdrg) {
            i = -1;
        } else {
            i = zzr.zzkx().zzzv();
        }
        this.zzdkm.setRequestedOrientation(i);
    }
}

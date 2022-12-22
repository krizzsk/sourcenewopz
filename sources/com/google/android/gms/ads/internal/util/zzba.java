package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzba implements zzaj {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ zzbb zzeil;

    zzba(zzay zzay, String str, zzbb zzbb) {
        this.zzeik = str;
        this.zzeil = zzbb;
    }

    public final void zzd(zzap zzap) {
        String str = this.zzeik;
        String zzap2 = zzap.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzap2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzap2);
        zzd.zzez(sb.toString());
        this.zzeil.zzb(null);
    }
}

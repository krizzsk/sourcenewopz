package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdhg implements Runnable {
    private final zzdhe zzhgn;
    private final long zzhgo;

    zzdhg(zzdhe zzdhe, long j) {
        this.zzhgn = zzdhe;
        this.zzhgo = j;
    }

    public final void run() {
        zzdhe zzdhe = this.zzhgn;
        long j = this.zzhgo;
        String canonicalName = zzdhe.getClass().getCanonicalName();
        long elapsedRealtime = zzr.zzlc().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzd.zzed(sb.toString());
    }
}

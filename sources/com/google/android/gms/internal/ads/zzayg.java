package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayg implements Runnable {
    private final String zzdmx;
    private final zzayd zzedj;
    private final zzayd.zza zzedk;

    zzayg(zzayd zzayd, zzayd.zza zza, String str) {
        this.zzedj = zzayd;
        this.zzedk = zza;
        this.zzdmx = str;
    }

    public final void run() {
        this.zzedj.zza(this.zzedk, this.zzdmx);
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzalq implements zzbbg {
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlh;

    zzalq(zzale zzale, zzalz zzalz) {
        this.zzdlf = zzale;
        this.zzdlh = zzalz;
    }

    public final void run() {
        synchronized (this.zzdlf.lock) {
            int unused = this.zzdlf.status = 1;
            zzd.zzed("Failed loading new engine. Marking new engine destroyable.");
            this.zzdlh.zzuy();
        }
    }
}

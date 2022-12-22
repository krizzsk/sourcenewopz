package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmu implements Runnable {
    private final /* synthetic */ zzms zzbdv;

    zzmu(zzms zzms) {
        this.zzbdv = zzms;
    }

    public final void run() {
        if (!this.zzbdv.zzagd) {
            this.zzbdv.zzbei.zza(this.zzbdv);
        }
    }
}

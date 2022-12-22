package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzro implements Runnable {
    private final /* synthetic */ zzrp zzbtl;

    zzro(zzrp zzrp) {
        this.zzbtl = zzrp;
    }

    public final void run() {
        synchronized (this.zzbtl.lock) {
            if (!this.zzbtl.foreground || !this.zzbtl.zzbtm) {
                zzd.zzdz("App is still foreground");
            } else {
                boolean unused = this.zzbtl.foreground = false;
                zzd.zzdz("App went background");
                for (zzrr zzq : this.zzbtl.zzbtn) {
                    try {
                        zzq.zzq(false);
                    } catch (Exception e) {
                        zzbao.zzc("", e);
                    }
                }
            }
        }
    }
}

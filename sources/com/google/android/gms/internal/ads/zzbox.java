package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbox implements zzbuj, zzqw {
    private final zzdot zzftr;
    private final zzbtl zzfye;
    private final zzbun zzfyf;
    private final AtomicBoolean zzfyg = new AtomicBoolean();
    private final AtomicBoolean zzfyh = new AtomicBoolean();

    public zzbox(zzdot zzdot, zzbtl zzbtl, zzbun zzbun) {
        this.zzftr = zzdot;
        this.zzfye = zzbtl;
        this.zzfyf = zzbun;
    }

    public final synchronized void onAdLoaded() {
        if (this.zzftr.zzhma != 1) {
            zzali();
        }
    }

    public final void zza(zzqx zzqx) {
        if (this.zzftr.zzhma == 1 && zzqx.zzbrt) {
            zzali();
        }
        if (zzqx.zzbrt && this.zzfyh.compareAndSet(false, true)) {
            this.zzfyf.zzamk();
        }
    }

    private final void zzali() {
        if (this.zzfyg.compareAndSet(false, true)) {
            this.zzfye.onAdImpression();
        }
    }
}

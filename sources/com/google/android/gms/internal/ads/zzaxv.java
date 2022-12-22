package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaxv {
    private final zzayd zzbrf;
    private final zzf zzecl;

    zzaxv(zzf zzf, zzayd zzayd) {
        this.zzecl = zzf;
        this.zzbrf = zzayd;
    }

    public final void zzdg(int i) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcpd)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
                this.zzecl.zzdk(-1);
            } else {
                this.zzecl.zzdk(i);
            }
            zzxo();
        }
    }

    public final void zzxo() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
            this.zzbrf.isInitialized();
        }
    }
}

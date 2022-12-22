package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrp implements zzbsz, zzbuj {
    private static final Object zzgte = new Object();
    private static int zzgtf = 0;
    private final zzf zzeci;
    private final zzcru zzgtg;

    public zzcrp(zzcru zzcru, zzf zzf) {
        this.zzgtg = zzcru;
        this.zzeci = zzf;
    }

    public final void onAdLoaded() {
        zzbm(true);
    }

    public final void zzd(zzvh zzvh) {
        zzbm(false);
    }

    private static boolean zzasq() {
        boolean z;
        synchronized (zzgte) {
            z = zzgtf < ((Integer) zzww.zzra().zzd(zzabq.zzcyu)).intValue();
        }
        return z;
    }

    private final void zzbm(boolean z) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && !this.zzeci.zzzn() && zzasq()) {
            this.zzgtg.zzbm(z);
            synchronized (zzgte) {
                zzgtf++;
            }
        }
    }
}

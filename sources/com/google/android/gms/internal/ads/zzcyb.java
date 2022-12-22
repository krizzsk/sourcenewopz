package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcyb implements zzbuf {
    private final /* synthetic */ zzctb zzgyr;
    private boolean zzgzg = false;
    private final /* synthetic */ zzbbe zzgzh;
    private final /* synthetic */ zzcxw zzgzi;

    zzcyb(zzcxw zzcxw, zzctb zzctb, zzbbe zzbbe) {
        this.zzgzi = zzcxw;
        this.zzgyr = zzctb;
        this.zzgzh = zzbbe;
    }

    public final void onAdFailedToLoad(int i) {
        if (!this.zzgzg) {
            zzm(new zzvh(i, zzcxw.zza(this.zzgyr.zzcja, i), "undefined", (zzvh) null, (IBinder) null));
        }
    }

    public final synchronized void zzf(int i, String str) {
        if (!this.zzgzg) {
            this.zzgzg = true;
            if (str == null) {
                str = zzcxw.zza(this.zzgyr.zzcja, i);
            }
            zzm(new zzvh(i, str, "undefined", (zzvh) null, (IBinder) null));
        }
    }

    public final synchronized void zzd(zzvh zzvh) {
        this.zzgzg = true;
        zzm(zzvh);
    }

    private final void zzm(zzvh zzvh) {
        zzdqj zzdqj = zzdqj.INTERNAL_ERROR;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxe)).booleanValue()) {
            zzdqj = zzdqj.NO_FILL;
        }
        this.zzgzh.setException(new zzctd(zzdqj, zzvh));
    }

    public final synchronized void onAdLoaded() {
        this.zzgzh.set(null);
    }
}

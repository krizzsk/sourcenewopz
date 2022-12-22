package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrs implements zzdtm {
    private final zzcrr zzgto;

    zzcrs(zzcrr zzcrr) {
        this.zzgto = zzcrr;
    }

    public final void zza(zzdth zzdth, String str) {
    }

    public final void zzb(zzdth zzdth, String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdth) {
            this.zzgto.zzff(zzr.zzlc().elapsedRealtime());
        }
    }

    public final void zza(zzdth zzdth, String str, Throwable th) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdth && this.zzgto.zzass() != 0) {
            this.zzgto.zzep(zzr.zzlc().elapsedRealtime() - this.zzgto.zzass());
        }
    }

    public final void zzc(zzdth zzdth, String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdth && this.zzgto.zzass() != 0) {
            this.zzgto.zzep(zzr.zzlc().elapsedRealtime() - this.zzgto.zzass());
        }
    }
}

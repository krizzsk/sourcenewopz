package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcll implements zzdtm {
    private zztz zzgnj;
    private Map<zzdth, zzcln> zzgnr;

    zzcll(zztz zztz, Map<zzdth, zzcln> map) {
        this.zzgnr = map;
        this.zzgnj = zztz;
    }

    public final void zza(zzdth zzdth, String str) {
    }

    public final void zzb(zzdth zzdth, String str) {
        if (this.zzgnr.containsKey(zzdth)) {
            this.zzgnj.zza(this.zzgnr.get(zzdth).zzgnt);
        }
    }

    public final void zza(zzdth zzdth, String str, Throwable th) {
        if (this.zzgnr.containsKey(zzdth)) {
            this.zzgnj.zza(this.zzgnr.get(zzdth).zzgnv);
        }
    }

    public final void zzc(zzdth zzdth, String str) {
        if (this.zzgnr.containsKey(zzdth)) {
            this.zzgnj.zza(this.zzgnr.get(zzdth).zzgnu);
        }
    }
}

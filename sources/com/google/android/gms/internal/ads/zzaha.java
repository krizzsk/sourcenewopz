package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaha extends zzagb {
    private final /* synthetic */ zzagy zzdhr;

    private zzaha(zzagy zzagy) {
        this.zzdhr = zzagy;
    }

    public final void zza(zzafo zzafo, String str) {
        if (this.zzdhr.zzdhp != null) {
            this.zzdhr.zzdhp.onCustomClick(this.zzdhr.zzb(zzafo), str);
        }
    }
}

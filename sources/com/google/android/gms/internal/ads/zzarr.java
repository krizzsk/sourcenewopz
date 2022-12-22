package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzarr extends zzagb {
    private final /* synthetic */ zzarp zzdsc;

    private zzarr(zzarp zzarp) {
        this.zzdsc = zzarp;
    }

    public final void zza(zzafo zzafo, String str) {
        if (this.zzdsc.zzdsa != null) {
            this.zzdsc.zzdsa.onCustomClick(this.zzdsc.zzc(zzafo), str);
        }
    }
}

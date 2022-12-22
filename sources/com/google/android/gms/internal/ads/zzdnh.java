package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdnh implements zzdma {
    private final String zzdkl;
    private final String zzdmx;
    private final zzavd zzgbs;

    zzdnh(zzavd zzavd, String str, String str2) {
        this.zzgbs = zzavd;
        this.zzdkl = str;
        this.zzdmx = str2;
    }

    public final void zzp(Object obj) {
        zzavd zzavd = this.zzgbs;
        ((zzawo) obj).zza(new zzaxb(zzavd.getType(), zzavd.getAmount()), this.zzdkl, this.zzdmx);
    }
}

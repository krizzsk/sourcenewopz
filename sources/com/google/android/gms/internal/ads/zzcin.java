package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcin implements zzaiw {
    private final zzbty zzfzc;
    private final zzavy zzgmc;
    private final String zzgmd;
    private final String zzgme;

    public zzcin(zzbty zzbty, zzdot zzdot) {
        this.zzfzc = zzbty;
        this.zzgmc = zzdot.zzdxw;
        this.zzgmd = zzdot.zzdoh;
        this.zzgme = zzdot.zzdoi;
    }

    public final void zzul() {
        this.zzfzc.onRewardedVideoStarted();
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzavy zzavy) {
        int i;
        String str;
        zzavy zzavy2 = this.zzgmc;
        if (zzavy2 != null) {
            zzavy = zzavy2;
        }
        if (zzavy != null) {
            str = zzavy.type;
            i = zzavy.zzean;
        } else {
            str = "";
            i = 1;
        }
        this.zzfzc.zzb(new zzavb(str, i), this.zzgmd, this.zzgme);
    }

    public final void zzum() {
        this.zzfzc.onRewardedVideoCompleted();
    }
}

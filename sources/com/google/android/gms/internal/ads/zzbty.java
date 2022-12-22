package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbty extends zzbxq<zzbsy> {
    public zzbty(Set<zzbzl<zzbsy>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbtx.zzgbn);
    }

    public final void onAdLeftApplication() {
        zza(zzbua.zzgbn);
    }

    public final void onAdOpened() {
        zza(zzbtz.zzgbn);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbuc.zzgbn);
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
        zza(new zzbub(zzavd, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbue.zzgbn);
    }
}

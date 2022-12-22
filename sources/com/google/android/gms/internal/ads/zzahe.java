package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzahe extends zzafv {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdht;

    public zzahe(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdht = onAppInstallAdLoadedListener;
    }

    public final void zza(zzafg zzafg) {
        this.zzdht.onAppInstallAdLoaded(new zzafl(zzafg));
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzahi extends zzagk {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzdhz;

    public zzahi(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzdhz = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzags zzags) {
        this.zzdhz.onUnifiedNativeAdLoaded(new zzagx(zzags));
    }
}

package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzaeh;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzf implements zzaeh {
    private final UnifiedNativeAdView zzbop;

    zzf(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbop = unifiedNativeAdView;
    }

    public final void setMediaContent(MediaContent mediaContent) {
        this.zzbop.zza(mediaContent);
    }
}

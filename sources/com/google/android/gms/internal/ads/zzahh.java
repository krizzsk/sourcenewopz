package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzahh extends zzafw {
    private final NativeContentAd.OnContentAdLoadedListener zzdhy;

    public zzahh(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdhy = onContentAdLoadedListener;
    }

    public final void zza(zzafk zzafk) {
        this.zzdhy.onContentAdLoaded(new zzafp(zzafk));
    }
}

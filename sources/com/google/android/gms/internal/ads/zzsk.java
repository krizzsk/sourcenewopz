package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzsk extends zzsu {
    private final AppOpenAdPresentationCallback zzbvd;

    public zzsk(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbvd = appOpenAdPresentationCallback;
    }

    public final void onAppOpenAdClosed() {
        this.zzbvd.onAppOpenAdClosed();
    }
}

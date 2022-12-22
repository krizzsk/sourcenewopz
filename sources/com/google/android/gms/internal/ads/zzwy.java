package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzwy extends zzyf {
    private final FullScreenContentCallback zzbvg;

    public zzwy(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvg = fullScreenContentCallback;
    }

    public final void zzb(zzvh zzvh) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvh.zzqh());
        }
    }

    public final void onAdShowedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void onAdDismissedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void onAdImpression() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }
}

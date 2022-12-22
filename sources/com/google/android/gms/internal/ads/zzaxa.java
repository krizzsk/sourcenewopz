package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaxa extends zzawj {
    private FullScreenContentCallback zzbvj;
    private OnUserEarnedRewardListener zzebc;

    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzebc = onUserEarnedRewardListener;
    }

    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void zzi(zzvh zzvh) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvh.zzqh());
        }
    }

    public final void zza(zzawa zzawa) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzebc;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzawt(zzawa));
        }
    }

    public final void onAdImpression() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }
}

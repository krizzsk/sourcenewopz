package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaws extends zzawj {
    private FullScreenContentCallback zzbvj;
    private RewardedAdCallback zzeay;

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
    }

    public final void zza(RewardedAdCallback rewardedAdCallback) {
        this.zzeay = rewardedAdCallback;
    }

    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void zza(zzawa zzawa) {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzawt(zzawa));
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    public final void zzi(zzvh zzvh) {
        AdError zzqh = zzvh.zzqh();
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzqh);
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzqh);
        }
    }

    public final void onAdImpression() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }
}

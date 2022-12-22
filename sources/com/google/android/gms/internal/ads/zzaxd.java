package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaxd extends zzawm {
    private final RewardedInterstitialAdLoadCallback zzebe;
    private final zzaxc zzebf;

    public zzaxd(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzaxc zzaxc) {
        this.zzebe = rewardedInterstitialAdLoadCallback;
        this.zzebf = zzaxc;
    }

    public final void onRewardedAdLoaded() {
        zzaxc zzaxc;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzebe;
        if (rewardedInterstitialAdLoadCallback != null && (zzaxc = this.zzebf) != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzaxc);
            this.zzebe.onAdLoaded(this.zzebf);
        }
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzebe;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    public final void zzj(zzvh zzvh) {
        if (this.zzebe != null) {
            LoadAdError zzqi = zzvh.zzqi();
            this.zzebe.onRewardedInterstitialAdFailedToLoad(zzqi);
            this.zzebe.onAdFailedToLoad(zzqi);
        }
    }
}

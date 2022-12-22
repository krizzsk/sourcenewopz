package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zza implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmn;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmn = abstractAdViewAdapter;
    }

    public final void onRewardedVideoAdLoaded() {
        this.zzmn.zzmt.onAdLoaded(this.zzmn);
    }

    public final void onRewardedVideoAdOpened() {
        this.zzmn.zzmt.onAdOpened(this.zzmn);
    }

    public final void onRewardedVideoStarted() {
        this.zzmn.zzmt.onVideoStarted(this.zzmn);
    }

    public final void onRewardedVideoAdClosed() {
        this.zzmn.zzmt.onAdClosed(this.zzmn);
        InterstitialAd unused = this.zzmn.zzms = null;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.zzmn.zzmt.onRewarded(this.zzmn, rewardItem);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.zzmn.zzmt.onAdLeftApplication(this.zzmn);
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.zzmn.zzmt.onAdFailedToLoad(this.zzmn, i);
    }

    public final void onRewardedVideoCompleted() {
        this.zzmn.zzmt.onVideoCompleted(this.zzmn);
    }
}

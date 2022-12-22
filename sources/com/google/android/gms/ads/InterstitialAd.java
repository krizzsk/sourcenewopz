package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzp;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class InterstitialAd {
    private final zzzp zzadr;

    public InterstitialAd(Context context) {
        this.zzadr = new zzzp(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadr.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadr.getAdUnitId();
    }

    public final boolean isLoaded() {
        return this.zzadr.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadr.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzadr.zza(adRequest.zzdt());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadr.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzve)) {
            this.zzadr.zza((zzve) adListener);
        } else if (adListener == null) {
            this.zzadr.zza((zzve) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzadr.setAdUnitId(str);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadr.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzadr.show();
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzadr.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzadr.setAdMetadataListener(adMetadataListener);
    }

    public final Bundle getAdMetadata() {
        return this.zzadr.getAdMetadata();
    }

    public final void zze(boolean z) {
        this.zzadr.zze(true);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadr.setImmersiveMode(z);
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadr.getResponseInfo();
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadr.setOnPaidEventListener(onPaidEventListener);
    }
}

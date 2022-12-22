package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzawq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class RewardedAd {
    private zzawq zzhvf = null;

    public static void load(Context context, String str, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawq(context, str).zza(adRequest.zzdt(), rewardedAdLoadCallback);
    }

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawq(context, str).zza(adManagerAdRequest.zzdt(), rewardedAdLoadCallback);
    }

    @Deprecated
    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzhvf = new zzawq(context, str);
    }

    protected RewardedAd() {
    }

    @Deprecated
    public void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.zza(adRequest.zzdt(), rewardedAdLoadCallback);
        }
    }

    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.zza(publisherAdRequest.zzdt(), rewardedAdLoadCallback);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.getMediationAdapterClassName();
        }
        return null;
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
        }
    }

    public OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.getOnAdMetadataChangedListener();
        }
        return null;
    }

    public Bundle getAdMetadata() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.getAdMetadata();
        }
        return new Bundle();
    }

    @Deprecated
    public boolean isLoaded() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.isLoaded();
        }
        return false;
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.show(activity, rewardedAdCallback);
        }
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.show(activity, rewardedAdCallback, z);
        }
    }

    public void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.show(activity, onUserEarnedRewardListener);
        }
    }

    public RewardItem getRewardItem() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.getRewardItem();
        }
        return null;
    }

    public ResponseInfo getResponseInfo() {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            return zzawq.getResponseInfo();
        }
        return null;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.setOnPaidEventListener(onPaidEventListener);
        }
    }

    public OnPaidEventListener getOnPaidEventListener() {
        zzawq zzawq = this.zzhvf;
        if (zzawq == null) {
            return null;
        }
        zzawq.getOnPaidEventListener();
        return null;
    }

    public void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.setFullScreenContentCallback(fullScreenContentCallback);
        }
    }

    public FullScreenContentCallback getFullScreenContentCallback() {
        zzawq zzawq = this.zzhvf;
        if (zzawq == null) {
            return null;
        }
        zzawq.getFullScreenContentCallback();
        return null;
    }

    public String getAdUnitId() {
        zzawq zzawq = this.zzhvf;
        return zzawq != null ? zzawq.getAdUnitId() : "";
    }

    public void setImmersiveMode(boolean z) {
        zzawq zzawq = this.zzhvf;
        if (zzawq != null) {
            zzawq.setImmersiveMode(z);
        }
    }
}

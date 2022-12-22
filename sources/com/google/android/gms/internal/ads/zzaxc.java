package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaxc extends RewardedInterstitialAd {
    private final Context zzaai;
    private final String zzbvf;
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;
    private final zzawf zzeau;
    private OnAdMetadataChangedListener zzeax;
    private final zzaxa zzebd = new zzaxa();

    public zzaxc(Context context, String str) {
        this.zzbvf = str;
        this.zzaai = context.getApplicationContext();
        this.zzeau = zzww.zzqx().zzc(context, str, new zzank());
    }

    public final void zza(zzzl zzzl, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            this.zzeau.zzb(zzvr.zza(this.zzaai, zzzl), new zzaxd(rewardedInterstitialAdLoadCallback, this));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzebd.setFullScreenContentCallback(fullScreenContentCallback);
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzeau.zza(new zzaww(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzeax = onAdMetadataChangedListener;
        try {
            this.zzeau.zza((zzyw) new zzaar(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzeax;
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzeau.getAdMetadata();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final RewardItem getRewardItem() {
        try {
            zzawa zzsb = this.zzeau.zzsb();
            if (zzsb != null) {
                return new zzawt(zzsb);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc;
        try {
            zzzc = this.zzeau.zzkm();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            zzzc = null;
        }
        return ResponseInfo.zza(zzzc);
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzebd.zza(onUserEarnedRewardListener);
        try {
            this.zzeau.zza((zzawg) this.zzebd);
            this.zzeau.zze(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzbvk = onPaidEventListener;
        try {
            this.zzeau.zza((zzyx) new zzaaq(onPaidEventListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzeau.setImmersiveMode(z);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}

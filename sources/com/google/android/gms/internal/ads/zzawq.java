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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzawq extends RewardedAd {
    private final Context zzaai;
    private final String zzbvf;
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;
    private final zzawf zzeau;
    private final zzaxa zzeav = new zzaxa();
    private final zzaws zzeaw = new zzaws();
    private OnAdMetadataChangedListener zzeax;

    public zzawq(Context context, String str) {
        this.zzaai = context.getApplicationContext();
        this.zzbvf = str;
        this.zzeau = zzww.zzqx().zzc(context, str, new zzank());
    }

    public final void zza(zzzl zzzl, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzeau.zza(zzvr.zza(this.zzaai, zzzl), (zzawn) new zzawx(rewardedAdLoadCallback, this));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzeau.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzeau.zza(new zzaww(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzeax = onAdMetadataChangedListener;
            this.zzeau.zza((zzyw) new zzaar(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzeau.getAdMetadata();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzeau.isLoaded();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzeaw.zza(rewardedAdCallback);
        try {
            this.zzeau.zza((zzawg) this.zzeaw);
            this.zzeau.zze(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzeaw.zza(rewardedAdCallback);
        try {
            this.zzeau.zza((zzawg) this.zzeaw);
            this.zzeau.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzeav.zza(onUserEarnedRewardListener);
        if (activity == null) {
            zzbao.zzez("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzeau.zza((zzawg) this.zzeav);
            this.zzeau.zze(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final RewardItem getRewardItem() {
        try {
            zzawa zzsb = this.zzeau.zzsb();
            if (zzsb == null) {
                return null;
            }
            return new zzawt(zzsb);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
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

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            this.zzeau.zza((zzyx) new zzaaq(onPaidEventListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzeax;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzeav.setFullScreenContentCallback(fullScreenContentCallback);
        this.zzeaw.setFullScreenContentCallback(fullScreenContentCallback);
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
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

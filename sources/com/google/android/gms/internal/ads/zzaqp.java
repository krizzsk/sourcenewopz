package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaqp implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzant zzdqa;
    private final /* synthetic */ zzaqj zzdqd;
    private final /* synthetic */ zzapz zzdqg;

    zzaqp(zzaqj zzaqj, zzapz zzapz, zzant zzant) {
        this.zzdqd = zzaqj;
        this.zzdqg = zzapz;
        this.zzdqa = zzant;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdqg.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbao.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.zzdqd.zzdpe = mediationRewardedAd;
                this.zzdqg.zzvy();
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
            }
            return new zzaqo(this.zzdqa);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdqg.zzg(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}

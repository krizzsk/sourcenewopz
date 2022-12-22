package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaqk implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzant zzdqa;
    private final /* synthetic */ zzapt zzdqc;
    private final /* synthetic */ zzaqj zzdqd;

    zzaqk(zzaqj zzaqj, zzapt zzapt, zzant zzant) {
        this.zzdqd = zzaqj;
        this.zzdqc = zzapt;
        this.zzdqa = zzant;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdqc.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbao.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.zzdqd.zzdpc = mediationInterstitialAd;
                this.zzdqc.zzvy();
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
            this.zzdqc.zzg(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}

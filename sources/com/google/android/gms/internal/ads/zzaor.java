package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaor implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzant zzdov;
    private final /* synthetic */ zzaon zzdox;

    zzaor(zzaon zzaon, zzant zzant) {
        this.zzdox = zzaon;
        this.zzdov = zzant;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        try {
            MediationInterstitialAd unused = this.zzdox.zzdpc = mediationInterstitialAd;
            this.zzdov.onAdLoaded();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
        return new zzaol(this.zzdov);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzdox.zzdoy.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzbao.zzdz(sb.toString());
            this.zzdov.zzc(adError.zzdr());
            this.zzdov.zzc(adError.getCode(), adError.getMessage());
            this.zzdov.onAdFailedToLoad(adError.getCode());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}

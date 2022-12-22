package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaql implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzapo zzdpz;
    private final /* synthetic */ zzant zzdqa;

    zzaql(zzaqj zzaqj, zzapo zzapo, zzant zzant) {
        this.zzdpz = zzapo;
        this.zzdqa = zzant;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationInterscrollerAd mediationInterscrollerAd) {
        if (mediationInterscrollerAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdpz.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbao.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdpz.zza(new zzaos(mediationInterscrollerAd));
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
            this.zzdpz.zzg(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}

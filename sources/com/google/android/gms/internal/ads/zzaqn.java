package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaqn implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzant zzdqa;
    private final /* synthetic */ zzapu zzdqf;

    zzaqn(zzaqj zzaqj, zzapu zzapu, zzant zzant) {
        this.zzdqf = zzapu;
        this.zzdqa = zzant;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdqf.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbao.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdqf.zza(new zzapp(unifiedNativeAdMapper));
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
            this.zzdqf.zzg(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}

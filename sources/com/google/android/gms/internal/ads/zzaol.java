package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaol implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback {
    private final zzant zzdou;

    public zzaol(zzant zzant) {
        this.zzdou = zzant;
    }

    public final void onVideoMute() {
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called reportAdClicked.");
        try {
            this.zzdou.onAdClicked();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called reportAdImpression.");
        try {
            this.zzdou.onAdImpression();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdOpened.");
        try {
            this.zzdou.onAdOpened();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdOpened.");
        try {
            this.zzdou.onAdOpened();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdLeftApplication.");
        try {
            this.zzdou.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoPause() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onVideoPause.");
        try {
            this.zzdou.onVideoPause();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoPlay() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onVideoPlay.");
        try {
            this.zzdou.onVideoPlay();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onVideoComplete.");
        try {
            this.zzdou.zzvq();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        zzbao.zzez(valueOf.length() != 0 ? "Mediation ad failed to show: ".concat(valueOf) : new String("Mediation ad failed to show: "));
        try {
            this.zzdou.zzdk(str);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 87 + String.valueOf(domain).length());
        sb.append("Mediation ad failed to show: Error Code = ");
        sb.append(code);
        sb.append(". Error Message = ");
        sb.append(message);
        sb.append(" Error Domain = ");
        sb.append(domain);
        zzbao.zzez(sb.toString());
        try {
            this.zzdou.zzf(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}

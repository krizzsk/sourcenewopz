package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzapb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzant zzdpk;

    public zzapb(zzant zzant) {
        this.zzdpk = zzant;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbao.zzdz("Adapter called onClick.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapa(this));
            return;
        }
        try {
            this.zzdpk.onAdClicked();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbao.zzdz("Adapter called onDismissScreen.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zzez("#008 Must be called on the main UI thread.");
            zzbae.zzaah.post(new zzapf(this));
            return;
        }
        try {
            this.zzdpk.onAdClosed();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbao.zzdz(sb.toString());
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzape(this, errorCode));
            return;
        }
        try {
            this.zzdpk.onAdFailedToLoad(zzapn.zza(errorCode));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbao.zzdz("Adapter called onLeaveApplication.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzaph(this));
            return;
        }
        try {
            this.zzdpk.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbao.zzdz("Adapter called onPresentScreen.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapg(this));
            return;
        }
        try {
            this.zzdpk.onAdOpened();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbao.zzdz("Adapter called onReceivedAd.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapj(this));
            return;
        }
        try {
            this.zzdpk.onAdLoaded();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbao.zzdz("Adapter called onDismissScreen.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapi(this));
            return;
        }
        try {
            this.zzdpk.onAdClosed();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbao.zzdz(sb.toString());
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapl(this, errorCode));
            return;
        }
        try {
            this.zzdpk.onAdFailedToLoad(zzapn.zza(errorCode));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbao.zzdz("Adapter called onLeaveApplication.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapk(this));
            return;
        }
        try {
            this.zzdpk.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbao.zzdz("Adapter called onPresentScreen.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapd(this));
            return;
        }
        try {
            this.zzdpk.onAdOpened();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbao.zzdz("Adapter called onReceivedAd.");
        zzww.zzqw();
        if (!zzbae.zzaaq()) {
            zzbao.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbae.zzaah.post(new zzapc(this));
            return;
        }
        try {
            this.zzdpk.onAdLoaded();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcuv extends zzans implements zzbug {
    private zzant zzdou;
    private zzbuf zzgxb;

    public final synchronized void zzb(zzant zzant) {
        this.zzdou = zzant;
    }

    public final synchronized void zza(zzbuf zzbuf) {
        this.zzgxb = zzbuf;
    }

    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdFailedToLoad(i);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdFailedToLoad(i);
        }
    }

    public final synchronized void zzc(int i, String str) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzc(i, str);
        }
        if (this.zzgxb != null) {
            this.zzgxb.zzf(i, str);
        }
    }

    public final synchronized void zzc(zzvh zzvh) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzc(zzvh);
        }
        if (this.zzgxb != null) {
            this.zzgxb.zzd(zzvh);
        }
    }

    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdLeftApplication();
        }
    }

    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdOpened();
        }
    }

    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdLoaded();
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdLoaded();
        }
    }

    public final synchronized void zza(zzanz zzanz) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zza(zzanz);
        }
    }

    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAdImpression();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onAppEvent(str, str2);
        }
    }

    public final synchronized void zza(zzafo zzafo, String str) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zza(zzafo, str);
        }
    }

    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onVideoEnd();
        }
    }

    public final synchronized void zzdj(String str) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzdj(str);
        }
    }

    public final synchronized void zzvp() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzvp();
        }
    }

    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onVideoPlay();
        }
    }

    public final synchronized void zzb(zzavy zzavy) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzb(zzavy);
        }
    }

    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.onVideoPause();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzb(bundle);
        }
    }

    public final synchronized void zzvq() throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzvq();
        }
    }

    public final synchronized void zzde(int i) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzde(i);
        }
    }

    public final synchronized void zzdk(String str) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzdk(str);
        }
    }

    public final synchronized void zzf(zzvh zzvh) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zzf(zzvh);
        }
    }

    public final synchronized void zza(zzawa zzawa) throws RemoteException {
        if (this.zzdou != null) {
            this.zzdou.zza(zzawa);
        }
    }
}

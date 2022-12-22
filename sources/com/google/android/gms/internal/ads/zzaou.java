package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaou extends zzans {
    private final zzavu zzdpa;
    private final Adapter zzdpj;

    zzaou(Adapter adapter, zzavu zzavu) {
        this.zzdpj = adapter;
        this.zzdpa = zzavu;
    }

    public final void onAdImpression() throws RemoteException {
    }

    public final void onAdLeftApplication() throws RemoteException {
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    public final void onVideoEnd() throws RemoteException {
    }

    public final void onVideoPause() throws RemoteException {
    }

    public final void onVideoPlay() throws RemoteException {
    }

    public final void zza(zzafo zzafo, String str) throws RemoteException {
    }

    public final void zza(zzanz zzanz) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzb(zzavy zzavy) throws RemoteException {
    }

    public final void zzc(int i, String str) throws RemoteException {
    }

    public final void zzc(zzvh zzvh) throws RemoteException {
    }

    public final void zzde(int i) throws RemoteException {
    }

    public final void zzdj(String str) throws RemoteException {
    }

    public final void zzdk(String str) {
    }

    public final void zzf(zzvh zzvh) {
    }

    public final void onAdLoaded() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzah(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void onAdOpened() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzai(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void onAdClosed() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzak(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void zza(zzawa zzawa) throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zza(ObjectWrapper.wrap(this.zzdpj), new zzavy(zzawa.getType(), zzawa.getAmount()));
        }
    }

    public final void zzvp() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzaj(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void zzvq() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzan(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void onAdClicked() throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zzal(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzavu zzavu = this.zzdpa;
        if (zzavu != null) {
            zzavu.zze(ObjectWrapper.wrap(this.zzdpj), i);
        }
    }
}

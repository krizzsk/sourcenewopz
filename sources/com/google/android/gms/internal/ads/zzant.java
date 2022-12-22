package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzant extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzafo zzafo, String str) throws RemoteException;

    void zza(zzanz zzanz) throws RemoteException;

    void zza(zzawa zzawa) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzavy zzavy) throws RemoteException;

    void zzc(int i, String str) throws RemoteException;

    void zzc(zzvh zzvh) throws RemoteException;

    void zzde(int i) throws RemoteException;

    void zzdj(String str) throws RemoteException;

    void zzdk(String str) throws RemoteException;

    void zzf(zzvh zzvh) throws RemoteException;

    void zzvp() throws RemoteException;

    void zzvq() throws RemoteException;
}

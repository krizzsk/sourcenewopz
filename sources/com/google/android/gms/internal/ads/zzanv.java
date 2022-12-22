package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzanv extends zzgw implements zzant {
    zzanv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void onAdClicked() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void onAdClosed() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(3, zzdp);
    }

    public final void onAdLeftApplication() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void onAdOpened() throws RemoteException {
        zzb(5, zzdp());
    }

    public final void onAdLoaded() throws RemoteException {
        zzb(6, zzdp());
    }

    public final void zza(zzanz zzanz) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzanz);
        zzb(7, zzdp);
    }

    public final void onAdImpression() throws RemoteException {
        zzb(8, zzdp());
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(9, zzdp);
    }

    public final void zza(zzafo zzafo, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzafo);
        zzdp.writeString(str);
        zzb(10, zzdp);
    }

    public final void onVideoEnd() throws RemoteException {
        zzb(11, zzdp());
    }

    public final void zzdj(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(12, zzdp);
    }

    public final void zzvp() throws RemoteException {
        zzb(13, zzdp());
    }

    public final void zzb(zzavy zzavy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzavy);
        zzb(14, zzdp);
    }

    public final void onVideoPause() throws RemoteException {
        zzb(15, zzdp());
    }

    public final void zza(zzawa zzawa) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzawa);
        zzb(16, zzdp);
    }

    public final void zzde(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(17, zzdp);
    }

    public final void zzvq() throws RemoteException {
        zzb(18, zzdp());
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) bundle);
        zzb(19, zzdp);
    }

    public final void onVideoPlay() throws RemoteException {
        zzb(20, zzdp());
    }

    public final void zzdk(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(21, zzdp);
    }

    public final void zzc(int i, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzdp.writeString(str);
        zzb(22, zzdp);
    }

    public final void zzc(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(23, zzdp);
    }

    public final void zzf(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(24, zzdp);
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzxe extends zzgw implements zzxc {
    zzxe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void onAdClosed() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    public final void onAdLeftApplication() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void onAdLoaded() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void onAdOpened() throws RemoteException {
        zzb(5, zzdp());
    }

    public final void onAdClicked() throws RemoteException {
        zzb(6, zzdp());
    }

    public final void onAdImpression() throws RemoteException {
        zzb(7, zzdp());
    }

    public final void zzc(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(8, zzdp);
    }
}

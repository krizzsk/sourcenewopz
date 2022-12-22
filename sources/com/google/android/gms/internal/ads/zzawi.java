package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzawi extends zzgw implements zzawg {
    zzawi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void onRewardedAdOpened() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void onRewardedAdClosed() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void zza(zzawa zzawa) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzawa);
        zzb(3, zzdp);
    }

    public final void onRewardedAdFailedToShow(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(4, zzdp);
    }

    public final void zzi(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(5, zzdp);
    }

    public final void onAdImpression() throws RemoteException {
        zzb(6, zzdp());
    }
}

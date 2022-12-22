package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavp extends zzgw implements zzavn {
    zzavp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void onRewardedVideoAdOpened() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void onRewardedVideoStarted() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void onRewardedVideoAdClosed() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void zza(zzavd zzavd) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzavd);
        zzb(5, zzdp);
    }

    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zzb(6, zzdp());
    }

    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(7, zzdp);
    }

    public final void onRewardedVideoCompleted() throws RemoteException {
        zzb(8, zzdp());
    }
}

package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzawg extends IInterface {
    void onAdImpression() throws RemoteException;

    void onRewardedAdClosed() throws RemoteException;

    void onRewardedAdFailedToShow(int i) throws RemoteException;

    void onRewardedAdOpened() throws RemoteException;

    void zza(zzawa zzawa) throws RemoteException;

    void zzi(zzvh zzvh) throws RemoteException;
}

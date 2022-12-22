package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzxi extends IInterface {
    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zza(zzvq zzvq, int i) throws RemoteException;

    void zzb(zzvq zzvq) throws RemoteException;

    String zzkl() throws RemoteException;
}

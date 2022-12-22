package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzawf extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzawg zzawg) throws RemoteException;

    void zza(zzawo zzawo) throws RemoteException;

    void zza(zzaww zzaww) throws RemoteException;

    void zza(zzvq zzvq, zzawn zzawn) throws RemoteException;

    void zza(zzyw zzyw) throws RemoteException;

    void zza(zzyx zzyx) throws RemoteException;

    void zzb(zzvq zzvq, zzawn zzawn) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzzc zzkm() throws RemoteException;

    zzawa zzsb() throws RemoteException;
}

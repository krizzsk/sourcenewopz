package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzaqa extends IInterface {
    zzzd getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvt zzvt, zzaqf zzaqf) throws RemoteException;

    void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException;

    void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapt zzapt, zzant zzant) throws RemoteException;

    void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant) throws RemoteException;

    void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant, zzaei zzaei) throws RemoteException;

    void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException;

    void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzab(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException;

    void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException;

    void zzdn(String str) throws RemoteException;

    zzaqr zzvm() throws RemoteException;

    zzaqr zzvn() throws RemoteException;

    void zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}

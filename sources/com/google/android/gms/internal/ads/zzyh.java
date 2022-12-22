package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzyh extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza(zzaat zzaat) throws RemoteException;

    void zza(zzajt zzajt) throws RemoteException;

    void zza(zzann zzann) throws RemoteException;

    void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzcd(String str) throws RemoteException;

    void zzce(String str) throws RemoteException;

    float zzrg() throws RemoteException;

    boolean zzrh() throws RemoteException;

    List<zzajm> zzri() throws RemoteException;

    void zzrj() throws RemoteException;
}

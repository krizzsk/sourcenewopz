package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzhb extends IInterface {
    void log() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    void zza(int[] iArr) throws RemoteException;

    void zzc(byte[] bArr) throws RemoteException;

    void zzt(int i) throws RemoteException;

    void zzu(int i) throws RemoteException;
}

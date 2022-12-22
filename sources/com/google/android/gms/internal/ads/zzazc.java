package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzazc extends IInterface {
    void zza(IObjectWrapper iObjectWrapper, zzazi zzazi, zzazb zzazb) throws RemoteException;

    void zza(zzatj zzatj) throws RemoteException;

    void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) throws RemoteException;

    void zzao(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzap(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) throws RemoteException;
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaze extends zzgw implements zzazc {
    zzaze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzazi zzazi, zzazb zzazb) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (Parcelable) zzazi);
        zzgx.zza(zzdp, (IInterface) zzazb);
        zzb(1, zzdp);
    }

    public final void zzao(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(2, zzdp);
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper2);
        Parcel zza = zza(3, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzap(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        Parcel zza = zza(4, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzasy);
        zzb(5, zzdp);
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzasy);
        zzb(6, zzdp);
    }

    public final void zza(zzatj zzatj) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzatj);
        zzb(7, zzdp);
    }
}

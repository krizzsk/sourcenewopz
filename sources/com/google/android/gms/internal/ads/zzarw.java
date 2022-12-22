package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzarw extends zzgw implements zzaru {
    zzarw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public final void zzc(Intent intent) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) intent);
        zzb(1, zzdp);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(2, zzdp);
    }

    public final void zzwe() throws RemoteException {
        zzb(3, zzdp());
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaff extends zzgw implements zzafd {
    zzaff(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(1, zzdp);
    }

    public final void unregisterNativeAd() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(3, zzdp);
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzsr extends zzgw implements zzsp {
    zzsr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzxq zzea() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        zzxq zzc = zzxp.zzc(zza.readStrongBinder());
        zza.recycle();
        return zzc;
    }

    public final void zza(zzsv zzsv) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzsv);
        zzb(3, zzdp);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzsw zzsw) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzsw);
        zzb(4, zzdp);
    }

    public final zzzc zzkm() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(6, zzdp);
    }

    public final void zza(zzyx zzyx) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzyx);
        zzb(7, zzdp);
    }
}

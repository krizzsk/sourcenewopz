package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwk extends zzgw implements zzdwl {
    zzdwk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzdwj zza(zzdwh zzdwh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzdwh);
        Parcel zza = zza(1, zzdp);
        zzdwj zzdwj = (zzdwj) zzgx.zza(zza, zzdwj.CREATOR);
        zza.recycle();
        return zzdwj;
    }

    public final void zza(zzdwc zzdwc) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzdwc);
        zzb(2, zzdp);
    }

    public final zzdwt zza(zzdwr zzdwr) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzdwr);
        Parcel zza = zza(3, zzdp);
        zzdwt zzdwt = (zzdwt) zzgx.zza(zza, zzdwt.CREATOR);
        zza.recycle();
        return zzdwt;
    }
}

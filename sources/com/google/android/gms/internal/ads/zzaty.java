package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaty extends zzgw implements zzatw {
    zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzats zza(zzatq zzatq) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzatq);
        Parcel zza = zza(1, zzdp);
        zzats zzats = (zzats) zzgx.zza(zza, zzats.CREATOR);
        zza.recycle();
        return zzats;
    }

    public final void zza(zzatq zzatq, zzaub zzaub) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzatq);
        zzgx.zza(zzdp, (IInterface) zzaub);
        zzb(2, zzdp);
    }

    public final void zza(zzauj zzauj, zzaud zzaud) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzauj);
        zzgx.zza(zzdp, (IInterface) zzaud);
        zzb(4, zzdp);
    }

    public final void zzb(zzauj zzauj, zzaud zzaud) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzauj);
        zzgx.zza(zzdp, (IInterface) zzaud);
        zzb(5, zzdp);
    }

    public final void zzc(zzauj zzauj, zzaud zzaud) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzauj);
        zzgx.zza(zzdp, (IInterface) zzaud);
        zzb(6, zzdp);
    }

    public final void zza(String str, zzaud zzaud) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) zzaud);
        zzb(7, zzdp);
    }
}

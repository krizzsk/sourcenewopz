package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zztm extends zzgw implements zztn {
    zztm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzth zza(zzti zzti) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzti);
        Parcel zza = zza(1, zzdp);
        zzth zzth = (zzth) zzgx.zza(zza, zzth.CREATOR);
        zza.recycle();
        return zzth;
    }

    public final zzth zzc(zzti zzti) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzti);
        Parcel zza = zza(2, zzdp);
        zzth zzth = (zzth) zzgx.zza(zza, zzth.CREATOR);
        zza.recycle();
        return zzth;
    }

    public final long zzb(zzti zzti) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzti);
        Parcel zza = zza(3, zzdp);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }
}

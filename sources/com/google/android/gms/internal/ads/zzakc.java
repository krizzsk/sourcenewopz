package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzakc extends zzgw implements zzaka {
    zzakc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final void destroy() throws RemoteException {
        zzb(4, zzdp());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzakf zzakf) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzakf);
        zzb(5, zzdp);
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(6, zzdp);
    }

    public final zzaer zzue() throws RemoteException {
        Parcel zza = zza(7, zzdp());
        zzaer zzn = zzaeq.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}

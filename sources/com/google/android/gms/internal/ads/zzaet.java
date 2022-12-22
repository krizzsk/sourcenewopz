package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaet extends zzgw implements zzaer {
    zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float getAspectRatio() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(3, zzdp);
    }

    public final IObjectWrapper zztr() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final float getDuration() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getCurrentTime() throws RemoteException {
        Parcel zza = zza(6, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final boolean hasVideoContent() throws RemoteException {
        Parcel zza = zza(8, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(zzage zzage) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzage);
        zzb(9, zzdp);
    }
}

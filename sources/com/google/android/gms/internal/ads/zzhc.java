package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzhc extends zzgw implements zzhb {
    zzhc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    public final void log() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void zza(int[] iArr) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeIntArray((int[]) null);
        zzb(4, zzdp);
    }

    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeByteArray(bArr);
        zzb(5, zzdp);
    }

    public final void zzt(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(6, zzdp);
    }

    public final void zzu(int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(7, zzdp);
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString((String) null);
        zzb(8, zzdp);
    }
}

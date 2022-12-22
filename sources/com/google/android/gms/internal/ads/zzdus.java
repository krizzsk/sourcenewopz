package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzdus extends zzgw implements zzduq {
    zzdus(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    public final boolean zzaw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        Parcel zza = zza(2, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(4, zzdp);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper2);
        zzb(5, zzdp);
    }

    public final String getVersion() throws RemoteException {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(7, zzdp);
    }

    public final void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper2);
        zzb(8, zzdp);
    }

    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        Parcel zza = zza(9, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        zzdp.writeString(str6);
        zzdp.writeString(str7);
        zzdp.writeString(str8);
        Parcel zza = zza(10, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzb(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        zzdp.writeString(str6);
        zzdp.writeString(str7);
        zzdp.writeString(str8);
        Parcel zza = zza(11, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}

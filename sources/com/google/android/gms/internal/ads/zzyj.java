package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzyj extends zzgw implements zzyh {
    zzyj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void initialize() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void setAppVolume(float f) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeFloat(f);
        zzb(2, zzdp);
    }

    public final void zzcd(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(3, zzdp);
    }

    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(4, zzdp);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzb(5, zzdp);
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(6, zzdp);
    }

    public final float zzrg() throws RemoteException {
        Parcel zza = zza(7, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean zzrh() throws RemoteException {
        Parcel zza = zza(8, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String getVersionString() throws RemoteException {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzce(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(10, zzdp);
    }

    public final void zza(zzann zzann) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzann);
        zzb(11, zzdp);
    }

    public final void zza(zzajt zzajt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzajt);
        zzb(12, zzdp);
    }

    public final List<zzajm> zzri() throws RemoteException {
        Parcel zza = zza(13, zzdp());
        ArrayList<zzajm> createTypedArrayList = zza.createTypedArrayList(zzajm.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zza(zzaat zzaat) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzaat);
        zzb(14, zzdp);
    }

    public final void zzrj() throws RemoteException {
        zzb(15, zzdp());
    }
}

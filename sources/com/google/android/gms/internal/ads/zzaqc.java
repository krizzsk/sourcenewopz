package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaqc extends zzgw implements zzaqa {
    zzaqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvt zzvt, zzaqf zzaqf) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzgx.zza(zzdp, (Parcelable) bundle);
        zzgx.zza(zzdp, (Parcelable) bundle2);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzgx.zza(zzdp, (IInterface) zzaqf);
        zzb(1, zzdp);
    }

    public final zzaqr zzvm() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        zzaqr zzaqr = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqr;
    }

    public final zzaqr zzvn() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        zzaqr zzaqr = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqr;
    }

    public final zzzd getVideoController() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(10, zzdp);
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeStringArray(strArr);
        zzdp.writeTypedArray(bundleArr, 0);
        zzb(11, zzdp);
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapo);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzb(13, zzdp);
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapt zzapt, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapt);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(14, zzdp);
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        Parcel zza = zza(15, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapz);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(16, zzdp);
    }

    public final boolean zzab(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        Parcel zza = zza(17, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapu);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(18, zzdp);
    }

    public final void zzdn(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(19, zzdp);
    }

    public final void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapz);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzb(20, zzdp);
    }

    public final void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapo);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzgx.zza(zzdp, (Parcelable) zzvt);
        zzb(21, zzdp);
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant, zzaei zzaei) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzgx.zza(zzdp, (IInterface) zzapu);
        zzgx.zza(zzdp, (IInterface) zzant);
        zzgx.zza(zzdp, (Parcelable) zzaei);
        zzb(22, zzdp);
    }
}

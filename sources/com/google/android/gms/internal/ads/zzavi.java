package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavi extends zzgw implements zzavg {
    zzavi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public final void zza(zzavt zzavt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzavt);
        zzb(1, zzdp);
    }

    public final void show() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void zza(zzavn zzavn) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzavn);
        zzb(3, zzdp);
    }

    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(5, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() throws RemoteException {
        zzb(6, zzdp());
    }

    public final void resume() throws RemoteException {
        zzb(7, zzdp());
    }

    public final void destroy() throws RemoteException {
        zzb(8, zzdp());
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(9, zzdp);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(10, zzdp);
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(11, zzdp);
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(12, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void setUserId(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(13, zzdp);
    }

    public final void zza(zzxt zzxt) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzxt);
        zzb(14, zzdp);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel zza = zza(15, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(zzave zzave) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzave);
        zzb(16, zzdp);
    }

    public final void setAppPackageName(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(17, zzdp);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(18, zzdp);
    }

    public final void setCustomData(String str) throws RemoteException {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(19, zzdp);
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(34, zzdp);
    }

    public final boolean zzsc() throws RemoteException {
        Parcel zza = zza(20, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zzzc zzkm() throws RemoteException {
        Parcel zza = zza(21, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }
}

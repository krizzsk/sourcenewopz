package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzgw;
import com.google.android.gms.internal.ads.zzgx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzbi extends zzgw implements zzbg {
    zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        Parcel zza = zza(1, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzaq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) iObjectWrapper);
        zzb(2, zzdp);
    }
}

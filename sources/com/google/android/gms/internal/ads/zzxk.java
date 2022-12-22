package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzxk extends zzgw implements zzxi {
    zzxk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final void zzb(zzvq zzvq) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzb(1, zzdp);
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String zzkl() throws RemoteException {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzvq zzvq, int i) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvq);
        zzdp.writeInt(i);
        zzb(5, zzdp);
    }
}

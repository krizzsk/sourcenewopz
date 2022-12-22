package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzxf extends zzgw implements zzxd {
    zzxf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    public final void onAdLoaded() throws RemoteException {
        zzb(1, zzdp());
    }

    public final void zzd(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(2, zzdp);
    }
}

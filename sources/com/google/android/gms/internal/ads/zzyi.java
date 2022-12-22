package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzyi extends zzgw implements zzyg {
    zzyi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final void zzb(zzvh zzvh) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (Parcelable) zzvh);
        zzb(1, zzdp);
    }

    public final void onAdShowedFullScreenContent() throws RemoteException {
        zzb(2, zzdp());
    }

    public final void onAdDismissedFullScreenContent() throws RemoteException {
        zzb(3, zzdp());
    }

    public final void onAdImpression() throws RemoteException {
        zzb(4, zzdp());
    }
}

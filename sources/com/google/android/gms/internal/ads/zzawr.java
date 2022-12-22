package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzawr extends zzgw implements zzawo {
    zzawr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zza(zzawa zzawa, String str, String str2) throws RemoteException {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, (IInterface) zzawa);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(2, zzdp);
    }
}

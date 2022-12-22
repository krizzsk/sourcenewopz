package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavf extends zzgw implements zzavd {
    zzavf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public final String getType() throws RemoteException {
        Parcel zza = zza(1, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final int getAmount() throws RemoteException {
        Parcel zza = zza(2, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}

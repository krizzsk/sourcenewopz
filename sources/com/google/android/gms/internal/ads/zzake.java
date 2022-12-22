package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzake extends zzgy implements zzakf {
    public zzake() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzuo();
        } else if (i != 2) {
            return false;
        } else {
            zzdd(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}

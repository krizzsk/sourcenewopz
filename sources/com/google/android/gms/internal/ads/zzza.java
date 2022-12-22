package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzza extends zzgy implements zzyx {
    public zzza() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzyx zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzyx) {
            return (zzyx) queryLocalInterface;
        }
        return new zzyz(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((zzvv) zzgx.zza(parcel, zzvv.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}

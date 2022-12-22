package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzarx extends zzgy implements zzaru {
    public zzarx() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzaru zzah(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzaru) {
            return (zzaru) queryLocalInterface;
        }
        return new zzarw(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzc((Intent) zzgx.zza(parcel, Intent.CREATOR));
        } else if (i == 2) {
            zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzwe();
        }
        parcel2.writeNoException();
        return true;
    }
}

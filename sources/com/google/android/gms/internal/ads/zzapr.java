package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzapr extends zzgy implements zzapo {
    public zzapr() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzy(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzdm(parcel.readString());
        } else if (i == 3) {
            zzg((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            zza(zzanx.zzae(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}

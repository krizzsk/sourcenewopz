package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzyf extends zzgy implements zzyg {
    public zzyf() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        } else if (i == 2) {
            onAdShowedFullScreenContent();
        } else if (i == 3) {
            onAdDismissedFullScreenContent();
        } else if (i != 4) {
            return false;
        } else {
            onAdImpression();
        }
        parcel2.writeNoException();
        return true;
    }
}

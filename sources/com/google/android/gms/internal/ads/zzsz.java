package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzsz extends zzgy implements zzsw {
    public zzsz() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            onAdShowedFullScreenContent();
        } else if (i == 2) {
            onAdDismissedFullScreenContent();
        } else if (i == 3) {
            zzb((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            onAdImpression();
        }
        parcel2.writeNoException();
        return true;
    }
}

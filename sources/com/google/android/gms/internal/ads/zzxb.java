package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzxb extends zzgy implements zzxc {
    public zzxb() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                onAdClosed();
                break;
            case 2:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 3:
                onAdLeftApplication();
                break;
            case 4:
                onAdLoaded();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdClicked();
                break;
            case 7:
                onAdImpression();
                break;
            case 8:
                zzc((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}

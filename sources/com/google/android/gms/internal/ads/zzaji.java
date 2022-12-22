package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaji extends zzajf {
    private final /* synthetic */ zzbbe zzbwi;

    zzaji(zzajj zzajj, zzbbe zzbbe) {
        this.zzbwi = zzbbe;
    }

    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbwi.set(parcelFileDescriptor);
    }
}

package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaq;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcqn implements zzebi<ParcelFileDescriptor> {
    private final /* synthetic */ zzaud zzgsi;

    zzcqn(zzcqb zzcqb, zzaud zzaud) {
        this.zzgsi = zzaud;
    }

    public final void zzb(Throwable th) {
        try {
            this.zzgsi.zza(zzaq.zzc(th));
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgsi.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }
}

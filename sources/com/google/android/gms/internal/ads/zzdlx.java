package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlx {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdma<T> zzdma) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdma.zzp(t);
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}

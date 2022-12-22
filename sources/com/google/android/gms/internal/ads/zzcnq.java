package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnq implements zzear {
    static final zzear zzbpa = new zzcnq();

    private zzcnq() {
    }

    public final zzebt zzf(Object obj) {
        return zzebh.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}

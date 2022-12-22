package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeag<V, X extends Throwable> extends zzead<V, X, zzear<? super X, ? extends V>, zzebt<? extends V>> {
    zzeag(zzebt<? extends V> zzebt, Class<X> cls, zzear<? super X, ? extends V> zzear) {
        super(zzebt, cls, zzear);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzebt) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzear zzear = (zzear) obj;
        zzebt zzf = zzear.zzf(th);
        zzdyi.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzear);
        return zzf;
    }
}

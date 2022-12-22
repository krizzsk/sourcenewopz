package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeaf<V, X extends Throwable> extends zzead<V, X, zzdxw<? super X, ? extends V>, V> {
    zzeaf(zzebt<? extends V> zzebt, Class<X> cls, zzdxw<? super X, ? extends V> zzdxw) {
        super(zzebt, cls, zzdxw);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl V v) {
        set(v);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        return ((zzdxw) obj).apply(th);
    }
}

package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeaj<I, O> extends zzeak<I, O, zzear<? super I, ? extends O>, zzebt<? extends O>> {
    zzeaj(zzebt<? extends I> zzebt, zzear<? super I, ? extends O> zzear) {
        super(zzebt, zzear);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzebt) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        zzear zzear = (zzear) obj;
        zzebt zzf = zzear.zzf(obj2);
        zzdyi.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzear);
        return zzf;
    }
}

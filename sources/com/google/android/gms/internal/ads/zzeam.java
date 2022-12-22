package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeam<I, O> extends zzeak<I, O, zzdxw<? super I, ? extends O>, O> {
    zzeam(zzebt<? extends I> zzebt, zzdxw<? super I, ? extends O> zzdxw) {
        super(zzebt, zzdxw);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdxw) obj).apply(obj2);
    }
}

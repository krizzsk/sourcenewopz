package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbrz implements zzebi<Boolean> {
    private final /* synthetic */ zzbrx zzgap;

    zzbrz(zzbrx zzbrx) {
        this.zzgap = zzbrx;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Boolean bool = (Boolean) obj;
        this.zzgap.zzgah.onAdImpression();
    }
}

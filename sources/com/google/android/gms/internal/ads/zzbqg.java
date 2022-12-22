package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbqg implements zzebi<Void> {
    private final /* synthetic */ zzbqd zzfzs;

    zzbqg(zzbqd zzbqd) {
        this.zzfzs = zzbqd;
    }

    public final void zzb(Throwable th) {
        this.zzfzs.zzfzk.zzbk(false);
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        this.zzfzs.zzfzk.zzbk(true);
    }
}

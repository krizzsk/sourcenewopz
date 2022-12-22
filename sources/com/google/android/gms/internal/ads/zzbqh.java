package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbqh implements zzebi<zzauj> {
    private final /* synthetic */ zzbqd zzfzs;

    zzbqh(zzbqd zzbqd) {
        this.zzfzs = zzbqd;
    }

    public final void zzb(Throwable th) {
        this.zzfzs.zzfzk.zzbj(false);
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        zzauj zzauj = (zzauj) obj;
        this.zzfzs.zzfzk.zzbj(true);
    }
}

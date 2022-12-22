package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdlv implements zzebi<Void> {
    zzdlv(zzdlu zzdlu) {
    }

    public final void zzb(Throwable th) {
        zzd.zzed("Notification of cache hit failed.");
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        zzd.zzed("Notification of cache hit successful.");
    }
}

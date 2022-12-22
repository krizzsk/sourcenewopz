package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnw implements Callable {
    private final Context zzclh;
    private final zzei zzgql;

    zzcnw(zzei zzei, Context context) {
        this.zzgql = zzei;
        this.zzclh = context;
    }

    public final Object call() {
        zzei zzei = this.zzgql;
        return zzei.zzcb().zzb(this.zzclh);
    }
}

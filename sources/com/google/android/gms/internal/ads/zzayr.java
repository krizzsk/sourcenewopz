package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayr implements Callable {
    private final Context zzclh;
    private final zzayd zzedj;

    zzayr(zzayd zzayd, Context context) {
        this.zzedj = zzayd;
        this.zzclh = context;
    }

    public final Object call() {
        return this.zzedj.zzai(this.zzclh);
    }
}

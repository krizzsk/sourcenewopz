package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcri implements zzesa<zzcrj> {
    private final zzesn<Context> zzeyq;

    private zzcri(zzesn<Context> zzesn) {
        this.zzeyq = zzesn;
    }

    public static zzcri zzaf(zzesn<Context> zzesn) {
        return new zzcri(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcrj(this.zzeyq.get());
    }
}

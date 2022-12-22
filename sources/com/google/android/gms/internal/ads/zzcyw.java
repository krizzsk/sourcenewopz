package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyw implements zzesa<zzcys> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcbj> zzgvz;

    public zzcyw(zzesn<Context> zzesn, zzesn<zzcbj> zzesn2) {
        this.zzeyq = zzesn;
        this.zzgvz = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcys(this.zzeyq.get(), this.zzgvz.get());
    }
}

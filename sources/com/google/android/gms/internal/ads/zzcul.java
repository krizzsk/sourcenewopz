package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcul implements zzesa<zzcue> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzboa> zzgvz;

    public zzcul(zzesn<Context> zzesn, zzesn<zzboa> zzesn2) {
        this.zzeyq = zzesn;
        this.zzgvz = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcue(this.zzeyq.get(), this.zzgvz.get());
    }
}

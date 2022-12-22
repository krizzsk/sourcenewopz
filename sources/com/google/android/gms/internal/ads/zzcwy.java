package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwy implements zzesa<zzcwx> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcis> zzgvz;

    public zzcwy(zzesn<Context> zzesn, zzesn<zzcis> zzesn2) {
        this.zzeyq = zzesn;
        this.zzgvz = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcwx(this.zzeyq.get(), this.zzgvz.get());
    }
}

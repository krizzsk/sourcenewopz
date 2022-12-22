package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwb implements zzesa<zzcvw> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzccf> zzgvz;

    public zzcwb(zzesn<Context> zzesn, zzesn<zzccf> zzesn2, zzesn<zzbar> zzesn3) {
        this.zzeyq = zzesn;
        this.zzgvz = zzesn2;
        this.zzfvj = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzcvw(this.zzeyq.get(), this.zzgvz.get(), this.zzfvj.get());
    }
}

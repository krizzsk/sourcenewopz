package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsw implements zzesa<zzcsr> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<zzbas> zzgve;

    public zzcsw(zzesn<Context> zzesn, zzesn<zzcsh> zzesn2, zzesn<zzbas> zzesn3, zzesn<zzcmb> zzesn4, zzesn<zzdtw> zzesn5) {
        this.zzeyq = zzesn;
        this.zzglz = zzesn2;
        this.zzgve = zzesn3;
        this.zzfac = zzesn4;
        this.zzgma = zzesn5;
    }

    public final /* synthetic */ Object get() {
        return new zzcsr(this.zzeyq.get(), this.zzglz.get(), this.zzgve.get(), this.zzfac.get(), this.zzgma.get());
    }
}

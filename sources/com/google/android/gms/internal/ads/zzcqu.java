package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqu implements zzesa<zzcqv> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<String> zzgno;
    private final zzesn<zzdpi> zzgnw;

    private zzcqu(zzesn<Context> zzesn, zzesn<zzdpz> zzesn2, zzesn<zzdpi> zzesn3, zzesn<zzdot> zzesn4, zzesn<zzcsh> zzesn5, zzesn<zzdtw> zzesn6, zzesn<String> zzesn7) {
        this.zzeyq = zzesn;
        this.zzfaq = zzesn2;
        this.zzgnw = zzesn3;
        this.zzfua = zzesn4;
        this.zzglz = zzesn5;
        this.zzgma = zzesn6;
        this.zzgno = zzesn7;
    }

    public static zzcqu zzb(zzesn<Context> zzesn, zzesn<zzdpz> zzesn2, zzesn<zzdpi> zzesn3, zzesn<zzdot> zzesn4, zzesn<zzcsh> zzesn5, zzesn<zzdtw> zzesn6, zzesn<String> zzesn7) {
        return new zzcqu(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7);
    }

    public final /* synthetic */ Object get() {
        return new zzcqv(this.zzeyq.get(), this.zzfaq.get(), this.zzgnw.get(), this.zzfua.get(), this.zzglz.get(), this.zzgma.get(), this.zzgno.get());
    }
}

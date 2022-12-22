package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclo implements zzesa<zzclp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdpi> zzgnw;

    private zzclo(zzesn<Context> zzesn, zzesn<zzdpz> zzesn2, zzesn<zzcmb> zzesn3, zzesn<zzdpi> zzesn4, zzesn<zzdot> zzesn5, zzesn<zzcsh> zzesn6) {
        this.zzeyq = zzesn;
        this.zzfaq = zzesn2;
        this.zzfac = zzesn3;
        this.zzgnw = zzesn4;
        this.zzfua = zzesn5;
        this.zzglz = zzesn6;
    }

    public static zzclo zza(zzesn<Context> zzesn, zzesn<zzdpz> zzesn2, zzesn<zzcmb> zzesn3, zzesn<zzdpi> zzesn4, zzesn<zzdot> zzesn5, zzesn<zzcsh> zzesn6) {
        return new zzclo(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6);
    }

    public final /* synthetic */ Object get() {
        return new zzclp(this.zzeyq.get(), this.zzfaq.get(), this.zzfac.get(), this.zzgnw.get(), this.zzfua.get(), this.zzglz.get());
    }
}

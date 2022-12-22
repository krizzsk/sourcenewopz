package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdum implements zzesa<zzdun> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdph> zzfri;
    private final zzesn<zzei> zzfuc;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzhec;
    private final zzesn<String> zzhed;
    private final zzesn<zzcwk> zzhuy;

    private zzdum(zzesn<zzcwk> zzesn, zzesn<zzbar> zzesn2, zzesn<String> zzesn3, zzesn<String> zzesn4, zzesn<Context> zzesn5, zzesn<zzdph> zzesn6, zzesn<Clock> zzesn7, zzesn<zzei> zzesn8) {
        this.zzhuy = zzesn;
        this.zzfvj = zzesn2;
        this.zzhec = zzesn3;
        this.zzhed = zzesn4;
        this.zzeyq = zzesn5;
        this.zzfri = zzesn6;
        this.zzfvh = zzesn7;
        this.zzfuc = zzesn8;
    }

    public static zzdum zzb(zzesn<zzcwk> zzesn, zzesn<zzbar> zzesn2, zzesn<String> zzesn3, zzesn<String> zzesn4, zzesn<Context> zzesn5, zzesn<zzdph> zzesn6, zzesn<Clock> zzesn7, zzesn<zzei> zzesn8) {
        return new zzdum(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7, zzesn8);
    }

    public final /* synthetic */ Object get() {
        return new zzdun(this.zzhuy.get(), this.zzfvj.get(), this.zzhec.get(), this.zzhed.get(), this.zzeyq.get(), this.zzfri.get(), this.zzfvh.get(), this.zzfuc.get());
    }
}

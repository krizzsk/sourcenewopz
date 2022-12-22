package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtj implements zzesa<zzbtb> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbtf> zzfkd;
    private final zzesn<Set<zzbzl<zzbtc>>> zzfxl;

    private zzbtj(zzesn<zzbtf> zzesn, zzesn<Set<zzbzl<zzbtc>>> zzesn2, zzesn<Executor> zzesn3) {
        this.zzfkd = zzesn;
        this.zzfxl = zzesn2;
        this.zzeyl = zzesn3;
    }

    public static zzbtj zzn(zzesn<zzbtf> zzesn, zzesn<Set<zzbzl<zzbtc>>> zzesn2, zzesn<Executor> zzesn3) {
        return new zzbtj(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzbtb(this.zzfkd.get(), this.zzfxl.get(), this.zzeyl.get());
    }
}

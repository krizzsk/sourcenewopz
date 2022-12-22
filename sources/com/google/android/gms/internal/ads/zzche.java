package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzche implements zzesa<zzchb> {
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzblv> zzgja;
    private final zzesn<zzbzk> zzgla;

    public zzche(zzesn<Executor> zzesn, zzesn<zzblv> zzesn2, zzesn<zzbzk> zzesn3) {
        this.zzfxf = zzesn;
        this.zzgja = zzesn2;
        this.zzgla = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzchb(this.zzfxf.get(), this.zzgja.get(), this.zzgla.get());
    }
}

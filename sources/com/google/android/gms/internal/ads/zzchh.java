package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchh implements zzesa<zzcgs> {
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;

    public zzchh(zzesn<zzdpm> zzesn, zzesn<Executor> zzesn2, zzesn<zzcja> zzesn3) {
        this.zzfxn = zzesn;
        this.zzfxf = zzesn2;
        this.zzgiz = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzcgs(this.zzfxn.get(), this.zzfxf.get(), this.zzgiz.get());
    }
}

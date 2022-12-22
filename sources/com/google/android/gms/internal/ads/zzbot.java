package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbot implements zzesa<zzbok> {
    private final zzesn<zzagm> zzeyk;
    private final zzesn<zzbpf> zzfkj;
    private final zzesn<Runnable> zzfqg;
    private final zzesn<Executor> zzfxf;

    public zzbot(zzesn<zzbpf> zzesn, zzesn<zzagm> zzesn2, zzesn<Runnable> zzesn3, zzesn<Executor> zzesn4) {
        this.zzfkj = zzesn;
        this.zzeyk = zzesn2;
        this.zzfqg = zzesn3;
        this.zzfxf = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzbok(this.zzfkj.get(), this.zzeyk.get(), this.zzfqg.get(), this.zzfxf.get());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcop implements zzesa<zzcon> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzcpd> zzgqi;
    private final zzesn<zzcqb> zzgqj;

    public zzcop(zzesn<ScheduledExecutorService> zzesn, zzesn<zzebs> zzesn2, zzesn<zzcpd> zzesn3, zzesn<zzcqb> zzesn4) {
        this.zzfty = zzesn;
        this.zzeyl = zzesn2;
        this.zzgqi = zzesn3;
        this.zzgqj = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzcon(this.zzfty.get(), this.zzeyl.get(), this.zzgqi.get(), zzesb.zzat(this.zzgqj));
    }
}

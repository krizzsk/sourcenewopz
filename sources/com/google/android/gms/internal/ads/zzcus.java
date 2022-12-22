package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcus implements zzesa<zzcuo> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzboa> zzfpn;
    private final zzesn<zzcts> zzfpr;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzbsx> zzgwy;

    public zzcus(zzesn<zzboa> zzesn, zzesn<zzcts> zzesn2, zzesn<zzbsx> zzesn3, zzesn<ScheduledExecutorService> zzesn4, zzesn<zzebs> zzesn5) {
        this.zzfpn = zzesn;
        this.zzfpr = zzesn2;
        this.zzgwy = zzesn3;
        this.zzfty = zzesn4;
        this.zzeyl = zzesn5;
    }

    public final /* synthetic */ Object get() {
        return new zzcuo(this.zzfpn.get(), this.zzfpr.get(), this.zzgwy.get(), this.zzfty.get(), this.zzeyl.get());
    }
}

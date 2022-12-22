package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcos implements zzesa<zzcoo> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzcrr> zzfci;
    private final zzesn<zzcno> zzfgi;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpm> zzfxn;

    private zzcos(zzesn<zzdpm> zzesn, zzesn<zzcno> zzesn2, zzesn<zzebs> zzesn3, zzesn<ScheduledExecutorService> zzesn4, zzesn<zzcrr> zzesn5) {
        this.zzfxn = zzesn;
        this.zzfgi = zzesn2;
        this.zzeyl = zzesn3;
        this.zzfty = zzesn4;
        this.zzfci = zzesn5;
    }

    public static zzcos zzf(zzesn<zzdpm> zzesn, zzesn<zzcno> zzesn2, zzesn<zzebs> zzesn3, zzesn<ScheduledExecutorService> zzesn4, zzesn<zzcrr> zzesn5) {
        return new zzcos(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzcoo(this.zzfxn.get(), this.zzfgi.get(), this.zzeyl.get(), this.zzfty.get(), this.zzfci.get());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdtp implements zzesa<zzdtg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdtj> zzfcm;
    private final zzesn<ScheduledExecutorService> zzfwv;

    private zzdtp(zzesn<zzebs> zzesn, zzesn<ScheduledExecutorService> zzesn2, zzesn<zzdtj> zzesn3) {
        this.zzeyl = zzesn;
        this.zzfwv = zzesn2;
        this.zzfcm = zzesn3;
    }

    public static zzdtp zzad(zzesn<zzebs> zzesn, zzesn<ScheduledExecutorService> zzesn2, zzesn<zzdtj> zzesn3) {
        return new zzdtp(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzdtg(this.zzeyl.get(), this.zzfwv.get(), this.zzfcm.get());
    }
}

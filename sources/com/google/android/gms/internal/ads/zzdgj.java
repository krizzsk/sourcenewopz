package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgj implements zzesa<zzdgg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzczb> zzezl;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<String> zzfvk;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcyz> zzgzb;

    private zzdgj(zzesn<zzebs> zzesn, zzesn<ScheduledExecutorService> zzesn2, zzesn<String> zzesn3, zzesn<zzczb> zzesn4, zzesn<Context> zzesn5, zzesn<zzdpm> zzesn6, zzesn<zzcyz> zzesn7) {
        this.zzeyl = zzesn;
        this.zzfty = zzesn2;
        this.zzfvk = zzesn3;
        this.zzezl = zzesn4;
        this.zzeyq = zzesn5;
        this.zzfxn = zzesn6;
        this.zzgzb = zzesn7;
    }

    public static zzdgj zzc(zzesn<zzebs> zzesn, zzesn<ScheduledExecutorService> zzesn2, zzesn<String> zzesn3, zzesn<zzczb> zzesn4, zzesn<Context> zzesn5, zzesn<zzdpm> zzesn6, zzesn<zzcyz> zzesn7) {
        return new zzdgj(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7);
    }

    public final /* synthetic */ Object get() {
        return new zzdgg(this.zzeyl.get(), this.zzfty.get(), this.zzfvk.get(), this.zzezl.get(), this.zzeyq.get(), this.zzfxn.get(), this.zzgzb.get());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdtz implements zzesa<zzdtw> {
    private final zzesn<zzduc> zzeza;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdul> zzhur;

    public zzdtz(zzesn<zzduc> zzesn, zzesn<zzdul> zzesn2, zzesn<ScheduledExecutorService> zzesn3) {
        this.zzeza = zzesn;
        this.zzhur = zzesn2;
        this.zzfty = zzesn3;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        zzeru<zzduc> zzat = zzesb.zzat(this.zzeza);
        zzeru<zzdul> zzat2 = zzesb.zzat(this.zzhur);
        ScheduledExecutorService scheduledExecutorService = this.zzfty.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbm)).booleanValue()) {
            obj = new zzdty(zzat.get(), scheduledExecutorService);
        } else {
            obj = zzat2.get();
        }
        return (zzdtw) zzesg.zzbd(obj);
    }
}

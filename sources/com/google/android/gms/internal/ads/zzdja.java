package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdja implements zzdhe<zzdix> {
    private Context context;
    private ScheduledExecutorService zzftq;
    private zzasp zzhhu;

    public zzdja(zzasp zzasp, ScheduledExecutorService scheduledExecutorService, Context context2) {
        this.zzhhu = zzasp;
        this.zzftq = scheduledExecutorService;
        this.context = context2;
    }

    public final zzebt<zzdix> zzatu() {
        return zzebh.zzb(zzebh.zza(this.zzhhu.zzo(this.context), ((Long) zzww.zzra().zzd(zzabq.zzcuq)).longValue(), TimeUnit.MILLISECONDS, this.zzftq), zzdiz.zzebv, (Executor) zzbat.zzeke);
    }
}

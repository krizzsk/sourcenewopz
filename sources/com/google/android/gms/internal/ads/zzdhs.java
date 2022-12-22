package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhs implements zzdhe<zzdhp> {
    private final Context context;
    private final Executor executor;
    private final ScheduledExecutorService zzftq;
    private final int zzgsm;
    private final zzazo zzhgy;

    public zzdhs(zzazo zzazo, Context context2, ScheduledExecutorService scheduledExecutorService, Executor executor2, int i) {
        this.zzhgy = zzazo;
        this.context = context2;
        this.zzftq = scheduledExecutorService;
        this.executor = executor2;
        this.zzgsm = i;
    }

    public final zzebt<zzdhp> zzatu() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcqc)).booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzebc.zzg(this.zzhgy.zza(this.context, this.zzgsm)).zza(zzdhr.zzebv, this.executor).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Throwable.class, new zzdhu(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdhp zzf(Throwable th) {
        zzww.zzqw();
        return new zzdhp((AdvertisingIdClient.Info) null, zzbae.zzbq(this.context));
    }
}

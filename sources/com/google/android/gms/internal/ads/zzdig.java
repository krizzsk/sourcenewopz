package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdig implements zzdhe<zzdid> {
    private final Context context;
    private final Executor executor;
    private final zzazs zzbqn;
    private final ScheduledExecutorService zzftq;
    private final int zzgsm;
    private final zzazo zzhgy;

    public zzdig(zzazo zzazo, int i, Context context2, zzazs zzazs, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzhgy = zzazo;
        this.zzgsm = i;
        this.context = context2;
        this.zzbqn = zzazs;
        this.zzftq = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzebt<zzdid> zzatu() {
        return zzebc.zzg(zzebh.zza(new zzdif(this), this.executor)).zza(zzdii.zzebv, this.executor).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Exception.class, new zzdih(this), zzebv.zzbbe());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdid zzb(Exception exc) {
        this.zzbqn.zza(exc, "AttestationTokenSignal");
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzaut() throws Exception {
        return this.zzhgy.zzb(this.context, this.zzgsm);
    }
}

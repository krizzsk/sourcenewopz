package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcon {
    private final ScheduledExecutorService zzftq;
    private final zzebs zzgka;
    private final zzeru<zzcqb> zzgqd;
    private final zzcpd zzgqs;

    public zzcon(ScheduledExecutorService scheduledExecutorService, zzebs zzebs, zzcpd zzcpd, zzeru<zzcqb> zzeru) {
        this.zzftq = scheduledExecutorService;
        this.zzgka = zzebs;
        this.zzgqs = zzcpd;
        this.zzgqd = zzeru;
    }

    public final zzebt<InputStream> zzg(zzauj zzauj) {
        zzebt<InputStream> zzebt;
        String str = zzauj.packageName;
        zzr.zzkv();
        if (zzj.zzem(str)) {
            zzebt = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzebt = this.zzgqs.zzj(zzauj);
        }
        int callingUid = Binder.getCallingUid();
        return zzebc.zzg(zzebt).zza((long) ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS, this.zzftq).zza(Throwable.class, new zzcom(this, zzauj, callingUid), (Executor) this.zzgka);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzauj zzauj, int i, Throwable th) throws Exception {
        return this.zzgqd.get().zzd(zzauj, i);
    }
}

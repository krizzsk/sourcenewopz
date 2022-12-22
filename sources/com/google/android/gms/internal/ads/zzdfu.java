package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdhb;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfu<S extends zzdhb<?>> implements zzdhe<S> {
    private final ScheduledExecutorService zzfvp;
    private final zzdhe<S> zzhel;
    private final long zzhfk;

    public zzdfu(zzdhe<S> zzdhe, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzhel = zzdhe;
        this.zzhfk = j;
        this.zzfvp = scheduledExecutorService;
    }

    public final zzebt<S> zzatu() {
        zzebt<S> zzatu = this.zzhel.zzatu();
        long j = this.zzhfk;
        if (j > 0) {
            zzatu = zzebh.zza(zzatu, j, TimeUnit.MILLISECONDS, this.zzfvp);
        }
        return zzebh.zzb(zzatu, Throwable.class, zzdft.zzbpa, zzbat.zzekj);
    }
}

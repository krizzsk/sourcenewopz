package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcoo implements zzcpp {
    /* access modifiers changed from: private */
    public static final Pattern zzgqv = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzftq;
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final zzcno zzgqt;
    /* access modifiers changed from: private */
    public final zzcrr zzgqu;

    zzcoo(zzdpm zzdpm, zzcno zzcno, zzebs zzebs, ScheduledExecutorService scheduledExecutorService, zzcrr zzcrr) {
        this.zzfzg = zzdpm;
        this.zzgqt = zzcno;
        this.zzgka = zzebs;
        this.zzftq = scheduledExecutorService;
        this.zzgqu = zzcrr;
    }

    public final zzebt<zzdpi> zzh(zzauj zzauj) {
        zzebt<zzdpi> zzb = zzebh.zzb(this.zzgqt.zze(zzauj), new zzcor(this), (Executor) this.zzgka);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxh)).booleanValue()) {
            zzb = zzebh.zzb(zzebh.zza(zzb, (long) ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS, this.zzftq), TimeoutException.class, zzcoq.zzbpa, zzbat.zzekj);
        }
        zzebh.zza(zzb, new zzcot(this), zzbat.zzekj);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzd(InputStream inputStream) throws Exception {
        return zzebh.zzag(new zzdpi(new zzdpd(this.zzfzg), zzdpg.zza(new InputStreamReader(inputStream))));
    }
}

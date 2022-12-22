package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzx extends Thread {
    private final BlockingQueue<zzab<?>> zzah;
    private final zzu zzai;
    private final zzk zzn;
    private final zzal zzo;
    private volatile boolean zzp = false;

    public zzx(BlockingQueue<zzab<?>> blockingQueue, zzu zzu, zzk zzk, zzal zzal) {
        this.zzah = blockingQueue;
        this.zzai = zzu;
        this.zzn = zzk;
        this.zzo = zzal;
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    public final void run() {
        SystemUtils.setProcessThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzao.m37366e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzab take = this.zzah.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.zzd(3);
        try {
            take.zzc("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzz zza = this.zzai.zza(take);
            take.zzc("network-http-complete");
            if (!zza.zzak || !take.zzl()) {
                zzag zza2 = take.zza(zza);
                take.zzc("network-parse-complete");
                if (take.zzh() && zza2.zzbq != null) {
                    this.zzn.zza(take.zze(), zza2.zzbq);
                    take.zzc("network-cache-written");
                }
                take.zzk();
                this.zzo.zza((zzab<?>) take, (zzag<?>) zza2);
                take.zza((zzag<?>) zza2);
                take.zzd(4);
                return;
            }
            take.zzd("not-modified");
            take.zzm();
        } catch (zzap e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzo.zza((zzab<?>) take, e);
            take.zzm();
        } catch (Exception e2) {
            zzao.zza(e2, "Unhandled exception %s", e2.toString());
            zzap zzap = new zzap((Throwable) e2);
            zzap.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzo.zza((zzab<?>) take, zzap);
            take.zzm();
        } finally {
            take.zzd(4);
        }
    }
}

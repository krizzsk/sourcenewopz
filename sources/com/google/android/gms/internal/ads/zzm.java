package com.google.android.gms.internal.ads;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzm extends Thread {
    private static final boolean DEBUG = zzao.DEBUG;
    private final BlockingQueue<zzab<?>> zzl;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzab<?>> zzm;
    private final zzk zzn;
    private final zzal zzo;
    private volatile boolean zzp = false;
    private final zzas zzq;

    public zzm(BlockingQueue<zzab<?>> blockingQueue, BlockingQueue<zzab<?>> blockingQueue2, zzk zzk, zzal zzal) {
        this.zzl = blockingQueue;
        this.zzm = blockingQueue2;
        this.zzn = zzk;
        this.zzo = zzal;
        this.zzq = new zzas(this, blockingQueue2, zzal);
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    public final void run() {
        if (DEBUG) {
            zzao.m37367v("start new dispatcher", new Object[0]);
        }
        SystemUtils.setProcessThreadPriority(10);
        this.zzn.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzao.m37366e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzab take = this.zzl.take();
        take.zzc("cache-queue-take");
        take.zzd(1);
        try {
            take.isCanceled();
            zzn zzb = this.zzn.zzb(take.zze());
            if (zzb == null) {
                take.zzc("cache-miss");
                if (!this.zzq.zzg(take)) {
                    this.zzm.put(take);
                }
            } else if (zzb.zza()) {
                take.zzc("cache-hit-expired");
                take.zza(zzb);
                if (!this.zzq.zzg(take)) {
                    this.zzm.put(take);
                }
                take.zzd(2);
            } else {
                take.zzc("cache-hit");
                zzag zza = take.zza(new zzz(zzb.data, zzb.zzw));
                take.zzc("cache-hit-parsed");
                if (!zza.isSuccess()) {
                    take.zzc("cache-parsing-failed");
                    this.zzn.zza(take.zze(), true);
                    take.zza((zzn) null);
                    if (!this.zzq.zzg(take)) {
                        this.zzm.put(take);
                    }
                    take.zzd(2);
                    return;
                }
                if (!(zzb.zzv < System.currentTimeMillis())) {
                    this.zzo.zza((zzab<?>) take, (zzag<?>) zza);
                } else {
                    take.zzc("cache-hit-refresh-needed");
                    take.zza(zzb);
                    zza.zzbs = true;
                    if (!this.zzq.zzg(take)) {
                        this.zzo.zza(take, zza, new zzp(this, take));
                    } else {
                        this.zzo.zza((zzab<?>) take, (zzag<?>) zza);
                    }
                }
                take.zzd(2);
            }
        } finally {
            take.zzd(2);
        }
    }
}

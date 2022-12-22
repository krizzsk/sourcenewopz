package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdty implements zzdtw {
    private final zzdtw zzhun;
    private final Queue<zzdtx> zzhuo = new LinkedBlockingQueue();
    private final int zzhup = ((Integer) zzww.zzra().zzd(zzabq.zzdbo)).intValue();
    private final AtomicBoolean zzhuq = new AtomicBoolean(false);

    public zzdty(zzdtw zzdtw, ScheduledExecutorService scheduledExecutorService) {
        this.zzhun = zzdtw;
        long intValue = (long) ((Integer) zzww.zzra().zzd(zzabq.zzdbn)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzdub(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public final void zzb(zzdtx zzdtx) {
        if (this.zzhuo.size() < this.zzhup) {
            this.zzhuo.offer(zzdtx);
        } else if (!this.zzhuq.getAndSet(true)) {
            Queue<zzdtx> queue = this.zzhuo;
            zzdtx zzgy = zzdtx.zzgy("dropped_event");
            Map<String, String> zzlw = zzdtx.zzlw();
            if (zzlw.containsKey("action")) {
                zzgy.zzw("dropped_action", zzlw.get("action"));
            }
            queue.offer(zzgy);
        }
    }

    public final String zzc(zzdtx zzdtx) {
        return this.zzhun.zzc(zzdtx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzayj() {
        while (!this.zzhuo.isEmpty()) {
            this.zzhun.zzb(this.zzhuo.remove());
        }
    }
}

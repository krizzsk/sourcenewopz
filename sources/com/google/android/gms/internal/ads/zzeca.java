package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeca<V> extends zzebb<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzebt<V> zzieb;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zziec;

    static <V> zzebt<V> zzb(zzebt<V> zzebt, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzeca zzeca = new zzeca(zzebt);
        zzecc zzecc = new zzecc(zzeca);
        zzeca.zziec = scheduledExecutorService.schedule(zzecc, j, timeUnit);
        zzebt.addListener(zzecc, zzeba.INSTANCE);
        return zzeca;
    }

    private zzeca(zzebt<V> zzebt) {
        this.zzieb = (zzebt) zzdyi.checkNotNull(zzebt);
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzebt<V> zzebt = this.zzieb;
        ScheduledFuture<?> scheduledFuture = this.zziec;
        if (zzebt == null) {
            return null;
        }
        String valueOf = String.valueOf(zzebt);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append(Const.jaRight);
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzieb);
        ScheduledFuture<?> scheduledFuture = this.zziec;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzieb = null;
        this.zziec = null;
    }
}

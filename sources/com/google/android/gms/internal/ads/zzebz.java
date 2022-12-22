package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzebz<V> extends zzebf<V> implements zzebt<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zziea;

    public zzebz(zzebt<V> zzebt, ScheduledFuture<?> scheduledFuture) {
        super(zzebt);
        this.zziea = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zziea.cancel(z);
        }
        return cancel;
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zziea.getDelay(timeUnit);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zziea.compareTo((Delayed) obj);
    }
}

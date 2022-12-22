package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzecg extends zzebp<V> {
    private final Callable<V> zzidk;
    private final /* synthetic */ zzece zzief;

    zzecg(zzece zzece, Callable<V> callable) {
        this.zzief = zzece;
        this.zzidk = (Callable) zzdyi.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzief.isDone();
    }

    /* access modifiers changed from: package-private */
    public final V zzbba() throws Exception {
        return this.zzidk.call();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzief.set(v);
        } else {
            this.zzief.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzbbb() {
        return this.zzidk.toString();
    }
}

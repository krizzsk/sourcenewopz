package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeay extends zzeax<V> {
    private final /* synthetic */ zzeav zzidj;
    private final Callable<V> zzidk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeay(zzeav zzeav, Callable<V> callable, Executor executor) {
        super(zzeav, executor);
        this.zzidj = zzeav;
        this.zzidk = (Callable) zzdyi.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final V zzbba() throws Exception {
        return this.zzidk.call();
    }

    /* access modifiers changed from: package-private */
    public final void setValue(V v) {
        this.zzidj.set(v);
    }

    /* access modifiers changed from: package-private */
    public final String zzbbb() {
        return this.zzidk.toString();
    }
}

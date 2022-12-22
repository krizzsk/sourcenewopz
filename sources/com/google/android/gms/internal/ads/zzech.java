package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzech extends zzebp<zzebt<V>> {
    private final /* synthetic */ zzece zzief;
    private final zzeas<V> zzieg;

    zzech(zzece zzece, zzeas<V> zzeas) {
        this.zzief = zzece;
        this.zzieg = (zzeas) zzdyi.checkNotNull(zzeas);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzief.isDone();
    }

    /* access modifiers changed from: package-private */
    public final String zzbbb() {
        return this.zzieg.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzebt zzebt = (zzebt) obj;
        if (th == null) {
            this.zzief.setFuture(zzebt);
        } else {
            this.zzief.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzbba() throws Exception {
        return (zzebt) zzdyi.zza(this.zzieg.zzauk(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzieg);
    }
}

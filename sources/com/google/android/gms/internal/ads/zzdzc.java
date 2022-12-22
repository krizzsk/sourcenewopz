package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzc<E> extends zzdyr<E> {
    private final zzdza<E> zziau;

    zzdzc(zzdza<E> zzdza, int i) {
        super(zzdza.size(), i);
        this.zziau = zzdza;
    }

    /* access modifiers changed from: protected */
    public final E get(int i) {
        return this.zziau.get(i);
    }
}

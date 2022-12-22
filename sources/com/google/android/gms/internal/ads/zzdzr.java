package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzr extends zzdza<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzibj;

    zzdzr(Object[] objArr, int i, int i2) {
        this.zzibj = objArr;
        this.offset = i;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return true;
    }

    public final Object get(int i) {
        zzdyi.zzv(i, this.size);
        return this.zzibj[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}

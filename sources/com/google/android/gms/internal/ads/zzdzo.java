package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzo<E> extends zzdza<E> {
    static final zzdza<Object> zzibk = new zzdzo(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzibl;

    zzdzo(Object[] objArr, int i) {
        this.zzibl = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzbah() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbag() {
        return this.zzibl;
    }

    /* access modifiers changed from: package-private */
    public final int zzbai() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzibl, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzdyi.zzv(i, this.size);
        return this.zzibl[i];
    }
}

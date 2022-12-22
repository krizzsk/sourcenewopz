package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzb extends zzdza<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdza zziat;

    zzdzb(zzdza zzdza, int i, int i2) {
        this.zziat = zzdza;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbag() {
        return this.zziat.zzbag();
    }

    /* access modifiers changed from: package-private */
    public final int zzbah() {
        return this.zziat.zzbah() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzbai() {
        return this.zziat.zzbah() + this.offset + this.length;
    }

    public final E get(int i) {
        zzdyi.zzv(i, this.length);
        return this.zziat.get(i + this.offset);
    }

    public final zzdza<E> zzx(int i, int i2) {
        zzdyi.zzf(i, i2, this.length);
        zzdza zzdza = this.zziat;
        int i3 = this.offset;
        return (zzdza) zzdza.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}

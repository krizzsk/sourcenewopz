package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.osgi.framework.VersionRange;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzw<E> extends zzdzd<E> {
    private final transient E zzibt;
    private transient int zzibu;

    zzdzw(E e) {
        this.zzibt = zzdyi.checkNotNull(e);
    }

    public final int size() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return false;
    }

    zzdzw(E e, int i) {
        this.zzibt = e;
        this.zzibu = i;
    }

    public final boolean contains(Object obj) {
        return this.zzibt.equals(obj);
    }

    public final zzdzx<E> zzbaf() {
        return new zzdzf(this.zzibt);
    }

    /* access modifiers changed from: package-private */
    public final zzdza<E> zzban() {
        return zzdza.zzac(this.zzibt);
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzibt;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.zzibu;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzibt.hashCode();
        this.zzibu = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbam() {
        return this.zzibu != 0;
    }

    public final String toString() {
        String obj = this.zzibt.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append(VersionRange.LEFT_CLOSED);
        sb.append(obj);
        sb.append(VersionRange.RIGHT_CLOSED);
        return sb.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}

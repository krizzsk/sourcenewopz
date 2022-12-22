package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzu<E> extends zzdzd<E> {
    static final zzdzu<Object> zzibp = new zzdzu(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzaih;
    private final transient Object[] zzibq;
    private final transient Object[] zzibr;

    zzdzu(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzibq = objArr;
        this.zzibr = objArr2;
        this.mask = i2;
        this.zzaih = i;
        this.size = i3;
    }

    /* access modifiers changed from: package-private */
    public final int zzbah() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbam() {
        return true;
    }

    public final boolean contains(@NullableDecl Object obj) {
        int i;
        Object[] objArr = this.zzibr;
        if (obj == null || objArr == null) {
            return false;
        }
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int zzex = zzdyw.zzex(i);
        while (true) {
            int i2 = zzex & this.mask;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzex = i2 + 1;
        }
    }

    public final int size() {
        return this.size;
    }

    public final zzdzx<E> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbag() {
        return this.zzibq;
    }

    /* access modifiers changed from: package-private */
    public final int zzbai() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzibq, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: package-private */
    public final zzdza<E> zzban() {
        return zzdza.zzb(this.zzibq, this.size);
    }

    public final int hashCode() {
        return this.zzaih;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}

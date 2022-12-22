package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzdyv<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zziap = new Object[0];

    zzdyv() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzbaf */
    public abstract zzdzx<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzbag() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzbak();

    public final Object[] toArray() {
        return toArray(zziap);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdyi.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzbag = zzbag();
            if (zzbag != null) {
                return Arrays.copyOfRange(zzbag, zzbah(), zzbai(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzbah() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzbai() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzdza<E> zzbaj() {
        return isEmpty() ? zzdza.zzbal() : zzdza.zzc(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzdzx zzdzx = (zzdzx) iterator();
        while (zzdzx.hasNext()) {
            objArr[i] = zzdzx.next();
            i++;
        }
        return i;
    }
}

package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzenv extends zzelk<String> implements zzenu, RandomAccess {
    private static final zzenv zzivc;
    private static final zzenu zzivd = zzivc;
    private final List<Object> zzive;

    public zzenv() {
        this(10);
    }

    public zzenv(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzenv(ArrayList<Object> arrayList) {
        this.zzive = arrayList;
    }

    public final int size() {
        return this.zzive.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbhf();
        if (collection instanceof zzenu) {
            collection = ((zzenu) collection).zzbkl();
        }
        boolean addAll = this.zzive.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbhf();
        this.zzive.clear();
        this.modCount++;
    }

    public final void zzak(zzelq zzelq) {
        zzbhf();
        this.zzive.add(zzelq);
        this.modCount++;
    }

    public final Object zzhr(int i) {
        return this.zzive.get(i);
    }

    private static String zzam(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzelq) {
            return ((zzelq) obj).zzbhh();
        }
        return zzenc.zzy((byte[]) obj);
    }

    public final List<?> zzbkl() {
        return Collections.unmodifiableList(this.zzive);
    }

    public final zzenu zzbkm() {
        return zzbhd() ? new zzeqf(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzbhf();
        return zzam(this.zzive.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        Object remove = this.zzive.remove(i);
        this.modCount++;
        return zzam(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzbhd() {
        return super.zzbhd();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbhf();
        this.zzive.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzenk zzgg(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzive);
            return new zzenv((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzive.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzelq) {
            zzelq zzelq = (zzelq) obj;
            String zzbhh = zzelq.zzbhh();
            if (zzelq.zzbhi()) {
                this.zzive.set(i, zzbhh);
            }
            return zzbhh;
        }
        byte[] bArr = (byte[]) obj;
        String zzy = zzenc.zzy(bArr);
        if (zzenc.zzx(bArr)) {
            this.zzive.set(i, zzy);
        }
        return zzy;
    }

    static {
        zzenv zzenv = new zzenv();
        zzivc = zzenv;
        zzenv.zzbhe();
    }
}

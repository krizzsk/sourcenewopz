package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p071io.FileUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzdze<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zziaw = new Map.Entry[0];
    private transient zzdzd<Map.Entry<K, V>> zziax;
    private transient zzdzd<K> zziay;
    private transient zzdyv<V> zziaz;

    public static <K, V> zzdze<K, V> zzc(K k, V v) {
        zzdyu.zzb(k, v);
        return zzdzn.zzc(1, new Object[]{k, v});
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzdzd<Map.Entry<K, V>> zzbao();

    /* access modifiers changed from: package-private */
    public abstract zzdzd<K> zzbap();

    /* access modifiers changed from: package-private */
    public abstract zzdyv<V> zzbaq();

    public static <K, V> zzdze<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdyu.zzb(k, v);
        zzdyu.zzb(k2, v2);
        zzdyu.zzb(k3, v3);
        zzdyu.zzb(k4, v4);
        zzdyu.zzb(k5, v5);
        return zzdzn.zzc(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    zzdze() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdyv) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzdzt.zzg((zzdzd) entrySet());
    }

    public String toString() {
        int size = size();
        zzdyu.zzh(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, FileUtils.ONE_GB));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Set entrySet() {
        zzdzd<Map.Entry<K, V>> zzdzd = this.zziax;
        if (zzdzd != null) {
            return zzdzd;
        }
        zzdzd<Map.Entry<K, V>> zzbao = zzbao();
        this.zziax = zzbao;
        return zzbao;
    }

    public /* synthetic */ Collection values() {
        zzdyv<V> zzdyv = this.zziaz;
        if (zzdyv != null) {
            return zzdyv;
        }
        zzdyv<V> zzbaq = zzbaq();
        this.zziaz = zzbaq;
        return zzbaq;
    }

    public /* synthetic */ Set keySet() {
        zzdzd<K> zzdzd = this.zziay;
        if (zzdzd != null) {
            return zzdzd;
        }
        zzdzd<K> zzbap = zzbap();
        this.zziay = zzbap;
        return zzbap;
    }
}

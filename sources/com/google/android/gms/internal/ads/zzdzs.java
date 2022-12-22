package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzs<K> extends zzdzd<K> {
    private final transient zzdza<K> zziau;
    private final transient zzdze<K, ?> zzibn;

    zzdzs(zzdze<K, ?> zzdze, zzdza<K> zzdza) {
        this.zzibn = zzdze;
        this.zziau = zzdza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return true;
    }

    public final zzdzx<K> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzbaj().zza(objArr, i);
    }

    public final zzdza<K> zzbaj() {
        return this.zziau;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzibn.get(obj) != null;
    }

    public final int size() {
        return this.zzibn.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}

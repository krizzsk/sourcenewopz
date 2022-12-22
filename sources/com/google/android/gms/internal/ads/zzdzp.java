package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzp extends zzdza<Map.Entry<K, V>> {
    private final /* synthetic */ zzdzq zzibm;

    zzdzp(zzdzq zzdzq) {
        this.zzibm = zzdzq;
    }

    public final boolean zzbak() {
        return true;
    }

    public final int size() {
        return this.zzibm.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzdyi.zzv(i, this.zzibm.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzibm.zzibj[i2], this.zzibm.zzibj[i2 + 1]);
    }
}

package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzerw<K, V, V2> {
    final LinkedHashMap<K, zzesn<V>> zzjey;

    zzerw(int i) {
        this.zzjey = zzerz.zzin(i);
    }

    /* access modifiers changed from: package-private */
    public zzerw<K, V, V2> zza(K k, zzesn<V> zzesn) {
        this.zzjey.put(zzesg.zza(k, "key"), zzesg.zza(zzesn, "provider"));
        return this;
    }
}

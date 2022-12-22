package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzeof<K, V> {
    static <K, V> void zza(zzemk zzemk, zzeoe<K, V> zzeoe, K k, V v) throws IOException {
        zzemt.zza(zzemk, zzeoe.zzivn, 1, k);
        zzemt.zza(zzemk, zzeoe.zzivp, 2, v);
    }

    static <K, V> int zza(zzeoe<K, V> zzeoe, K k, V v) {
        return zzemt.zza(zzeoe.zzivn, 1, k) + zzemt.zza(zzeoe.zzivp, 2, v);
    }
}

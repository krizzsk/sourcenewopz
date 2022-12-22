package com.google.android.gms.internal.measurement;

import com.didi.sdk.push.fcm.Constact;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzlq {
    private static final zzlq zza = new zzlq();
    private final zzlu zzb = new zzla();
    private final ConcurrentMap<Class<?>, zzlt<?>> zzc = new ConcurrentHashMap();

    private zzlq() {
    }

    public static zzlq zza() {
        return zza;
    }

    public final <T> zzlt<T> zzb(Class<T> cls) {
        zzkl.zzb(cls, Constact.KEY_LINK_MESSAGETYPE);
        zzlt<T> zzlt = (zzlt) this.zzc.get(cls);
        if (zzlt == null) {
            zzlt = this.zzb.zza(cls);
            zzkl.zzb(cls, Constact.KEY_LINK_MESSAGETYPE);
            zzkl.zzb(zzlt, "schema");
            zzlt<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzlt);
            return putIfAbsent == null ? zzlt : putIfAbsent;
        }
    }
}

package com.google.android.gms.internal.ads;

import com.didi.sdk.push.fcm.Constact;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepb {
    private static final zzepb zziwr = new zzepb();
    private final zzepl zziws = new zzeoa();
    private final ConcurrentMap<Class<?>, zzepi<?>> zziwt = new ConcurrentHashMap();

    public static zzepb zzble() {
        return zziwr;
    }

    public final <T> zzepi<T> zzj(Class<T> cls) {
        zzenc.zza(cls, Constact.KEY_LINK_MESSAGETYPE);
        zzepi<T> zzepi = (zzepi) this.zziwt.get(cls);
        if (zzepi != null) {
            return zzepi;
        }
        zzepi<T> zzi = this.zziws.zzi(cls);
        zzenc.zza(cls, Constact.KEY_LINK_MESSAGETYPE);
        zzenc.zza(zzi, "schema");
        zzepi<T> putIfAbsent = this.zziwt.putIfAbsent(cls, zzi);
        return putIfAbsent != null ? putIfAbsent : zzi;
    }

    public final <T> zzepi<T> zzax(T t) {
        return zzj(t.getClass());
    }

    private zzepb() {
    }
}

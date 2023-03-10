package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public final class zzif {
    public static <T> zzib<T> zza(zzib<T> zzib) {
        if ((zzib instanceof zzid) || (zzib instanceof zzic)) {
            return zzib;
        }
        if (zzib instanceof Serializable) {
            return new zzic(zzib);
        }
        return new zzid(zzib);
    }

    public static <T> zzib<T> zzb(@NullableDecl T t) {
        return new zzie(t);
    }
}

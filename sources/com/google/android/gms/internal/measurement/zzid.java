package com.google.android.gms.internal.measurement;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzid<T> implements zzib<T> {
    volatile zzib<T> zza;
    volatile boolean zzb;
    @NullableDecl
    T zzc;

    zzid(zzib<T> zzib) {
        if (zzib != null) {
            this.zza = zzib;
            return;
        }
        throw null;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}

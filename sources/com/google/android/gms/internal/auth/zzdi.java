package com.google.android.gms.internal.auth;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzdi<T> implements zzdg<T> {
    @CheckForNull
    volatile zzdg<T> zza;
    volatile boolean zzb;
    @CheckForNull
    T zzc;

    zzdi(zzdg<T> zzdg) {
        if (zzdg != null) {
            this.zza = zzdg;
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
                    zzdg<T> zzdg = this.zza;
                    zzdg.getClass();
                    T zza2 = zzdg.zza();
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

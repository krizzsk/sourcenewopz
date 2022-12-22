package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedm implements zzedl.zzb {
    private final /* synthetic */ zzedi zzifi;
    private final /* synthetic */ zzecu zzifj;

    zzedm(zzedi zzedi, zzecu zzecu) {
        this.zzifi = zzedi;
        this.zzifj = zzecu;
    }

    public final <Q> zzect<Q> zzc(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzedj(this.zzifi, this.zzifj, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzect<?> zzbbv() {
        zzedi zzedi = this.zzifi;
        return new zzedj(zzedi, this.zzifj, zzedi.zzbbm());
    }

    public final Class<?> zzbbw() {
        return this.zzifi.getClass();
    }

    public final Set<Class<?>> zzbbl() {
        return this.zzifi.zzbbl();
    }

    public final Class<?> zzbbx() {
        return this.zzifj.getClass();
    }
}

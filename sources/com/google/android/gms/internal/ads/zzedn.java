package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedn implements zzedl.zzb {
    private final /* synthetic */ zzecu zzifk;

    zzedn(zzecu zzecu) {
        this.zzifk = zzecu;
    }

    public final Class<?> zzbbx() {
        return null;
    }

    public final <Q> zzect<Q> zzc(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzecs(this.zzifk, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzect<?> zzbbv() {
        zzecu zzecu = this.zzifk;
        return new zzecs(zzecu, zzecu.zzbbm());
    }

    public final Class<?> zzbbw() {
        return this.zzifk.getClass();
    }

    public final Set<Class<?>> zzbbl() {
        return this.zzifk.zzbbl();
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedk implements zzedl.zzb {
    private final /* synthetic */ zzect zzifc;

    zzedk(zzect zzect) {
        this.zzifc = zzect;
    }

    public final Class<?> zzbbx() {
        return null;
    }

    public final <Q> zzect<Q> zzc(Class<Q> cls) throws GeneralSecurityException {
        if (this.zzifc.zzbbh().equals(cls)) {
            return this.zzifc;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzect<?> zzbbv() {
        return this.zzifc;
    }

    public final Class<?> zzbbw() {
        return this.zzifc.getClass();
    }

    public final Set<Class<?>> zzbbl() {
        return Collections.singleton(this.zzifc.zzbbh());
    }
}

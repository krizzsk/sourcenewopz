package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzecz {
    private final zzeik zziep;

    private zzecz(zzeik zzeik) {
        this.zziep = zzeik;
    }

    static final zzecz zza(zzeik zzeik) throws GeneralSecurityException {
        if (zzeik != null && zzeik.zzbfk() > 0) {
            return new zzecz(zzeik);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzedp.zzb(this.zziep).toString();
    }

    public final <P> P zza(Class<P> cls) throws GeneralSecurityException {
        Class<?> zzd = zzedl.zzd(cls);
        if (zzd == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        zzedp.zzc(this.zziep);
        zzedc<P> zzb = zzedc.zzb(zzd);
        for (zzeik.zzb next : this.zziep.zzbfj()) {
            if (next.zzbbr() == zzeid.ENABLED) {
                zzede<P> zza = zzb.zza(zzedl.zza(next.zzbfn(), zzd), next);
                if (next.zzbfo() == this.zziep.zzbfi()) {
                    zzb.zza(zza);
                }
            }
        }
        return zzedl.zza(zzb, cls);
    }
}

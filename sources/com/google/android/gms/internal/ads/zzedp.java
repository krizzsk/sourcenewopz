package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedp {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzein zzb(zzeik zzeik) {
        zzein.zzb zzfv = zzein.zzbfq().zzfv(zzeik.zzbfi());
        for (zzeik.zzb next : zzeik.zzbfj()) {
            zzfv.zzb((zzein.zza) ((zzena) zzein.zza.zzbfs().zzhw(next.zzbfn().zzbev()).zzb(next.zzbbr()).zzb(next.zzbbs()).zzfw(next.zzbfo()).zzbjv()));
        }
        return (zzein) ((zzena) zzfv.zzbjv());
    }

    public static void zzc(zzeik zzeik) throws GeneralSecurityException {
        int zzbfi = zzeik.zzbfi();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzeik.zzb next : zzeik.zzbfj()) {
            if (next.zzbbr() == zzeid.ENABLED) {
                if (!next.zzbfm()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzbfo())}));
                } else if (next.zzbbs() == zzeiw.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzbfo())}));
                } else if (next.zzbbr() != zzeid.UNKNOWN_STATUS) {
                    if (next.zzbfo() == zzbfi) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzbfn().zzbex() != zzeic.zza.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzbfo())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}

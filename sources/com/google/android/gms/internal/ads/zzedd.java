package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeik;
import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedd {
    @Deprecated
    public static final zzecz zzl(byte[] bArr) throws GeneralSecurityException {
        try {
            zzeik zzc = zzeik.zzc(bArr, zzemn.zzbiv());
            for (zzeik.zzb next : zzc.zzbfj()) {
                if (next.zzbfn().zzbex() == zzeic.zza.UNKNOWN_KEYMATERIAL || next.zzbfn().zzbex() == zzeic.zza.SYMMETRIC || next.zzbfn().zzbex() == zzeic.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzecz.zza(zzc);
        } catch (zzenn unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}

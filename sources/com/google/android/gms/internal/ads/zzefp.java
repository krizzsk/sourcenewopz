package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefp extends zzecw<zzeda, zzehu> {
    zzefp(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) throws GeneralSecurityException {
        zzehu zzehu = (zzehu) obj;
        zzehs zzbes = zzehu.zzbem().zzbes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzehu.zzbcc().toByteArray(), "HMAC");
        int zzbch = zzehu.zzbem().zzbch();
        int i = zzefr.zzigw[zzbes.ordinal()];
        if (i == 1) {
            return new zzekq(new zzeko("HMACSHA1", secretKeySpec), zzbch);
        }
        if (i == 2) {
            return new zzekq(new zzeko("HMACSHA256", secretKeySpec), zzbch);
        }
        if (i == 3) {
            return new zzekq(new zzeko("HMACSHA512", secretKeySpec), zzbch);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}

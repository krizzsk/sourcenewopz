package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefg {
    public static void zza(zzehj zzehj) throws GeneralSecurityException {
        zzejw.zza(zza(zzehj.zzbdu().zzbeh()));
        zza(zzehj.zzbdu().zzbei());
        if (zzehj.zzbdw() != zzehd.UNKNOWN_FORMAT) {
            zzedl.zza(zzehj.zzbdv().zzbdp());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzehs zzehs) throws NoSuchAlgorithmException {
        int i = zzefj.zzigw[zzehs.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzehs);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzejy zza(zzehr zzehr) throws GeneralSecurityException {
        int i = zzefj.zzigx[zzehr.ordinal()];
        if (i == 1) {
            return zzejy.NIST_P256;
        }
        if (i == 2) {
            return zzejy.NIST_P384;
        }
        if (i == 3) {
            return zzejy.NIST_P521;
        }
        String valueOf = String.valueOf(zzehr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzekb zza(zzehd zzehd) throws GeneralSecurityException {
        int i = zzefj.zzigy[zzehd.ordinal()];
        if (i == 1) {
            return zzekb.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzekb.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzekb.COMPRESSED;
        }
        String valueOf = String.valueOf(zzehd);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzekq implements zzeda {
    private final zzefu zzinz;
    private final int zzioa;

    public zzekq(zzefu zzefu, int i) throws GeneralSecurityException {
        this.zzinz = zzefu;
        this.zzioa = i;
        if (i >= 10) {
            zzefu.zzd(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        return this.zzinz.zzd(bArr, this.zzioa);
    }
}

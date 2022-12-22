package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzekp implements zzefu {
    private final SecretKey zzigl;
    private byte[] zzinx;
    private byte[] zziny;

    private static Cipher zzbgq() throws GeneralSecurityException {
        return zzekd.zzinj.zzhx("AES/ECB/NoPadding");
    }

    public zzekp(byte[] bArr) throws GeneralSecurityException {
        zzeku.zzgc(bArr.length);
        this.zzigl = new SecretKeySpec(bArr, "AES");
        Cipher zzbgq = zzbgq();
        zzbgq.init(1, this.zzigl);
        byte[] zzp = zzejk.zzp(zzbgq.doFinal(new byte[16]));
        this.zzinx = zzp;
        this.zziny = zzejk.zzp(zzp);
    }

    public final byte[] zzd(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzbgq = zzbgq();
            zzbgq.init(1, this.zzigl);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if ((max << 4) == bArr.length) {
                bArr2 = zzejn.zza(bArr, (max - 1) << 4, this.zzinx, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
                if (copyOfRange.length < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                    bArr2 = zzejn.zzd(copyOf, this.zziny);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzbgq.doFinal(zzejn.zza(bArr3, 0, bArr, i2 << 4, 16));
            }
            return Arrays.copyOf(zzbgq.doFinal(zzejn.zzd(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzejf implements zzekn {
    private static final ThreadLocal<Cipher> zzigk = new zzeje();
    private final SecretKeySpec zzily;
    private final int zzilz;
    private final int zzima;

    public zzejf(byte[] bArr, int i) throws GeneralSecurityException {
        zzeku.zzgc(bArr.length);
        this.zzily = new SecretKeySpec(bArr, "AES");
        int blockSize = zzigk.get().getBlockSize();
        this.zzima = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzilz = i;
    }

    public final byte[] zzn(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzilz;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzgb = zzekt.zzgb(i);
            System.arraycopy(zzgb, 0, bArr2, 0, this.zzilz);
            int length2 = bArr.length;
            int i2 = this.zzilz;
            Cipher cipher = zzigk.get();
            byte[] bArr3 = new byte[this.zzima];
            System.arraycopy(zzgb, 0, bArr3, 0, this.zzilz);
            cipher.init(1, this.zzily, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.zzilz);
        throw new GeneralSecurityException(sb.toString());
    }
}

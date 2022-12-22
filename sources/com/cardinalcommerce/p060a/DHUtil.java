package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.DHUtil */
public final class DHUtil implements X931SignatureSpi.RIPEMD128WithRSAEncryption {
    public static final DHUtil cca_continue = new DHUtil();

    public final byte[] getInstance(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int init = setSelected.init(bigInteger);
        byte[] bArr = new byte[(init << 1)];
        m1799a(bigInteger, bigInteger2, bArr, 0, init);
        m1799a(bigInteger, bigInteger3, bArr, init, init);
        return bArr;
    }

    public final BigInteger[] configure(BigInteger bigInteger, byte[] bArr) {
        int init = setSelected.init(bigInteger);
        if (bArr.length == (init << 1)) {
            BigInteger[] bigIntegerArr = new BigInteger[2];
            BigInteger bigInteger2 = new BigInteger(1, setForegroundTintBlendMode.cca_continue(bArr, 0, init + 0));
            if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("Value out of range");
            }
            bigIntegerArr[0] = bigInteger2;
            BigInteger bigInteger3 = new BigInteger(1, setForegroundTintBlendMode.cca_continue(bArr, init, init + init));
            if (bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("Value out of range");
            }
            bigIntegerArr[1] = bigInteger3;
            return bigIntegerArr;
        }
        throw new IllegalArgumentException("Encoding has incorrect length");
    }

    /* renamed from: a */
    private static void m1799a(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i, int i2) {
        if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            throw new IllegalArgumentException("Value out of range");
        }
        byte[] byteArray = bigInteger2.toByteArray();
        int max = Math.max(0, byteArray.length - i2);
        int length = byteArray.length - max;
        int i3 = (i2 - length) + i;
        setForegroundTintBlendMode.getInstance(bArr, i, i3);
        System.arraycopy(byteArray, max, bArr, i3, length);
    }
}

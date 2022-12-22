package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnReceiveContentListener */
public abstract class setOnReceiveContentListener {

    /* renamed from: a */
    private static setAccessibilityPaneTitle f2906a = new C2013i(BigInteger.valueOf(2));

    /* renamed from: b */
    private static setAccessibilityPaneTitle f2907b = new C2013i(BigInteger.valueOf(3));

    public static setContentCaptureSession Cardinal(int[] iArr) {
        if (iArr[0] == 0) {
            int i = 1;
            while (i < iArr.length) {
                if (iArr[i] > iArr[i - 1]) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new C2025p(f2906a, new C2129t(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static setAccessibilityPaneTitle getInstance(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return f2906a;
            }
            if (intValue == 3) {
                return f2907b;
            }
        }
        return new C2013i(bigInteger);
    }
}

package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setForeground */
public final class setForeground {
    static {
        BigInteger.valueOf(0);
        BigInteger.valueOf(1);
        BigInteger.valueOf(2);
        BigInteger.valueOf(4);
    }

    public static int init(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 8;
        }
        return i2;
    }
}

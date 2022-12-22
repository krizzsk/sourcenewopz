package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setSecondaryProgress */
public enum setSecondaryProgress {
    RSA,
    EC;
    
    private static int cca_continue = 1;
    private static int configure;

    static {
        int i = configure;
        int i2 = (i | 97) << 1;
        int i3 = -(((~i) & 97) | (i & -98));
        int i4 = (i2 & i3) + (i3 | i2);
        cca_continue = i4 % 128;
        if ((i4 % 2 == 0 ? 9 : '?') != '?') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }
}

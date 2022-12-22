package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setMovementMethod */
public enum setMovementMethod {
    JOSE,
    JSON;
    
    private static int cca_continue = 1;
    private static int configure;

    static {
        boolean z;
        int i = configure;
        int i2 = i & 125;
        int i3 = (i2 - (~((i ^ 125) | i2))) - 1;
        cca_continue = i3 % 128;
        if (i3 % 2 != 0) {
            z = true;
        }
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }
}

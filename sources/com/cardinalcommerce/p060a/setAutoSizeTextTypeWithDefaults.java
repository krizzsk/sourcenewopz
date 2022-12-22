package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setAutoSizeTextTypeWithDefaults */
public enum setAutoSizeTextTypeWithDefaults {
    LOW,
    MEDIUM,
    HIGH;
    
    private static int Cardinal = 1;
    private static int configure;

    static {
        boolean z;
        int i = Cardinal;
        int i2 = i & 49;
        int i3 = ((i ^ 49) | i2) << 1;
        int i4 = -((i | 49) & (~i2));
        int i5 = (i3 & i4) + (i4 | i3);
        configure = i5 % 128;
        if (i5 % 2 == 0) {
            z = true;
        }
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }
}

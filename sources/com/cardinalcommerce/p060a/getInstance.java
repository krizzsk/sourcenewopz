package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.getInstance */
public final class getInstance {

    /* renamed from: a */
    private static final boolean[][] f2564a = {new boolean[]{true, true, false, false, false, false, false, false, false, false}, new boolean[]{true, true, true, false, false, false, false, false, false, false}, new boolean[]{true, true, true, true, false, false, false, false, false, false}, new boolean[]{true, true, true, false, true, false, true, false, false, false}, new boolean[]{false, true, false, true, true, true, true, true, true, false}, new boolean[]{true, true, true, true, true, true, true, true, true, false}, new boolean[]{false, false, false, false, false, false, false, false, false, true}, new boolean[]{false, true, false, false, false, false, true, true, true, false}, new boolean[]{false, true, false, false, false, false, false, true, true, true}, new boolean[]{true, true, true, false, true, false, true, true, false, false}};

    /* renamed from: b */
    private static int f2565b = 0;

    /* renamed from: c */
    private static int f2566c = 1;

    getInstance() {
    }

    static {
        int i = 1 & 103;
        int i2 = ((((1 ^ 103) | i) << 1) - (~(-((~i) & (1 | 103))))) - 1;
        f2565b = i2 % 128;
        int i3 = i2 % 2;
    }

    public static boolean cca_continue(cca_continue cca_continue, cca_continue cca_continue2) {
        int i = f2565b;
        int i2 = i & 49;
        int i3 = i2 + ((i ^ 49) | i2);
        f2566c = i3 % 128;
        int i4 = i3 % 2;
        boolean z = f2564a[cca_continue.index][cca_continue2.index];
        int i5 = f2566c;
        int i6 = i5 & 45;
        int i7 = (i5 ^ 45) | i6;
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f2565b = i8 % 128;
        int i9 = i8 % 2;
        return z;
    }
}

package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setNextClusterForwardId */
public abstract class setNextClusterForwardId {
    public static void cca_continue(long[] jArr, long[] jArr2, int i) {
        jArr2[i] = jArr[0];
        jArr2[i + 1] = jArr[1];
        jArr2[i + 2] = jArr[2];
        jArr2[i + 3] = jArr[3];
        jArr2[i + 4] = jArr[4];
        jArr2[i + 5] = jArr[5];
        jArr2[i + 6] = jArr[6];
    }

    public static boolean configure(long[] jArr) {
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean configure(long[] jArr, long[] jArr2) {
        for (int i = 6; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean getInstance(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

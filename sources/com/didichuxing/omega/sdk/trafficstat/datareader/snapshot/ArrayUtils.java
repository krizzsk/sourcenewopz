package com.didichuxing.omega.sdk.trafficstat.datareader.snapshot;

import java.util.Arrays;

public final class ArrayUtils {
    public static final int[] INT = new int[0];
    public static final long[] LONG = new long[0];
    public static final String[] STRING = new String[0];

    public static <T> boolean contains(int[] iArr, int i) {
        return indexOf(iArr, Integer.valueOf(i)) != -1;
    }

    public static <T> int indexOf(int[] iArr, Integer num) {
        if (iArr == null) {
            return -1;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (equals(Integer.valueOf(iArr[i]), num)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}

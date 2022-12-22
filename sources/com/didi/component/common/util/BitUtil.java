package com.didi.component.common.util;

public class BitUtil {
    public static long value_bit(long j, int i, boolean z) {
        int i2 = i - 1;
        return z ? j | ((long) (1 << i2)) : j & ((long) (~(1 << i2)));
    }

    public static boolean value_bit(long j, int i) {
        return ((j >> (i - 1)) & 1) == 1;
    }
}

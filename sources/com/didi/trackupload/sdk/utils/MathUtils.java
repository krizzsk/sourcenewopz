package com.didi.trackupload.sdk.utils;

public class MathUtils {
    public static int gcd(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return 0;
        }
        while (true) {
            int i3 = i % i2;
            if (i3 == 0) {
                return i2;
            }
            int i4 = i2;
            i2 = i3;
            i = i4;
        }
    }
}

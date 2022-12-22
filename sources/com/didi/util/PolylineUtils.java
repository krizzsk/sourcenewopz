package com.didi.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PolylineUtils {
    public static final int ArrowType_Circle = 5;
    public static final int ArrowType_Left = 2;
    public static final int ArrowType_Right = 3;
    public static final int ArrowType_Straight = 1;
    public static final int ArrowType_TurnAround = 4;
    public static final int ArrowType_Unknown = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowType {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        return 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        return 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getPolylineType(int r0) {
        /*
            switch(r0) {
                case 1: goto L_0x001f;
                case 2: goto L_0x001d;
                case 3: goto L_0x001b;
                case 4: goto L_0x0019;
                case 5: goto L_0x0017;
                case 6: goto L_0x001d;
                case 7: goto L_0x001b;
                case 8: goto L_0x001f;
                default: goto L_0x0003;
            }
        L_0x0003:
            switch(r0) {
                case 10: goto L_0x001d;
                case 11: goto L_0x001d;
                case 12: goto L_0x001d;
                case 13: goto L_0x001d;
                case 14: goto L_0x001d;
                case 15: goto L_0x001d;
                case 16: goto L_0x001d;
                case 17: goto L_0x001d;
                default: goto L_0x0006;
            }
        L_0x0006:
            switch(r0) {
                case 20: goto L_0x001b;
                case 21: goto L_0x001b;
                case 22: goto L_0x001b;
                case 23: goto L_0x001b;
                case 24: goto L_0x001b;
                case 25: goto L_0x001b;
                case 26: goto L_0x001b;
                case 27: goto L_0x001b;
                default: goto L_0x0009;
            }
        L_0x0009:
            switch(r0) {
                case 30: goto L_0x001d;
                case 31: goto L_0x001d;
                case 32: goto L_0x001d;
                case 33: goto L_0x001d;
                case 34: goto L_0x001d;
                case 35: goto L_0x001d;
                case 36: goto L_0x001d;
                case 37: goto L_0x001d;
                case 38: goto L_0x001d;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r0) {
                case 40: goto L_0x001b;
                case 41: goto L_0x001b;
                case 42: goto L_0x001b;
                case 43: goto L_0x001b;
                case 44: goto L_0x001b;
                case 45: goto L_0x001b;
                case 46: goto L_0x001b;
                case 47: goto L_0x001b;
                case 48: goto L_0x001b;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r0) {
                case 51: goto L_0x0017;
                case 52: goto L_0x0017;
                case 53: goto L_0x0017;
                case 54: goto L_0x0017;
                case 55: goto L_0x0017;
                case 56: goto L_0x0017;
                case 57: goto L_0x0017;
                case 58: goto L_0x0017;
                case 59: goto L_0x0017;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r0) {
                case 81: goto L_0x001f;
                case 82: goto L_0x001f;
                case 83: goto L_0x001f;
                case 84: goto L_0x001f;
                case 85: goto L_0x0019;
                case 86: goto L_0x0019;
                case 87: goto L_0x0019;
                case 88: goto L_0x0019;
                case 89: goto L_0x0019;
                default: goto L_0x0015;
            }
        L_0x0015:
            r0 = 0
            goto L_0x0020
        L_0x0017:
            r0 = 5
            goto L_0x0020
        L_0x0019:
            r0 = 4
            goto L_0x0020
        L_0x001b:
            r0 = 3
            goto L_0x0020
        L_0x001d:
            r0 = 2
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.util.PolylineUtils.getPolylineType(int):int");
    }
}

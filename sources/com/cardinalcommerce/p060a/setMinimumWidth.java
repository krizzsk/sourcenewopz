package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setMinimumWidth */
public abstract class setMinimumWidth {
    public static int cca_continue(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public static void configure(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static byte[] configure(int i) {
        byte[] bArr = new byte[4];
        getInstance(i, bArr, 0);
        return bArr;
    }

    public static int getInstance(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public static void getInstance(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static short init(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static byte[] init(int i) {
        byte[] bArr = new byte[4];
        configure(i, bArr, 0);
        return bArr;
    }

    public static byte[] Cardinal(long j) {
        byte[] bArr = new byte[8];
        configure((int) j, bArr, 0);
        configure((int) (j >>> 32), bArr, 4);
        return bArr;
    }
}

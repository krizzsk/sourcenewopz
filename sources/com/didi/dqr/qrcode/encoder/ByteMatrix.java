package com.didi.dqr.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class ByteMatrix {

    /* renamed from: a */
    private final byte[][] f19080a;

    /* renamed from: b */
    private final int f19081b;

    /* renamed from: c */
    private final int f19082c;

    public ByteMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.f19080a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.f19081b = i;
        this.f19082c = i2;
    }

    public int getHeight() {
        return this.f19082c;
    }

    public int getWidth() {
        return this.f19081b;
    }

    public byte get(int i, int i2) {
        return this.f19080a[i2][i];
    }

    public byte[][] getArray() {
        return this.f19080a;
    }

    public void set(int i, int i2, byte b) {
        this.f19080a[i2][i] = b;
    }

    public void set(int i, int i2, int i3) {
        this.f19080a[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        this.f19080a[i2][i] = z ? (byte) 1 : 0;
    }

    public void clear(byte b) {
        for (byte[] fill : this.f19080a) {
            Arrays.fill(fill, b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f19081b * 2 * this.f19082c) + 2);
        for (int i = 0; i < this.f19082c; i++) {
            byte[] bArr = this.f19080a[i];
            for (int i2 = 0; i2 < this.f19081b; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

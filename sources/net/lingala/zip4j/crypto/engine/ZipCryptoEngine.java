package net.lingala.zip4j.crypto.engine;

import net.lingala.zip4j.util.Zip4jUtil;

public class ZipCryptoEngine {

    /* renamed from: b */
    private static final int[] f4823b = new int[256];

    /* renamed from: a */
    private final int[] f4824a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ -306674912 : i2 >>> 1;
            }
            f4823b[i] = i2;
        }
    }

    public void initKeys(char[] cArr) {
        int[] iArr = this.f4824a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b : Zip4jUtil.convertCharArrayToByteArray(cArr)) {
            updateKeys((byte) (b & 255));
        }
    }

    public void updateKeys(byte b) {
        int[] iArr = this.f4824a;
        iArr[0] = m3074a(iArr[0], b);
        int[] iArr2 = this.f4824a;
        iArr2[1] = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = (iArr2[1] * 134775813) + 1;
        iArr2[2] = m3074a(iArr2[2], (byte) (iArr2[1] >> 24));
    }

    /* renamed from: a */
    private int m3074a(int i, byte b) {
        return f4823b[(i ^ b) & 255] ^ (i >>> 8);
    }

    public byte decryptByte() {
        int i = this.f4824a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }
}

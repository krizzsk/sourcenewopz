package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.appsflyer.internal.al */
public class C1686al extends FilterInputStream {

    /* renamed from: Ι */
    private static final short f1924 = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));

    /* renamed from: ı */
    private byte[] f1925 = new byte[8];

    /* renamed from: Ɩ */
    private int f1926;

    /* renamed from: ǃ */
    private int f1927 = 8;

    /* renamed from: ȷ */
    private int f1928;

    /* renamed from: ɩ */
    private byte[] f1929 = new byte[8];

    /* renamed from: ɹ */
    private int f1930;

    /* renamed from: ɾ */
    private int f1931;

    /* renamed from: ι */
    private byte[] f1932 = new byte[8];

    /* renamed from: І */
    private int f1933;

    /* renamed from: і */
    private int f1934 = 8;

    /* renamed from: Ӏ */
    private int f1935 = Integer.MAX_VALUE;

    /* renamed from: ӏ */
    private int f1936;

    public boolean markSupported() {
        return false;
    }

    public C1686al(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.f1933 = Math.min(Math.max(i2, 5), 16);
        this.f1930 = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.f1932, 0, 8);
        }
        long j = ((((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32) | (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[1]));
        if (i == 0) {
            this.f1926 = (int) j;
            long j2 = j >> 3;
            short s = f1924;
            this.f1931 = (int) ((((long) s) * j2) >> 32);
            this.f1928 = (int) (j >> 32);
            this.f1936 = (int) (j2 + ((long) s));
            return;
        }
        int i4 = (int) j;
        this.f1926 = i4;
        this.f1931 = i4 * i;
        this.f1928 = i4 ^ i;
        this.f1936 = (int) (j >> 32);
    }

    public int read() throws IOException {
        m1648();
        int i = this.f1927;
        if (i >= this.f1934) {
            return -1;
        }
        byte[] bArr = this.f1925;
        this.f1927 = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            m1648();
            int i5 = this.f1927;
            if (i5 < this.f1934) {
                byte[] bArr2 = this.f1925;
                this.f1927 = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public int available() throws IOException {
        m1648();
        return this.f1934 - this.f1927;
    }

    /* renamed from: ɩ */
    private void m1647() {
        if (this.f1930 == 3) {
            byte[] bArr = this.f1925;
            System.arraycopy(bArr, 0, this.f1929, 0, bArr.length);
        }
        byte[] bArr2 = this.f1925;
        int i = ((bArr2[0] << Ascii.CAN) & -16777216) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i2 = (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.f1933;
            if (i3 >= i4) {
                break;
            }
            short s = f1924;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.f1928)) ^ ((i >>> 5) + this.f1936);
            i -= (((i2 << 4) + this.f1926) ^ ((s * (i4 - i3)) + i2)) ^ ((i2 >>> 5) + this.f1931);
            i3++;
        }
        byte[] bArr3 = this.f1925;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.f1930 == 3) {
            for (int i5 = 0; i5 < 8; i5++) {
                byte[] bArr4 = this.f1925;
                bArr4[i5] = (byte) (bArr4[i5] ^ this.f1932[i5]);
            }
            byte[] bArr5 = this.f1929;
            System.arraycopy(bArr5, 0, this.f1932, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* renamed from: ι */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1648() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.f1935
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f1935 = r0
        L_0x000f:
            int r0 = r7.f1927
            r1 = 8
            if (r0 != r1) goto L_0x005a
            byte[] r0 = r7.f1925
            int r2 = r7.f1935
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0054
            r2 = 1
        L_0x0023:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.f1925
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0032
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0023
        L_0x0032:
            if (r2 < r1) goto L_0x004e
            r7.m1647()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f1935 = r0
            r7.f1927 = r4
            if (r0 >= 0) goto L_0x004b
            byte[] r0 = r7.f1925
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004b:
            r7.f1934 = r1
            goto L_0x005a
        L_0x004e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0054:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x005a:
            int r0 = r7.f1934
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1686al.m1648():int");
    }
}

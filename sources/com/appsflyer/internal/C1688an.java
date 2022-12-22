package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.appsflyer.internal.an */
public class C1688an extends FilterInputStream {

    /* renamed from: ı */
    private byte[] f1938;

    /* renamed from: Ɩ */
    private int f1939;

    /* renamed from: ǃ */
    private byte[] f1940;

    /* renamed from: ɩ */
    private C1685ak f1941;

    /* renamed from: ɹ */
    private int[] f1942;

    /* renamed from: Ι */
    private byte[] f1943;

    /* renamed from: ι */
    private final int f1944;

    /* renamed from: І */
    private int f1945;

    /* renamed from: і */
    private int f1946 = Integer.MAX_VALUE;

    /* renamed from: Ӏ */
    private int f1947;

    public boolean markSupported() {
        return false;
    }

    public C1688an(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        super(inputStream);
        this.f1944 = Math.min(Math.max(i, 3), 16);
        this.f1940 = new byte[8];
        byte[] bArr2 = new byte[8];
        this.f1943 = bArr2;
        this.f1938 = new byte[8];
        this.f1942 = new int[2];
        this.f1939 = 8;
        this.f1947 = 8;
        this.f1945 = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.f1941 = new C1685ak(iArr, this.f1944, true, z);
    }

    public int read() throws IOException {
        m1649();
        int i = this.f1939;
        if (i >= this.f1947) {
            return -1;
        }
        byte[] bArr = this.f1940;
        this.f1939 = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            m1649();
            int i5 = this.f1939;
            if (i5 < this.f1947) {
                byte[] bArr2 = this.f1940;
                this.f1939 = i5 + 1;
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
        m1649();
        return this.f1947 - this.f1939;
    }

    /* renamed from: Ι */
    private void m1650() {
        if (this.f1945 == 2) {
            byte[] bArr = this.f1940;
            System.arraycopy(bArr, 0, this.f1938, 0, bArr.length);
        }
        byte[] bArr2 = this.f1940;
        C1684aj.m1644(((bArr2[0] << Ascii.CAN) & -16777216) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255), (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.f1944, this.f1941.f1922, this.f1941.f1923, this.f1942);
        int[] iArr = this.f1942;
        int i = iArr[0];
        int i2 = iArr[1];
        byte[] bArr3 = this.f1940;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.f1945 == 2) {
            for (int i3 = 0; i3 < 8; i3++) {
                byte[] bArr4 = this.f1940;
                bArr4[i3] = (byte) (bArr4[i3] ^ this.f1943[i3]);
            }
            byte[] bArr5 = this.f1938;
            System.arraycopy(bArr5, 0, this.f1943, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* renamed from: ǃ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1649() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.f1946
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f1946 = r0
        L_0x000f:
            int r0 = r7.f1939
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.f1940
            int r2 = r7.f1946
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.f1940
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.m1650()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f1946 = r0
            r7.f1939 = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.f1940
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.f1947 = r1
            goto L_0x0059
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0059:
            int r0 = r7.f1947
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1688an.m1649():int");
    }
}

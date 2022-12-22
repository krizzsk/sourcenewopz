package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.ECGOST2012SignatureSpi512 */
public final class ECGOST2012SignatureSpi512 implements KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo, setPaddingRelative {

    /* renamed from: a */
    private static final int[] f2410a = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, 200, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};

    /* renamed from: b */
    private static final long[] f2411b = new long[256];

    /* renamed from: c */
    private static final long[] f2412c = new long[256];

    /* renamed from: d */
    private static final long[] f2413d = new long[256];

    /* renamed from: e */
    private static final long[] f2414e = new long[256];

    /* renamed from: f */
    private static final long[] f2415f = new long[256];

    /* renamed from: g */
    private static final long[] f2416g = new long[256];

    /* renamed from: h */
    private static final long[] f2417h = new long[256];

    /* renamed from: i */
    private static final long[] f2418i = new long[256];

    /* renamed from: s */
    private static final short[] f2419s;

    /* renamed from: j */
    private final long[] f2420j = new long[11];

    /* renamed from: k */
    private byte[] f2421k = new byte[64];

    /* renamed from: l */
    private int f2422l = 0;

    /* renamed from: m */
    private short[] f2423m = new short[32];

    /* renamed from: n */
    private long[] f2424n = new long[8];

    /* renamed from: o */
    private long[] f2425o = new long[8];

    /* renamed from: p */
    private long[] f2426p = new long[8];

    /* renamed from: q */
    private long[] f2427q = new long[8];

    /* renamed from: r */
    private long[] f2428r = new long[8];

    static {
        short[] sArr = new short[32];
        f2419s = sArr;
        sArr[31] = 8;
    }

    private ECGOST2012SignatureSpi512(ECGOST2012SignatureSpi512 eCGOST2012SignatureSpi512) {
        cca_continue(eCGOST2012SignatureSpi512);
    }

    /* renamed from: a */
    private static long m1806a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((((long) i2) << 48) ^ (((long) i) << 56)) ^ (((long) i3) << 40)) ^ (((long) i4) << 32)) ^ (((long) i5) << 24)) ^ (((long) i6) << 16)) ^ (((long) i7) << 8)) ^ ((long) i8);
    }

    /* renamed from: a */
    private static long m1807a(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    /* renamed from: b */
    private void m1809b() {
        long[] jArr;
        for (int i = 0; i < 8; i++) {
            long[] jArr2 = this.f2428r;
            long j = this.f2427q[i];
            long[] jArr3 = this.f2425o;
            long j2 = this.f2424n[i];
            jArr3[i] = j2;
            jArr2[i] = j ^ j2;
        }
        int i2 = 1;
        while (i2 <= 10) {
            int i3 = 0;
            while (i3 < 8) {
                long[] jArr4 = this.f2426p;
                jArr4[i3] = 0;
                long j3 = jArr4[i3];
                long[] jArr5 = f2411b;
                long[] jArr6 = this.f2425o;
                jArr4[i3] = jArr5[((int) (jArr6[i3 & 7] >>> 56)) & 255] ^ j3;
                jArr4[i3] = jArr4[i3] ^ f2412c[((int) (jArr6[(i3 - 1) & 7] >>> 48)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2413d[((int) (jArr6[(i3 - 2) & 7] >>> 40)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2414e[((int) (jArr6[(i3 - 3) & 7] >>> 32)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2415f[((int) (jArr6[(i3 - 4) & 7] >>> 24)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2416g[((int) (jArr6[(i3 - 5) & 7] >>> 16)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2417h[((int) (jArr6[(i3 - 6) & 7] >>> 8)) & 255];
                jArr4[i3] = jArr4[i3] ^ f2418i[((int) jArr6[(i3 - 7) & 7]) & 255];
                i3++;
                i2 = i2;
            }
            int i4 = i2;
            long[] jArr7 = this.f2426p;
            long[] jArr8 = this.f2425o;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this.f2425o;
            jArr9[0] = jArr9[0] ^ this.f2420j[i4];
            int i5 = 0;
            while (true) {
                jArr = this.f2426p;
                if (i5 >= 8) {
                    break;
                }
                jArr[i5] = this.f2425o[i5];
                long j4 = jArr[i5];
                long[] jArr10 = f2411b;
                long[] jArr11 = this.f2428r;
                jArr[i5] = j4 ^ jArr10[((int) (jArr11[i5 & 7] >>> 56)) & 255];
                jArr[i5] = jArr[i5] ^ f2412c[((int) (jArr11[(i5 - 1) & 7] >>> 48)) & 255];
                jArr[i5] = jArr[i5] ^ f2413d[((int) (jArr11[(i5 - 2) & 7] >>> 40)) & 255];
                jArr[i5] = jArr[i5] ^ f2414e[((int) (jArr11[(i5 - 3) & 7] >>> 32)) & 255];
                jArr[i5] = jArr[i5] ^ f2415f[((int) (jArr11[(i5 - 4) & 7] >>> 24)) & 255];
                jArr[i5] = jArr[i5] ^ f2416g[((int) (jArr11[(i5 - 5) & 7] >>> 16)) & 255];
                jArr[i5] = jArr[i5] ^ f2417h[((int) (jArr11[(i5 - 6) & 7] >>> 8)) & 255];
                jArr[i5] = jArr[i5] ^ f2418i[((int) jArr11[(i5 - 7) & 7]) & 255];
                i5++;
            }
            long[] jArr12 = this.f2428r;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i2 = i4 + 1;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            long[] jArr13 = this.f2424n;
            jArr13[i6] = jArr13[i6] ^ (this.f2428r[i6] ^ this.f2427q[i6]);
        }
    }

    /* renamed from: c */
    private void m1810c() {
        int i = 0;
        for (int length = this.f2423m.length - 1; length >= 0; length--) {
            short[] sArr = this.f2423m;
            int i2 = (sArr[length] & 255) + f2419s[length] + i;
            i = i2 >>> 8;
            sArr[length] = (short) (i2 & 255);
        }
    }

    /* renamed from: d */
    private byte[] m1811d() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 32; i++) {
            bArr[i] = (byte) this.f2423m[i];
        }
        return bArr;
    }

    public final int Cardinal() {
        return 64;
    }

    public final void Cardinal(byte b) {
        byte[] bArr = this.f2421k;
        int i = this.f2422l;
        bArr[i] = b;
        int i2 = i + 1;
        this.f2422l = i2;
        if (i2 == bArr.length) {
            m1808a();
        }
        m1810c();
    }

    public final void cca_continue(setPaddingRelative setpaddingrelative) {
        ECGOST2012SignatureSpi512 eCGOST2012SignatureSpi512 = (ECGOST2012SignatureSpi512) setpaddingrelative;
        long[] jArr = eCGOST2012SignatureSpi512.f2420j;
        long[] jArr2 = this.f2420j;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = eCGOST2012SignatureSpi512.f2421k;
        byte[] bArr2 = this.f2421k;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f2422l = eCGOST2012SignatureSpi512.f2422l;
        short[] sArr = eCGOST2012SignatureSpi512.f2423m;
        short[] sArr2 = this.f2423m;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = eCGOST2012SignatureSpi512.f2424n;
        long[] jArr4 = this.f2424n;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = eCGOST2012SignatureSpi512.f2425o;
        long[] jArr6 = this.f2425o;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = eCGOST2012SignatureSpi512.f2426p;
        long[] jArr8 = this.f2426p;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = eCGOST2012SignatureSpi512.f2427q;
        long[] jArr10 = this.f2427q;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = eCGOST2012SignatureSpi512.f2428r;
        long[] jArr12 = this.f2428r;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public final String configure() {
        return "Whirlpool";
    }

    public final int getInstance() {
        return 64;
    }

    public final setPaddingRelative init() {
        return new ECGOST2012SignatureSpi512(this);
    }

    public final void init(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            Cardinal(bArr[i]);
            i++;
            i2--;
        }
    }

    public ECGOST2012SignatureSpi512() {
        for (int i = 0; i < 256; i++) {
            int i2 = f2410a[i];
            int i3 = i2 << 1;
            int i4 = ((long) i3) >= 256 ? i3 ^ 285 : i3;
            int i5 = i4 << 1;
            int i6 = ((long) i5) >= 256 ? i5 ^ 285 : i5;
            int i7 = i6 ^ i2;
            int i8 = i6 << 1;
            if (((long) i8) >= 256) {
                i8 ^= 285;
            }
            int i9 = i8;
            int i10 = i9 ^ i2;
            f2411b[i] = m1806a(i2, i2, i6, i2, i9, i7, i4, i10);
            int i11 = i2;
            f2412c[i] = m1806a(i10, i2, i11, i6, i2, i9, i7, i4);
            int i12 = i2;
            f2413d[i] = m1806a(i4, i10, i11, i12, i6, i2, i9, i7);
            int i13 = i2;
            f2414e[i] = m1806a(i7, i4, i10, i12, i13, i6, i2, i9);
            int i14 = i2;
            f2415f[i] = m1806a(i9, i7, i4, i10, i13, i14, i6, i2);
            int i15 = i2;
            f2416g[i] = m1806a(i2, i9, i7, i4, i10, i14, i15, i6);
            int i16 = i2;
            f2417h[i] = m1806a(i6, i2, i9, i7, i4, i10, i15, i16);
            f2418i[i] = m1806a(i2, i6, i2, i9, i7, i4, i10, i16);
        }
        this.f2420j[0] = 0;
        for (int i17 = 1; i17 <= 10; i17++) {
            int i18 = (i17 - 1) * 8;
            this.f2420j[i17] = (((((((f2411b[i18] & -72057594037927936L) ^ (f2412c[i18 + 1] & 71776119061217280L)) ^ (f2413d[i18 + 2] & 280375465082880L)) ^ (f2414e[i18 + 3] & 1095216660480L)) ^ (f2415f[i18 + 4] & 4278190080L)) ^ (f2416g[i18 + 5] & 16711680)) ^ (f2417h[i18 + 6] & 65280)) ^ (f2418i[i18 + 7] & 255);
        }
    }

    public final int configure(byte[] bArr, int i) {
        byte[] d = m1811d();
        byte[] bArr2 = this.f2421k;
        int i2 = this.f2422l;
        int i3 = i2 + 1;
        this.f2422l = i3;
        bArr2[i2] = (byte) (bArr2[i2] | 128);
        if (i3 == bArr2.length) {
            m1808a();
        }
        if (this.f2422l > 32) {
            while (this.f2422l != 0) {
                Cardinal((byte) 0);
            }
        }
        while (this.f2422l <= 32) {
            Cardinal((byte) 0);
        }
        System.arraycopy(d, 0, this.f2421k, 32, 32);
        m1808a();
        for (int i4 = 0; i4 < 8; i4++) {
            long j = this.f2424n[i4];
            int i5 = (i4 << 3) + i;
            for (int i6 = 0; i6 < 8; i6++) {
                bArr[i5 + i6] = (byte) ((int) ((j >> (56 - (i6 << 3))) & 255));
            }
        }
        cca_continue();
        return 64;
    }

    public final void cca_continue() {
        this.f2422l = 0;
        short[] sArr = this.f2423m;
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = 0;
        }
        byte[] bArr = this.f2421k;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = 0;
        }
        long[] jArr = this.f2424n;
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3] = 0;
        }
        long[] jArr2 = this.f2425o;
        for (int i4 = 0; i4 < jArr2.length; i4++) {
            jArr2[i4] = 0;
        }
        long[] jArr3 = this.f2426p;
        for (int i5 = 0; i5 < jArr3.length; i5++) {
            jArr3[i5] = 0;
        }
        long[] jArr4 = this.f2427q;
        for (int i6 = 0; i6 < jArr4.length; i6++) {
            jArr4[i6] = 0;
        }
        long[] jArr5 = this.f2428r;
        for (int i7 = 0; i7 < jArr5.length; i7++) {
            jArr5[i7] = 0;
        }
    }

    /* renamed from: a */
    private void m1808a() {
        for (int i = 0; i < this.f2428r.length; i++) {
            this.f2427q[i] = m1807a(this.f2421k, i << 3);
        }
        m1809b();
        this.f2422l = 0;
        byte[] bArr = this.f2421k;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }
}

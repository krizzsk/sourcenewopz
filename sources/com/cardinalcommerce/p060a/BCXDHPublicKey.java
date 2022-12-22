package com.cardinalcommerce.p060a;

import androidx.core.view.MotionEventCompat;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.google.common.base.Ascii;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.a.BCXDHPublicKey */
public final class BCXDHPublicKey implements KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo {

    /* renamed from: d */
    private static byte[] f2291d = {4, 10, 9, 2, Ascii.f53584CR, 8, 0, Ascii.f53594SO, 6, 11, 1, Ascii.f53586FF, 7, Ascii.f53593SI, 5, 3, Ascii.f53594SO, 11, 4, Ascii.f53586FF, 6, Ascii.f53584CR, Ascii.f53593SI, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, Ascii.f53584CR, 10, 3, 4, 2, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53586FF, 7, 6, 0, 9, 11, 7, Ascii.f53584CR, 10, 1, 0, 8, 9, Ascii.f53593SI, Ascii.f53594SO, 4, 6, Ascii.f53586FF, 11, 2, 5, 3, 6, Ascii.f53586FF, 7, 1, 5, Ascii.f53593SI, Ascii.f53584CR, 8, 4, 10, 9, Ascii.f53594SO, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, Ascii.f53584CR, 3, 6, 8, 5, 9, Ascii.f53586FF, Ascii.f53593SI, Ascii.f53594SO, Ascii.f53584CR, 11, 4, 1, 3, Ascii.f53593SI, 5, 9, 0, 10, Ascii.f53594SO, 7, 6, 8, 2, Ascii.f53586FF, 1, Ascii.f53593SI, Ascii.f53584CR, 0, 5, 7, 10, 4, 9, 2, 3, Ascii.f53594SO, 6, 11, 8, Ascii.f53586FF};

    /* renamed from: e */
    private static byte[] f2292e = {4, 2, Ascii.f53593SI, 5, 9, 1, 0, 8, Ascii.f53594SO, 3, 11, Ascii.f53586FF, Ascii.f53584CR, 7, 10, 6, Ascii.f53586FF, 9, Ascii.f53593SI, Ascii.f53594SO, 8, 1, 3, 10, 2, 7, 4, Ascii.f53584CR, 6, 0, 11, 5, Ascii.f53584CR, 8, Ascii.f53594SO, Ascii.f53586FF, 7, 3, 9, 10, 1, 5, 2, 4, 6, Ascii.f53593SI, 0, 11, Ascii.f53594SO, 9, 11, 2, 5, Ascii.f53593SI, 7, 1, 0, Ascii.f53584CR, Ascii.f53586FF, 6, 10, 4, 3, 8, 3, Ascii.f53594SO, 5, 9, 6, 8, 0, Ascii.f53584CR, 10, 11, 7, Ascii.f53586FF, 2, 1, Ascii.f53593SI, 4, 8, Ascii.f53593SI, 6, 11, 1, 9, Ascii.f53586FF, 5, Ascii.f53584CR, 3, 7, 10, 0, Ascii.f53594SO, 2, 4, 9, 11, Ascii.f53586FF, 0, 3, 6, 7, 5, 4, 8, Ascii.f53594SO, Ascii.f53593SI, 1, 10, 2, Ascii.f53584CR, Ascii.f53586FF, 6, 5, 2, 11, 0, 9, Ascii.f53584CR, 3, Ascii.f53594SO, 7, 10, Ascii.f53593SI, 4, 1, 8};

    /* renamed from: f */
    private static byte[] f2293f = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53586FF, 0, Ascii.f53584CR, 5, 3, 7, Ascii.f53594SO, 9, 8, 10, Ascii.f53593SI, 0, 5, 2, 6, Ascii.f53586FF, 11, 4, Ascii.f53584CR, 1, Ascii.f53594SO, 4, 6, 2, 11, 3, Ascii.f53584CR, 8, Ascii.f53586FF, Ascii.f53593SI, 5, 10, 0, 7, 1, 9, Ascii.f53594SO, 7, 10, Ascii.f53586FF, Ascii.f53584CR, 1, 3, 9, 0, 2, 11, 4, Ascii.f53593SI, 8, 5, 6, 11, 5, 1, 9, 8, Ascii.f53584CR, Ascii.f53593SI, 0, Ascii.f53594SO, 4, 2, 3, Ascii.f53586FF, 7, 10, 6, 3, 10, Ascii.f53584CR, Ascii.f53586FF, 1, 2, 0, 11, 7, 5, 9, 4, 8, Ascii.f53593SI, Ascii.f53594SO, 6, 1, Ascii.f53584CR, 2, 9, 7, 10, 6, 0, 8, Ascii.f53586FF, 4, 5, Ascii.f53593SI, 3, 11, Ascii.f53594SO, 11, 10, Ascii.f53593SI, 5, 0, Ascii.f53586FF, Ascii.f53594SO, 8, 6, 2, 3, 9, 1, 7, Ascii.f53584CR, 4};

    /* renamed from: g */
    private static byte[] f2294g = {8, 4, 11, 1, 3, 5, 0, 9, 2, Ascii.f53594SO, 10, Ascii.f53586FF, Ascii.f53584CR, 6, 7, Ascii.f53593SI, 0, 1, 2, 10, 4, Ascii.f53584CR, 5, Ascii.f53586FF, 9, 7, 3, Ascii.f53593SI, 11, 8, 6, Ascii.f53594SO, Ascii.f53594SO, Ascii.f53586FF, 0, 10, 9, 2, Ascii.f53584CR, 11, 7, 5, 8, Ascii.f53593SI, 3, 6, 1, 4, 7, 5, 0, Ascii.f53584CR, 11, 6, 1, 2, 3, 10, Ascii.f53586FF, Ascii.f53593SI, 4, Ascii.f53594SO, 9, 8, 2, 7, Ascii.f53586FF, Ascii.f53593SI, 9, 5, 10, 11, 1, 4, 0, Ascii.f53584CR, 6, 8, Ascii.f53594SO, 3, 8, 3, 2, 6, 4, Ascii.f53584CR, Ascii.f53594SO, 11, Ascii.f53586FF, 1, 7, Ascii.f53593SI, 10, 0, 9, 5, 5, 2, 10, 11, 9, 1, Ascii.f53586FF, 3, 7, 4, Ascii.f53584CR, 0, 6, Ascii.f53593SI, 8, Ascii.f53594SO, 0, 4, 11, Ascii.f53594SO, 8, 3, 7, 1, 10, 2, 9, 6, Ascii.f53593SI, Ascii.f53584CR, 5, Ascii.f53586FF};

    /* renamed from: h */
    private static byte[] f2295h = {1, 11, Ascii.f53586FF, 2, 9, Ascii.f53584CR, 0, Ascii.f53593SI, 4, 5, 8, Ascii.f53594SO, 10, 7, 6, 3, 0, 1, 7, Ascii.f53584CR, 11, 4, 5, 2, 8, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53586FF, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, Ascii.f53593SI, 10, 3, 7, Ascii.f53586FF, Ascii.f53584CR, 6, Ascii.f53594SO, 1, 11, 3, 6, 0, 1, 5, Ascii.f53584CR, 10, 8, 11, 2, 9, 7, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53586FF, 4, 8, Ascii.f53584CR, 11, 0, 4, 5, 1, 2, 9, 3, Ascii.f53586FF, Ascii.f53594SO, 6, Ascii.f53593SI, 10, 7, Ascii.f53586FF, 9, 11, 1, 8, Ascii.f53594SO, 2, 4, 7, 3, 6, 5, 10, 0, Ascii.f53593SI, Ascii.f53584CR, 10, 9, 6, 8, Ascii.f53584CR, Ascii.f53594SO, 2, 0, Ascii.f53593SI, 3, 5, 11, 4, 1, Ascii.f53586FF, 7, 7, 4, 0, 5, 10, 2, Ascii.f53593SI, Ascii.f53594SO, Ascii.f53586FF, 6, 1, 11, Ascii.f53584CR, 9, 3, 8};

    /* renamed from: i */
    private static byte[] f2296i = {Ascii.f53593SI, Ascii.f53586FF, 2, 10, 6, 4, 5, 0, 7, 9, Ascii.f53594SO, Ascii.f53584CR, 1, 11, 8, 3, 11, 6, 3, 4, Ascii.f53586FF, Ascii.f53593SI, Ascii.f53594SO, 2, 7, Ascii.f53584CR, 8, 0, 5, 10, 9, 1, 1, Ascii.f53586FF, 11, 0, Ascii.f53593SI, Ascii.f53594SO, 6, 5, 10, Ascii.f53584CR, 4, 8, 9, 3, 7, 2, 1, 5, Ascii.f53594SO, Ascii.f53586FF, 10, 7, 0, Ascii.f53584CR, 6, 2, 11, 4, 9, 3, Ascii.f53593SI, 8, 0, Ascii.f53586FF, 8, 9, Ascii.f53584CR, 2, 10, 11, 7, 3, 6, 5, 4, Ascii.f53594SO, Ascii.f53593SI, 1, 8, 0, Ascii.f53593SI, 3, 2, 5, Ascii.f53594SO, 11, 1, 10, 4, 7, Ascii.f53586FF, 9, Ascii.f53584CR, 6, 3, 0, 6, Ascii.f53593SI, 1, Ascii.f53594SO, 9, 2, Ascii.f53584CR, 8, Ascii.f53586FF, 4, 11, 10, 5, 7, 1, 10, 6, 8, Ascii.f53593SI, 11, 0, 4, Ascii.f53586FF, 3, 5, 9, 7, Ascii.f53584CR, 2, Ascii.f53594SO};

    /* renamed from: j */
    private static byte[] f2297j = {Ascii.f53586FF, 4, 6, 2, 10, 5, 11, 9, Ascii.f53594SO, 8, Ascii.f53584CR, 7, 0, 3, Ascii.f53593SI, 1, 6, 8, 2, 3, 9, 10, 5, Ascii.f53586FF, 1, Ascii.f53594SO, 4, 7, 11, Ascii.f53584CR, 0, Ascii.f53593SI, 11, 3, 5, 8, 2, Ascii.f53593SI, 10, Ascii.f53584CR, Ascii.f53594SO, 1, 7, 4, Ascii.f53586FF, 9, 6, 0, Ascii.f53586FF, 8, 2, 1, Ascii.f53584CR, 4, Ascii.f53593SI, 6, 7, 0, 10, 5, 3, Ascii.f53594SO, 9, 11, 7, Ascii.f53593SI, 5, 10, 8, 1, 6, Ascii.f53584CR, 0, 9, 3, Ascii.f53594SO, 11, 4, 2, Ascii.f53586FF, 5, Ascii.f53584CR, Ascii.f53593SI, 6, 9, 2, Ascii.f53586FF, 10, 11, 7, 8, 1, 4, 3, Ascii.f53594SO, 0, 8, Ascii.f53594SO, 2, 5, 6, 9, 1, Ascii.f53586FF, Ascii.f53593SI, 4, 11, 0, Ascii.f53584CR, 10, 3, 7, 1, 7, Ascii.f53594SO, Ascii.f53584CR, 0, 5, 8, 3, 4, Ascii.f53593SI, 10, 6, 9, Ascii.f53586FF, 11, 2};

    /* renamed from: k */
    private static byte[] f2298k = {4, 10, 9, 2, Ascii.f53584CR, 8, 0, Ascii.f53594SO, 6, 11, 1, Ascii.f53586FF, 7, Ascii.f53593SI, 5, 3, Ascii.f53594SO, 11, 4, Ascii.f53586FF, 6, Ascii.f53584CR, Ascii.f53593SI, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, Ascii.f53584CR, 10, 3, 4, 2, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53586FF, 7, 6, 0, 9, 11, 7, Ascii.f53584CR, 10, 1, 0, 8, 9, Ascii.f53593SI, Ascii.f53594SO, 4, 6, Ascii.f53586FF, 11, 2, 5, 3, 6, Ascii.f53586FF, 7, 1, 5, Ascii.f53593SI, Ascii.f53584CR, 8, 4, 10, 9, Ascii.f53594SO, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, Ascii.f53584CR, 3, 6, 8, 5, 9, Ascii.f53586FF, Ascii.f53593SI, Ascii.f53594SO, Ascii.f53584CR, 11, 4, 1, 3, Ascii.f53593SI, 5, 9, 0, 10, Ascii.f53594SO, 7, 6, 8, 2, Ascii.f53586FF, 1, Ascii.f53593SI, Ascii.f53584CR, 0, 5, 7, 10, 4, 9, 2, 3, Ascii.f53594SO, 6, 11, 8, Ascii.f53586FF};

    /* renamed from: l */
    private static byte[] f2299l = {10, 4, 5, 6, 8, 1, 3, 7, Ascii.f53584CR, Ascii.f53586FF, Ascii.f53594SO, 0, 9, 2, 11, Ascii.f53593SI, 5, Ascii.f53593SI, 4, 0, 2, Ascii.f53584CR, 11, 9, 1, 7, 6, 3, Ascii.f53586FF, Ascii.f53594SO, 10, 8, 7, Ascii.f53593SI, Ascii.f53586FF, Ascii.f53594SO, 9, 4, 1, 0, 3, 11, 5, 2, 6, 10, 8, Ascii.f53584CR, 4, 10, 7, Ascii.f53586FF, 0, Ascii.f53593SI, 2, 8, Ascii.f53594SO, 1, 6, 5, Ascii.f53584CR, 11, 9, 3, 7, 6, 4, 11, 9, Ascii.f53586FF, 2, 10, 1, 8, 0, Ascii.f53594SO, Ascii.f53593SI, Ascii.f53584CR, 3, 5, 7, 6, 2, 4, Ascii.f53584CR, 9, Ascii.f53593SI, 0, 10, 1, 5, 11, 8, Ascii.f53594SO, Ascii.f53586FF, 3, Ascii.f53584CR, Ascii.f53594SO, 4, 1, 7, 0, 5, 10, 3, Ascii.f53586FF, 8, Ascii.f53593SI, 6, 2, 9, 11, 1, 3, 10, 9, 5, 11, 4, Ascii.f53593SI, 8, 6, 7, Ascii.f53594SO, Ascii.f53584CR, 0, 2, Ascii.f53586FF};

    /* renamed from: m */
    private static Hashtable f2300m;

    /* renamed from: a */
    private int[] f2301a = null;

    /* renamed from: b */
    private boolean f2302b;

    /* renamed from: c */
    private byte[] f2303c = f2291d;

    /* renamed from: a */
    private int m1777a(int i, int i2) {
        int i3 = i2 + i;
        byte[] bArr = this.f2303c;
        int i4 = bArr[(i3 & 15) + 0] + (bArr[((i3 >> 4) & 15) + 16] << 4) + (bArr[((i3 >> 8) & 15) + 32] << 8) + (bArr[((i3 >> 12) & 15) + 48] << Ascii.f53586FF) + (bArr[((i3 >> 16) & 15) + 64] << 16) + (bArr[((i3 >> 20) & 15) + 80] << Ascii.DC4) + (bArr[((i3 >> 24) & 15) + 96] << Ascii.CAN) + (bArr[((i3 >> 28) & 15) + 112] << Ascii.f53587FS);
        return (i4 << 11) | (i4 >>> 21);
    }

    /* renamed from: a */
    private static int m1778a(byte[] bArr, int i) {
        return ((bArr[i + 3] << Ascii.CAN) & -16777216) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & 255);
    }

    /* renamed from: a */
    private static void m1779a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    /* renamed from: a */
    private void m1780a(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m1778a(bArr, i);
        int a2 = m1778a(bArr, i + 4);
        int i3 = 7;
        if (this.f2302b) {
            for (int i4 = 0; i4 < 3; i4++) {
                int i5 = 0;
                while (i5 < 8) {
                    i5++;
                    int i6 = a;
                    a = a2 ^ m1777a(a, iArr[i5]);
                    a2 = i6;
                }
            }
            while (i3 > 0) {
                i3--;
                int i7 = a;
                a = a2 ^ m1777a(a, iArr[i3]);
                a2 = i7;
            }
        } else {
            int i8 = 0;
            while (i8 < 8) {
                i8++;
                int i9 = a;
                a = a2 ^ m1777a(a, iArr[i8]);
                a2 = i9;
            }
            int i10 = 0;
            while (i10 < 3) {
                int i11 = 7;
                while (i11 >= 0 && (i10 != 2 || i11 != 0)) {
                    i11--;
                    int i12 = a;
                    a = a2 ^ m1777a(a, iArr[i11]);
                    a2 = i12;
                }
                i10++;
            }
        }
        m1779a(a, bArr2, i2);
        m1779a(m1777a(a, iArr[0]) ^ a2, bArr2, i2 + 4);
    }

    /* renamed from: a */
    private int[] m1781a(boolean z, byte[] bArr) {
        this.f2302b = z;
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = m1778a(bArr, i << 2);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public static byte[] getInstance(String str) {
        byte[] bArr = (byte[]) f2300m.get(setAnimation.Cardinal(str));
        if (bArr != null) {
            return setForegroundTintBlendMode.cca_continue(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    public final String Cardinal() {
        return "GOST28147";
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        if (eCKAEGwithSHA512KDF instanceof PSSSignatureSpi) {
            byte[] cca_continue = ((PSSSignatureSpi) eCKAEGwithSHA512KDF).cca_continue();
            if (cca_continue.length == f2291d.length) {
                this.f2303c = setForegroundTintBlendMode.cca_continue(cca_continue);
                return;
            }
            throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
        } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.MD5WithRSAEncryption) {
            this.f2301a = m1781a(z, ((ISOSignatureSpi.MD5WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance());
        } else if (eCKAEGwithSHA512KDF != null) {
            StringBuilder sb = new StringBuilder("invalid parameter passed to GOST28147 init - ");
            sb.append(eCKAEGwithSHA512KDF.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final int cca_continue() {
        return 8;
    }

    public final int init(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.f2301a;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            m1780a(iArr, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new KeyFactorySpi.ECDSA("output buffer too short");
        }
    }

    public final void init() {
    }

    static {
        Hashtable hashtable = new Hashtable();
        f2300m = hashtable;
        hashtable.put(setAnimation.Cardinal("Default"), f2291d);
        f2300m.put(setAnimation.Cardinal("E-TEST"), f2292e);
        f2300m.put(setAnimation.Cardinal("E-A"), f2293f);
        f2300m.put(setAnimation.Cardinal("E-B"), f2294g);
        f2300m.put(setAnimation.Cardinal("E-C"), f2295h);
        f2300m.put(setAnimation.Cardinal("E-D"), f2296i);
        f2300m.put(setAnimation.Cardinal("Param-Z"), f2297j);
        f2300m.put(setAnimation.Cardinal("D-TEST"), f2298k);
        f2300m.put(setAnimation.Cardinal("D-A"), f2299l);
    }
}

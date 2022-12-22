package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.setRevealOnFocusHint;
import com.didi.soda.customer.C13565R2;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setAutofillId */
public abstract class setAutofillId {

    /* renamed from: a */
    private static final byte[] f2684a = setAnimation.configure("SigEd448");

    /* renamed from: b */
    private static final int[] f2685b = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2686c = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};

    /* renamed from: d */
    private static final int[] f2687d = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};

    /* renamed from: e */
    private static final int[] f2688e = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};

    /* renamed from: f */
    private static Object f2689f = new Object();

    /* renamed from: g */
    private static getInstance[] f2690g = null;

    /* renamed from: h */
    private static int[] f2691h = null;

    /* renamed from: a */
    private static int m1954a(byte[] bArr, int i) {
        int i2 = i + 1;
        return ((bArr[i2 + 1] & 255) << 16) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    /* renamed from: a */
    private static void m1957a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    private static void m1959a(KeyPairGeneratorSpi.ECDH ecdh, byte b, byte[] bArr) {
        byte[] bArr2 = f2684a;
        ecdh.init(bArr2, 0, bArr2.length);
        ecdh.Cardinal(b);
        ecdh.Cardinal((byte) bArr.length);
        ecdh.init(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private static void m1962a(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    /* renamed from: a */
    private static void m1965a(int[] iArr, int[] iArr2, getInstance getinstance, getInstance getinstance2) {
        m1956a();
        byte[] a = m1970a(iArr, 7);
        byte[] a2 = m1970a(iArr2, 5);
        getInstance[] a3 = m1971a(getinstance, 8);
        m1975c(getinstance2);
        int i = 447;
        while (i > 0 && (a[i] | a2[i]) == 0) {
            i--;
        }
        while (true) {
            byte b = a[i];
            boolean z = false;
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                m1961a(i2 != 0, f2690g[(b ^ i2) >>> 1], getinstance2);
            }
            byte b2 = a2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.f53596US;
                int i4 = (b2 ^ i3) >>> 1;
                if (i3 != 0) {
                    z = true;
                }
                m1961a(z, a3[i4], getinstance2);
            }
            i--;
            if (i >= 0) {
                m1973b(getinstance2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m1966a(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    /* renamed from: a */
    private static byte[] m1970a(int[] iArr, int i) {
        int i2;
        int[] iArr2 = new int[28];
        int i3 = 0;
        int i4 = 14;
        int i5 = 28;
        int i6 = 0;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            int i7 = iArr[i4];
            int i8 = i5 - 1;
            iArr2[i8] = (i6 << 16) | (i7 >>> 16);
            i5 = i8 - 1;
            iArr2[i5] = i7;
            i6 = i7;
        }
        byte[] bArr = new byte[448];
        int i9 = 1 << i;
        int i10 = i9 - 1;
        int i11 = i9 >>> 1;
        int i12 = 0;
        int i13 = 0;
        while (i3 < 28) {
            int i14 = iArr2[i3];
            while (i2 < 16) {
                int i15 = i14 >>> i2;
                if ((i15 & 1) == i13) {
                    i2++;
                } else {
                    int i16 = (i15 & i10) + i13;
                    int i17 = i16 & i11;
                    int i18 = i16 - (i17 << 1);
                    i13 = i17 >>> (i - 1);
                    bArr[(i3 << 4) + i2] = (byte) i18;
                    i2 += i;
                }
            }
            i3++;
            i12 = i2 - 16;
        }
        return bArr;
    }

    /* renamed from: a */
    private static getInstance[] m1971a(getInstance getinstance, int i) {
        getInstance a = m1955a(getinstance);
        m1973b(a);
        getInstance[] getinstanceArr = new getInstance[i];
        getinstanceArr[0] = m1955a(getinstance);
        for (int i2 = 1; i2 < i; i2++) {
            getinstanceArr[i2] = m1955a(getinstanceArr[i2 - 1]);
            m1961a(false, a, getinstanceArr[i2]);
        }
        return getinstanceArr;
    }

    /* renamed from: b */
    private static int m1972b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public static void cca_continue(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void configure(setRevealOnFocusHint.getInstance getinstance, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (getinstance != null) {
            byte[] bArr2 = new byte[57];
            m1962a(bArr, i, bArr2);
            getInstance getinstance2 = new getInstance((byte) 0);
            m1963a(bArr2, getinstance2);
            DSASigner.dsa256.cca_continue(getinstance2.getInstance, iArr, 0);
            DSASigner.dsa256.cca_continue(getinstance2.cca_continue, iArr2, 0);
            return;
        }
        throw new NullPointerException("This method is only for use by X448");
    }

    public static boolean configure(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) {
        return m1968a(bArr, 0, bArr2, 0, bArr3, bArr4, 0, i);
    }

    /* renamed from: com.cardinalcommerce.a.setAutofillId$cca_continue */
    static class cca_continue {
        int[] getInstance;
        int[] init;

        /* synthetic */ cca_continue(byte b) {
            this();
        }

        private cca_continue() {
            this.init = new int[16];
            this.getInstance = new int[16];
        }
    }

    /* renamed from: com.cardinalcommerce.a.setAutofillId$getInstance */
    static class getInstance {
        int[] cca_continue;
        int[] getInstance;
        int[] init;

        /* synthetic */ getInstance(byte b) {
            this();
        }

        private getInstance() {
            this.getInstance = new int[16];
            this.cca_continue = new int[16];
            this.init = new int[16];
        }
    }

    /* renamed from: a */
    private static byte[] m1969a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        for (int i = 0; i < 14; i++) {
            iArr[i] = m1972b(bArr, (i << 2) + 0);
        }
        int[] iArr2 = new int[14];
        for (int i2 = 0; i2 < 14; i2++) {
            iArr2[i2] = m1972b(bArr2, (i2 << 2) + 0);
        }
        int[] iArr3 = new int[14];
        for (int i3 = 0; i3 < 14; i3++) {
            iArr3[i3] = m1972b(bArr3, (i3 << 2) + 0);
        }
        long j = 0;
        for (int i4 = 0; i4 < 14; i4++) {
            int i5 = i4 + 14;
            long configure = (((long) setDrawingCacheQuality.configure(14, iArr2[i4], iArr3, iArr, i4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[i5]));
            iArr[i5] = (int) configure;
            j = configure >>> 32;
        }
        byte[] bArr4 = new byte[114];
        for (int i6 = 0; i6 < 28; i6++) {
            m1957a(iArr[i6], bArr4, i6 << 2);
        }
        return m1977d(bArr4);
    }

    /* renamed from: b */
    private static boolean m1974b(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        for (int i = 0; i < 14; i++) {
            iArr[i] = m1972b(bArr, (i << 2) + 0);
        }
        return !setDrawingCacheQuality.init(14, iArr, f2685b);
    }

    /* renamed from: c */
    private static boolean m1976c(byte[] bArr) {
        if (bArr[56] != 0) {
            return false;
        }
        int[] iArr = new int[14];
        for (int i = 0; i < 14; i++) {
            iArr[i] = m1972b(bArr, (i << 2) + 0);
        }
        return !setDrawingCacheQuality.init(14, iArr, f2686c);
    }

    /* renamed from: a */
    private static boolean m1967a(byte[] bArr, int i, getInstance getinstance) {
        byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr, i, i + 57);
        if (!m1974b(cca_continue2)) {
            return false;
        }
        int i2 = (cca_continue2[56] & 128) >>> 7;
        cca_continue2[56] = (byte) (cca_continue2[56] & Byte.MAX_VALUE);
        DSASigner.dsa256.getInstance(cca_continue2, 0, getinstance.cca_continue);
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        DSASigner.dsa256.cca_continue(getinstance.cca_continue, iArr);
        DSASigner.dsa256.getInstance(iArr, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, iArr2);
        DSASigner.dsa256.Cardinal(new int[16], iArr, iArr);
        iArr[0] = iArr[0] + 1;
        iArr2[0] = iArr2[0] + 1;
        if (!DSASigner.dsa256.getInstance(iArr, iArr2, getinstance.getInstance)) {
            return false;
        }
        int[] iArr3 = getinstance.getInstance;
        DSASigner.dsa256.configure(iArr3, 1);
        DSASigner.dsa256.configure(iArr3, -1);
        if (i2 == 1 && DSASigner.dsa256.cca_continue(getinstance.getInstance)) {
            return false;
        }
        if (!(i2 != (getinstance.getInstance[0] & 1))) {
            DSASigner.dsa256.Cardinal(new int[16], getinstance.getInstance, getinstance.getInstance);
        }
        int[] iArr4 = getinstance.init;
        iArr4[0] = 1;
        for (int i3 = 1; i3 < 16; i3++) {
            iArr4[i3] = 0;
        }
        return true;
    }

    /* renamed from: a */
    private static void m1964a(byte[] bArr, int[] iArr) {
        for (int i = 0; i < 14; i++) {
            iArr[i] = m1972b(bArr, (i << 2) + 0);
        }
    }

    /* renamed from: a */
    private static void m1958a(long j, byte[] bArr, int i) {
        m1957a((int) j, bArr, i);
        int i2 = (int) (j >>> 32);
        int i3 = i + 4;
        bArr[i3] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i4 + 1] = (byte) (i2 >>> 16);
    }

    /* renamed from: a */
    private static void m1960a(getInstance getinstance, byte[] bArr, int i) {
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        DSASigner.dsa256.getInstance(getinstance.init, iArr2);
        DSASigner.dsa256.cca_continue(getinstance.getInstance, iArr2, iArr);
        DSASigner.dsa256.cca_continue(getinstance.cca_continue, iArr2, iArr2);
        DSASigner.dsa256.configure(iArr, 1);
        DSASigner.dsa256.configure(iArr, -1);
        DSASigner.dsa256.configure(iArr2, 1);
        DSASigner.dsa256.configure(iArr2, -1);
        DSASigner.dsa256.configure(iArr2, bArr, i);
        bArr[(i + 57) - 1] = (byte) ((1 & iArr[0]) << 7);
    }

    public static void init(byte[] bArr, byte[] bArr2) {
        SignatureSpi.ecNR512 ecnr512 = new SignatureSpi.ecNR512(256);
        byte[] bArr3 = new byte[114];
        ecnr512.init(bArr, 0, 57);
        ecnr512.getInstance(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        m1962a(bArr3, 0, bArr4);
        getInstance getinstance = new getInstance((byte) 0);
        m1963a(bArr4, getinstance);
        m1960a(getinstance, bArr2, 0);
    }

    /* renamed from: a */
    private static boolean m1968a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        if (m1966a(bArr3)) {
            byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr, 0, 57);
            byte[] cca_continue3 = setForegroundTintBlendMode.cca_continue(bArr, 57, 114);
            if (!m1974b(cca_continue2) || !m1976c(cca_continue3)) {
                return false;
            }
            getInstance getinstance = new getInstance((byte) 0);
            if (!m1967a(bArr2, 0, getinstance)) {
                return false;
            }
            SignatureSpi.ecNR512 ecnr512 = new SignatureSpi.ecNR512(256);
            byte[] bArr5 = new byte[114];
            m1959a((KeyPairGeneratorSpi.ECDH) ecnr512, (byte) 0, bArr3);
            ecnr512.init(cca_continue2, 0, 57);
            ecnr512.init(bArr2, 0, 57);
            ecnr512.init(bArr4, 0, i4);
            ecnr512.getInstance(bArr5, 0, 114);
            byte[] d = m1977d(bArr5);
            int[] iArr = new int[14];
            m1964a(cca_continue3, iArr);
            int[] iArr2 = new int[14];
            m1964a(d, iArr2);
            getInstance getinstance2 = new getInstance((byte) 0);
            m1965a(iArr, iArr2, getinstance, getinstance2);
            byte[] bArr6 = new byte[57];
            m1960a(getinstance2, bArr6, 0);
            return setForegroundTintBlendMode.Cardinal(bArr6, cca_continue2);
        }
        throw new IllegalArgumentException("ctx");
    }

    /* renamed from: a */
    private static void m1961a(boolean z, getInstance getinstance, getInstance getinstance2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        getInstance getinstance3 = getinstance;
        getInstance getinstance4 = getinstance2;
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        int[] iArr7 = new int[16];
        int[] iArr8 = new int[16];
        int[] iArr9 = new int[16];
        int[] iArr10 = new int[16];
        int[] iArr11 = new int[16];
        int[] iArr12 = new int[16];
        int[] iArr13 = getinstance3.cca_continue;
        int[] iArr14 = getinstance3.getInstance;
        if (z) {
            DSASigner.dsa256.Cardinal(iArr13, iArr14, iArr12);
            iArr = iArr6;
            iArr2 = iArr9;
            iArr3 = iArr10;
            iArr4 = iArr11;
        } else {
            for (int i = 0; i < 16; i++) {
                iArr12[i] = iArr13[i] + iArr14[i];
            }
            iArr2 = iArr6;
            iArr = iArr9;
            iArr4 = iArr10;
            iArr3 = iArr11;
        }
        DSASigner.dsa256.cca_continue(getinstance3.init, getinstance4.init, iArr5);
        DSASigner.dsa256.cca_continue(iArr5, iArr6);
        DSASigner.dsa256.cca_continue(getinstance3.getInstance, getinstance4.getInstance, iArr7);
        DSASigner.dsa256.cca_continue(getinstance3.cca_continue, getinstance4.cca_continue, iArr8);
        DSASigner.dsa256.cca_continue(iArr7, iArr8, iArr9);
        DSASigner.dsa256.getInstance(iArr9, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, iArr9);
        for (int i2 = 0; i2 < 16; i2++) {
            iArr4[i2] = iArr6[i2] + iArr9[i2];
        }
        DSASigner.dsa256.Cardinal(iArr6, iArr9, iArr3);
        int[] iArr15 = getinstance4.getInstance;
        int[] iArr16 = getinstance4.cca_continue;
        for (int i3 = 0; i3 < 16; i3++) {
            iArr9[i3] = iArr15[i3] + iArr16[i3];
        }
        DSASigner.dsa256.cca_continue(iArr12, iArr9, iArr12);
        for (int i4 = 0; i4 < 16; i4++) {
            iArr2[i4] = iArr8[i4] + iArr7[i4];
        }
        DSASigner.dsa256.Cardinal(iArr8, iArr7, iArr);
        DSASigner.dsa256.configure(iArr2);
        DSASigner.dsa256.Cardinal(iArr12, iArr6, iArr12);
        DSASigner.dsa256.cca_continue(iArr12, iArr5, iArr12);
        DSASigner.dsa256.cca_continue(iArr9, iArr5, iArr9);
        DSASigner.dsa256.cca_continue(iArr10, iArr12, getinstance4.getInstance);
        DSASigner.dsa256.cca_continue(iArr9, iArr11, getinstance4.cca_continue);
        DSASigner.dsa256.cca_continue(iArr10, iArr11, getinstance4.init);
    }

    /* renamed from: a */
    private static getInstance m1955a(getInstance getinstance) {
        getInstance getinstance2 = new getInstance((byte) 0);
        int[] iArr = getinstance.getInstance;
        int[] iArr2 = getinstance2.getInstance;
        for (int i = 0; i < 16; i++) {
            iArr2[i + 0] = iArr[i];
        }
        int[] iArr3 = getinstance.cca_continue;
        int[] iArr4 = getinstance2.cca_continue;
        for (int i2 = 0; i2 < 16; i2++) {
            iArr4[i2 + 0] = iArr3[i2];
        }
        int[] iArr5 = getinstance.init;
        int[] iArr6 = getinstance2.init;
        for (int i3 = 0; i3 < 16; i3++) {
            iArr6[i3 + 0] = iArr5[i3];
        }
        return getinstance2;
    }

    /* renamed from: b */
    private static void m1973b(getInstance getinstance) {
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        int[] iArr7 = getinstance.getInstance;
        int[] iArr8 = getinstance.cca_continue;
        for (int i = 0; i < 16; i++) {
            iArr[i] = iArr7[i] + iArr8[i];
        }
        DSASigner.dsa256.cca_continue(iArr, iArr);
        DSASigner.dsa256.cca_continue(getinstance.getInstance, iArr2);
        DSASigner.dsa256.cca_continue(getinstance.cca_continue, iArr3);
        for (int i2 = 0; i2 < 16; i2++) {
            iArr4[i2] = iArr2[i2] + iArr3[i2];
        }
        DSASigner.dsa256.configure(iArr4);
        DSASigner.dsa256.cca_continue(getinstance.init, iArr5);
        for (int i3 = 0; i3 < 16; i3++) {
            iArr5[i3] = iArr5[i3] + iArr5[i3];
        }
        DSASigner.dsa256.configure(iArr5);
        DSASigner.dsa256.Cardinal(iArr4, iArr5, iArr6);
        DSASigner.dsa256.Cardinal(iArr, iArr4, iArr);
        DSASigner.dsa256.Cardinal(iArr2, iArr3, iArr2);
        DSASigner.dsa256.cca_continue(iArr, iArr6, getinstance.getInstance);
        DSASigner.dsa256.cca_continue(iArr4, iArr2, getinstance.cca_continue);
        DSASigner.dsa256.cca_continue(iArr4, iArr6, getinstance.init);
    }

    /* renamed from: c */
    private static void m1975c(getInstance getinstance) {
        int[] iArr = getinstance.getInstance;
        for (int i = 0; i < 16; i++) {
            iArr[i] = 0;
        }
        int[] iArr2 = getinstance.cca_continue;
        iArr2[0] = 1;
        for (int i2 = 1; i2 < 16; i2++) {
            iArr2[i2] = 0;
        }
        int[] iArr3 = getinstance.init;
        iArr3[0] = 1;
        for (int i3 = 1; i3 < 16; i3++) {
            iArr3[i3] = 0;
        }
    }

    /* renamed from: a */
    private static void m1956a() {
        synchronized (f2689f) {
            if (f2691h == null) {
                getInstance getinstance = new getInstance((byte) 0);
                int[] iArr = f2687d;
                int[] iArr2 = getinstance.getInstance;
                for (int i = 0; i < 16; i++) {
                    iArr2[i + 0] = iArr[i];
                }
                int[] iArr3 = f2688e;
                int[] iArr4 = getinstance.cca_continue;
                for (int i2 = 0; i2 < 16; i2++) {
                    iArr4[i2 + 0] = iArr3[i2];
                }
                int[] iArr5 = getinstance.init;
                iArr5[0] = 1;
                for (int i3 = 1; i3 < 16; i3++) {
                    iArr5[i3] = 0;
                }
                f2690g = m1971a(getinstance, 32);
                f2691h = new int[2560];
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    getInstance[] getinstanceArr = new getInstance[5];
                    getInstance getinstance2 = new getInstance((byte) 0);
                    m1975c(getinstance2);
                    for (int i6 = 0; i6 < 5; i6++) {
                        m1961a(true, getinstance, getinstance2);
                        m1973b(getinstance);
                        getinstanceArr[i6] = m1955a(getinstance);
                        if (i5 + i6 != 8) {
                            for (int i7 = 1; i7 < 18; i7++) {
                                m1973b(getinstance);
                            }
                        }
                    }
                    getInstance[] getinstanceArr2 = new getInstance[16];
                    getinstanceArr2[0] = getinstance2;
                    int i8 = 1;
                    for (int i9 = 0; i9 < 4; i9++) {
                        int i10 = 1 << i9;
                        int i11 = 0;
                        while (i11 < i10) {
                            getinstanceArr2[i8] = m1955a(getinstanceArr2[i8 - i10]);
                            m1961a(false, getinstanceArr[i9], getinstanceArr2[i8]);
                            i11++;
                            i8++;
                        }
                    }
                    for (int i12 = 0; i12 < 16; i12++) {
                        getInstance getinstance3 = getinstanceArr2[i12];
                        DSASigner.dsa256.getInstance(getinstance3.init, getinstance3.init);
                        DSASigner.dsa256.cca_continue(getinstance3.getInstance, getinstance3.init, getinstance3.getInstance);
                        DSASigner.dsa256.cca_continue(getinstance3.cca_continue, getinstance3.init, getinstance3.cca_continue);
                        int[] iArr6 = getinstance3.getInstance;
                        int[] iArr7 = f2691h;
                        for (int i13 = 0; i13 < 16; i13++) {
                            iArr7[i4 + i13] = iArr6[i13];
                        }
                        int i14 = i4 + 16;
                        int[] iArr8 = getinstance3.cca_continue;
                        int[] iArr9 = f2691h;
                        for (int i15 = 0; i15 < 16; i15++) {
                            iArr9[i14 + i15] = iArr8[i15];
                        }
                        i4 = i14 + 16;
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private static byte[] m1977d(byte[] bArr) {
        byte[] bArr2 = bArr;
        long b = ((long) m1972b(bArr2, 0)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a = ((long) (m1954a(bArr2, 4) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b2 = ((long) m1972b(bArr2, 7)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a2 = ((long) (m1954a(bArr2, 11) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b3 = ((long) m1972b(bArr2, 14)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a3 = ((long) (m1954a(bArr2, 18) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j = a;
        long b4 = ((long) m1972b(bArr2, 21)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = b2;
        long a4 = ((long) (m1954a(bArr2, 25) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b5 = ((long) m1972b(bArr2, 28)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = a2;
        long a5 = ((long) (m1954a(bArr2, 32) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = b3;
        long b6 = ((long) m1972b(bArr2, 35)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = a3;
        long a6 = ((long) (m1954a(bArr2, 39) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = b4;
        long b7 = ((long) m1972b(bArr2, 42)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = a4;
        long a7 = ((long) (m1954a(bArr2, 46) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = b5;
        long b8 = ((long) m1972b(bArr2, 49)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = a5;
        long a8 = ((long) (m1954a(bArr2, 53) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = b6;
        long b9 = ((long) m1972b(bArr2, 56)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = a6;
        long a9 = ((long) (m1954a(bArr2, 60) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j12 = b7;
        long b10 = ((long) m1972b(bArr2, 63)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j13 = a7;
        long a10 = ((long) (m1954a(bArr2, 67) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j14 = b8;
        long b11 = ((long) m1972b(bArr2, 70)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j15 = a8;
        long a11 = ((long) (m1954a(bArr2, 74) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b12 = ((long) m1972b(bArr2, 77)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a12 = ((long) (m1954a(bArr2, 81) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b13 = ((long) m1972b(bArr2, 84)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a13 = ((long) (m1954a(bArr2, 88) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b14 = ((long) m1972b(bArr2, 91)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a14 = ((long) (m1954a(bArr2, 95) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b15 = ((long) m1972b(bArr2, 98)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a15 = ((long) (m1954a(bArr2, 102) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b16 = ((long) m1972b(bArr2, 105)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a16 = ((long) (m1954a(bArr2, 109) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j16 = ((long) (((bArr2[113] & 255) << 8) | (bArr2[112] & 255))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j17 = a12 + (j16 * 550336261);
        long j18 = a16 + (b16 >>> 28);
        long j19 = b16 & 268435455;
        long j20 = b12 + (j16 * 149865618) + (j18 * 550336261);
        long j21 = a15 + (b15 >>> 28);
        long j22 = b15 & 268435455;
        long j23 = b11 + (j16 * 96434764) + (j18 * 227822194) + (j19 * 149865618) + (j21 * 550336261);
        long j24 = a14 + (b14 >>> 28);
        long j25 = b14 & 268435455;
        long j26 = b10 + (j16 * 163752818) + (j18 * 258169998) + (j19 * 96434764) + (j21 * 227822194) + (j22 * 149865618) + (j24 * 550336261);
        long j27 = a9 + (j16 * 30366549) + (j18 * 163752818) + (j19 * 258169998) + (j21 * 96434764) + (j22 * 227822194) + (j24 * 149865618) + (j25 * 550336261);
        long j28 = a13 + (b13 >>> 28);
        long j29 = a11 + (j16 * 227822194) + (j18 * 149865618) + (j19 * 550336261) + (j23 >>> 28);
        long j30 = j20 + (j29 >>> 28);
        long j31 = j17 + (j30 >>> 28);
        long j32 = j30 & 268435455;
        long j33 = (b13 & 268435455) + (j31 >>> 28);
        long j34 = j31 & 268435455;
        long j35 = j7 + (j34 * 43969588);
        long j36 = j8 + (j33 * 43969588) + (j34 * 30366549);
        long j37 = j9 + (j28 * 43969588) + (j33 * 30366549) + (j34 * 163752818);
        long j38 = j10 + (j25 * 43969588) + (j28 * 30366549) + (j33 * 163752818) + (j34 * 258169998);
        long j39 = j11 + (j24 * 43969588) + (j25 * 30366549) + (j28 * 163752818) + (j33 * 258169998) + (j34 * 96434764);
        long j40 = j12 + (j22 * 43969588) + (j24 * 30366549) + (j25 * 163752818) + (j28 * 258169998) + (j33 * 96434764) + (j34 * 227822194);
        long j41 = j14 + (j19 * 43969588) + (j21 * 30366549) + (j22 * 163752818) + (j24 * 258169998) + (j25 * 96434764) + (j28 * 227822194) + (j33 * 149865618) + (j34 * 550336261);
        long j42 = j26 + (j27 >>> 28);
        long j43 = a10 + (j16 * 258169998) + (j18 * 96434764) + (j19 * 227822194) + (j21 * 149865618) + (j22 * 550336261) + (j42 >>> 28);
        long j44 = (j23 & 268435455) + (j43 >>> 28);
        long j45 = j43 & 268435455;
        long j46 = (j29 & 268435455) + (j44 >>> 28);
        long j47 = j44 & 268435455;
        long j48 = j4 + (j47 * 43969588);
        long j49 = j5 + (j46 * 43969588) + (j47 * 30366549);
        long j50 = j6 + (j32 * 43969588) + (j46 * 30366549) + (j47 * 163752818);
        long j51 = j35 + (j32 * 30366549) + (j46 * 163752818) + (j47 * 258169998);
        long j52 = j36 + (j32 * 163752818) + (j46 * 258169998) + (j47 * 96434764);
        long j53 = j37 + (j32 * 258169998) + (j46 * 96434764) + (j47 * 227822194);
        long j54 = j39 + (j32 * 227822194) + (j46 * 149865618) + (j47 * 550336261);
        long j55 = j3 + (j45 * 43969588);
        long j56 = j38 + (j32 * 96434764) + (j46 * 227822194) + (j47 * 149865618) + (j45 * 550336261);
        long j57 = j15 + (j18 * 43969588) + (j19 * 30366549) + (j21 * 163752818) + (j22 * 258169998) + (j24 * 96434764) + (j25 * 227822194) + (j28 * 149865618) + (j33 * 550336261) + (j41 >>> 28);
        long j58 = b9 + (j16 * 43969588) + (j18 * 30366549) + (j19 * 163752818) + (j21 * 258169998) + (j22 * 96434764) + (j24 * 227822194) + (j25 * 149865618) + (j28 * 550336261) + (j57 >>> 28);
        long j59 = j57 & 268435455;
        long j60 = (j27 & 268435455) + (j58 >>> 28);
        long j61 = (j42 & 268435455) + (j60 >>> 28);
        long j62 = j60 & 268435455;
        long j63 = j2 + (j61 * 43969588);
        long j64 = j55 + (j61 * 30366549);
        long j65 = j48 + (j45 * 30366549) + (j61 * 163752818);
        long j66 = j49 + (j45 * 163752818) + (j61 * 258169998);
        long j67 = j50 + (j45 * 258169998) + (j61 * 96434764);
        long j68 = j51 + (j45 * 96434764) + (j61 * 227822194);
        long j69 = j53 + (j45 * 149865618) + (j61 * 550336261);
        long j70 = j52 + (j45 * 227822194) + (j61 * 149865618) + (j62 * 550336261);
        long j71 = j59 & 67108863;
        long j72 = ((j58 & 268435455) << 2) + (j59 >>> 26) + 1;
        long j73 = b + (78101261 * j72);
        long j74 = j + (43969588 * j62) + (141809365 * j72) + (j73 >>> 28);
        long j75 = j63 + (30366549 * j62) + (175155932 * j72) + (j74 >>> 28);
        long j76 = j64 + (163752818 * j62) + (64542499 * j72) + (j75 >>> 28);
        long j77 = j65 + (258169998 * j62) + (158326419 * j72) + (j76 >>> 28);
        long j78 = j66 + (96434764 * j62) + (191173276 * j72) + (j77 >>> 28);
        long j79 = j77 & 268435455;
        long j80 = j67 + (227822194 * j62) + (104575268 * j72) + (j78 >>> 28);
        long j81 = j78 & 268435455;
        long j82 = j68 + (149865618 * j62) + (j72 * 137584065) + (j80 >>> 28);
        long j83 = j70 + (j82 >>> 28);
        long j84 = j82 & 268435455;
        long j85 = j69 + (j83 >>> 28);
        long j86 = j83 & 268435455;
        long j87 = j56 + (j85 >>> 28);
        long j88 = j54 + (j87 >>> 28);
        long j89 = j40 + (j32 * 149865618) + (j46 * 550336261) + (j88 >>> 28);
        long j90 = j13 + (j21 * 43969588) + (j22 * 30366549) + (j24 * 163752818) + (j25 * 258169998) + (j28 * 96434764) + (j33 * 227822194) + (j34 * 149865618) + (j32 * 550336261) + (j89 >>> 28);
        long j91 = (j41 & 268435455) + (j90 >>> 28);
        long j92 = j71 + (j91 >>> 28);
        long j93 = j91 & 268435455;
        long j94 = 67108863 & j92;
        long j95 = (j92 >>> 26) - 1;
        long j96 = (j73 & 268435455) - (78101261 & j95);
        long j97 = (j75 & 268435455) - (175155932 & j95);
        long j98 = (j76 & 268435455) - (64542499 & j95);
        long j99 = j79 - (158326419 & j95);
        long j100 = j81 - (191173276 & j95);
        long j101 = (j80 & 268435455) - (104575268 & j95);
        long j102 = j84 - (j95 & 137584065);
        long j103 = ((j74 & 268435455) - (141809365 & j95)) + (j96 >> 28);
        long j104 = j96 & 268435455;
        long j105 = j97 + (j103 >> 28);
        long j106 = j98 + (j105 >> 28);
        long j107 = j105 & 268435455;
        long j108 = j99 + (j106 >> 28);
        long j109 = j100 + (j108 >> 28);
        long j110 = j108 & 268435455;
        long j111 = j101 + (j109 >> 28);
        long j112 = j109 & 268435455;
        long j113 = j102 + (j111 >> 28);
        long j114 = j86 + (j113 >> 28);
        long j115 = j113 & 268435455;
        long j116 = (j85 & 268435455) + (j114 >> 28);
        long j117 = (j87 & 268435455) + (j116 >> 28);
        long j118 = (j88 & 268435455) + (j117 >> 28);
        long j119 = (j89 & 268435455) + (j118 >> 28);
        long j120 = (j90 & 268435455) + (j119 >> 28);
        long j121 = j93 + (j120 >> 28);
        byte[] bArr3 = new byte[57];
        m1958a(((j103 & 268435455) << 28) | j104, bArr3, 0);
        m1958a(((j106 & 268435455) << 28) | j107, bArr3, 7);
        m1958a(j110 | (j112 << 28), bArr3, 14);
        m1958a((j111 & 268435455) | (j115 << 28), bArr3, 21);
        m1958a((j114 & 268435455) | ((j116 & 268435455) << 28), bArr3, 28);
        m1958a((j117 & 268435455) | ((j118 & 268435455) << 28), bArr3, 35);
        m1958a((j119 & 268435455) | ((j120 & 268435455) << 28), bArr3, 42);
        m1958a((j121 & 268435455) | ((j94 + (j121 >> 28)) << 28), bArr3, 49);
        return bArr3;
    }

    /* renamed from: a */
    private static void m1963a(byte[] bArr, getInstance getinstance) {
        getInstance getinstance2 = getinstance;
        m1956a();
        m1975c(getinstance);
        int i = 15;
        int[] iArr = new int[15];
        int i2 = 0;
        for (int i3 = 0; i3 < 14; i3++) {
            iArr[i3] = m1972b(bArr, (i3 << 2) + 0);
        }
        int i4 = 1;
        iArr[14] = setDrawingCacheQuality.getInstance(14, (~iArr[0]) & 1, iArr, f2686c, iArr) + 4;
        setDrawingCacheQuality.init(15, iArr, 0);
        cca_continue cca_continue2 = new cca_continue((byte) 0);
        int i5 = 17;
        while (true) {
            int i6 = i5;
            int i7 = 0;
            while (i7 < 5) {
                int i8 = 0;
                for (int i9 = 0; i9 < 5; i9++) {
                    i8 = (i8 & (~(i4 << i9))) ^ ((iArr[i6 >>> 5] >>> (i6 & 31)) << i9);
                    i6 += 18;
                }
                int i10 = (i8 >>> 4) & i4;
                int i11 = ((-i10) ^ i8) & i;
                int i12 = ((i7 << 4) << i4) << 4;
                for (int i13 = 0; i13 < 16; i13++) {
                    int i14 = ((i13 ^ i11) - i4) >> 31;
                    setDrawingCacheQuality.configure(16, i14, f2691h, i12, cca_continue2.init);
                    int i15 = i12 + 16;
                    setDrawingCacheQuality.configure(16, i14, f2691h, i15, cca_continue2.getInstance);
                    i12 = i15 + 16;
                }
                int[] iArr2 = cca_continue2.init;
                int[] iArr3 = new int[16];
                DSASigner.dsa256.Cardinal(iArr3, iArr2, iArr3);
                setDrawingCacheQuality.configure(16, i10, iArr3, i2, iArr2);
                int[] iArr4 = new int[16];
                int[] iArr5 = new int[16];
                int[] iArr6 = new int[16];
                int[] iArr7 = new int[16];
                int[] iArr8 = new int[16];
                int[] iArr9 = new int[16];
                int[] iArr10 = new int[16];
                DSASigner.dsa256.cca_continue(getinstance2.init, iArr4);
                DSASigner.dsa256.cca_continue(cca_continue2.init, getinstance2.getInstance, iArr5);
                DSASigner.dsa256.cca_continue(cca_continue2.getInstance, getinstance2.cca_continue, iArr6);
                DSASigner.dsa256.cca_continue(iArr5, iArr6, iArr7);
                DSASigner.dsa256.getInstance(iArr7, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, iArr7);
                for (int i16 = 0; i16 < 16; i16++) {
                    iArr8[i16] = iArr4[i16] + iArr7[i16];
                }
                DSASigner.dsa256.Cardinal(iArr4, iArr7, iArr9);
                int[] iArr11 = cca_continue2.init;
                int[] iArr12 = cca_continue2.getInstance;
                int[] iArr13 = iArr;
                for (int i17 = 0; i17 < 16; i17++) {
                    iArr4[i17] = iArr11[i17] + iArr12[i17];
                }
                int[] iArr14 = getinstance2.getInstance;
                int[] iArr15 = getinstance2.cca_continue;
                for (int i18 = 0; i18 < 16; i18++) {
                    iArr7[i18] = iArr14[i18] + iArr15[i18];
                }
                DSASigner.dsa256.cca_continue(iArr4, iArr7, iArr10);
                for (int i19 = 0; i19 < 16; i19++) {
                    iArr4[i19] = iArr6[i19] + iArr5[i19];
                }
                DSASigner.dsa256.Cardinal(iArr6, iArr5, iArr7);
                DSASigner.dsa256.configure(iArr4);
                DSASigner.dsa256.Cardinal(iArr10, iArr4, iArr10);
                DSASigner.dsa256.cca_continue(iArr10, getinstance2.init, iArr10);
                DSASigner.dsa256.cca_continue(iArr7, getinstance2.init, iArr7);
                DSASigner.dsa256.cca_continue(iArr8, iArr10, getinstance2.getInstance);
                DSASigner.dsa256.cca_continue(iArr7, iArr9, getinstance2.cca_continue);
                DSASigner.dsa256.cca_continue(iArr8, iArr9, getinstance2.init);
                i7++;
                iArr = iArr13;
                i = 15;
                i2 = 0;
                i4 = 1;
            }
            int[] iArr16 = iArr;
            i5--;
            if (i5 >= 0) {
                m1973b(getinstance);
                iArr = iArr16;
                i = 15;
                i2 = 0;
                i4 = 1;
            } else {
                return;
            }
        }
    }

    public static void Cardinal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2, byte[] bArr5, int i3) {
        if (m1966a(bArr3)) {
            SignatureSpi.ecNR512 ecnr512 = new SignatureSpi.ecNR512(256);
            byte[] bArr6 = new byte[114];
            ecnr512.init(bArr, 0, 57);
            ecnr512.getInstance(bArr6, 0, 114);
            byte[] bArr7 = new byte[57];
            m1962a(bArr6, 0, bArr7);
            m1959a((KeyPairGeneratorSpi.ECDH) ecnr512, (byte) 0, bArr3);
            ecnr512.init(bArr6, 57, 57);
            ecnr512.init(bArr4, 0, i2);
            ecnr512.getInstance(bArr6, 0, 114);
            byte[] d = m1977d(bArr6);
            byte[] bArr8 = new byte[57];
            getInstance getinstance = new getInstance((byte) 0);
            m1963a(d, getinstance);
            m1960a(getinstance, bArr8, 0);
            m1959a((KeyPairGeneratorSpi.ECDH) ecnr512, (byte) 0, bArr3);
            ecnr512.init(bArr8, 0, 57);
            ecnr512.init(bArr2, 0, 57);
            ecnr512.init(bArr4, 0, i2);
            ecnr512.getInstance(bArr6, 0, 114);
            byte[] a = m1969a(d, m1977d(bArr6), bArr7);
            System.arraycopy(bArr8, 0, bArr5, 0, 57);
            System.arraycopy(a, 0, bArr5, 57, 57);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }
}

package com.cardinalcommerce.p060a;

import androidx.core.view.MotionEventCompat;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setOnHoverListener;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setImportantForAutofill */
public abstract class setImportantForAutofill {

    /* renamed from: a */
    private static final byte[] f2825a = setAnimation.configure("SigEd25519 no Ed25519 collisions");

    /* renamed from: b */
    private static final int[] f2826b = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: c */
    private static final int[] f2827c = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};

    /* renamed from: d */
    private static final int[] f2828d = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* renamed from: e */
    private static final int[] f2829e = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* renamed from: f */
    private static final int[] f2830f = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* renamed from: g */
    private static final int[] f2831g = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* renamed from: h */
    private static final int[] f2832h = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};

    /* renamed from: i */
    private static Object f2833i = new Object();

    /* renamed from: j */
    private static C2055init[] f2834j = null;

    /* renamed from: k */
    private static int[] f2835k = null;

    /* renamed from: com.cardinalcommerce.a.setImportantForAutofill$Cardinal */
    static class Cardinal {
        int[] cca_continue;
        int[] configure;
        int[] init;

        private Cardinal() {
            this.cca_continue = setOnCreateContextMenuListener.getInstance();
            this.configure = setOnCreateContextMenuListener.getInstance();
            this.init = setOnCreateContextMenuListener.getInstance();
        }

        /* synthetic */ Cardinal(byte b) {
            this();
        }
    }

    /* renamed from: com.cardinalcommerce.a.setImportantForAutofill$configure */
    static class C2054configure {
        int[] Cardinal;
        int[] cca_continue;
        int[] configure;
        int[] getInstance;
        int[] init;

        private C2054configure() {
            this.getInstance = setOnCreateContextMenuListener.getInstance();
            this.cca_continue = setOnCreateContextMenuListener.getInstance();
            this.init = setOnCreateContextMenuListener.getInstance();
            this.configure = setOnCreateContextMenuListener.getInstance();
            this.Cardinal = setOnCreateContextMenuListener.getInstance();
        }

        /* synthetic */ C2054configure(byte b) {
            this();
        }
    }

    /* renamed from: com.cardinalcommerce.a.setImportantForAutofill$init */
    static class C2055init {
        int[] cca_continue;
        int[] configure;
        int[] getInstance;
        int[] init;

        private C2055init() {
            this.init = setOnCreateContextMenuListener.getInstance();
            this.getInstance = setOnCreateContextMenuListener.getInstance();
            this.configure = setOnCreateContextMenuListener.getInstance();
            this.cca_continue = setOnCreateContextMenuListener.getInstance();
        }

        /* synthetic */ C2055init(byte b) {
            this();
        }
    }

    public static void Cardinal(setOnHoverListener.getInstance getinstance, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (getinstance != null) {
            byte[] bArr2 = new byte[32];
            m2012a(bArr, i, bArr2);
            C2054configure configure = new C2054configure((byte) 0);
            m2013a(bArr2, configure);
            setOnCreateContextMenuListener.getInstance(configure.cca_continue, iArr, 0);
            setOnCreateContextMenuListener.getInstance(configure.init, iArr2, 0);
            return;
        }
        throw new NullPointerException("This method is only for use by X25519");
    }

    /* renamed from: a */
    private static int m2003a(byte[] bArr, int i) {
        int i2 = i + 1;
        return ((bArr[i2 + 1] & 255) << 16) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    /* renamed from: a */
    private static C2055init m2004a(C2054configure configure) {
        C2055init init = new C2055init((byte) 0);
        setOnCreateContextMenuListener.getInstance(configure.getInstance, init.init, 0);
        setOnCreateContextMenuListener.getInstance(configure.cca_continue, init.getInstance, 0);
        setOnCreateContextMenuListener.getInstance(configure.init, init.configure, 0);
        setOnCreateContextMenuListener.getInstance(configure.configure, configure.Cardinal, init.cca_continue);
        return init;
    }

    /* renamed from: a */
    private static void m2006a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    private static void m2008a(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, byte b, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = f2825a;
            mQVwithSHA256KDFAndSharedInfo.init(bArr2, 0, bArr2.length);
            mQVwithSHA256KDFAndSharedInfo.Cardinal(b);
            mQVwithSHA256KDFAndSharedInfo.Cardinal((byte) bArr.length);
            mQVwithSHA256KDFAndSharedInfo.init(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a */
    private static void m2009a(C2054configure configure, byte[] bArr, int i) {
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        setOnCreateContextMenuListener.init(configure.init, instance2);
        setOnCreateContextMenuListener.getInstance(configure.getInstance, instance2, instance);
        setOnCreateContextMenuListener.getInstance(configure.cca_continue, instance2, instance2);
        setOnCreateContextMenuListener.getInstance(instance);
        setOnCreateContextMenuListener.getInstance(instance2);
        setOnCreateContextMenuListener.configure(instance2, bArr, i);
        int i2 = (i + 32) - 1;
        bArr[i2] = (byte) (bArr[i2] | ((instance[0] & 1) << 7));
    }

    /* renamed from: a */
    private static void m2010a(boolean z, C2055init init, C2054configure configure) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        int[] instance3 = setOnCreateContextMenuListener.getInstance();
        int[] instance4 = setOnCreateContextMenuListener.getInstance();
        int[] iArr5 = configure.configure;
        int[] instance5 = setOnCreateContextMenuListener.getInstance();
        int[] instance6 = setOnCreateContextMenuListener.getInstance();
        int[] iArr6 = configure.Cardinal;
        if (z) {
            iArr = instance3;
            iArr4 = instance4;
            iArr3 = instance5;
            iArr2 = instance6;
        } else {
            iArr4 = instance3;
            iArr = instance4;
            iArr2 = instance5;
            iArr3 = instance6;
        }
        setOnCreateContextMenuListener.cca_continue(configure.cca_continue, configure.getInstance, instance2, instance);
        setOnCreateContextMenuListener.cca_continue(init.getInstance, init.init, iArr, iArr4);
        setOnCreateContextMenuListener.getInstance(instance, instance3, instance);
        setOnCreateContextMenuListener.getInstance(instance2, instance4, instance2);
        setOnCreateContextMenuListener.getInstance(configure.configure, configure.Cardinal, instance3);
        setOnCreateContextMenuListener.getInstance(instance3, init.cca_continue, instance3);
        setOnCreateContextMenuListener.getInstance(instance3, f2831g, instance3);
        setOnCreateContextMenuListener.getInstance(configure.init, init.configure, instance4);
        setOnCreateContextMenuListener.configure(instance4, instance4, instance4);
        setOnCreateContextMenuListener.cca_continue(instance2, instance, iArr6, iArr5);
        setOnCreateContextMenuListener.cca_continue(instance4, instance3, iArr3, iArr2);
        setOnCreateContextMenuListener.Cardinal(iArr3);
        setOnCreateContextMenuListener.getInstance(iArr5, instance5, configure.getInstance);
        setOnCreateContextMenuListener.getInstance(instance6, iArr6, configure.cca_continue);
        setOnCreateContextMenuListener.getInstance(instance5, instance6, configure.init);
    }

    /* renamed from: a */
    private static void m2011a(boolean z, C2055init init, C2055init init2, C2055init init3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        C2055init init4 = init;
        C2055init init5 = init2;
        C2055init init6 = init3;
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        int[] instance3 = setOnCreateContextMenuListener.getInstance();
        int[] instance4 = setOnCreateContextMenuListener.getInstance();
        int[] instance5 = setOnCreateContextMenuListener.getInstance();
        int[] instance6 = setOnCreateContextMenuListener.getInstance();
        int[] instance7 = setOnCreateContextMenuListener.getInstance();
        int[] instance8 = setOnCreateContextMenuListener.getInstance();
        if (z) {
            iArr4 = instance3;
            iArr3 = instance4;
            iArr2 = instance6;
            iArr = instance7;
        } else {
            iArr3 = instance3;
            iArr4 = instance4;
            iArr = instance6;
            iArr2 = instance7;
        }
        setOnCreateContextMenuListener.cca_continue(init4.getInstance, init4.init, instance2, instance);
        setOnCreateContextMenuListener.cca_continue(init5.getInstance, init5.init, iArr4, iArr3);
        setOnCreateContextMenuListener.getInstance(instance, instance3, instance);
        setOnCreateContextMenuListener.getInstance(instance2, instance4, instance2);
        setOnCreateContextMenuListener.getInstance(init4.cca_continue, init5.cca_continue, instance3);
        setOnCreateContextMenuListener.getInstance(instance3, f2831g, instance3);
        setOnCreateContextMenuListener.getInstance(init4.configure, init5.configure, instance4);
        setOnCreateContextMenuListener.configure(instance4, instance4, instance4);
        setOnCreateContextMenuListener.cca_continue(instance2, instance, instance8, instance5);
        setOnCreateContextMenuListener.cca_continue(instance4, instance3, iArr2, iArr);
        setOnCreateContextMenuListener.Cardinal(iArr2);
        setOnCreateContextMenuListener.getInstance(instance5, instance6, init6.init);
        int[] iArr5 = instance7;
        setOnCreateContextMenuListener.getInstance(iArr5, instance8, init6.getInstance);
        setOnCreateContextMenuListener.getInstance(instance6, iArr5, init6.configure);
        setOnCreateContextMenuListener.getInstance(instance5, instance8, init6.cca_continue);
    }

    /* renamed from: a */
    private static void m2012a(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        bArr2[31] = (byte) (bArr2[31] & Byte.MAX_VALUE);
        bArr2[31] = (byte) (bArr2[31] | 64);
    }

    /* renamed from: a */
    private static void m2015a(int[] iArr, int[] iArr2, C2055init init, C2054configure configure) {
        m2005a();
        byte[] a = m2021a(iArr, 7);
        byte[] a2 = m2021a(iArr2, 5);
        C2055init[] a3 = m2022a(init, 8);
        m2026c(configure);
        int i = 255;
        while (i > 0 && (a[i] | a2[i]) == 0) {
            i--;
        }
        while (true) {
            byte b = a[i];
            boolean z = false;
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                m2010a(i2 != 0, f2834j[(b ^ i2) >>> 1], configure);
            }
            byte b2 = a2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.f53596US;
                int i4 = (b2 ^ i3) >>> 1;
                if (i3 != 0) {
                    z = true;
                }
                m2010a(z, a3[i4], configure);
            }
            i--;
            if (i >= 0) {
                m2024b(configure);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m2017a(byte[] bArr, byte b) {
        if (bArr == null && b == 0) {
            return true;
        }
        return bArr != null && bArr.length < 256;
    }

    /* renamed from: a */
    private static byte[] m2021a(int[] iArr, int i) {
        int i2;
        int[] iArr2 = new int[16];
        int i3 = 0;
        int i4 = 8;
        int i5 = 16;
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
        byte[] bArr = new byte[256];
        int i9 = 1 << i;
        int i10 = i9 - 1;
        int i11 = i9 >>> 1;
        int i12 = 0;
        int i13 = 0;
        while (i3 < 16) {
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

    /* renamed from: b */
    private static int m2023b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    /* renamed from: b */
    private static void m2024b(C2054configure configure) {
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        int[] instance3 = setOnCreateContextMenuListener.getInstance();
        int[] iArr = configure.configure;
        int[] instance4 = setOnCreateContextMenuListener.getInstance();
        int[] instance5 = setOnCreateContextMenuListener.getInstance();
        int[] iArr2 = configure.Cardinal;
        setOnCreateContextMenuListener.cca_continue(configure.getInstance, instance);
        setOnCreateContextMenuListener.cca_continue(configure.cca_continue, instance2);
        setOnCreateContextMenuListener.cca_continue(configure.init, instance3);
        setOnCreateContextMenuListener.configure(instance3, instance3, instance3);
        setOnCreateContextMenuListener.cca_continue(instance, instance2, iArr2, instance5);
        setOnCreateContextMenuListener.configure(configure.getInstance, configure.cca_continue, iArr);
        setOnCreateContextMenuListener.cca_continue(iArr, iArr);
        setOnCreateContextMenuListener.cca_continue(iArr2, iArr, iArr);
        setOnCreateContextMenuListener.configure(instance3, instance5, instance4);
        setOnCreateContextMenuListener.Cardinal(instance4);
        setOnCreateContextMenuListener.getInstance(iArr, instance4, configure.getInstance);
        setOnCreateContextMenuListener.getInstance(instance5, iArr2, configure.cca_continue);
        setOnCreateContextMenuListener.getInstance(instance4, instance5, configure.init);
    }

    /* renamed from: c */
    private static void m2026c(C2054configure configure) {
        setOnCreateContextMenuListener.cleanup(configure.getInstance);
        setOnCreateContextMenuListener.cca_continue(configure.cca_continue);
        setOnCreateContextMenuListener.cca_continue(configure.init);
        setOnCreateContextMenuListener.cleanup(configure.configure);
        setOnCreateContextMenuListener.cca_continue(configure.Cardinal);
    }

    /* renamed from: c */
    private static byte[] m2027c(byte[] bArr) {
        byte[] bArr2 = bArr;
        long b = ((long) m2023b(bArr2, 0)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a = ((long) (m2003a(bArr2, 4) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b2 = ((long) m2023b(bArr2, 7)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a2 = ((long) (m2003a(bArr2, 11) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b3 = ((long) m2023b(bArr2, 14)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a3 = ((long) (m2003a(bArr2, 18) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j = a;
        long b4 = ((long) m2023b(bArr2, 21)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = b2;
        long a4 = ((long) (m2003a(bArr2, 25) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b5 = ((long) m2023b(bArr2, 28)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = a2;
        long a5 = ((long) (m2003a(bArr2, 32) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = b3;
        long b6 = ((long) m2023b(bArr2, 35)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = a3;
        long a6 = ((long) (m2003a(bArr2, 39) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = b4;
        long b7 = ((long) m2023b(bArr2, 42)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = a4;
        long a7 = ((long) (m2003a(bArr2, 46) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = b5;
        long b8 = ((long) m2023b(bArr2, 49)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a8 = ((long) (m2003a(bArr2, 53) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long b9 = ((long) m2023b(bArr2, 56)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long a9 = ((long) (m2003a(bArr2, 60) << 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = ((long) bArr2[63]) & 255;
        long j10 = a9 + (b9 >> 28);
        long j11 = b9 & 268435455;
        long j12 = j8 - (j10 * -50998291);
        long j13 = (a5 - (j9 * -50998291)) - (j10 * 19280294);
        long j14 = (b6 - (j9 * 19280294)) - (j10 * 127719000);
        long j15 = (b7 - (j9 * -6428113)) - (j10 * 5343);
        long j16 = j7 - (j11 * -50998291);
        long j17 = ((a6 - (j9 * 127719000)) - (j10 * -6428113)) - (j11 * 5343);
        long j18 = a8 + (b8 >> 28);
        long j19 = b8 & 268435455;
        long j20 = (j14 - (j11 * -6428113)) - (j18 * 5343);
        long j21 = ((j13 - (j11 * 127719000)) - (j18 * -6428113)) - (j19 * 5343);
        long j22 = (a7 - (j9 * 5343)) + (j15 >> 28);
        long j23 = (j15 & 268435455) + (j17 >> 28);
        long j24 = j3 - (j23 * -50998291);
        long j25 = (j4 - (j22 * -50998291)) - (j23 * 19280294);
        long j26 = ((j5 - (j19 * -50998291)) - (j22 * 19280294)) - (j23 * 127719000);
        long j27 = (((j16 - (j18 * 19280294)) - (j19 * 127719000)) - (j22 * -6428113)) - (j23 * 5343);
        long j28 = (j17 & 268435455) + (j20 >> 28);
        long j29 = j20 & 268435455;
        long j30 = j2 - (j28 * -50998291);
        long j31 = j24 - (j28 * 19280294);
        long j32 = j25 - (j28 * 127719000);
        long j33 = ((((j6 - (j18 * -50998291)) - (j19 * 19280294)) - (j22 * 127719000)) - (j23 * -6428113)) - (j28 * 5343);
        long j34 = j29 + (j21 >> 28);
        long j35 = j30 - (j34 * 19280294);
        long j36 = j31 - (j34 * 127719000);
        long j37 = j32 - (j34 * -6428113);
        long j38 = (j26 - (j28 * -6428113)) - (j34 * 5343);
        long j39 = ((((j12 - (j11 * 19280294)) - (j18 * 127719000)) - (j19 * -6428113)) - (j22 * 5343)) + (j27 >> 28);
        long j40 = j39 & 268435455;
        long j41 = j40 >>> 27;
        long j42 = (j21 & 268435455) + (j39 >> 28) + j41;
        long j43 = b - (j42 * -50998291);
        long j44 = ((j - (j34 * -50998291)) - (j42 * 19280294)) + (j43 >> 28);
        long j45 = j43 & 268435455;
        long j46 = (j35 - (j42 * 127719000)) + (j44 >> 28);
        long j47 = (j36 - (j42 * -6428113)) + (j46 >> 28);
        long j48 = (j37 - (j42 * 5343)) + (j47 >> 28);
        long j49 = j38 + (j48 >> 28);
        long j50 = j48 & 268435455;
        long j51 = j33 + (j49 >> 28);
        long j52 = (j27 & 268435455) + (j51 >> 28);
        long j53 = j40 + (j52 >> 28);
        long j54 = (j53 >> 28) - j41;
        long j55 = j45 + (j54 & -50998291);
        long j56 = (j44 & 268435455) + (j54 & 19280294) + (j55 >> 28);
        long j57 = (j46 & 268435455) + (j54 & 127719000) + (j56 >> 28);
        long j58 = (j47 & 268435455) + (j54 & -6428113) + (j57 >> 28);
        long j59 = j50 + (j54 & 5343) + (j58 >> 28);
        long j60 = (j49 & 268435455) + (j59 >> 28);
        long j61 = (j51 & 268435455) + (j60 >> 28);
        long j62 = (j52 & 268435455) + (j61 >> 28);
        byte[] bArr3 = new byte[32];
        m2007a((j55 & 268435455) | ((j56 & 268435455) << 28), bArr3, 0);
        m2007a(((j58 & 268435455) << 28) | (j57 & 268435455), bArr3, 7);
        m2007a((j59 & 268435455) | ((j60 & 268435455) << 28), bArr3, 14);
        m2007a((j61 & 268435455) | ((j62 & 268435455) << 28), bArr3, 21);
        m2006a((int) ((j53 & 268435455) + (j62 >> 28)), bArr3, 28);
        return bArr3;
    }

    public static boolean cca_continue(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return m2019a(bArr, 0, bArr2, 0, bArr3, 0, i);
    }

    public static void init(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    /* renamed from: a */
    private static byte[] m2020a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        for (int i = 0; i < 8; i++) {
            iArr[i] = m2023b(bArr, (i << 2) + 0);
        }
        int[] iArr2 = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr2[i2] = m2023b(bArr2, (i2 << 2) + 0);
        }
        int[] iArr3 = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr3[i3] = m2023b(bArr3, (i3 << 2) + 0);
        }
        setNextFocusLeftId.init(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i4 = 0; i4 < 16; i4++) {
            m2006a(iArr[i4], bArr4, i4 << 2);
        }
        return m2027c(bArr4);
    }

    /* renamed from: a */
    private static boolean m2016a(byte[] bArr) {
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = m2023b(bArr, (i << 2) + 0);
        }
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !setNextFocusLeftId.configure(iArr, f2826b);
    }

    /* renamed from: b */
    private static boolean m2025b(byte[] bArr) {
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = m2023b(bArr, (i << 2) + 0);
        }
        return !setNextFocusLeftId.configure(iArr, f2827c);
    }

    /* renamed from: a */
    private static boolean m2018a(byte[] bArr, int i, C2055init init) {
        byte[] cca_continue = setForegroundTintBlendMode.cca_continue(bArr, i, i + 32);
        boolean z = false;
        if (!m2016a(cca_continue)) {
            return false;
        }
        int i2 = (cca_continue[31] & 128) >>> 7;
        cca_continue[31] = (byte) (cca_continue[31] & Byte.MAX_VALUE);
        setOnCreateContextMenuListener.Cardinal(cca_continue, 0, init.getInstance);
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        setOnCreateContextMenuListener.cca_continue(init.getInstance, instance);
        setOnCreateContextMenuListener.getInstance(f2830f, instance, instance2);
        setOnCreateContextMenuListener.CardinalError(instance);
        setOnCreateContextMenuListener.init(instance2);
        if (!setOnCreateContextMenuListener.init(instance, instance2, init.init)) {
            return false;
        }
        setOnCreateContextMenuListener.getInstance(init.init);
        if (i2 == 1 && setOnCreateContextMenuListener.configure(init.init)) {
            return false;
        }
        if (i2 != (init.init[0] & 1)) {
            z = true;
        }
        if (!z) {
            setOnCreateContextMenuListener.getInstance(init.init, init.init);
        }
        setOnCreateContextMenuListener.cca_continue(init.configure);
        setOnCreateContextMenuListener.getInstance(init.init, init.getInstance, init.cca_continue);
        return true;
    }

    /* renamed from: a */
    private static void m2014a(byte[] bArr, int[] iArr) {
        for (int i = 0; i < 8; i++) {
            iArr[i] = m2023b(bArr, (i << 2) + 0);
        }
    }

    /* renamed from: a */
    private static void m2007a(long j, byte[] bArr, int i) {
        m2006a((int) j, bArr, i);
        int i2 = (int) (j >>> 32);
        int i3 = i + 4;
        bArr[i3] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i4 + 1] = (byte) (i2 >>> 16);
    }

    public static void cca_continue(byte[] bArr, byte[] bArr2) {
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = new BCECGOST3410PrivateKey();
        byte[] bArr3 = new byte[bCECGOST3410PrivateKey.getInstance()];
        bCECGOST3410PrivateKey.init(bArr, 0, 32);
        bCECGOST3410PrivateKey.configure(bArr3, 0);
        byte[] bArr4 = new byte[32];
        m2012a(bArr3, 0, bArr4);
        C2054configure configure = new C2054configure((byte) 0);
        m2013a(bArr4, configure);
        m2009a(configure, bArr2, 0);
    }

    /* renamed from: a */
    private static boolean m2019a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        if (m2017a((byte[]) null, (byte) 0)) {
            byte[] cca_continue = setForegroundTintBlendMode.cca_continue(bArr, 0, 32);
            byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr, 32, 64);
            if (!m2016a(cca_continue) || !m2025b(cca_continue2)) {
                return false;
            }
            C2055init init = new C2055init((byte) 0);
            if (!m2018a(bArr2, 0, init)) {
                return false;
            }
            BCECGOST3410PrivateKey bCECGOST3410PrivateKey = new BCECGOST3410PrivateKey();
            byte[] bArr4 = new byte[bCECGOST3410PrivateKey.getInstance()];
            m2008a((KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo) bCECGOST3410PrivateKey, (byte) 0, (byte[]) null);
            bCECGOST3410PrivateKey.init(cca_continue, 0, 32);
            bCECGOST3410PrivateKey.init(bArr2, 0, 32);
            bCECGOST3410PrivateKey.init(bArr3, 0, i4);
            bCECGOST3410PrivateKey.configure(bArr4, 0);
            byte[] c = m2027c(bArr4);
            int[] iArr = new int[8];
            m2014a(cca_continue2, iArr);
            int[] iArr2 = new int[8];
            m2014a(c, iArr2);
            C2054configure configure = new C2054configure((byte) 0);
            m2015a(iArr, iArr2, init, configure);
            byte[] bArr5 = new byte[32];
            m2009a(configure, bArr5, 0);
            return setForegroundTintBlendMode.Cardinal(bArr5, cca_continue);
        }
        throw new IllegalArgumentException("ctx");
    }

    /* renamed from: a */
    private static C2055init[] m2022a(C2055init init, int i) {
        C2055init init2 = new C2055init((byte) 0);
        m2011a(false, init, init, init2);
        C2055init[] initArr = new C2055init[i];
        C2055init init3 = new C2055init((byte) 0);
        setOnCreateContextMenuListener.getInstance(init.init, init3.init, 0);
        setOnCreateContextMenuListener.getInstance(init.getInstance, init3.getInstance, 0);
        setOnCreateContextMenuListener.getInstance(init.configure, init3.configure, 0);
        setOnCreateContextMenuListener.getInstance(init.cca_continue, init3.cca_continue, 0);
        initArr[0] = init3;
        for (int i2 = 1; i2 < i; i2++) {
            C2055init init4 = initArr[i2 - 1];
            C2055init init5 = new C2055init((byte) 0);
            initArr[i2] = init5;
            m2011a(false, init4, init2, init5);
        }
        return initArr;
    }

    /* renamed from: a */
    private static void m2005a() {
        synchronized (f2833i) {
            if (f2835k == null) {
                C2055init init = new C2055init((byte) 0);
                setOnCreateContextMenuListener.getInstance(f2828d, init.init, 0);
                setOnCreateContextMenuListener.getInstance(f2829e, init.getInstance, 0);
                setOnCreateContextMenuListener.cca_continue(init.configure);
                setOnCreateContextMenuListener.getInstance(init.init, init.getInstance, init.cca_continue);
                f2834j = m2022a(init, 32);
                C2054configure configure = new C2054configure((byte) 0);
                setOnCreateContextMenuListener.getInstance(f2828d, configure.getInstance, 0);
                setOnCreateContextMenuListener.getInstance(f2829e, configure.cca_continue, 0);
                setOnCreateContextMenuListener.cca_continue(configure.init);
                setOnCreateContextMenuListener.getInstance(configure.getInstance, configure.configure, 0);
                setOnCreateContextMenuListener.getInstance(configure.cca_continue, configure.Cardinal, 0);
                f2835k = new int[1920];
                int i = 0;
                for (int i2 = 0; i2 < 8; i2++) {
                    C2055init[] initArr = new C2055init[4];
                    C2055init init2 = new C2055init((byte) 0);
                    setOnCreateContextMenuListener.cleanup(init2.init);
                    setOnCreateContextMenuListener.cca_continue(init2.getInstance);
                    setOnCreateContextMenuListener.cca_continue(init2.configure);
                    setOnCreateContextMenuListener.cleanup(init2.cca_continue);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        }
                        m2011a(true, init2, m2004a(configure), init2);
                        m2024b(configure);
                        initArr[i3] = m2004a(configure);
                        if (i2 + i3 != 10) {
                            for (int i4 = 1; i4 < 8; i4++) {
                                m2024b(configure);
                            }
                        }
                        i3++;
                    }
                    C2055init[] initArr2 = new C2055init[8];
                    initArr2[0] = init2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 3; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            C2055init init3 = initArr2[i5 - i7];
                            C2055init init4 = initArr[i6];
                            C2055init init5 = new C2055init((byte) 0);
                            initArr2[i5] = init5;
                            m2011a(false, init3, init4, init5);
                            i8++;
                            i5++;
                        }
                    }
                    for (int i9 = 0; i9 < 8; i9++) {
                        C2055init init6 = initArr2[i9];
                        int[] instance = setOnCreateContextMenuListener.getInstance();
                        int[] instance2 = setOnCreateContextMenuListener.getInstance();
                        setOnCreateContextMenuListener.configure(init6.configure, init6.configure, instance);
                        setOnCreateContextMenuListener.init(instance, instance2);
                        setOnCreateContextMenuListener.getInstance(init6.init, instance2, instance);
                        setOnCreateContextMenuListener.getInstance(init6.getInstance, instance2, instance2);
                        Cardinal cardinal = new Cardinal((byte) 0);
                        setOnCreateContextMenuListener.cca_continue(instance2, instance, cardinal.cca_continue, cardinal.configure);
                        setOnCreateContextMenuListener.getInstance(instance, instance2, cardinal.init);
                        setOnCreateContextMenuListener.getInstance(cardinal.init, f2832h, cardinal.init);
                        setOnCreateContextMenuListener.getInstance(cardinal.cca_continue);
                        setOnCreateContextMenuListener.getInstance(cardinal.configure);
                        setOnCreateContextMenuListener.getInstance(cardinal.cca_continue, f2835k, i);
                        int i10 = i + 10;
                        setOnCreateContextMenuListener.getInstance(cardinal.configure, f2835k, i10);
                        int i11 = i10 + 10;
                        setOnCreateContextMenuListener.getInstance(cardinal.init, f2835k, i11);
                        i = i11 + 10;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m2013a(byte[] bArr, C2054configure configure) {
        C2054configure configure2 = configure;
        m2005a();
        m2026c(configure);
        int i = 8;
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = m2023b(bArr, (i2 << 2) + 0);
        }
        setDrawingCacheQuality.getInstance(8, (~iArr[0]) & 1, iArr, f2827c, iArr);
        setDrawingCacheQuality.init(8, iArr, 1);
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = iArr[i3];
            int i5 = ((i4 >>> 7) ^ i4) & 11141290;
            int i6 = i4 ^ (i5 ^ (i5 << 7));
            int i7 = ((i6 >>> 14) ^ i6) & 52428;
            int i8 = i6 ^ (i7 ^ (i7 << 14));
            int i9 = ((i8 >>> 4) ^ i8) & 15728880;
            int i10 = i8 ^ (i9 ^ (i9 << 4));
            int i11 = ((i10 >>> 8) ^ i10) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            iArr[i3] = i10 ^ (i11 ^ (i11 << 8));
        }
        Cardinal cardinal = new Cardinal((byte) 0);
        int i12 = 28;
        while (true) {
            int i13 = 0;
            while (i13 < i) {
                int i14 = iArr[i13] >>> i12;
                int i15 = (i14 >>> 3) & 1;
                int i16 = (i14 ^ (-i15)) & 7;
                int i17 = (i13 << 3) * 3 * 10;
                for (int i18 = 0; i18 < i; i18++) {
                    int i19 = ((i18 ^ i16) - 1) >> 31;
                    setDrawingCacheQuality.configure(10, i19, f2835k, i17, cardinal.cca_continue);
                    int i20 = i17 + 10;
                    setDrawingCacheQuality.configure(10, i19, f2835k, i20, cardinal.configure);
                    int i21 = i20 + 10;
                    setDrawingCacheQuality.configure(10, i19, f2835k, i21, cardinal.init);
                    i17 = i21 + 10;
                }
                setOnCreateContextMenuListener.cca_continue(i15, cardinal.cca_continue, cardinal.configure);
                setOnCreateContextMenuListener.Cardinal(i15, cardinal.init);
                int[] instance = setOnCreateContextMenuListener.getInstance();
                int[] instance2 = setOnCreateContextMenuListener.getInstance();
                int[] instance3 = setOnCreateContextMenuListener.getInstance();
                int[] iArr2 = configure2.configure;
                int[] instance4 = setOnCreateContextMenuListener.getInstance();
                int[] instance5 = setOnCreateContextMenuListener.getInstance();
                int[] iArr3 = configure2.Cardinal;
                setOnCreateContextMenuListener.cca_continue(configure2.cca_continue, configure2.getInstance, instance2, instance);
                setOnCreateContextMenuListener.getInstance(instance, cardinal.configure, instance);
                setOnCreateContextMenuListener.getInstance(instance2, cardinal.cca_continue, instance2);
                setOnCreateContextMenuListener.getInstance(configure2.configure, configure2.Cardinal, instance3);
                setOnCreateContextMenuListener.getInstance(instance3, cardinal.init, instance3);
                setOnCreateContextMenuListener.cca_continue(instance2, instance, iArr3, iArr2);
                setOnCreateContextMenuListener.cca_continue(configure2.init, instance3, instance5, instance4);
                setOnCreateContextMenuListener.Cardinal(instance5);
                setOnCreateContextMenuListener.getInstance(iArr2, instance4, configure2.getInstance);
                setOnCreateContextMenuListener.getInstance(instance5, iArr3, configure2.cca_continue);
                setOnCreateContextMenuListener.getInstance(instance4, instance5, configure2.init);
                i13++;
                i = 8;
            }
            i12 -= 4;
            if (i12 >= 0) {
                m2024b(configure);
                i = 8;
            } else {
                return;
            }
        }
    }

    public static void getInstance(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, byte[] bArr4, int i3) {
        if (m2017a((byte[]) null, (byte) 0)) {
            BCECGOST3410PrivateKey bCECGOST3410PrivateKey = new BCECGOST3410PrivateKey();
            byte[] bArr5 = new byte[bCECGOST3410PrivateKey.getInstance()];
            bCECGOST3410PrivateKey.init(bArr, 0, 32);
            bCECGOST3410PrivateKey.configure(bArr5, 0);
            byte[] bArr6 = new byte[32];
            m2012a(bArr5, 0, bArr6);
            m2008a((KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo) bCECGOST3410PrivateKey, (byte) 0, (byte[]) null);
            bCECGOST3410PrivateKey.init(bArr5, 32, 32);
            bCECGOST3410PrivateKey.init(bArr3, 0, i2);
            bCECGOST3410PrivateKey.configure(bArr5, 0);
            byte[] c = m2027c(bArr5);
            byte[] bArr7 = new byte[32];
            C2054configure configure = new C2054configure((byte) 0);
            m2013a(c, configure);
            m2009a(configure, bArr7, 0);
            m2008a((KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo) bCECGOST3410PrivateKey, (byte) 0, (byte[]) null);
            bCECGOST3410PrivateKey.init(bArr7, 0, 32);
            bCECGOST3410PrivateKey.init(bArr2, 0, 32);
            bCECGOST3410PrivateKey.init(bArr3, 0, i2);
            bCECGOST3410PrivateKey.configure(bArr5, 0);
            byte[] a = m2020a(c, m2027c(bArr5), bArr6);
            System.arraycopy(bArr7, 0, bArr4, 0, 32);
            System.arraycopy(a, 0, bArr4, 32, 32);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }
}

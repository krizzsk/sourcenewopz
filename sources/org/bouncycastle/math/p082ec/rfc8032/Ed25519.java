package org.bouncycastle.math.p082ec.rfc8032;

import com.google.common.base.Ascii;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.p082ec.rfc7748.X25519;
import org.bouncycastle.math.p082ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519 */
public abstract class Ed25519 {
    private static final int[] B_x = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
    private static final int[] B_y = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
    private static final int COORD_INTS = 8;
    private static final int[] C_d = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
    private static final int[] C_d2 = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
    private static final int[] C_d4 = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    private static final byte[] DOM2_PREFIX = {83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};

    /* renamed from: L */
    private static final int[] f6394L = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};

    /* renamed from: L0 */
    private static final int f6395L0 = -50998291;

    /* renamed from: L1 */
    private static final int f6396L1 = 19280294;

    /* renamed from: L2 */
    private static final int f6397L2 = 127719000;

    /* renamed from: L3 */
    private static final int f6398L3 = -6428113;

    /* renamed from: L4 */
    private static final int f6399L4 = 5343;
    private static final long M08L = 255;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;

    /* renamed from: P */
    private static final int[] f6400P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int POINT_BYTES = 32;
    private static final int PRECOMP_BLOCKS = 8;
    private static final int PRECOMP_MASK = 7;
    private static final int PRECOMP_POINTS = 8;
    private static final int PRECOMP_SPACING = 8;
    private static final int PRECOMP_TEETH = 4;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    private static final int SCALAR_BYTES = 32;
    private static final int SCALAR_INTS = 8;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$Algorithm */
    public static final class Algorithm {
        public static final int Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$F */
    private static class C2791F extends X25519Field {
        private C2791F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointAccum */
    private static class PointAccum {

        /* renamed from: u */
        int[] f6401u;

        /* renamed from: v */
        int[] f6402v;

        /* renamed from: x */
        int[] f6403x;

        /* renamed from: y */
        int[] f6404y;

        /* renamed from: z */
        int[] f6405z;

        private PointAccum() {
            this.f6403x = C2791F.create();
            this.f6404y = C2791F.create();
            this.f6405z = C2791F.create();
            this.f6401u = C2791F.create();
            this.f6402v = C2791F.create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointAffine */
    private static class PointAffine {

        /* renamed from: x */
        int[] f6406x;

        /* renamed from: y */
        int[] f6407y;

        private PointAffine() {
            this.f6406x = C2791F.create();
            this.f6407y = C2791F.create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointExt */
    private static class PointExt {

        /* renamed from: t */
        int[] f6408t;

        /* renamed from: x */
        int[] f6409x;

        /* renamed from: y */
        int[] f6410y;

        /* renamed from: z */
        int[] f6411z;

        private PointExt() {
            this.f6409x = C2791F.create();
            this.f6410y = C2791F.create();
            this.f6411z = C2791F.create();
            this.f6408t = C2791F.create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointPrecomp */
    private static class PointPrecomp {
        int[] xyd;
        int[] ymx_h;
        int[] ypx_h;

        private PointPrecomp() {
            this.ypx_h = C2791F.create();
            this.ymx_h = C2791F.create();
            this.xyd = C2791F.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        decodeScalar(bArr3, 0, iArr3);
        Nat256.mulAddTo(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i = 0; i < 16; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr, byte b) {
        return (bArr == null && b == 0) || (bArr != null && bArr.length < 256);
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        C2791F.sqr(iArr, create2);
        C2791F.sqr(iArr2, create3);
        C2791F.mul(create2, create3, create);
        C2791F.sub(create3, create2, create3);
        C2791F.mul(create, C_d, create);
        C2791F.addOne(create);
        C2791F.sub(create, create3, create);
        C2791F.normalize(create);
        return C2791F.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] create4 = C2791F.create();
        C2791F.sqr(iArr, create2);
        C2791F.sqr(iArr2, create3);
        C2791F.sqr(iArr3, create4);
        C2791F.mul(create2, create3, create);
        C2791F.sub(create3, create2, create3);
        C2791F.mul(create3, create4, create3);
        C2791F.sqr(create4, create4);
        C2791F.mul(create, C_d, create);
        C2791F.add(create, create4, create);
        C2791F.sub(create, create3, create);
        C2791F.normalize(create);
        return C2791F.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        int[] iArr = new int[8];
        decode32(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !Nat256.gte(iArr, f6400P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        decodeScalar(bArr, 0, iArr);
        return !Nat256.gte(iArr, f6394L);
    }

    private static byte[] copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    private static Digest createDigest() {
        return new SHA512Digest();
    }

    public static Digest createPrehash() {
        return createDigest();
    }

    private static int decode24(byte[] bArr, int i) {
        int i2 = i + 1;
        return ((bArr[i2 + 1] & 255) << 16) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointAffine pointAffine) {
        byte[] copy = copy(bArr, i, 32);
        boolean z2 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        int i2 = (copy[31] & 128) >>> 7;
        copy[31] = (byte) (copy[31] & Byte.MAX_VALUE);
        C2791F.decode(copy, 0, pointAffine.f6407y);
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        C2791F.sqr(pointAffine.f6407y, create);
        C2791F.mul(C_d, create, create2);
        C2791F.subOne(create);
        C2791F.addOne(create2);
        if (!C2791F.sqrtRatioVar(create, create2, pointAffine.f6406x)) {
            return false;
        }
        C2791F.normalize(pointAffine.f6406x);
        if (i2 == 1 && C2791F.isZeroVar(pointAffine.f6406x)) {
            return false;
        }
        if (i2 != (pointAffine.f6406x[0] & 1)) {
            z2 = true;
        }
        if (z ^ z2) {
            C2791F.negate(pointAffine.f6406x, pointAffine.f6406x);
        }
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 8);
    }

    private static void dom2(Digest digest, byte b, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = DOM2_PREFIX;
            int length = bArr2.length;
            int i = length + 2;
            int length2 = bArr.length + i;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            bArr3[length] = b;
            bArr3[length + 1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr3, i, bArr.length);
            digest.update(bArr3, 0, length2);
        }
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i3 + 1] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointAccum pointAccum, byte[] bArr, int i) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        C2791F.inv(pointAccum.f6405z, create2);
        C2791F.mul(pointAccum.f6403x, create2, create);
        C2791F.mul(pointAccum.f6404y, create2, create2);
        C2791F.normalize(create);
        C2791F.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        C2791F.encode(create2, bArr, i);
        int i2 = (i + 32) - 1;
        bArr[i2] = (byte) (((create[0] & 1) << 7) | bArr[i2]);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Digest createDigest = createDigest();
        byte[] bArr3 = new byte[createDigest.getDigestSize()];
        createDigest.update(bArr, i, 32);
        createDigest.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[32];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
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
        byte[] bArr = new byte[253];
        int i9 = 32 - i;
        int i10 = 0;
        int i11 = 0;
        while (i3 < 16) {
            int i12 = iArr2[i3];
            while (i2 < 16) {
                int i13 = i12 >>> i2;
                if ((i13 & 1) == i11) {
                    i2++;
                } else {
                    int i14 = (i13 | 1) << i9;
                    bArr[(i3 << 4) + i2] = (byte) (i14 >> i9);
                    i2 += i;
                    i11 = i14 >>> 31;
                }
            }
            i3++;
            i10 = i2 - 16;
        }
        return bArr;
    }

    private static void implSign(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom2(digest, b, bArr4);
        digest.update(bArr, 32, 32);
        digest.update(bArr5, i2, i3);
        digest.doFinal(bArr, 0);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom2(digest, b, bArr4);
        digest.update(bArr7, 0, 32);
        digest.update(bArr3, i, 32);
        digest.update(bArr5, i2, i3);
        digest.doFinal(bArr, 0);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 32);
        System.arraycopy(calculateS, 0, bArr6, i4 + 32, 32);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (checkContextVar(bArr2, b)) {
            Digest createDigest = createDigest();
            byte[] bArr5 = new byte[createDigest.getDigestSize()];
            byte[] bArr6 = bArr;
            int i5 = i;
            createDigest.update(bArr, i, 32);
            createDigest.doFinal(bArr5, 0);
            byte[] bArr7 = new byte[32];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[32];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createDigest, bArr5, bArr7, bArr8, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (checkContextVar(bArr3, b)) {
            Digest createDigest = createDigest();
            byte[] bArr6 = new byte[createDigest.getDigestSize()];
            byte[] bArr7 = bArr;
            int i6 = i;
            createDigest.update(bArr, i, 32);
            createDigest.doFinal(bArr6, 0);
            byte[] bArr8 = new byte[32];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createDigest, bArr6, bArr8, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        byte[] bArr5 = bArr;
        int i5 = i;
        byte[] bArr6 = bArr2;
        int i6 = i2;
        if (checkContextVar(bArr3, b)) {
            byte[] copy = copy(bArr, i, 32);
            byte[] copy2 = copy(bArr, i5 + 32, 32);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[8];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointAffine pointAffine = new PointAffine();
            if (!decodePointVar(bArr6, i6, true, pointAffine)) {
                return false;
            }
            Digest createDigest = createDigest();
            byte[] bArr7 = new byte[createDigest.getDigestSize()];
            dom2(createDigest, b, bArr3);
            createDigest.update(copy, 0, 32);
            createDigest.update(bArr6, i6, 32);
            createDigest.update(bArr4, i3, i4);
            createDigest.doFinal(bArr7, 0);
            int[] iArr2 = new int[8];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointAccum pointAccum = new PointAccum();
            scalarMultStrausVar(iArr, iArr2, pointAffine, pointAccum);
            byte[] bArr8 = new byte[32];
            return encodePoint(pointAccum, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2) {
        return C2791F.isZeroVar(iArr) && C2791F.isOneVar(iArr2);
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return C2791F.isZeroVar(iArr) && C2791F.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointAccum pointAccum) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] create4 = C2791F.create();
        int[] iArr = pointAccum.f6401u;
        int[] create5 = C2791F.create();
        int[] create6 = C2791F.create();
        int[] iArr2 = pointAccum.f6402v;
        C2791F.apm(pointAccum.f6404y, pointAccum.f6403x, create2, create);
        C2791F.apm(pointExt.f6410y, pointExt.f6409x, create4, create3);
        C2791F.mul(create, create3, create);
        C2791F.mul(create2, create4, create2);
        C2791F.mul(pointAccum.f6401u, pointAccum.f6402v, create3);
        C2791F.mul(create3, pointExt.f6408t, create3);
        C2791F.mul(create3, C_d2, create3);
        C2791F.mul(pointAccum.f6405z, pointExt.f6411z, create4);
        C2791F.add(create4, create4, create4);
        C2791F.apm(create2, create, iArr2, iArr);
        C2791F.apm(create4, create3, create6, create5);
        C2791F.carry(create6);
        C2791F.mul(iArr, create5, pointAccum.f6403x);
        C2791F.mul(create6, iArr2, pointAccum.f6404y);
        C2791F.mul(create5, create6, pointAccum.f6405z);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] create4 = C2791F.create();
        int[] create5 = C2791F.create();
        int[] create6 = C2791F.create();
        int[] create7 = C2791F.create();
        int[] create8 = C2791F.create();
        C2791F.apm(pointExt.f6410y, pointExt.f6409x, create2, create);
        C2791F.apm(pointExt2.f6410y, pointExt2.f6409x, create4, create3);
        C2791F.mul(create, create3, create);
        C2791F.mul(create2, create4, create2);
        C2791F.mul(pointExt.f6408t, pointExt2.f6408t, create3);
        C2791F.mul(create3, C_d2, create3);
        C2791F.mul(pointExt.f6411z, pointExt2.f6411z, create4);
        C2791F.add(create4, create4, create4);
        C2791F.apm(create2, create, create8, create5);
        C2791F.apm(create4, create3, create7, create6);
        C2791F.carry(create7);
        C2791F.mul(create5, create6, pointExt2.f6409x);
        C2791F.mul(create7, create8, pointExt2.f6410y);
        C2791F.mul(create6, create7, pointExt2.f6411z);
        C2791F.mul(create5, create8, pointExt2.f6408t);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointAccum pointAccum) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] iArr = pointAccum.f6401u;
        int[] create4 = C2791F.create();
        int[] create5 = C2791F.create();
        int[] iArr2 = pointAccum.f6402v;
        C2791F.apm(pointAccum.f6404y, pointAccum.f6403x, create2, create);
        C2791F.mul(create, pointPrecomp.ymx_h, create);
        C2791F.mul(create2, pointPrecomp.ypx_h, create2);
        C2791F.mul(pointAccum.f6401u, pointAccum.f6402v, create3);
        C2791F.mul(create3, pointPrecomp.xyd, create3);
        C2791F.apm(create2, create, iArr2, iArr);
        C2791F.apm(pointAccum.f6405z, create3, create5, create4);
        C2791F.carry(create5);
        C2791F.mul(iArr, create4, pointAccum.f6403x);
        C2791F.mul(create5, iArr2, pointAccum.f6404y);
        C2791F.mul(create4, create5, pointAccum.f6405z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointAccum pointAccum) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] create4 = C2791F.create();
        int[] iArr5 = pointAccum.f6401u;
        int[] create5 = C2791F.create();
        int[] create6 = C2791F.create();
        int[] iArr6 = pointAccum.f6402v;
        if (z) {
            iArr = create3;
            iArr4 = create4;
            iArr3 = create5;
            iArr2 = create6;
        } else {
            iArr4 = create3;
            iArr = create4;
            iArr2 = create5;
            iArr3 = create6;
        }
        C2791F.apm(pointAccum.f6404y, pointAccum.f6403x, create2, create);
        C2791F.apm(pointExt.f6410y, pointExt.f6409x, iArr, iArr4);
        C2791F.mul(create, create3, create);
        C2791F.mul(create2, create4, create2);
        C2791F.mul(pointAccum.f6401u, pointAccum.f6402v, create3);
        C2791F.mul(create3, pointExt.f6408t, create3);
        C2791F.mul(create3, C_d2, create3);
        C2791F.mul(pointAccum.f6405z, pointExt.f6411z, create4);
        C2791F.add(create4, create4, create4);
        C2791F.apm(create2, create, iArr6, iArr5);
        C2791F.apm(create4, create3, iArr3, iArr2);
        C2791F.carry(iArr3);
        C2791F.mul(iArr5, create5, pointAccum.f6403x);
        C2791F.mul(create6, iArr6, pointAccum.f6404y);
        C2791F.mul(create5, create6, pointAccum.f6405z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2, PointExt pointExt3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        PointExt pointExt4 = pointExt;
        PointExt pointExt5 = pointExt2;
        PointExt pointExt6 = pointExt3;
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] create4 = C2791F.create();
        int[] create5 = C2791F.create();
        int[] create6 = C2791F.create();
        int[] create7 = C2791F.create();
        int[] create8 = C2791F.create();
        if (z) {
            iArr4 = create3;
            iArr3 = create4;
            iArr2 = create6;
            iArr = create7;
        } else {
            iArr3 = create3;
            iArr4 = create4;
            iArr = create6;
            iArr2 = create7;
        }
        C2791F.apm(pointExt4.f6410y, pointExt4.f6409x, create2, create);
        C2791F.apm(pointExt5.f6410y, pointExt5.f6409x, iArr4, iArr3);
        C2791F.mul(create, create3, create);
        C2791F.mul(create2, create4, create2);
        C2791F.mul(pointExt4.f6408t, pointExt5.f6408t, create3);
        C2791F.mul(create3, C_d2, create3);
        C2791F.mul(pointExt4.f6411z, pointExt5.f6411z, create4);
        C2791F.add(create4, create4, create4);
        C2791F.apm(create2, create, create8, create5);
        C2791F.apm(create4, create3, iArr2, iArr);
        C2791F.carry(iArr2);
        C2791F.mul(create5, create6, pointExt6.f6409x);
        int[] iArr5 = create7;
        C2791F.mul(iArr5, create8, pointExt6.f6410y);
        C2791F.mul(create6, iArr5, pointExt6.f6411z);
        C2791F.mul(create5, create8, pointExt6.f6408t);
    }

    private static PointExt pointCopy(PointAccum pointAccum) {
        PointExt pointExt = new PointExt();
        C2791F.copy(pointAccum.f6403x, 0, pointExt.f6409x, 0);
        C2791F.copy(pointAccum.f6404y, 0, pointExt.f6410y, 0);
        C2791F.copy(pointAccum.f6405z, 0, pointExt.f6411z, 0);
        C2791F.mul(pointAccum.f6401u, pointAccum.f6402v, pointExt.f6408t);
        return pointExt;
    }

    private static PointExt pointCopy(PointAffine pointAffine) {
        PointExt pointExt = new PointExt();
        C2791F.copy(pointAffine.f6406x, 0, pointExt.f6409x, 0);
        C2791F.copy(pointAffine.f6407y, 0, pointExt.f6410y, 0);
        pointExtendXY(pointExt);
        return pointExt;
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointAffine pointAffine, PointAccum pointAccum) {
        C2791F.copy(pointAffine.f6406x, 0, pointAccum.f6403x, 0);
        C2791F.copy(pointAffine.f6407y, 0, pointAccum.f6404y, 0);
        pointExtendXY(pointAccum);
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        C2791F.copy(pointExt.f6409x, 0, pointExt2.f6409x, 0);
        C2791F.copy(pointExt.f6410y, 0, pointExt2.f6410y, 0);
        C2791F.copy(pointExt.f6411z, 0, pointExt2.f6411z, 0);
        C2791F.copy(pointExt.f6408t, 0, pointExt2.f6408t, 0);
    }

    private static void pointDouble(PointAccum pointAccum) {
        int[] create = C2791F.create();
        int[] create2 = C2791F.create();
        int[] create3 = C2791F.create();
        int[] iArr = pointAccum.f6401u;
        int[] create4 = C2791F.create();
        int[] create5 = C2791F.create();
        int[] iArr2 = pointAccum.f6402v;
        C2791F.sqr(pointAccum.f6403x, create);
        C2791F.sqr(pointAccum.f6404y, create2);
        C2791F.sqr(pointAccum.f6405z, create3);
        C2791F.add(create3, create3, create3);
        C2791F.apm(create, create2, iArr2, create5);
        C2791F.add(pointAccum.f6403x, pointAccum.f6404y, iArr);
        C2791F.sqr(iArr, iArr);
        C2791F.sub(iArr2, iArr, iArr);
        C2791F.add(create3, create5, create4);
        C2791F.carry(create4);
        C2791F.mul(iArr, create4, pointAccum.f6403x);
        C2791F.mul(create5, iArr2, pointAccum.f6404y);
        C2791F.mul(create4, create5, pointAccum.f6405z);
    }

    private static void pointExtendXY(PointAccum pointAccum) {
        C2791F.one(pointAccum.f6405z);
        C2791F.copy(pointAccum.f6403x, 0, pointAccum.f6401u, 0);
        C2791F.copy(pointAccum.f6404y, 0, pointAccum.f6402v, 0);
    }

    private static void pointExtendXY(PointExt pointExt) {
        C2791F.one(pointExt.f6411z);
        C2791F.mul(pointExt.f6409x, pointExt.f6410y, pointExt.f6408t);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 8 * 3 * 10;
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            C2791F.cmov(i5, precompBase, i3, pointPrecomp.ypx_h, 0);
            int i6 = i3 + 10;
            C2791F.cmov(i5, precompBase, i6, pointPrecomp.ymx_h, 0);
            int i7 = i6 + 10;
            C2791F.cmov(i5, precompBase, i7, pointPrecomp.xyd, 0);
            i3 = i7 + 10;
        }
    }

    private static void pointLookup(int[] iArr, int i, PointExt pointExt) {
        int i2 = i * 40;
        C2791F.copy(iArr, i2, pointExt.f6409x, 0);
        int i3 = i2 + 10;
        C2791F.copy(iArr, i3, pointExt.f6410y, 0);
        int i4 = i3 + 10;
        C2791F.copy(iArr, i4, pointExt.f6411z, 0);
        C2791F.copy(iArr, i4 + 10, pointExt.f6408t, 0);
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            C2791F.cmov(i6, iArr2, i4, pointExt.f6409x, 0);
            int i7 = i4 + 10;
            C2791F.cmov(i6, iArr2, i7, pointExt.f6410y, 0);
            int i8 = i7 + 10;
            C2791F.cmov(i6, iArr2, i8, pointExt.f6411z, 0);
            int i9 = i8 + 10;
            C2791F.cmov(i6, iArr2, i9, pointExt.f6408t, 0);
            i4 = i9 + 10;
        }
        C2791F.cnegate(i2, pointExt.f6409x);
        C2791F.cnegate(i2, pointExt.f6408t);
    }

    private static int[] pointPrecompute(PointAffine pointAffine, int i) {
        PointExt pointCopy = pointCopy(pointAffine);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointAdd(pointCopy, pointCopy2);
        int[] createTable = C2791F.createTable(i * 4);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            C2791F.copy(pointCopy.f6409x, 0, createTable, i2);
            int i4 = i2 + 10;
            C2791F.copy(pointCopy.f6410y, 0, createTable, i4);
            int i5 = i4 + 10;
            C2791F.copy(pointCopy.f6411z, 0, createTable, i5);
            int i6 = i5 + 10;
            C2791F.copy(pointCopy.f6408t, 0, createTable, i6);
            i2 = i6 + 10;
            i3++;
            if (i3 == i) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointExt2 = new PointExt();
        pointAddVar(false, pointExt, pointExt, pointExt2);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointExt3 = pointExtArr[i2 - 1];
            PointExt pointExt4 = new PointExt();
            pointExtArr[i2] = pointExt4;
            pointAddVar(false, pointExt3, pointExt2, pointExt4);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointAccum pointAccum) {
        C2791F.zero(pointAccum.f6403x);
        C2791F.one(pointAccum.f6404y);
        C2791F.one(pointAccum.f6405z);
        C2791F.zero(pointAccum.f6401u);
        C2791F.one(pointAccum.f6402v);
    }

    private static void pointSetNeutral(PointExt pointExt) {
        C2791F.zero(pointExt.f6409x);
        C2791F.one(pointExt.f6410y);
        C2791F.one(pointExt.f6411z);
        C2791F.zero(pointExt.f6408t);
    }

    public static void precompute() {
        int i;
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                C2791F.copy(B_x, 0, pointExt.f6409x, 0);
                C2791F.copy(B_y, 0, pointExt.f6410y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                PointAccum pointAccum = new PointAccum();
                C2791F.copy(B_x, 0, pointAccum.f6403x, 0);
                C2791F.copy(B_y, 0, pointAccum.f6404y, 0);
                pointExtendXY(pointAccum);
                precompBase = C2791F.createTable(192);
                int i2 = 0;
                for (int i3 = 0; i3 < 8; i3++) {
                    PointExt[] pointExtArr = new PointExt[4];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i4 = 0;
                    while (true) {
                        i = 1;
                        if (i4 >= 4) {
                            break;
                        }
                        pointAddVar(true, pointExt2, pointCopy(pointAccum), pointExt2);
                        pointDouble(pointAccum);
                        pointExtArr[i4] = pointCopy(pointAccum);
                        if (i3 + i4 != 10) {
                            while (i < 8) {
                                pointDouble(pointAccum);
                                i++;
                            }
                        }
                        i4++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[8];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 0;
                    int i6 = 1;
                    while (i5 < 3) {
                        int i7 = i << i5;
                        int i8 = 0;
                        while (i8 < i7) {
                            PointExt pointExt3 = pointExtArr2[i6 - i7];
                            PointExt pointExt4 = pointExtArr[i5];
                            PointExt pointExt5 = new PointExt();
                            pointExtArr2[i6] = pointExt5;
                            pointAddVar(false, pointExt3, pointExt4, pointExt5);
                            i8++;
                            i6++;
                        }
                        i5++;
                        i = 1;
                    }
                    int[] createTable = C2791F.createTable(8);
                    int[] create = C2791F.create();
                    C2791F.copy(pointExtArr2[0].f6411z, 0, create, 0);
                    C2791F.copy(create, 0, createTable, 0);
                    int i9 = 0;
                    while (true) {
                        i9++;
                        if (i9 >= 8) {
                            break;
                        }
                        C2791F.mul(create, pointExtArr2[i9].f6411z, create);
                        C2791F.copy(create, 0, createTable, i9 * 10);
                    }
                    C2791F.add(create, create, create);
                    C2791F.invVar(create, create);
                    int i10 = i9 - 1;
                    int[] create2 = C2791F.create();
                    while (i10 > 0) {
                        int i11 = i10 - 1;
                        C2791F.copy(createTable, i11 * 10, create2, 0);
                        C2791F.mul(create2, create, create2);
                        C2791F.copy(create2, 0, createTable, i10 * 10);
                        C2791F.mul(create, pointExtArr2[i10].f6411z, create);
                        i10 = i11;
                    }
                    C2791F.copy(create, 0, createTable, 0);
                    for (int i12 = 0; i12 < 8; i12++) {
                        PointExt pointExt6 = pointExtArr2[i12];
                        int[] create3 = C2791F.create();
                        int[] create4 = C2791F.create();
                        C2791F.copy(createTable, i12 * 10, create4, 0);
                        C2791F.mul(pointExt6.f6409x, create4, create3);
                        C2791F.mul(pointExt6.f6410y, create4, create4);
                        PointPrecomp pointPrecomp = new PointPrecomp();
                        C2791F.apm(create4, create3, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                        C2791F.mul(create3, create4, pointPrecomp.xyd);
                        C2791F.mul(pointPrecomp.xyd, C_d4, pointPrecomp.xyd);
                        C2791F.normalize(pointPrecomp.ypx_h);
                        C2791F.normalize(pointPrecomp.ymx_h);
                        C2791F.copy(pointPrecomp.ypx_h, 0, precompBase, i2);
                        int i13 = i2 + 10;
                        C2791F.copy(pointPrecomp.ymx_h, 0, precompBase, i13);
                        int i14 = i13 + 10;
                        C2791F.copy(pointPrecomp.xyd, 0, precompBase, i14);
                        i2 = i14 + 10;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        bArr2[31] = (byte) (bArr2[31] & Byte.MAX_VALUE);
        bArr2[31] = (byte) (bArr2[31] | 64);
    }

    private static byte[] reduceScalar(byte[] bArr) {
        byte[] bArr2 = bArr;
        long decode24 = ((long) (decode24(bArr2, 4) << 4)) & 4294967295L;
        long decode32 = ((long) decode32(bArr2, 7)) & 4294967295L;
        long decode242 = ((long) (decode24(bArr2, 11) << 4)) & 4294967295L;
        long decode322 = ((long) decode32(bArr2, 14)) & 4294967295L;
        long decode243 = ((long) (decode24(bArr2, 18) << 4)) & 4294967295L;
        long decode323 = ((long) decode32(bArr2, 21)) & 4294967295L;
        long decode244 = ((long) (decode24(bArr2, 25) << 4)) & 4294967295L;
        long decode324 = ((long) decode32(bArr2, 28)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode245 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 56)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 60) << 4)) & 4294967295L;
        long j = ((long) bArr2[63]) & M08L;
        long decode247 = (((long) (decode24(bArr2, 46) << 4)) & 4294967295L) - (j * 5343);
        long j2 = decode246 + (decode326 >> 28);
        long j3 = decode326 & M28L;
        long j4 = decode324 - (j2 * -50998291);
        long decode248 = ((((long) (decode24(bArr2, 32) << 4)) & 4294967295L) - (j * -50998291)) - (j2 * 19280294);
        long decode327 = ((((long) decode32(bArr2, 35)) & 4294967295L) - (j * 19280294)) - (j2 * 127719000);
        long decode328 = ((((long) decode32(bArr2, 42)) & 4294967295L) - (j * -6428113)) - (j2 * 5343);
        long j5 = decode244 - (j3 * -50998291);
        long decode249 = (((((long) (decode24(bArr2, 39) << 4)) & 4294967295L) - (j * 127719000)) - (j2 * -6428113)) - (j3 * 5343);
        long j6 = decode245 + (decode325 >> 28);
        long j7 = decode325 & M28L;
        long j8 = (decode327 - (j3 * -6428113)) - (j6 * 5343);
        long j9 = ((decode248 - (j3 * 127719000)) - (j6 * -6428113)) - (j7 * 5343);
        long j10 = decode247 + (decode328 >> 28);
        long j11 = (decode328 & M28L) + (decode249 >> 28);
        long j12 = decode242 - (j11 * -50998291);
        long j13 = (decode322 - (j10 * -50998291)) - (j11 * 19280294);
        long j14 = ((decode243 - (j7 * -50998291)) - (j10 * 19280294)) - (j11 * 127719000);
        long j15 = (((j5 - (j6 * 19280294)) - (j7 * 127719000)) - (j10 * -6428113)) - (j11 * 5343);
        long j16 = (decode249 & M28L) + (j8 >> 28);
        long j17 = j8 & M28L;
        long j18 = decode32 - (j16 * -50998291);
        long j19 = j12 - (j16 * 19280294);
        long j20 = j13 - (j16 * 127719000);
        long j21 = ((((decode323 - (j6 * -50998291)) - (j7 * 19280294)) - (j10 * 127719000)) - (j11 * -6428113)) - (j16 * 5343);
        long j22 = j17 + (j9 >> 28);
        long j23 = j9 & M28L;
        long j24 = j18 - (j22 * 19280294);
        long j25 = j19 - (j22 * 127719000);
        long j26 = j20 - (j22 * -6428113);
        long j27 = (j14 - (j16 * -6428113)) - (j22 * 5343);
        long j28 = ((((j4 - (j3 * 19280294)) - (j6 * 127719000)) - (j7 * -6428113)) - (j10 * 5343)) + (j15 >> 28);
        long j29 = j15 & M28L;
        long j30 = j28 & M28L;
        long j31 = j30 >>> 27;
        long j32 = j23 + (j28 >> 28) + j31;
        long decode329 = (((long) decode32(bArr2, 0)) & 4294967295L) - (j32 * -50998291);
        long j33 = ((decode24 - (j22 * -50998291)) - (j32 * 19280294)) + (decode329 >> 28);
        long j34 = decode329 & M28L;
        long j35 = (j24 - (j32 * 127719000)) + (j33 >> 28);
        long j36 = j33 & M28L;
        long j37 = (j25 - (j32 * -6428113)) + (j35 >> 28);
        long j38 = j35 & M28L;
        long j39 = (j26 - (j32 * 5343)) + (j37 >> 28);
        long j40 = j37 & M28L;
        long j41 = j27 + (j39 >> 28);
        long j42 = j39 & M28L;
        long j43 = j21 + (j41 >> 28);
        long j44 = j41 & M28L;
        long j45 = j29 + (j43 >> 28);
        long j46 = j43 & M28L;
        long j47 = j30 + (j45 >> 28);
        long j48 = j45 & M28L;
        long j49 = j47 >> 28;
        long j50 = j47 & M28L;
        long j51 = j49 - j31;
        long j52 = j34 + (j51 & -50998291);
        long j53 = j36 + (j51 & 19280294) + (j52 >> 28);
        long j54 = j52 & M28L;
        long j55 = j38 + (j51 & 127719000) + (j53 >> 28);
        long j56 = j53 & M28L;
        long j57 = j40 + (j51 & -6428113) + (j55 >> 28);
        long j58 = j55 & M28L;
        long j59 = j42 + (j51 & 5343) + (j57 >> 28);
        long j60 = j57 & M28L;
        long j61 = j44 + (j59 >> 28);
        long j62 = j59 & M28L;
        long j63 = j46 + (j61 >> 28);
        long j64 = j61 & M28L;
        long j65 = j48 + (j63 >> 28);
        long j66 = j63 & M28L;
        long j67 = j65 & M28L;
        byte[] bArr3 = new byte[32];
        encode56(j54 | (j56 << 28), bArr3, 0);
        encode56((j60 << 28) | j58, bArr3, 7);
        encode56(j62 | (j64 << 28), bArr3, 14);
        encode56(j66 | (j67 << 28), bArr3, 21);
        encode32((int) (j50 + (j65 >> 28)), bArr3, 28);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointAffine pointAffine, PointAccum pointAccum) {
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(8, iArr, 3, 1);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, f6394L, iArr);
        Nat.shiftDownBit(8, iArr, 0);
        int[] pointPrecompute = pointPrecompute(pointAffine, 8);
        PointExt pointExt = new PointExt();
        pointCopy(pointAffine, pointAccum);
        pointLookup(pointPrecompute, 7, pointExt);
        pointAdd(pointExt, pointAccum);
        int i = 62;
        while (true) {
            pointLookup(iArr, i, pointPrecompute, pointExt);
            pointAdd(pointExt, pointAccum);
            pointDouble(pointAccum);
            pointDouble(pointAccum);
            pointDouble(pointAccum);
            i--;
            if (i >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointAccum pointAccum) {
        precompute();
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, f6394L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
        for (int i = 0; i < 8; i++) {
            iArr[i] = Interleave.shuffle2(iArr[i]);
        }
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointAccum);
        int i2 = 28;
        while (true) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = iArr[i3] >>> i2;
                int i5 = (i4 >>> 3) & 1;
                pointLookup(i3, (i4 ^ (-i5)) & 7, pointPrecomp);
                C2791F.cswap(i5, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                C2791F.cnegate(i5, pointPrecomp.xyd);
                pointAddPrecomp(pointPrecomp, pointAccum);
            }
            i2 -= 4;
            if (i2 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr, pointAccum);
        if (encodePoint(pointAccum, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseYZ(X25519.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend != null) {
            byte[] bArr2 = new byte[32];
            pruneScalar(bArr, i, bArr2);
            PointAccum pointAccum = new PointAccum();
            scalarMultBase(bArr2, pointAccum);
            if (checkPoint(pointAccum.f6403x, pointAccum.f6404y, pointAccum.f6405z) != 0) {
                C2791F.copy(pointAccum.f6404y, 0, iArr, 0);
                C2791F.copy(pointAccum.f6405z, 0, iArr2, 0);
                return;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("This method is only for use by X25519");
    }

    private static void scalarMultOrderVar(PointAffine pointAffine, PointAccum pointAccum) {
        byte[] wnafVar = getWnafVar(f6394L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i = 252;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                boolean z = true;
                int i3 = (b ^ i2) >>> 1;
                if (i2 == 0) {
                    z = false;
                }
                pointAddVar(z, pointPrecomputeVar[i3], pointAccum);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointAffine pointAffine, PointAccum pointAccum) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i = 252;
        while (true) {
            byte b = wnafVar[i];
            boolean z = false;
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointAccum);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.f53596US;
                int i4 = (b2 ^ i3) >>> 1;
                if (i3 != 0) {
                    z = true;
                }
                pointAddVar(z, pointPrecomputeVar[i4], pointAccum);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        implSign(bArr, i, (byte[]) null, (byte) 0, bArr2, i2, i3, bArr3, i4);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        implSign(bArr, i, bArr2, i2, (byte[]) null, (byte) 0, bArr3, i3, i4, bArr4, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Digest digest, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 == digest.doFinal(bArr5, 0)) {
            implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Digest digest, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArr, i, false, pointAffine)) {
            return false;
        }
        C2791F.normalize(pointAffine.f6406x);
        C2791F.normalize(pointAffine.f6407y);
        if (isNeutralElementVar(pointAffine.f6406x, pointAffine.f6407y)) {
            return false;
        }
        PointAccum pointAccum = new PointAccum();
        scalarMultOrderVar(pointAffine, pointAccum);
        C2791F.normalize(pointAccum.f6403x);
        C2791F.normalize(pointAccum.f6404y);
        C2791F.normalize(pointAccum.f6405z);
        return isNeutralElementVar(pointAccum.f6403x, pointAccum.f6404y, pointAccum.f6405z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        return decodePointVar(bArr, i, false, new PointAffine());
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, (byte[]) null, (byte) 0, bArr3, i3, i4);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Digest digest) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}

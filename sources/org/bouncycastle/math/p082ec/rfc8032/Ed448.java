package org.bouncycastle.math.p082ec.rfc8032;

import com.didi.soda.customer.C13565R2;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.p082ec.rfc7748.X448;
import org.bouncycastle.math.p082ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

/* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448 */
public abstract class Ed448 {
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final int COORD_INTS = 14;
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};

    /* renamed from: L */
    private static final int[] f6412L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;

    /* renamed from: P */
    private static final int[] f6413P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$Algorithm */
    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$F */
    private static class C2793F extends X448Field {
        private C2793F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PointExt */
    private static class PointExt {

        /* renamed from: x */
        int[] f6414x;

        /* renamed from: y */
        int[] f6415y;

        /* renamed from: z */
        int[] f6416z;

        private PointExt() {
            this.f6414x = C2793F.create();
            this.f6415y = C2793F.create();
            this.f6416z = C2793F.create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PointPrecomp */
    private static class PointPrecomp {

        /* renamed from: x */
        int[] f6417x;

        /* renamed from: y */
        int[] f6418y;

        private PointPrecomp() {
            this.f6417x = C2793F.create();
            this.f6418y = C2793F.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        C2793F.sqr(iArr, create2);
        C2793F.sqr(iArr2, create3);
        C2793F.mul(create2, create3, create);
        C2793F.add(create2, create3, create2);
        C2793F.mul(create, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create);
        C2793F.subOne(create);
        C2793F.add(create, create2, create);
        C2793F.normalize(create);
        return C2793F.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        int[] create4 = C2793F.create();
        C2793F.sqr(iArr, create2);
        C2793F.sqr(iArr2, create3);
        C2793F.sqr(iArr3, create4);
        C2793F.mul(create2, create3, create);
        C2793F.add(create2, create3, create2);
        C2793F.mul(create2, create4, create2);
        C2793F.sqr(create4, create4);
        C2793F.mul(create, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create);
        C2793F.sub(create, create4, create);
        C2793F.add(create, create2, create);
        C2793F.normalize(create);
        return C2793F.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, f6413P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, f6412L);
    }

    private static byte[] copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
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

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] copy = copy(bArr, i, 57);
        boolean z2 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        int i2 = (copy[56] & 128) >>> 7;
        copy[56] = (byte) (copy[56] & Byte.MAX_VALUE);
        C2793F.decode(copy, 0, pointExt.f6415y);
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        C2793F.sqr(pointExt.f6415y, create);
        C2793F.mul(create, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create2);
        C2793F.negate(create, create);
        C2793F.addOne(create);
        C2793F.addOne(create2);
        if (!C2793F.sqrtRatioVar(create, create2, pointExt.f6414x)) {
            return false;
        }
        C2793F.normalize(pointExt.f6414x);
        if (i2 == 1 && C2793F.isZeroVar(pointExt.f6414x)) {
            return false;
        }
        if (i2 != (pointExt.f6414x[0] & 1)) {
            z2 = true;
        }
        if (z ^ z2) {
            C2793F.negate(pointExt.f6414x, pointExt.f6414x);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        xof.update(bArr3, 0, length2);
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

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        C2793F.inv(pointExt.f6416z, create2);
        C2793F.mul(pointExt.f6414x, create2, create);
        C2793F.mul(pointExt.f6415y, create2, create2);
        C2793F.normalize(create);
        C2793F.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        C2793F.encode(create2, bArr, i);
        bArr[(i + 57) - 1] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
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
        byte[] bArr = new byte[447];
        int i9 = 32 - i;
        int i10 = 0;
        int i11 = 0;
        while (i3 < 28) {
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

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(calculateS, 0, bArr6, i4 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (checkContextVar(bArr2)) {
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            byte[] bArr6 = bArr;
            int i5 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr5, 0, 114);
            byte[] bArr7 = new byte[57];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[57];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createXof, bArr5, bArr7, bArr8, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (checkContextVar(bArr3)) {
            Xof createXof = createXof();
            byte[] bArr6 = new byte[114];
            byte[] bArr7 = bArr;
            int i6 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr6, 0, 114);
            byte[] bArr8 = new byte[57];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createXof, bArr6, bArr8, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        byte[] bArr5 = bArr;
        int i5 = i;
        byte[] bArr6 = bArr2;
        int i6 = i2;
        if (checkContextVar(bArr3)) {
            byte[] copy = copy(bArr, i5, 57);
            byte[] copy2 = copy(bArr, i5 + 57, 57);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[14];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointExt pointExt = new PointExt();
            if (!decodePointVar(bArr6, i6, true, pointExt)) {
                return false;
            }
            Xof createXof = createXof();
            byte[] bArr7 = new byte[114];
            dom4(createXof, b, bArr3);
            createXof.update(copy, 0, 57);
            createXof.update(bArr6, i6, 57);
            createXof.update(bArr4, i3, i4);
            createXof.doFinal(bArr7, 0, 114);
            int[] iArr2 = new int[14];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointExt pointExt2 = new PointExt();
            scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
            byte[] bArr8 = new byte[57];
            return encodePoint(pointExt2, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return C2793F.isZeroVar(iArr) && C2793F.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        int[] create4 = C2793F.create();
        int[] create5 = C2793F.create();
        int[] create6 = C2793F.create();
        int[] create7 = C2793F.create();
        int[] create8 = C2793F.create();
        C2793F.mul(pointExt.f6416z, pointExt2.f6416z, create);
        C2793F.sqr(create, create2);
        C2793F.mul(pointExt.f6414x, pointExt2.f6414x, create3);
        C2793F.mul(pointExt.f6415y, pointExt2.f6415y, create4);
        C2793F.mul(create3, create4, create5);
        C2793F.mul(create5, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create5);
        C2793F.add(create2, create5, create6);
        C2793F.sub(create2, create5, create7);
        C2793F.add(pointExt.f6414x, pointExt.f6415y, create2);
        C2793F.add(pointExt2.f6414x, pointExt2.f6415y, create5);
        C2793F.mul(create2, create5, create8);
        C2793F.add(create4, create3, create2);
        C2793F.sub(create4, create3, create5);
        C2793F.carry(create2);
        C2793F.sub(create8, create2, create8);
        C2793F.mul(create8, create, create8);
        C2793F.mul(create5, create, create5);
        C2793F.mul(create6, create8, pointExt2.f6414x);
        C2793F.mul(create5, create7, pointExt2.f6415y);
        C2793F.mul(create6, create7, pointExt2.f6416z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        int[] create4 = C2793F.create();
        int[] create5 = C2793F.create();
        int[] create6 = C2793F.create();
        int[] create7 = C2793F.create();
        C2793F.sqr(pointExt.f6416z, create);
        C2793F.mul(pointPrecomp.f6417x, pointExt.f6414x, create2);
        C2793F.mul(pointPrecomp.f6418y, pointExt.f6415y, create3);
        C2793F.mul(create2, create3, create4);
        C2793F.mul(create4, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create4);
        C2793F.add(create, create4, create5);
        C2793F.sub(create, create4, create6);
        C2793F.add(pointPrecomp.f6417x, pointPrecomp.f6418y, create);
        C2793F.add(pointExt.f6414x, pointExt.f6415y, create4);
        C2793F.mul(create, create4, create7);
        C2793F.add(create3, create2, create);
        C2793F.sub(create3, create2, create4);
        C2793F.carry(create);
        C2793F.sub(create7, create, create7);
        C2793F.mul(create7, pointExt.f6416z, create7);
        C2793F.mul(create4, pointExt.f6416z, create4);
        C2793F.mul(create5, create7, pointExt.f6414x);
        C2793F.mul(create4, create6, pointExt.f6415y);
        C2793F.mul(create5, create6, pointExt.f6416z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        int[] create4 = C2793F.create();
        int[] create5 = C2793F.create();
        int[] create6 = C2793F.create();
        int[] create7 = C2793F.create();
        int[] create8 = C2793F.create();
        if (z) {
            C2793F.sub(pointExt.f6415y, pointExt.f6414x, create8);
            iArr2 = create2;
            iArr3 = create5;
            iArr4 = create6;
            iArr = create7;
        } else {
            C2793F.add(pointExt.f6415y, pointExt.f6414x, create8);
            iArr3 = create2;
            iArr2 = create5;
            iArr = create6;
            iArr4 = create7;
        }
        C2793F.mul(pointExt.f6416z, pointExt2.f6416z, create);
        C2793F.sqr(create, create2);
        C2793F.mul(pointExt.f6414x, pointExt2.f6414x, create3);
        C2793F.mul(pointExt.f6415y, pointExt2.f6415y, create4);
        C2793F.mul(create3, create4, create5);
        C2793F.mul(create5, (int) C13565R2.styleable.RUILoopView_rui_lp_lineSpace, create5);
        C2793F.add(create2, create5, iArr);
        C2793F.sub(create2, create5, iArr4);
        C2793F.add(pointExt2.f6414x, pointExt2.f6415y, create5);
        C2793F.mul(create8, create5, create8);
        C2793F.add(create4, create3, iArr3);
        C2793F.sub(create4, create3, iArr2);
        C2793F.carry(iArr3);
        C2793F.sub(create8, create2, create8);
        C2793F.mul(create8, create, create8);
        C2793F.mul(create5, create, create5);
        C2793F.mul(create6, create8, pointExt2.f6414x);
        C2793F.mul(create5, create7, pointExt2.f6415y);
        C2793F.mul(create6, create7, pointExt2.f6416z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        C2793F.copy(pointExt.f6414x, 0, pointExt2.f6414x, 0);
        C2793F.copy(pointExt.f6415y, 0, pointExt2.f6415y, 0);
        C2793F.copy(pointExt.f6416z, 0, pointExt2.f6416z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = C2793F.create();
        int[] create2 = C2793F.create();
        int[] create3 = C2793F.create();
        int[] create4 = C2793F.create();
        int[] create5 = C2793F.create();
        int[] create6 = C2793F.create();
        C2793F.add(pointExt.f6414x, pointExt.f6415y, create);
        C2793F.sqr(create, create);
        C2793F.sqr(pointExt.f6414x, create2);
        C2793F.sqr(pointExt.f6415y, create3);
        C2793F.add(create2, create3, create4);
        C2793F.carry(create4);
        C2793F.sqr(pointExt.f6416z, create5);
        C2793F.add(create5, create5, create5);
        C2793F.carry(create5);
        C2793F.sub(create4, create5, create6);
        C2793F.sub(create, create4, create);
        C2793F.sub(create2, create3, create2);
        C2793F.mul(create, create6, pointExt.f6414x);
        C2793F.mul(create4, create2, pointExt.f6415y);
        C2793F.mul(create4, create6, pointExt.f6416z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        C2793F.one(pointExt.f6416z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 16 * 2 * 16;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            C2793F.cmov(i5, precompBase, i3, pointPrecomp.f6417x, 0);
            int i6 = i3 + 16;
            C2793F.cmov(i5, precompBase, i6, pointPrecomp.f6418y, 0);
            i3 = i6 + 16;
        }
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            C2793F.cmov(i6, iArr2, i4, pointExt.f6414x, 0);
            int i7 = i4 + 16;
            C2793F.cmov(i6, iArr2, i7, pointExt.f6415y, 0);
            int i8 = i7 + 16;
            C2793F.cmov(i6, iArr2, i8, pointExt.f6416z, 0);
            i4 = i8 + 16;
        }
        C2793F.cnegate(i2, pointExt.f6414x);
    }

    private static int[] pointPrecompute(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = C2793F.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            C2793F.copy(pointCopy.f6414x, 0, createTable, i2);
            int i4 = i2 + 16;
            C2793F.copy(pointCopy.f6415y, 0, createTable, i4);
            int i5 = i4 + 16;
            C2793F.copy(pointCopy.f6416z, 0, createTable, i5);
            i2 = i5 + 16;
            i3++;
            if (i3 == i) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            pointExtArr[i2] = pointCopy(pointExtArr[i2 - 1]);
            pointAddVar(false, pointCopy, pointExtArr[i2]);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        C2793F.zero(pointExt.f6414x);
        C2793F.one(pointExt.f6415y);
        C2793F.one(pointExt.f6416z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                C2793F.copy(B_x, 0, pointExt.f6414x, 0);
                C2793F.copy(B_y, 0, pointExt.f6415y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = C2793F.createTable(160);
                int i = 0;
                for (int i2 = 0; i2 < 5; i2++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i3] = pointCopy(pointExt);
                        if (i2 + i3 != 8) {
                            for (int i4 = 1; i4 < 18; i4++) {
                                pointDouble(pointExt);
                            }
                        }
                        i3++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            pointExtArr2[i5] = pointCopy(pointExtArr2[i5 - i7]);
                            pointAddVar(false, pointExtArr[i6], pointExtArr2[i5]);
                            i8++;
                            i5++;
                        }
                    }
                    int[] createTable = C2793F.createTable(16);
                    int[] create = C2793F.create();
                    C2793F.copy(pointExtArr2[0].f6416z, 0, create, 0);
                    C2793F.copy(create, 0, createTable, 0);
                    int i9 = 0;
                    while (true) {
                        i9++;
                        if (i9 >= 16) {
                            break;
                        }
                        C2793F.mul(create, pointExtArr2[i9].f6416z, create);
                        C2793F.copy(create, 0, createTable, i9 * 16);
                    }
                    C2793F.invVar(create, create);
                    int i10 = i9 - 1;
                    int[] create2 = C2793F.create();
                    while (i10 > 0) {
                        int i11 = i10 - 1;
                        C2793F.copy(createTable, i11 * 16, create2, 0);
                        C2793F.mul(create2, create, create2);
                        C2793F.copy(create2, 0, createTable, i10 * 16);
                        C2793F.mul(create, pointExtArr2[i10].f6416z, create);
                        i10 = i11;
                    }
                    C2793F.copy(create, 0, createTable, 0);
                    for (int i12 = 0; i12 < 16; i12++) {
                        PointExt pointExt3 = pointExtArr2[i12];
                        C2793F.copy(createTable, i12 * 16, pointExt3.f6416z, 0);
                        C2793F.mul(pointExt3.f6414x, pointExt3.f6416z, pointExt3.f6414x);
                        C2793F.mul(pointExt3.f6415y, pointExt3.f6416z, pointExt3.f6415y);
                        C2793F.copy(pointExt3.f6414x, 0, precompBase, i);
                        int i13 = i + 16;
                        C2793F.copy(pointExt3.f6415y, 0, precompBase, i13);
                        i = i13 + 16;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
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
        long decode245 = ((long) (decode24(bArr2, 32) << 4)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 35)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 39) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 42)) & 4294967295L;
        long decode247 = ((long) (decode24(bArr2, 46) << 4)) & 4294967295L;
        long decode327 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode248 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode249 = ((long) (decode24(bArr2, 74) << 4)) & 4294967295L;
        long decode328 = ((long) decode32(bArr2, 77)) & 4294967295L;
        long decode2410 = ((long) (decode24(bArr2, 81) << 4)) & 4294967295L;
        long decode329 = ((long) decode32(bArr2, 84)) & 4294967295L;
        long decode2411 = ((long) (decode24(bArr2, 88) << 4)) & 4294967295L;
        long decode3210 = ((long) decode32(bArr2, 91)) & 4294967295L;
        long decode2412 = ((long) (decode24(bArr2, 95) << 4)) & 4294967295L;
        long decode3211 = ((long) decode32(bArr2, 98)) & 4294967295L;
        long decode2413 = ((long) (decode24(bArr2, 102) << 4)) & 4294967295L;
        long decode3212 = ((long) decode32(bArr2, 105)) & 4294967295L;
        long decode2414 = ((long) (decode24(bArr2, 109) << 4)) & 4294967295L;
        long decode16 = ((long) decode16(bArr2, 112)) & 4294967295L;
        long j = decode2410 + (decode16 * 550336261);
        long j2 = decode2414 + (decode3212 >>> 28);
        long j3 = decode3212 & M28L;
        long decode3213 = (((long) decode32(bArr2, 56)) & 4294967295L) + (decode16 * 43969588) + (j2 * 30366549);
        long decode2415 = (((long) (decode24(bArr2, 60) << 4)) & 4294967295L) + (decode16 * 30366549) + (j2 * 163752818);
        long decode3214 = (((long) decode32(bArr2, 63)) & 4294967295L) + (decode16 * 163752818) + (j2 * 258169998);
        long decode2416 = (((long) (decode24(bArr2, 67) << 4)) & 4294967295L) + (decode16 * 258169998) + (j2 * 96434764);
        long j4 = decode328 + (decode16 * 149865618) + (j2 * 550336261);
        long j5 = decode2413 + (decode3211 >>> 28);
        long j6 = decode3211 & M28L;
        long decode3215 = (((long) decode32(bArr2, 70)) & 4294967295L) + (decode16 * 96434764) + (j2 * 227822194) + (j3 * 149865618) + (j5 * 550336261);
        long j7 = decode2412 + (decode3210 >>> 28);
        long j8 = decode3210 & M28L;
        long j9 = decode3214 + (j3 * 96434764) + (j5 * 227822194) + (j6 * 149865618) + (j7 * 550336261);
        long j10 = decode2415 + (j3 * 258169998) + (j5 * 96434764) + (j6 * 227822194) + (j7 * 149865618) + (j8 * 550336261);
        long j11 = decode2411 + (decode329 >>> 28);
        long j12 = decode329 & M28L;
        long j13 = decode249 + (decode16 * 227822194) + (j2 * 149865618) + (j3 * 550336261) + (decode3215 >>> 28);
        long j14 = decode3215 & M28L;
        long j15 = j4 + (j13 >>> 28);
        long j16 = j13 & M28L;
        long j17 = j + (j15 >>> 28);
        long j18 = j15 & M28L;
        long j19 = j12 + (j17 >>> 28);
        long j20 = j17 & M28L;
        long j21 = decode244 + (j20 * 43969588);
        long j22 = decode324 + (j19 * 43969588) + (j20 * 30366549);
        long j23 = decode245 + (j11 * 43969588) + (j19 * 30366549) + (j20 * 163752818);
        long j24 = decode325 + (j8 * 43969588) + (j11 * 30366549) + (j19 * 163752818) + (j20 * 258169998);
        long j25 = decode246 + (j7 * 43969588) + (j8 * 30366549) + (j11 * 163752818) + (j19 * 258169998) + (j20 * 96434764);
        long j26 = decode326 + (j6 * 43969588) + (j7 * 30366549) + (j8 * 163752818) + (j11 * 258169998) + (j19 * 96434764) + (j20 * 227822194);
        long j27 = decode327 + (j3 * 43969588) + (j5 * 30366549) + (j6 * 163752818) + (j7 * 258169998) + (j8 * 96434764) + (j11 * 227822194) + (j19 * 149865618) + (j20 * 550336261);
        long j28 = j9 + (j10 >>> 28);
        long j29 = j10 & M28L;
        long j30 = decode2416 + (j3 * 227822194) + (j5 * 149865618) + (j6 * 550336261) + (j28 >>> 28);
        long j31 = j28 & M28L;
        long j32 = j14 + (j30 >>> 28);
        long j33 = j30 & M28L;
        long j34 = j16 + (j32 >>> 28);
        long j35 = j32 & M28L;
        long j36 = decode322 + (j35 * 43969588);
        long j37 = decode243 + (j34 * 43969588) + (j35 * 30366549);
        long j38 = decode323 + (j18 * 43969588) + (j34 * 30366549) + (j35 * 163752818);
        long j39 = j21 + (j18 * 30366549) + (j34 * 163752818) + (j35 * 258169998);
        long j40 = j22 + (j18 * 163752818) + (j34 * 258169998) + (j35 * 96434764);
        long j41 = j23 + (j18 * 258169998) + (j34 * 96434764) + (j35 * 227822194);
        long j42 = j25 + (j18 * 227822194) + (j34 * 149865618) + (j35 * 550336261);
        long j43 = decode242 + (j33 * 43969588);
        long j44 = j36 + (j33 * 30366549);
        long j45 = j37 + (j33 * 163752818);
        long j46 = j38 + (j33 * 258169998);
        long j47 = j39 + (j33 * 96434764);
        long j48 = j40 + (j33 * 227822194);
        long j49 = j41 + (j33 * 149865618);
        long j50 = j24 + (j18 * 96434764) + (j34 * 227822194) + (j35 * 149865618) + (j33 * 550336261);
        long j51 = decode248 + (j2 * 43969588) + (j3 * 30366549) + (j5 * 163752818) + (j6 * 258169998) + (j7 * 96434764) + (j8 * 227822194) + (j11 * 149865618) + (j19 * 550336261) + (j27 >>> 28);
        long j52 = j27 & M28L;
        long j53 = decode3213 + (j3 * 163752818) + (j5 * 258169998) + (j6 * 96434764) + (j7 * 227822194) + (j8 * 149865618) + (j11 * 550336261) + (j51 >>> 28);
        long j54 = j51 & M28L;
        long j55 = j29 + (j53 >>> 28);
        long j56 = j53 & M28L;
        long j57 = j31 + (j55 >>> 28);
        long j58 = j55 & M28L;
        long j59 = decode32 + (j57 * 43969588);
        long j60 = j43 + (j57 * 30366549);
        long j61 = j44 + (j57 * 163752818);
        long j62 = j45 + (j57 * 258169998);
        long j63 = j46 + (j57 * 96434764);
        long j64 = j47 + (j57 * 227822194);
        long j65 = j49 + (j57 * 550336261);
        long j66 = j54 & M26L;
        long j67 = (j56 * 4) + (j54 >>> 26) + 1;
        long decode3216 = (((long) decode32(bArr2, 0)) & 4294967295L) + (78101261 * j67);
        long j68 = j59 + (30366549 * j58) + (175155932 * j67);
        long j69 = j60 + (163752818 * j58) + (64542499 * j67);
        long j70 = j61 + (258169998 * j58) + (158326419 * j67);
        long j71 = j62 + (96434764 * j58) + (191173276 * j67);
        long j72 = j64 + (149865618 * j58) + (j67 * 137584065);
        long j73 = decode24 + (43969588 * j58) + (141809365 * j67) + (decode3216 >>> 28);
        long j74 = decode3216 & M28L;
        long j75 = j68 + (j73 >>> 28);
        long j76 = j73 & M28L;
        long j77 = j69 + (j75 >>> 28);
        long j78 = j75 & M28L;
        long j79 = j70 + (j77 >>> 28);
        long j80 = j77 & M28L;
        long j81 = j71 + (j79 >>> 28);
        long j82 = j79 & M28L;
        long j83 = j63 + (227822194 * j58) + (104575268 * j67) + (j81 >>> 28);
        long j84 = j81 & M28L;
        long j85 = j72 + (j83 >>> 28);
        long j86 = j83 & M28L;
        long j87 = j48 + (j57 * 149865618) + (j58 * 550336261) + (j85 >>> 28);
        long j88 = j85 & M28L;
        long j89 = j65 + (j87 >>> 28);
        long j90 = j87 & M28L;
        long j91 = j50 + (j89 >>> 28);
        long j92 = j89 & M28L;
        long j93 = j42 + (j91 >>> 28);
        long j94 = j91 & M28L;
        long j95 = j26 + (j18 * 149865618) + (j34 * 550336261) + (j93 >>> 28);
        long j96 = j93 & M28L;
        long j97 = decode247 + (j5 * 43969588) + (j6 * 30366549) + (j7 * 163752818) + (j8 * 258169998) + (j11 * 96434764) + (j19 * 227822194) + (j20 * 149865618) + (j18 * 550336261) + (j95 >>> 28);
        long j98 = j95 & M28L;
        long j99 = j52 + (j97 >>> 28);
        long j100 = j97 & M28L;
        long j101 = j66 + (j99 >>> 28);
        long j102 = j99 & M28L;
        long j103 = j101 & M26L;
        long j104 = (j101 >>> 26) - 1;
        long j105 = j74 - (j104 & 78101261);
        long j106 = (j76 - (j104 & 141809365)) + (j105 >> 28);
        long j107 = j105 & M28L;
        long j108 = (j78 - (j104 & 175155932)) + (j106 >> 28);
        long j109 = j106 & M28L;
        long j110 = (j80 - (j104 & 64542499)) + (j108 >> 28);
        long j111 = j108 & M28L;
        long j112 = (j82 - (j104 & 158326419)) + (j110 >> 28);
        long j113 = j110 & M28L;
        long j114 = (j84 - (j104 & 191173276)) + (j112 >> 28);
        long j115 = j112 & M28L;
        long j116 = (j86 - (j104 & 104575268)) + (j114 >> 28);
        long j117 = j114 & M28L;
        long j118 = (j88 - (j104 & 137584065)) + (j116 >> 28);
        long j119 = j116 & M28L;
        long j120 = j90 + (j118 >> 28);
        long j121 = j118 & M28L;
        long j122 = j92 + (j120 >> 28);
        long j123 = j120 & M28L;
        long j124 = j94 + (j122 >> 28);
        long j125 = j122 & M28L;
        long j126 = j96 + (j124 >> 28);
        long j127 = j124 & M28L;
        long j128 = j98 + (j126 >> 28);
        long j129 = j126 & M28L;
        long j130 = j100 + (j128 >> 28);
        long j131 = j128 & M28L;
        long j132 = j102 + (j130 >> 28);
        long j133 = j130 & M28L;
        long j134 = j132 & M28L;
        byte[] bArr3 = new byte[57];
        encode56((j109 << 28) | j107, bArr3, 0);
        encode56((j113 << 28) | j111, bArr3, 7);
        encode56(j115 | (j117 << 28), bArr3, 14);
        encode56(j119 | (j121 << 28), bArr3, 21);
        encode56(j123 | (j125 << 28), bArr3, 28);
        encode56(j127 | (j129 << 28), bArr3, 35);
        encode56(j131 | (j133 << 28), bArr3, 42);
        encode56(((j103 + (j132 >> 28)) << 28) | j134, bArr3, 49);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(14, iArr, 2, 0);
        Nat.cadd(14, (~iArr[0]) & 1, iArr, f6412L, iArr);
        Nat.shiftDownBit(14, iArr, 1);
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup(iArr, 111, pointPrecompute, pointExt2);
        for (int i = 110; i >= 0; i--) {
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointExt2);
            }
            pointLookup(iArr, i, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, f6412L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                C2793F.cnegate(i6, pointPrecomp.f6417x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend != null) {
            byte[] bArr2 = new byte[57];
            pruneScalar(bArr, i, bArr2);
            PointExt pointExt = new PointExt();
            scalarMultBase(bArr2, pointExt);
            if (checkPoint(pointExt.f6414x, pointExt.f6415y, pointExt.f6416z) != 0) {
                C2793F.copy(pointExt.f6414x, 0, iArr, 0);
                C2793F.copy(pointExt.f6415y, 0, iArr2, 0);
                return;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("This method is only for use by X448");
    }

    private static void scalarMultOrderVar(PointExt pointExt, PointExt pointExt2) {
        byte[] wnafVar = getWnafVar(f6412L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                boolean z = true;
                int i3 = (b ^ i2) >>> 1;
                if (i2 == 0) {
                    z = false;
                }
                pointAddVar(z, pointPrecomputeVar[i3], pointExt2);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            boolean z = false;
            if (b != 0) {
                int i2 = b >> Ascii.f53596US;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointExt2);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.f53596US;
                int i4 = (b2 ^ i3) >>> 1;
                if (i3 != 0) {
                    z = true;
                }
                pointAddVar(z, pointPrecomputeVar[i4], pointExt2);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 == xof.doFinal(bArr5, 0, 64)) {
            implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr, i, false, pointExt)) {
            return false;
        }
        C2793F.normalize(pointExt.f6414x);
        C2793F.normalize(pointExt.f6415y);
        C2793F.normalize(pointExt.f6416z);
        if (isNeutralElementVar(pointExt.f6414x, pointExt.f6415y, pointExt.f6416z)) {
            return false;
        }
        PointExt pointExt2 = new PointExt();
        scalarMultOrderVar(pointExt, pointExt2);
        C2793F.normalize(pointExt2.f6414x);
        C2793F.normalize(pointExt2.f6415y);
        C2793F.normalize(pointExt2.f6416z);
        return isNeutralElementVar(pointExt2.f6414x, pointExt2.f6415y, pointExt2.f6416z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        return decodePointVar(bArr, i, false, new PointExt());
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}

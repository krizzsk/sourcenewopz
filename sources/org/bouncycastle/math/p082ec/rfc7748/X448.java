package org.bouncycastle.math.p082ec.rfc7748;

import com.google.common.base.Ascii;
import java.security.SecureRandom;
import org.bouncycastle.math.p082ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

/* renamed from: org.bouncycastle.math.ec.rfc7748.X448 */
public abstract class X448 {
    private static final int C_A = 156326;
    private static final int C_A24 = 39082;
    public static final int POINT_SIZE = 56;
    public static final int SCALAR_SIZE = 56;

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X448$F */
    private static class C2789F extends X448Field {
        private C2789F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X448$Friend */
    public static class Friend {
        /* access modifiers changed from: private */
        public static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !Arrays.areAllZeroes(bArr3, i3, 56);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 14; i2++) {
            iArr[i2] = decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & -4;
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | 128);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = C2789F.create();
        int[] create2 = C2789F.create();
        C2789F.add(iArr, iArr2, create);
        C2789F.sub(iArr, iArr2, create2);
        C2789F.sqr(create, create);
        C2789F.sqr(create2, create2);
        C2789F.mul(create, create2, iArr);
        C2789F.sub(create, create2, create);
        C2789F.mul(create, 39082, iArr2);
        C2789F.add(iArr2, create2, iArr2);
        C2789F.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed448.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[14];
        decodeScalar(bArr, i, iArr);
        int[] create = C2789F.create();
        C2789F.decode(bArr2, i2, create);
        int[] create2 = C2789F.create();
        C2789F.copy(create, 0, create2, 0);
        int[] create3 = C2789F.create();
        create3[0] = 1;
        int[] create4 = C2789F.create();
        create4[0] = 1;
        int[] create5 = C2789F.create();
        int[] create6 = C2789F.create();
        int[] create7 = C2789F.create();
        int i4 = 447;
        int i5 = 1;
        while (true) {
            C2789F.add(create4, create5, create6);
            C2789F.sub(create4, create5, create4);
            C2789F.add(create2, create3, create5);
            C2789F.sub(create2, create3, create2);
            C2789F.mul(create6, create2, create6);
            C2789F.mul(create4, create5, create4);
            C2789F.sqr(create5, create5);
            C2789F.sqr(create2, create2);
            C2789F.sub(create5, create2, create7);
            C2789F.mul(create7, 39082, create3);
            C2789F.add(create3, create2, create3);
            C2789F.mul(create3, create7, create3);
            C2789F.mul(create2, create5, create2);
            C2789F.sub(create6, create4, create5);
            C2789F.add(create6, create4, create4);
            C2789F.sqr(create4, create4);
            C2789F.sqr(create5, create5);
            C2789F.mul(create5, create, create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            C2789F.cswap(i7, create2, create4);
            C2789F.cswap(i7, create3, create5);
            if (i4 < 2) {
                break;
            }
            i5 = i6;
        }
        for (int i8 = 0; i8 < 2; i8++) {
            pointDouble(create2, create3);
        }
        C2789F.inv(create3, create3);
        C2789F.mul(create2, create3, create2);
        C2789F.normalize(create2);
        C2789F.encode(create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] create = C2789F.create();
        int[] create2 = C2789F.create();
        Ed448.scalarMultBaseXY(Friend.INSTANCE, bArr, i, create, create2);
        C2789F.inv(create, create);
        C2789F.mul(create, create2, create);
        C2789F.sqr(create, create);
        C2789F.normalize(create);
        C2789F.encode(create, bArr2, i2);
    }
}

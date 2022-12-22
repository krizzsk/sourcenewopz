package org.bouncycastle.math.p082ec.rfc7748;

import com.google.common.base.Ascii;
import java.security.SecureRandom;
import org.bouncycastle.math.p082ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

/* renamed from: org.bouncycastle.math.ec.rfc7748.X25519 */
public abstract class X25519 {
    private static final int C_A = 486662;
    private static final int C_A24 = 121666;
    public static final int POINT_SIZE = 32;
    public static final int SCALAR_SIZE = 32;

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X25519$F */
    private static class C2788F extends X25519Field {
        private C2788F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X25519$Friend */
    public static class Friend {
        /* access modifiers changed from: private */
        public static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !Arrays.areAllZeroes(bArr3, i3, 32);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & -8;
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = iArr[7] | 1073741824;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 248);
        bArr[31] = (byte) (bArr[31] & Byte.MAX_VALUE);
        bArr[31] = (byte) (bArr[31] | 64);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = C2788F.create();
        int[] create2 = C2788F.create();
        C2788F.apm(iArr, iArr2, create, create2);
        C2788F.sqr(create, create);
        C2788F.sqr(create2, create2);
        C2788F.mul(create, create2, iArr);
        C2788F.sub(create, create2, create);
        C2788F.mul(create, (int) C_A24, iArr2);
        C2788F.add(iArr2, create2, iArr2);
        C2788F.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed25519.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[8];
        decodeScalar(bArr, i, iArr);
        int[] create = C2788F.create();
        C2788F.decode(bArr2, i2, create);
        int[] create2 = C2788F.create();
        C2788F.copy(create, 0, create2, 0);
        int[] create3 = C2788F.create();
        create3[0] = 1;
        int[] create4 = C2788F.create();
        create4[0] = 1;
        int[] create5 = C2788F.create();
        int[] create6 = C2788F.create();
        int[] create7 = C2788F.create();
        int i4 = 254;
        int i5 = 1;
        while (true) {
            C2788F.apm(create4, create5, create6, create4);
            C2788F.apm(create2, create3, create5, create2);
            C2788F.mul(create6, create2, create6);
            C2788F.mul(create4, create5, create4);
            C2788F.sqr(create5, create5);
            C2788F.sqr(create2, create2);
            C2788F.sub(create5, create2, create7);
            C2788F.mul(create7, (int) C_A24, create3);
            C2788F.add(create3, create2, create3);
            C2788F.mul(create3, create7, create3);
            C2788F.mul(create2, create5, create2);
            C2788F.apm(create6, create4, create4, create5);
            C2788F.sqr(create4, create4);
            C2788F.sqr(create5, create5);
            C2788F.mul(create5, create, create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            C2788F.cswap(i7, create2, create4);
            C2788F.cswap(i7, create3, create5);
            if (i4 < 3) {
                break;
            }
            i5 = i6;
        }
        for (int i8 = 0; i8 < 3; i8++) {
            pointDouble(create2, create3);
        }
        C2788F.inv(create3, create3);
        C2788F.mul(create2, create3, create2);
        C2788F.normalize(create2);
        C2788F.encode(create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] create = C2788F.create();
        int[] create2 = C2788F.create();
        Ed25519.scalarMultBaseYZ(Friend.INSTANCE, bArr, i, create, create2);
        C2788F.apm(create2, create, create, create2);
        C2788F.inv(create2, create2);
        C2788F.mul(create, create2, create);
        C2788F.normalize(create);
        C2788F.encode(create, bArr2, i2);
    }
}

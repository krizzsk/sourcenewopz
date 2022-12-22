package org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class GOST3411Digest implements ExtendedDigest, Memoable {

    /* renamed from: C2 */
    private static final byte[] f5774C2 = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: C */
    private byte[][] f5775C = ((byte[][]) Array.newInstance(byte.class, new int[]{4, 32}));

    /* renamed from: H */
    private byte[] f5776H = new byte[32];

    /* renamed from: K */
    private byte[] f5777K = new byte[32];

    /* renamed from: L */
    private byte[] f5778L = new byte[32];

    /* renamed from: M */
    private byte[] f5779M = new byte[32];

    /* renamed from: S */
    byte[] f5780S = new byte[32];
    private byte[] Sum = new byte[32];

    /* renamed from: U */
    byte[] f5781U = new byte[32];

    /* renamed from: V */
    byte[] f5782V = new byte[32];

    /* renamed from: W */
    byte[] f5783W = new byte[32];

    /* renamed from: a */
    byte[] f5784a = new byte[8];
    private long byteCount;
    private BlockCipher cipher = new GOST28147Engine();
    private byte[] sBox;

    /* renamed from: wS */
    short[] f5785wS = new short[16];
    short[] w_S = new short[16];
    private byte[] xBuf = new byte[32];
    private int xBufOff;

    public GOST3411Digest() {
        byte[] sBox2 = GOST28147Engine.getSBox("D-A");
        this.sBox = sBox2;
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, sBox2));
        reset();
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        reset(gOST3411Digest);
    }

    public GOST3411Digest(byte[] bArr) {
        byte[] clone = Arrays.clone(bArr);
        this.sBox = clone;
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, clone));
        reset();
    }

    /* renamed from: A */
    private byte[] m3636A(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.f5784a[i] = (byte) (bArr[i] ^ bArr[i + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.f5784a, 0, bArr, 24, 8);
        return bArr;
    }

    /* renamed from: E */
    private void m3637E(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        this.cipher.init(true, new KeyParameter(bArr));
        this.cipher.processBlock(bArr3, i2, bArr2, i);
    }

    /* renamed from: P */
    private byte[] m3638P(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            byte[] bArr2 = this.f5777K;
            int i2 = i * 4;
            bArr2[i2] = bArr[i];
            bArr2[i2 + 1] = bArr[i + 8];
            bArr2[i2 + 2] = bArr[i + 16];
            bArr2[i2 + 3] = bArr[i + 24];
        }
        return this.f5777K;
    }

    private void cpyBytesToShort(byte[] bArr, short[] sArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & 255) | ((bArr[i2 + 1] << 8) & 65280));
        }
    }

    private void cpyShortToBytes(short[] sArr, byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            bArr[i2 + 1] = (byte) (sArr[i] >> 8);
            bArr[i2] = (byte) sArr[i];
        }
    }

    private void finish() {
        Pack.longToLittleEndian(this.byteCount * 8, this.f5778L, 0);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        processBlock(this.f5778L, 0);
        processBlock(this.Sum, 0);
    }

    /* renamed from: fw */
    private void m3639fw(byte[] bArr) {
        cpyBytesToShort(bArr, this.f5785wS);
        short[] sArr = this.w_S;
        short[] sArr2 = this.f5785wS;
        sArr[15] = (short) (((((sArr2[0] ^ sArr2[1]) ^ sArr2[2]) ^ sArr2[3]) ^ sArr2[12]) ^ sArr2[15]);
        System.arraycopy(sArr2, 1, sArr, 0, 15);
        cpyShortToBytes(this.w_S, bArr);
    }

    private void sumByteArray(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.Sum;
            if (i != bArr2.length) {
                int i3 = (bArr2[i] & 255) + (bArr[i] & 255) + i2;
                bArr2[i] = (byte) i3;
                i2 = i3 >>> 8;
                i++;
            } else {
                return;
            }
        }
    }

    public Memoable copy() {
        return new GOST3411Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        byte[] bArr2 = this.f5776H;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "GOST3411";
    }

    public int getByteLength() {
        return 32;
    }

    public int getDigestSize() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public void processBlock(byte[] bArr, int i) {
        System.arraycopy(bArr, i, this.f5779M, 0, 32);
        System.arraycopy(this.f5776H, 0, this.f5781U, 0, 32);
        System.arraycopy(this.f5779M, 0, this.f5782V, 0, 32);
        for (int i2 = 0; i2 < 32; i2++) {
            this.f5783W[i2] = (byte) (this.f5781U[i2] ^ this.f5782V[i2]);
        }
        m3637E(m3638P(this.f5783W), this.f5780S, 0, this.f5776H, 0);
        for (int i3 = 1; i3 < 4; i3++) {
            byte[] A = m3636A(this.f5781U);
            for (int i4 = 0; i4 < 32; i4++) {
                this.f5781U[i4] = (byte) (A[i4] ^ this.f5775C[i3][i4]);
            }
            this.f5782V = m3636A(m3636A(this.f5782V));
            for (int i5 = 0; i5 < 32; i5++) {
                this.f5783W[i5] = (byte) (this.f5781U[i5] ^ this.f5782V[i5]);
            }
            int i6 = i3 * 8;
            m3637E(m3638P(this.f5783W), this.f5780S, i6, this.f5776H, i6);
        }
        for (int i7 = 0; i7 < 12; i7++) {
            m3639fw(this.f5780S);
        }
        for (int i8 = 0; i8 < 32; i8++) {
            byte[] bArr2 = this.f5780S;
            bArr2[i8] = (byte) (bArr2[i8] ^ this.f5779M[i8]);
        }
        m3639fw(this.f5780S);
        for (int i9 = 0; i9 < 32; i9++) {
            byte[] bArr3 = this.f5780S;
            bArr3[i9] = (byte) (this.f5776H[i9] ^ bArr3[i9]);
        }
        for (int i10 = 0; i10 < 61; i10++) {
            m3639fw(this.f5780S);
        }
        byte[] bArr4 = this.f5780S;
        byte[] bArr5 = this.f5776H;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5776H;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5778L;
            if (i2 >= bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f5779M;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr3[i3] = 0;
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[][] bArr4 = this.f5775C;
            if (i4 >= bArr4[1].length) {
                break;
            }
            bArr4[1][i4] = 0;
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[][] bArr5 = this.f5775C;
            if (i5 >= bArr5[3].length) {
                break;
            }
            bArr5[3][i5] = 0;
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr6 = this.Sum;
            if (i6 >= bArr6.length) {
                break;
            }
            bArr6[i6] = 0;
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr7 = this.xBuf;
            if (i7 < bArr7.length) {
                bArr7[i7] = 0;
                i7++;
            } else {
                byte[] bArr8 = f5774C2;
                System.arraycopy(bArr8, 0, this.f5775C[2], 0, bArr8.length);
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        GOST3411Digest gOST3411Digest = (GOST3411Digest) memoable;
        byte[] bArr = gOST3411Digest.sBox;
        this.sBox = bArr;
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, bArr));
        reset();
        byte[] bArr2 = gOST3411Digest.f5776H;
        System.arraycopy(bArr2, 0, this.f5776H, 0, bArr2.length);
        byte[] bArr3 = gOST3411Digest.f5778L;
        System.arraycopy(bArr3, 0, this.f5778L, 0, bArr3.length);
        byte[] bArr4 = gOST3411Digest.f5779M;
        System.arraycopy(bArr4, 0, this.f5779M, 0, bArr4.length);
        byte[] bArr5 = gOST3411Digest.Sum;
        System.arraycopy(bArr5, 0, this.Sum, 0, bArr5.length);
        byte[][] bArr6 = gOST3411Digest.f5775C;
        System.arraycopy(bArr6[1], 0, this.f5775C[1], 0, bArr6[1].length);
        byte[][] bArr7 = gOST3411Digest.f5775C;
        System.arraycopy(bArr7[2], 0, this.f5775C[2], 0, bArr7[2].length);
        byte[][] bArr8 = gOST3411Digest.f5775C;
        System.arraycopy(bArr8[3], 0, this.f5775C[3], 0, bArr8[3].length);
        byte[] bArr9 = gOST3411Digest.xBuf;
        System.arraycopy(bArr9, 0, this.xBuf, 0, bArr9.length);
        this.xBufOff = gOST3411Digest.xBufOff;
        this.byteCount = gOST3411Digest.byteCount;
    }

    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        int i2 = i + 1;
        this.xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            sumByteArray(bArr);
            processBlock(this.xBuf, 0);
            this.xBufOff = 0;
        }
        this.byteCount++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (true) {
            byte[] bArr2 = this.xBuf;
            if (i2 <= bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            sumByteArray(this.xBuf);
            processBlock(this.xBuf, 0);
            byte[] bArr3 = this.xBuf;
            i += bArr3.length;
            i2 -= bArr3.length;
            this.byteCount += (long) bArr3.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}

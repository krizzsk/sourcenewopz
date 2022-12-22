package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;

    /* renamed from: P */
    private static final byte[][] f6016P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, 120, -28, -35, -47, 56, Ascii.f53584CR, -58, 53, -104, Ascii.CAN, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, Ascii.f53585EM, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, Ascii.SYN, Ascii.f53586FF, -29, 97, -64, -116, 58, -11, 115, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, Ascii.f53587FS, Ascii.f53592RS, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, Ascii.f53588GS, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, Ascii.ESC, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, Ascii.SUB, 75, Ascii.f53594SO, -89, 90, 40, Ascii.DC4, Utf8.REPLACEMENT_BYTE, 41, -120, 60, 76, 2, -72, -38, -80, Ascii.ETB, 85, Ascii.f53596US, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, Ascii.NAK, 34, Ascii.DC2, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, -36, -2, 50, -92, -54, 16, 33, -16, -45, 93, Ascii.f53593SI, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, Ascii.f53593SI, -8, Ascii.ESC, -121, -6, 6, Utf8.REPLACEMENT_BYTE, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, Ascii.f53594SO, Byte.MIN_VALUE, 93, -46, -43, -96, -124, 7, Ascii.DC4, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, 16, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 43, -30, 121, Ascii.f53586FF, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, Ascii.ETB, 102, -108, -95, Ascii.f53588GS, 61, -16, -34, -77, 11, 114, -89, Ascii.f53587FS, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, Ascii.SUB, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, Ascii.CAN, 35, -35, Ascii.f53596US, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, Ascii.f53585EM, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, Ascii.NAK, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, Ascii.DC2, -94, Ascii.f53584CR, 82, -69, 2, 47, -87, -41, 97, Ascii.f53592RS, -76, 80, 4, -10, -62, Ascii.SYN, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i = 0; i < 256; i++) {
            int i2 = f6016P[0][i] & 255;
            iArr[0] = i2;
            iArr2[0] = Mx_X(i2) & 255;
            iArr3[0] = Mx_Y(i2) & 255;
            int i3 = f6016P[1][i] & 255;
            iArr[1] = i3;
            iArr2[1] = Mx_X(i3) & 255;
            iArr3[1] = Mx_Y(i3) & 255;
            this.gMDS0[i] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.gMDS1[i] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.gMDS2[i] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.gMDS3[i] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    private void Bits32ToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    private int BytesTo32Bits(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private int F32(int i, int[] iArr) {
        int i2;
        int i3;
        int b0 = m3718b0(i);
        int b1 = m3719b1(i);
        int b2 = m3720b2(i);
        int b3 = m3721b3(i);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = this.k64Cnt & 3;
        if (i8 == 0) {
            b0 = (f6016P[1][b0] & 255) ^ m3718b0(i7);
            b1 = (f6016P[0][b1] & 255) ^ m3719b1(i7);
            b2 = (f6016P[0][b2] & 255) ^ m3720b2(i7);
            b3 = (f6016P[1][b3] & 255) ^ m3721b3(i7);
        } else if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
            }
            int[] iArr2 = this.gMDS0;
            byte[][] bArr = f6016P;
            int i9 = iArr2[(bArr[0][(bArr[0][b0] & 255) ^ m3718b0(i5)] & 255) ^ m3718b0(i4)];
            int[] iArr3 = this.gMDS1;
            byte[][] bArr2 = f6016P;
            int i10 = i9 ^ iArr3[(bArr2[0][(bArr2[1][b1] & 255) ^ m3719b1(i5)] & 255) ^ m3719b1(i4)];
            int[] iArr4 = this.gMDS2;
            byte[][] bArr3 = f6016P;
            i2 = i10 ^ iArr4[(bArr3[1][(bArr3[0][b2] & 255) ^ m3720b2(i5)] & 255) ^ m3720b2(i4)];
            int[] iArr5 = this.gMDS3;
            byte[][] bArr4 = f6016P;
            i3 = iArr5[(bArr4[1][(bArr4[1][b3] & 255) ^ m3721b3(i5)] & 255) ^ m3721b3(i4)];
            return i2 ^ i3;
        } else {
            i2 = (this.gMDS0[(f6016P[0][b0] & 255) ^ m3718b0(i4)] ^ this.gMDS1[(f6016P[0][b1] & 255) ^ m3719b1(i4)]) ^ this.gMDS2[(f6016P[1][b2] & 255) ^ m3720b2(i4)];
            i3 = this.gMDS3[(f6016P[1][b3] & 255) ^ m3721b3(i4)];
            return i2 ^ i3;
        }
        b0 = m3718b0(i6) ^ (f6016P[1][b0] & 255);
        b1 = m3719b1(i6) ^ (f6016P[1][b1] & 255);
        b2 = m3720b2(i6) ^ (f6016P[0][b2] & 255);
        b3 = (f6016P[0][b3] & 255) ^ m3721b3(i6);
        int[] iArr22 = this.gMDS0;
        byte[][] bArr5 = f6016P;
        int i92 = iArr22[(bArr5[0][(bArr5[0][b0] & 255) ^ m3718b0(i5)] & 255) ^ m3718b0(i4)];
        int[] iArr32 = this.gMDS1;
        byte[][] bArr22 = f6016P;
        int i102 = i92 ^ iArr32[(bArr22[0][(bArr22[1][b1] & 255) ^ m3719b1(i5)] & 255) ^ m3719b1(i4)];
        int[] iArr42 = this.gMDS2;
        byte[][] bArr32 = f6016P;
        i2 = i102 ^ iArr42[(bArr32[1][(bArr32[0][b2] & 255) ^ m3720b2(i5)] & 255) ^ m3720b2(i4)];
        int[] iArr52 = this.gMDS3;
        byte[][] bArr42 = f6016P;
        i3 = iArr52[(bArr42[1][(bArr42[1][b3] & 255) ^ m3721b3(i5)] & 255) ^ m3721b3(i4)];
        return i2 ^ i3;
    }

    private int Fe32_0(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 24) & 255) * 2) + 513] ^ ((iArr[((i & 255) * 2) + 0] ^ iArr[(((i >>> 8) & 255) * 2) + 1]) ^ iArr[(((i >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i >>> 24) & 255) * 2) + 0] ^ iArr[((i & 255) * 2) + 1]) ^ iArr[(((i >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i) {
        return ((i & 1) != 0 ? 180 : 0) ^ (i >> 1);
    }

    private int LFSR2(int i) {
        int i2 = 0;
        int i3 = (i >> 2) ^ ((i & 2) != 0 ? 180 : 0);
        if ((i & 1) != 0) {
            i2 = 90;
        }
        return i3 ^ i2;
    }

    private int Mx_X(int i) {
        return i ^ LFSR2(i);
    }

    private int Mx_Y(int i) {
        return LFSR2(i) ^ (LFSR1(i) ^ i);
    }

    private int RS_MDS_Encode(int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = RS_rem(i2);
        }
        int i4 = i ^ i2;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 = RS_rem(i4);
        }
        return i4;
    }

    private int RS_rem(int i) {
        int i2 = (i >>> 24) & 255;
        int i3 = 0;
        int i4 = ((i2 << 1) ^ ((i2 & 128) != 0 ? 333 : 0)) & 255;
        int i5 = i2 >>> 1;
        if ((i2 & 1) != 0) {
            i3 = 166;
        }
        int i6 = (i5 ^ i3) ^ i4;
        return ((((i << 8) ^ (i6 << 24)) ^ (i4 << 16)) ^ (i6 << 8)) ^ i2;
    }

    /* renamed from: b0 */
    private int m3718b0(int i) {
        return i & 255;
    }

    /* renamed from: b1 */
    private int m3719b1(int i) {
        return (i >>> 8) & 255;
    }

    /* renamed from: b2 */
    private int m3720b2(int i) {
        return (i >>> 16) & 255;
    }

    /* renamed from: b3 */
    private int m3721b3(int i) {
        return (i >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[4];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[5];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[6];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[7];
        int i3 = 39;
        for (int i4 = 0; i4 < 16; i4 += 2) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i3 - 1;
            int i6 = BytesTo32Bits4 ^ (((Fe32_3 * 2) + Fe32_0) + iArr[i3]);
            int i7 = i5 - 1;
            BytesTo32Bits3 = ((BytesTo32Bits3 >>> 31) | (BytesTo32Bits3 << 1)) ^ ((Fe32_0 + Fe32_3) + iArr[i5]);
            BytesTo32Bits4 = (i6 << 31) | (i6 >>> 1);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i8 = i7 - 1;
            int i9 = BytesTo32Bits2 ^ (((Fe32_32 * 2) + Fe32_02) + iArr2[i7]);
            i3 = i8 - 1;
            BytesTo32Bits = ((BytesTo32Bits >>> 31) | (BytesTo32Bits << 1)) ^ ((Fe32_02 + Fe32_32) + iArr2[i8]);
            BytesTo32Bits2 = (i9 << 31) | (i9 >>> 1);
        }
        Bits32ToBytes(this.gSubKeys[0] ^ BytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[1], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ BytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ BytesTo32Bits2, bArr2, i2 + 12);
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[0];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[1];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[2];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[3];
        int i4 = 8;
        while (i3 < 16) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i4 + 1;
            int i6 = BytesTo32Bits3 ^ ((Fe32_0 + Fe32_3) + iArr[i4]);
            BytesTo32Bits3 = (i6 >>> 1) | (i6 << 31);
            int i7 = (BytesTo32Bits4 >>> 31) | (BytesTo32Bits4 << 1);
            int i8 = i5 + 1;
            BytesTo32Bits4 = i7 ^ ((Fe32_0 + (Fe32_3 * 2)) + iArr[i5]);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i9 = i8 + 1;
            int i10 = BytesTo32Bits ^ ((Fe32_02 + Fe32_32) + iArr2[i8]);
            BytesTo32Bits = (i10 >>> 1) | (i10 << 31);
            i3 += 2;
            BytesTo32Bits2 = ((BytesTo32Bits2 << 1) | (BytesTo32Bits2 >>> 31)) ^ ((Fe32_02 + (Fe32_32 * 2)) + iArr2[i9]);
            i4 = i9 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ BytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[5], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ BytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ BytesTo32Bits2, bArr2, i2 + 12);
    }

    private void setKey(byte[] bArr) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i = this.k64Cnt;
        if (i < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i <= 4) {
            for (int i2 = 0; i2 < this.k64Cnt; i2++) {
                int i3 = i2 * 8;
                iArr[i2] = BytesTo32Bits(bArr2, i3);
                iArr2[i2] = BytesTo32Bits(bArr2, i3 + 4);
                iArr3[(this.k64Cnt - 1) - i2] = RS_MDS_Encode(iArr[i2], iArr2[i2]);
            }
            for (int i4 = 0; i4 < 20; i4++) {
                int i5 = SK_STEP * i4;
                int F32 = F32(i5, iArr);
                int F322 = F32(i5 + SK_BUMP, iArr2);
                int i6 = (F322 >>> 24) | (F322 << 8);
                int i7 = F32 + i6;
                int[] iArr4 = this.gSubKeys;
                int i8 = i4 * 2;
                iArr4[i8] = i7;
                int i9 = i7 + i6;
                iArr4[i8 + 1] = (i9 << 9) | (i9 >>> 23);
            }
            int i10 = iArr3[0];
            int i11 = iArr3[1];
            int i12 = 2;
            int i13 = iArr3[2];
            int i14 = iArr3[3];
            this.gSBox = new int[1024];
            int i15 = 0;
            while (i15 < 256) {
                int i16 = this.k64Cnt & 3;
                if (i16 != 0) {
                    if (i16 == 1) {
                        int i17 = i15 * 2;
                        this.gSBox[i17] = this.gMDS0[(f6016P[0][i15] & 255) ^ m3718b0(i10)];
                        this.gSBox[i17 + 1] = this.gMDS1[(f6016P[0][i15] & 255) ^ m3719b1(i10)];
                        this.gSBox[i17 + 512] = this.gMDS2[(f6016P[1][i15] & 255) ^ m3720b2(i10)];
                        this.gSBox[i17 + 513] = this.gMDS3[(f6016P[1][i15] & 255) ^ m3721b3(i10)];
                    } else if (i16 == i12) {
                        b4 = i15;
                        b3 = b4;
                        b2 = b3;
                        b = b2;
                        int[] iArr5 = this.gSBox;
                        int i18 = i15 * 2;
                        int[] iArr6 = this.gMDS0;
                        byte[][] bArr3 = f6016P;
                        iArr5[i18] = iArr6[(bArr3[0][(bArr3[0][b4] & 255) ^ m3718b0(i11)] & 255) ^ m3718b0(i10)];
                        int[] iArr7 = this.gMDS1;
                        byte[][] bArr4 = f6016P;
                        this.gSBox[i18 + 1] = iArr7[(bArr4[0][(bArr4[1][b3] & 255) ^ m3719b1(i11)] & 255) ^ m3719b1(i10)];
                        int[] iArr8 = this.gMDS2;
                        byte[][] bArr5 = f6016P;
                        this.gSBox[i18 + 512] = iArr8[(bArr5[1][(bArr5[0][b2] & 255) ^ m3720b2(i11)] & 255) ^ m3720b2(i10)];
                        int[] iArr9 = this.gMDS3;
                        byte[][] bArr6 = f6016P;
                        this.gSBox[i18 + 513] = iArr9[(bArr6[1][(bArr6[1][b] & 255) ^ m3721b3(i11)] & 255) ^ m3721b3(i10)];
                    } else if (i16 == 3) {
                        b8 = i15;
                        b7 = b8;
                        b6 = b7;
                        b5 = b6;
                    }
                    i15++;
                    i12 = 2;
                } else {
                    b8 = (f6016P[1][i15] & 255) ^ m3718b0(i14);
                    b7 = (f6016P[0][i15] & 255) ^ m3719b1(i14);
                    b6 = (f6016P[0][i15] & 255) ^ m3720b2(i14);
                    b5 = (f6016P[1][i15] & 255) ^ m3721b3(i14);
                }
                b4 = (f6016P[1][b8] & 255) ^ m3718b0(i13);
                b3 = (f6016P[1][b7] & 255) ^ m3719b1(i13);
                b2 = (f6016P[0][b6] & 255) ^ m3720b2(i13);
                b = (f6016P[0][b5] & 255) ^ m3721b3(i13);
                int[] iArr52 = this.gSBox;
                int i182 = i15 * 2;
                int[] iArr62 = this.gMDS0;
                byte[][] bArr32 = f6016P;
                iArr52[i182] = iArr62[(bArr32[0][(bArr32[0][b4] & 255) ^ m3718b0(i11)] & 255) ^ m3718b0(i10)];
                int[] iArr72 = this.gMDS1;
                byte[][] bArr42 = f6016P;
                this.gSBox[i182 + 1] = iArr72[(bArr42[0][(bArr42[1][b3] & 255) ^ m3719b1(i11)] & 255) ^ m3719b1(i10)];
                int[] iArr82 = this.gMDS2;
                byte[][] bArr52 = f6016P;
                this.gSBox[i182 + 512] = iArr82[(bArr52[1][(bArr52[0][b2] & 255) ^ m3720b2(i11)] & 255) ^ m3720b2(i10)];
                int[] iArr92 = this.gMDS3;
                byte[][] bArr62 = f6016P;
                this.gSBox[i182 + 513] = iArr92[(bArr62[1][(bArr62[1][b] & 255) ^ m3721b3(i11)] & 255) ^ m3721b3(i10)];
                i15++;
                i12 = 2;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    public String getAlgorithmName() {
        return "Twofish";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            this.k64Cnt = key.length / 8;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        } else {
            decryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
    }

    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}

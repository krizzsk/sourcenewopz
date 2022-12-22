package org.bouncycastle.crypto.macs;

import android.view.View;
import net.lingala.zip4j.util.InternalZipConstants;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0 */
    private int f6048h0;

    /* renamed from: h1 */
    private int f6049h1;

    /* renamed from: h2 */
    private int f6050h2;

    /* renamed from: h3 */
    private int f6051h3;

    /* renamed from: h4 */
    private int f6052h4;

    /* renamed from: k0 */
    private int f6053k0;

    /* renamed from: k1 */
    private int f6054k1;

    /* renamed from: k2 */
    private int f6055k2;

    /* renamed from: k3 */
    private int f6056k3;

    /* renamed from: r0 */
    private int f6057r0;

    /* renamed from: r1 */
    private int f6058r1;

    /* renamed from: r2 */
    private int f6059r2;

    /* renamed from: r3 */
    private int f6060r3;

    /* renamed from: r4 */
    private int f6061r4;

    /* renamed from: s1 */
    private int f6062s1;

    /* renamed from: s2 */
    private int f6063s2;

    /* renamed from: s3 */
    private int f6064s3;

    /* renamed from: s4 */
    private int f6065s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int i, int i2) {
        return (((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * ((long) i2);
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long littleEndianToInt4 = InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        this.f6048h0 = (int) (((long) this.f6048h0) + (littleEndianToInt & 67108863));
        this.f6049h1 = (int) (((long) this.f6049h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.f6050h2 = (int) (((long) this.f6050h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f6051h3 = (int) (((long) this.f6051h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i3 = (int) (((long) this.f6052h4) + (littleEndianToInt4 >>> 8));
        this.f6052h4 = i3;
        if (this.currentBlockOffset == 16) {
            this.f6052h4 = i3 + 16777216;
        }
        long mul32x32_64 = mul32x32_64(this.f6048h0, this.f6057r0) + mul32x32_64(this.f6049h1, this.f6065s4) + mul32x32_64(this.f6050h2, this.f6064s3) + mul32x32_64(this.f6051h3, this.f6063s2) + mul32x32_64(this.f6052h4, this.f6062s1);
        long mul32x32_642 = mul32x32_64(this.f6048h0, this.f6058r1) + mul32x32_64(this.f6049h1, this.f6057r0) + mul32x32_64(this.f6050h2, this.f6065s4) + mul32x32_64(this.f6051h3, this.f6064s3) + mul32x32_64(this.f6052h4, this.f6063s2);
        long mul32x32_643 = mul32x32_64(this.f6048h0, this.f6059r2) + mul32x32_64(this.f6049h1, this.f6058r1) + mul32x32_64(this.f6050h2, this.f6057r0) + mul32x32_64(this.f6051h3, this.f6065s4) + mul32x32_64(this.f6052h4, this.f6064s3);
        long mul32x32_644 = mul32x32_64(this.f6048h0, this.f6060r3) + mul32x32_64(this.f6049h1, this.f6059r2) + mul32x32_64(this.f6050h2, this.f6058r1) + mul32x32_64(this.f6051h3, this.f6057r0) + mul32x32_64(this.f6052h4, this.f6065s4);
        long mul32x32_645 = mul32x32_64(this.f6048h0, this.f6061r4) + mul32x32_64(this.f6049h1, this.f6060r3) + mul32x32_64(this.f6050h2, this.f6059r2) + mul32x32_64(this.f6051h3, this.f6058r1) + mul32x32_64(this.f6052h4, this.f6057r0);
        int i4 = ((int) mul32x32_64) & 67108863;
        this.f6048h0 = i4;
        long j = mul32x32_642 + (mul32x32_64 >>> 26);
        int i5 = ((int) j) & 67108863;
        this.f6049h1 = i5;
        long j2 = mul32x32_643 + (j >>> 26);
        this.f6050h2 = ((int) j2) & 67108863;
        long j3 = mul32x32_644 + (j2 >>> 26);
        this.f6051h3 = ((int) j3) & 67108863;
        long j4 = mul32x32_645 + (j3 >>> 26);
        this.f6052h4 = ((int) j4) & 67108863;
        int i6 = i4 + (((int) (j4 >>> 26)) * 5);
        this.f6048h0 = i6;
        this.f6049h1 = i5 + (i6 >>> 26);
        this.f6048h0 = i6 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            int i = 16;
            if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
                int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
                int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
                int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
                this.f6057r0 = 67108863 & littleEndianToInt;
                int i2 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
                this.f6058r1 = i2;
                int i3 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
                this.f6059r2 = i3;
                int i4 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
                this.f6060r3 = i4;
                int i5 = (littleEndianToInt4 >>> 8) & 1048575;
                this.f6061r4 = i5;
                this.f6062s1 = i2 * 5;
                this.f6063s2 = i3 * 5;
                this.f6064s3 = i4 * 5;
                this.f6065s4 = i5 * 5;
                BlockCipher blockCipher = this.cipher;
                if (blockCipher != null) {
                    byte[] bArr3 = new byte[16];
                    blockCipher.init(true, new KeyParameter(bArr, 16, 16));
                    this.cipher.processBlock(bArr2, 0, bArr3, 0);
                    bArr = bArr3;
                    i = 0;
                }
                this.f6053k0 = Pack.littleEndianToInt(bArr, i + 0);
                this.f6054k1 = Pack.littleEndianToInt(bArr, i + 4);
                this.f6055k2 = Pack.littleEndianToInt(bArr, i + 8);
                this.f6056k3 = Pack.littleEndianToInt(bArr, i + 12);
                return;
            }
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (i + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i2 = this.f6049h1;
            int i3 = this.f6048h0;
            int i4 = i2 + (i3 >>> 26);
            this.f6049h1 = i4;
            int i5 = i3 & 67108863;
            this.f6048h0 = i5;
            int i6 = this.f6050h2 + (i4 >>> 26);
            this.f6050h2 = i6;
            int i7 = i4 & 67108863;
            this.f6049h1 = i7;
            int i8 = this.f6051h3 + (i6 >>> 26);
            this.f6051h3 = i8;
            int i9 = i6 & 67108863;
            this.f6050h2 = i9;
            int i10 = this.f6052h4 + (i8 >>> 26);
            this.f6052h4 = i10;
            int i11 = i8 & 67108863;
            this.f6051h3 = i11;
            int i12 = i5 + ((i10 >>> 26) * 5);
            this.f6048h0 = i12;
            int i13 = i10 & 67108863;
            this.f6052h4 = i13;
            int i14 = i7 + (i12 >>> 26);
            this.f6049h1 = i14;
            int i15 = i12 & 67108863;
            this.f6048h0 = i15;
            int i16 = i15 + 5;
            int i17 = (i16 >>> 26) + i14;
            int i18 = (i17 >>> 26) + i9;
            int i19 = (i18 >>> 26) + i11;
            int i20 = 67108863 & i19;
            int i21 = ((i19 >>> 26) + i13) - View.STATUS_BAR_TRANSIENT;
            int i22 = (i21 >>> 31) - 1;
            int i23 = ~i22;
            int i24 = (i15 & i23) | (i16 & 67108863 & i22);
            this.f6048h0 = i24;
            int i25 = (i14 & i23) | (i17 & 67108863 & i22);
            this.f6049h1 = i25;
            int i26 = (i9 & i23) | (i18 & 67108863 & i22);
            this.f6050h2 = i26;
            int i27 = (i20 & i22) | (i11 & i23);
            this.f6051h3 = i27;
            int i28 = (i13 & i23) | (i21 & i22);
            this.f6052h4 = i28;
            long j = (((long) (i24 | (i25 << 26))) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) this.f6053k0) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            long j2 = (((long) ((i25 >>> 6) | (i26 << 20))) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) this.f6054k1) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            long j3 = (((long) ((i26 >>> 12) | (i27 << 14))) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) this.f6055k2) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            Pack.intToLittleEndian((int) j, bArr, i);
            long j4 = j2 + (j >>> 32);
            Pack.intToLittleEndian((int) j4, bArr, i + 4);
            long j5 = j3 + (j4 >>> 32);
            Pack.intToLittleEndian((int) j5, bArr, i + 8);
            Pack.intToLittleEndian((int) ((((long) ((i27 >>> 18) | (i28 << 8))) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) this.f6056k3)) + (j5 >>> 32)), bArr, i + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return 16;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.f6052h4 = 0;
        this.f6051h3 = 0;
        this.f6050h2 = 0;
        this.f6049h1 = 0;
        this.f6048h0 = 0;
    }

    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, min);
            i3 += min;
            this.currentBlockOffset += min;
        }
    }
}

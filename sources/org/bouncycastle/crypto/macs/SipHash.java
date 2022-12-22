package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class SipHash implements Mac {

    /* renamed from: c */
    protected final int f6066c;

    /* renamed from: d */
    protected final int f6067d;

    /* renamed from: k0 */
    protected long f6068k0;

    /* renamed from: k1 */
    protected long f6069k1;

    /* renamed from: m */
    protected long f6070m;

    /* renamed from: v0 */
    protected long f6071v0;

    /* renamed from: v1 */
    protected long f6072v1;

    /* renamed from: v2 */
    protected long f6073v2;

    /* renamed from: v3 */
    protected long f6074v3;
    protected int wordCount;
    protected int wordPos;

    public SipHash() {
        this.f6070m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f6066c = 2;
        this.f6067d = 4;
    }

    public SipHash(int i, int i2) {
        this.f6070m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f6066c = i;
        this.f6067d = i2;
    }

    protected static long rotateLeft(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    /* access modifiers changed from: protected */
    public void applySipRounds(int i) {
        long j = this.f6071v0;
        long j2 = this.f6072v1;
        long j3 = this.f6073v2;
        long j4 = this.f6074v3;
        for (int i2 = 0; i2 < i; i2++) {
            long j5 = j + j2;
            long j6 = j3 + j4;
            long rotateLeft = rotateLeft(j2, 13) ^ j5;
            long rotateLeft2 = rotateLeft(j4, 16) ^ j6;
            long j7 = j6 + rotateLeft;
            j = rotateLeft(j5, 32) + rotateLeft2;
            j2 = rotateLeft(rotateLeft, 17) ^ j7;
            j4 = rotateLeft(rotateLeft2, 21) ^ j;
            j3 = rotateLeft(j7, 32);
        }
        this.f6071v0 = j;
        this.f6072v1 = j2;
        this.f6073v2 = j3;
        this.f6074v3 = j4;
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), bArr, i);
        return 8;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        long j = this.f6070m;
        int i = this.wordPos;
        long j2 = j >>> ((7 - i) << 3);
        this.f6070m = j2;
        long j3 = j2 >>> 8;
        this.f6070m = j3;
        this.f6070m = j3 | ((((long) ((this.wordCount << 3) + i)) & 255) << 56);
        processMessageWord();
        this.f6073v2 ^= 255;
        applySipRounds(this.f6067d);
        long j4 = ((this.f6071v0 ^ this.f6072v1) ^ this.f6073v2) ^ this.f6074v3;
        reset();
        return j4;
    }

    public String getAlgorithmName() {
        return "SipHash-" + this.f6066c + "-" + this.f6067d;
    }

    public int getMacSize() {
        return 8;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.f6068k0 = Pack.littleEndianToLong(key, 0);
                this.f6069k1 = Pack.littleEndianToLong(key, 8);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    /* access modifiers changed from: protected */
    public void processMessageWord() {
        this.wordCount++;
        this.f6074v3 ^= this.f6070m;
        applySipRounds(this.f6066c);
        this.f6071v0 ^= this.f6070m;
    }

    public void reset() {
        long j = this.f6068k0;
        this.f6071v0 = 8317987319222330741L ^ j;
        long j2 = this.f6069k1;
        this.f6072v1 = 7237128888997146477L ^ j2;
        this.f6073v2 = j ^ 7816392313619706465L;
        this.f6074v3 = 8387220255154660723L ^ j2;
        this.f6070m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    public void update(byte b) throws IllegalStateException {
        long j = this.f6070m >>> 8;
        this.f6070m = j;
        this.f6070m = j | ((((long) b) & 255) << 56);
        int i = this.wordPos + 1;
        this.wordPos = i;
        if (i == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = i3 & -8;
        int i5 = this.wordPos;
        int i6 = 0;
        if (i5 == 0) {
            while (i6 < i4) {
                this.f6070m = Pack.littleEndianToLong(bArr2, i + i6);
                processMessageWord();
                i6 += 8;
            }
            while (i6 < i3) {
                long j = this.f6070m >>> 8;
                this.f6070m = j;
                this.f6070m = j | ((((long) bArr2[i + i6]) & 255) << 56);
                i6++;
            }
            this.wordPos = i3 - i4;
            return;
        }
        int i7 = i5 << 3;
        int i8 = 0;
        while (i8 < i4) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr2, i + i8);
            this.f6070m = (this.f6070m >>> (-i7)) | (littleEndianToLong << i7);
            processMessageWord();
            this.f6070m = littleEndianToLong;
            i8 += 8;
        }
        while (i8 < i3) {
            long j2 = this.f6070m >>> 8;
            this.f6070m = j2;
            this.f6070m = j2 | ((((long) bArr2[i + i8]) & 255) << 56);
            int i9 = this.wordPos + 1;
            this.wordPos = i9;
            if (i9 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i8++;
        }
    }
}

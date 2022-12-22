package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Pack;

public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public SipHash128(int i, int i2) {
        super(i, i2);
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        this.f6070m >>>= (7 - this.wordPos) << 3;
        this.f6070m >>>= 8;
        this.f6070m |= (((long) ((this.wordCount << 3) + this.wordPos)) & 255) << 56;
        processMessageWord();
        this.f6073v2 ^= 238;
        applySipRounds(this.f6067d);
        long j = ((this.f6071v0 ^ this.f6072v1) ^ this.f6073v2) ^ this.f6074v3;
        this.f6072v1 ^= 221;
        applySipRounds(this.f6067d);
        reset();
        Pack.longToLittleEndian(j, bArr, i);
        Pack.longToLittleEndian(((this.f6071v0 ^ this.f6072v1) ^ this.f6073v2) ^ this.f6074v3, bArr, i + 8);
        return 16;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    public String getAlgorithmName() {
        return "SipHash128-" + this.f6066c + "-" + this.f6067d;
    }

    public int getMacSize() {
        return 16;
    }

    public void reset() {
        super.reset();
        this.f6072v1 ^= 238;
    }
}

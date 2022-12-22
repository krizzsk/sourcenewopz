package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.BlockCipher;

public class X931RNG {
    private static final int BLOCK128_MAX_BITS_REQUEST = 262144;
    private static final long BLOCK128_RESEED_MAX = 8388608;
    private static final int BLOCK64_MAX_BITS_REQUEST = 4096;
    private static final long BLOCK64_RESEED_MAX = 32768;

    /* renamed from: DT */
    private final byte[] f6200DT;

    /* renamed from: I */
    private final byte[] f6201I;

    /* renamed from: R */
    private final byte[] f6202R;

    /* renamed from: V */
    private byte[] f6203V;
    private final BlockCipher engine;
    private final EntropySource entropySource;
    private long reseedCounter = 1;

    public X931RNG(BlockCipher blockCipher, byte[] bArr, EntropySource entropySource2) {
        this.engine = blockCipher;
        this.entropySource = entropySource2;
        byte[] bArr2 = new byte[blockCipher.getBlockSize()];
        this.f6200DT = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f6201I = new byte[blockCipher.getBlockSize()];
        this.f6202R = new byte[blockCipher.getBlockSize()];
    }

    private void increment(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b == 0) {
                length--;
            } else {
                return;
            }
        }
    }

    private static boolean isTooLarge(byte[] bArr, int i) {
        return bArr != null && bArr.length > i;
    }

    private void process(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) (bArr2[i] ^ bArr3[i]);
        }
        this.engine.processBlock(bArr, 0, bArr, 0);
    }

    /* access modifiers changed from: package-private */
    public int generate(byte[] bArr, boolean z) {
        if (this.f6202R.length == 8) {
            if (this.reseedCounter > 32768) {
                return -1;
            }
            if (isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.reseedCounter > BLOCK128_RESEED_MAX) {
            return -1;
        } else {
            if (isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z || this.f6203V == null) {
            byte[] entropy = this.entropySource.getEntropy();
            this.f6203V = entropy;
            if (entropy.length != this.engine.getBlockSize()) {
                throw new IllegalStateException("Insufficient entropy returned");
            }
        }
        int length = bArr.length / this.f6202R.length;
        for (int i = 0; i < length; i++) {
            this.engine.processBlock(this.f6200DT, 0, this.f6201I, 0);
            process(this.f6202R, this.f6201I, this.f6203V);
            process(this.f6203V, this.f6202R, this.f6201I);
            byte[] bArr2 = this.f6202R;
            System.arraycopy(bArr2, 0, bArr, bArr2.length * i, bArr2.length);
            increment(this.f6200DT);
        }
        int length2 = bArr.length - (this.f6202R.length * length);
        if (length2 > 0) {
            this.engine.processBlock(this.f6200DT, 0, this.f6201I, 0);
            process(this.f6202R, this.f6201I, this.f6203V);
            process(this.f6203V, this.f6202R, this.f6201I);
            byte[] bArr3 = this.f6202R;
            System.arraycopy(bArr3, 0, bArr, length * bArr3.length, length2);
            increment(this.f6200DT);
        }
        this.reseedCounter++;
        return bArr.length;
    }

    /* access modifiers changed from: package-private */
    public EntropySource getEntropySource() {
        return this.entropySource;
    }

    /* access modifiers changed from: package-private */
    public void reseed() {
        byte[] entropy = this.entropySource.getEntropy();
        this.f6203V = entropy;
        if (entropy.length == this.engine.getBlockSize()) {
            this.reseedCounter = 1;
            return;
        }
        throw new IllegalStateException("Insufficient entropy returned");
    }
}

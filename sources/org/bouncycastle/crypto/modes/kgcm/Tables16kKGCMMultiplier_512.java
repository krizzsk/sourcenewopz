package org.bouncycastle.crypto.modes.kgcm;

import java.lang.reflect.Array;

public class Tables16kKGCMMultiplier_512 implements KGCMMultiplier {

    /* renamed from: T */
    private long[][] f6129T;

    public void init(long[] jArr) {
        long[][] jArr2 = this.f6129T;
        if (jArr2 == null) {
            this.f6129T = (long[][]) Array.newInstance(long.class, new int[]{256, 8});
        } else if (KGCMUtil_512.equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_512.copy(jArr, this.f6129T[1]);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr3 = this.f6129T;
            KGCMUtil_512.multiplyX(jArr3[i >> 1], jArr3[i]);
            long[][] jArr4 = this.f6129T;
            KGCMUtil_512.add(jArr4[i], jArr4[1], jArr4[i + 1]);
        }
    }

    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[8];
        KGCMUtil_512.copy(this.f6129T[((int) (jArr[7] >>> 56)) & 255], jArr2);
        for (int i = 62; i >= 0; i--) {
            KGCMUtil_512.multiplyX8(jArr2, jArr2);
            KGCMUtil_512.add(this.f6129T[((int) (jArr[i >>> 3] >>> ((i & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_512.copy(jArr2, jArr);
    }
}

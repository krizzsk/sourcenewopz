package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

public final class EAN13Reader extends UPCEANReader {

    /* renamed from: a */
    static final int[] f18728a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: g */
    private final int[] f18729g = new int[4];

    /* access modifiers changed from: protected */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f18729g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < size; i3++) {
            int a = m13917a(bitArray, iArr2, i, f18757f);
            sb.append((char) ((a % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (a >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        m13902a(sb, i2);
        int i5 = m13920a(bitArray, i, true, f18754c)[1];
        for (int i6 = 0; i6 < 6 && i5 < size; i6++) {
            sb.append((char) (m13917a(bitArray, iArr2, i5, f18756e) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public BarcodeFormat mo58371a() {
        return BarcodeFormat.EAN_13;
    }

    /* renamed from: a */
    private static void m13902a(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f18728a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

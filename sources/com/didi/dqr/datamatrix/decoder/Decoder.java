package com.didi.dqr.datamatrix.decoder;

import com.didi.dqr.ChecksumException;
import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.reedsolomon.GenericGF;
import com.didi.dqr.common.reedsolomon.ReedSolomonDecoder;
import com.didi.dqr.common.reedsolomon.ReedSolomonException;

public final class Decoder {

    /* renamed from: a */
    private final ReedSolomonDecoder f18595a = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws FormatException, ChecksumException {
        return decode(BitMatrix.parse(zArr));
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws FormatException, ChecksumException {
        C7837a aVar = new C7837a(bitMatrix);
        C7838b[] a = C7838b.m13785a(aVar.mo58318b(), aVar.mo58317a());
        int i = 0;
        for (C7838b a2 : a) {
            i += a2.mo58319a();
        }
        byte[] bArr = new byte[i];
        int length = a.length;
        for (int i2 = 0; i2 < length; i2++) {
            C7838b bVar = a[i2];
            byte[] b = bVar.mo58320b();
            int a3 = bVar.mo58319a();
            m13772a(b, a3);
            for (int i3 = 0; i3 < a3; i3++) {
                bArr[(i3 * length) + i2] = b[i3];
            }
        }
        return DecodedBitStreamParser.m13764a(bArr);
    }

    /* renamed from: a */
    private void m13772a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f18595a.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}

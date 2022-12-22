package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.reedsolomon.GenericGF;
import com.didi.dqr.common.reedsolomon.ReedSolomonDecoder;
import com.didi.dqr.common.reedsolomon.ReedSolomonException;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.util.Map;

public final class Decoder {

    /* renamed from: a */
    private final ReedSolomonDecoder f19018a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        return decode(zArr, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return decode(BitMatrix.parse(zArr), map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e;
        C7897a aVar = new C7897a(bitMatrix);
        FormatException formatException = null;
        try {
            return m14211a(aVar, map);
        } catch (FormatException e2) {
            FormatException formatException2 = e2;
            e = null;
            formatException = formatException2;
            try {
                aVar.mo58599d();
                aVar.mo58596a(true);
                aVar.mo58597b();
                aVar.mo58595a();
                aVar.mo58600e();
                DecoderResult a = m14211a(aVar, map);
                a.setOther(new QRCodeDecoderMetaData(true));
                return a;
            } catch (ChecksumException | FormatException e3) {
                if (formatException != null) {
                    throw formatException;
                } else if (e != null) {
                    throw e;
                } else {
                    throw e3;
                }
            }
        } catch (ChecksumException e4) {
            e = e4;
            aVar.mo58599d();
            aVar.mo58596a(true);
            aVar.mo58597b();
            aVar.mo58595a();
            aVar.mo58600e();
            DecoderResult a2 = m14211a(aVar, map);
            a2.setOther(new QRCodeDecoderMetaData(true));
            return a2;
        }
    }

    /* renamed from: a */
    private DecoderResult m14211a(C7897a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Version b = aVar.mo58597b();
        ErrorCorrectionLevel a = aVar.mo58595a().mo58603a();
        C7898b[] a2 = C7898b.m14223a(aVar.mo58598c(), b, a);
        int i = 0;
        for (C7898b a3 : a2) {
            i += a3.mo58601a();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (C7898b bVar : a2) {
            byte[] b2 = bVar.mo58602b();
            int a4 = bVar.mo58601a();
            m14212a(b2, a4);
            int i3 = 0;
            while (i3 < a4) {
                bArr[i2] = b2[i3];
                i3++;
                i2++;
            }
        }
        return DecodedBitStreamParser.decode(bArr, b, a, map);
    }

    /* renamed from: a */
    private void m14212a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f19018a.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            AnalysisManager.report(EventId.QRCODE_CORRECT_ERROR_CHECK_ERROR);
            throw ChecksumException.getChecksumInstance();
        }
    }
}

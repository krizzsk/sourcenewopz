package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.Writer;
import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitMatrix;
import java.util.Map;

public final class UPCAWriter implements Writer {

    /* renamed from: a */
    private final EAN13Writer f18751a = new EAN13Writer();

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            EAN13Writer eAN13Writer = this.f18751a;
            return eAN13Writer.encode('0' + str, BarcodeFormat.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }
}

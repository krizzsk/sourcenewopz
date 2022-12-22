package com.didi.zxing.barcodescanner;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.DecodeHintType;
import java.util.Collection;
import java.util.Map;

public interface DecoderFactory {
    Decoder createDecoder(Map<DecodeHintType, ?> map);

    void setDecodeFormats(Collection<BarcodeFormat> collection);
}

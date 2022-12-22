package com.didi.dqr.multi;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;

public interface MultipleBarcodeReader {
    Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException;

    Result[] decodeMultiple(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException;
}

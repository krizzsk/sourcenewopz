package com.didi.zxing.barcodescanner;

import com.didi.dqr.ResultPoint;
import java.util.List;

public interface BarcodeCallback {
    void barcodeResult(BarcodeResult barcodeResult);

    void possibleResultPoints(List<ResultPoint> list);
}

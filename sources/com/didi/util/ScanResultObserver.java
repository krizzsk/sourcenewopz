package com.didi.util;

import com.didi.zxing.barcodescanner.SourceData;

public interface ScanResultObserver {
    void onCancel();

    void onScanFail(long j, long j2, SourceData sourceData);

    void onScanSuccess(long j, long j2, SourceData sourceData);
}

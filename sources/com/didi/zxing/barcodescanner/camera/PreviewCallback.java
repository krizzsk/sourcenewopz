package com.didi.zxing.barcodescanner.camera;

import com.didi.zxing.barcodescanner.SourceData;

public interface PreviewCallback {
    void onPreview(SourceData sourceData);

    void onPreviewError(Exception exc);

    boolean oneShot();
}

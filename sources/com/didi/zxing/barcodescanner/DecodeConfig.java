package com.didi.zxing.barcodescanner;

import com.didi.dqrutil.DqrDecodeConfig;
import com.didi.dqrutil.analysis.AnalysisInter;

public interface DecodeConfig extends DqrDecodeConfig {
    boolean analysisDqr();

    int autoFocusTimeout();

    boolean autoSelectFocusMode();

    boolean autoTorch();

    int autoTorchLum();

    boolean autoZoom();

    int binarizerType();

    boolean cropRect();

    int cropRedundancy();

    float cvBlockSizeFact();

    String extraBarcodeFormats();

    AnalysisInter getAnalysis();

    int patternMinValidCount();

    boolean threadCountRelatedCpu();

    boolean useContinousFocusMode();

    int useContinousFocusModeEndTime();

    int useContinousFocusModeLum();

    int useContinousFocusModeStartTime();

    boolean useSurfaceView();

    int zoomMinDp();

    int zoomSize();
}

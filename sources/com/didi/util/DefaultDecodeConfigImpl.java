package com.didi.util;

import com.didi.dqr.qrcode.detector.BestPatternMethodEnum;
import com.didi.dqrutil.analysis.AnalysisInter;
import com.didi.zxing.barcodescanner.DecodeConfig;

public class DefaultDecodeConfigImpl implements DecodeConfig {
    public boolean analysisDqr() {
        return false;
    }

    public int autoFocusTimeout() {
        return 5000;
    }

    public boolean autoSelectFocusMode() {
        return false;
    }

    public boolean autoTorch() {
        return false;
    }

    public int autoTorchLum() {
        return 30;
    }

    public boolean autoZoom() {
        return true;
    }

    public int binarizerType() {
        return 4;
    }

    public boolean caculateIncline() {
        return true;
    }

    public int contourDilateCount() {
        return 3;
    }

    public int contourFinderRate() {
        return 15;
    }

    public boolean cropRect() {
        return false;
    }

    public int cropRedundancy() {
        return 20;
    }

    public float cvBlockSizeFact() {
        return 1.0f;
    }

    public String extraBarcodeFormats() {
        return "";
    }

    public AnalysisInter getAnalysis() {
        return null;
    }

    public int newFinderRate() {
        return 10;
    }

    public int opencvBlockBulking() {
        return 2;
    }

    public float patternCorrectLimit() {
        return 15.0f;
    }

    public int patternCorrectRate() {
        return 15;
    }

    public int patternMinValidCount() {
        return 3;
    }

    public float patternTolerant() {
        return 0.8f;
    }

    public boolean threadCountRelatedCpu() {
        return true;
    }

    public boolean useContinousFocusMode() {
        return false;
    }

    public int useContinousFocusModeEndTime() {
        return 0;
    }

    public int useContinousFocusModeLum() {
        return 0;
    }

    public int useContinousFocusModeStartTime() {
        return 0;
    }

    public boolean useContourFinder() {
        return false;
    }

    public boolean useDynamicCVBlocksize() {
        return true;
    }

    public boolean useFilter() {
        return false;
    }

    public int useNativeDecodeRate() {
        return 0;
    }

    public boolean usePatternAutoComple() {
        return true;
    }

    public boolean usePatternCorrect() {
        return false;
    }

    public boolean useSurfaceView() {
        return true;
    }

    public int zoomMinDp() {
        return 4;
    }

    public int zoomSize() {
        return 2;
    }

    public int findBestPatternType() {
        return BestPatternMethodEnum.TYPE_MIX.ordinal();
    }
}

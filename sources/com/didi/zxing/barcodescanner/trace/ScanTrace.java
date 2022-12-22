package com.didi.zxing.barcodescanner.trace;

import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.DecodeConfig;
import java.util.HashMap;
import java.util.Map;

public class ScanTrace {
    public static void trace(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config != null && config.getAnalysis() != null) {
            map.put("binarizerType", config.binarizerType() + "");
            map.put("cvBlockSizeFact", config.cvBlockSizeFact() + "");
            map.put("useCF", config.useContourFinder() + "");
            map.put("useCFRate", config.contourFinderRate() + "");
            map.put("useDynamicCV", config.useDynamicCVBlocksize() + "");
            map.put("cropRect", config.cropRect() + "");
            map.put("cropRedundancy", config.cropRedundancy() + "");
            map.put("autoZoom", config.autoZoom() + "");
            map.put("patternMinValidCount", config.patternMinValidCount() + "");
            map.put("zoomMinDp", config.zoomMinDp() + "");
            map.put("findBestPatternType", config.findBestPatternType() + "");
            map.put("opencvBlockBulking", config.opencvBlockBulking() + "");
            map.put("threadCountRelatedCpu", config.threadCountRelatedCpu() + "");
            map.put("usePatternAutoComple", config.usePatternAutoComple() + "");
            map.put("usePatternCorrect", config.usePatternCorrect() + "");
            map.put("patternCorrectLimit", config.patternCorrectLimit() + "");
            map.put("newFinderRate", config.newFinderRate() + "");
            map.put("useNativeDecodeRate", config.useNativeDecodeRate() + "");
            map.put("useSurfaceView", config.useSurfaceView() + "");
            map.put("sessionId", AnalysisManager.getSessionId() + "");
            map.put("decodeId", AnalysisManager.getDecodeId() + "");
            map.put("caculateIncline", config.caculateIncline() + "");
            map.put("patternTolerant", config.patternTolerant() + "");
            map.put("useContinousFocusMode", config.useContinousFocusMode() + "");
            map.put("autoTorch", config.autoTorch() + "");
            map.put("autoTorchLum", config.autoTorchLum() + "");
            map.put("autoFocusTimeout", config.autoFocusTimeout() + "");
            map.put("useContinousFocusModeLum", config.useContinousFocusModeLum() + "");
            map.put("autoSelectFocusMode", config.autoSelectFocusMode() + "");
            config.getAnalysis().report(str, map);
        }
    }

    public static void trace(String str) {
        trace(str, (Map<String, Object>) null);
    }

    public static void traceSingle(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        trace(str, hashMap);
    }
}

package com.didi.component.framework.leak;

import com.didi.component.common.util.GLog;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.HeapDump;
import java.util.Map;

public class LeakUploadService extends DisplayLeakService {
    /* access modifiers changed from: protected */
    public void afterDefaultHandling(HeapDump heapDump, AnalysisResult analysisResult, String str) {
        if (analysisResult.leakFound && !analysisResult.excludedLeak) {
            GLog.m7965d("LeakUploadService", "leakInfo:" + analysisResult.className);
            GLog.m7965d("LeakUploadService", "leakInfo:" + str);
            GLog.m7965d("LeakUploadService", "leakFile:" + heapDump.heapDumpFile.getAbsolutePath());
            String str2 = "leakcanary#" + analysisResult.className;
            OmegaSDK.trackError("leakcanary", str2, str2, str, (Map<String, Object>) null);
        }
    }
}

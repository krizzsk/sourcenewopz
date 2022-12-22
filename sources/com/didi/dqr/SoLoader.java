package com.didi.dqr;

import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;

public class SoLoader {
    public static boolean loadLibraryError = true;

    public static void load() {
    }

    static {
        try {
            System.out.println("dqr SoLoader load opencv===");
            System.loadLibrary("dqr");
            System.loadLibrary("opencv");
        } catch (Throwable th) {
            th.printStackTrace();
            AnalysisManager.report(EventId.DQR_SCAN_LOADCV_FAIL);
        }
    }
}

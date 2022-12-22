package com.kwai.koom.javaoom.monitor;

public class TriggerReason {

    /* renamed from: a */
    private static TriggerReason f55643a;
    public AnalysisReason analysisReason;
    public DumpReason dumpReason;

    public enum AnalysisReason {
        RIGHT_NOW,
        REANALYSIS,
        TEST
    }

    public enum DumpReason {
        MANUAL_TRIGGER,
        MANUAL_TRIGGER_ON_CRASH,
        HEAP_OVER_THRESHOLD,
        HEAP_THRASHING_HEAVILY,
        HEAP_OOM_CRASH,
        FD_OVER_THRESHOLD,
        FD_OOM_CRASH,
        THREAD_OVER_THRESHOLD,
        THREAD_OOM_CRASH
    }

    /* renamed from: a */
    private static TriggerReason m40115a() {
        if (f55643a == null) {
            f55643a = new TriggerReason();
        }
        return f55643a;
    }

    public static TriggerReason dumpReason(DumpReason dumpReason2) {
        m40115a().dumpReason = dumpReason2;
        return f55643a;
    }

    public static TriggerReason analysisReason(AnalysisReason analysisReason2) {
        m40115a().analysisReason = analysisReason2;
        return f55643a;
    }
}

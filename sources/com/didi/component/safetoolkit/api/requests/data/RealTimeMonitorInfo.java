package com.didi.component.safetoolkit.api.requests.data;

public class RealTimeMonitorInfo {
    private RealTimeMonitorInfo() {
    }

    public static RealTimeMonitorInfo getInstance() {
        return SingleTonInnerClass.sRealTimeMonitor;
    }

    private static class SingleTonInnerClass {
        /* access modifiers changed from: private */
        public static RealTimeMonitorInfo sRealTimeMonitor = new RealTimeMonitorInfo();

        private SingleTonInnerClass() {
        }
    }
}
